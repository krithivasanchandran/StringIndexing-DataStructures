package Hashes;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Prime number : 1610612741,805306457,402653189, 201326611 => https://planetmath.org/goodhashtableprimes
 * Dataset => https://www.researchgate.net/figure/Word-frequency-distributions-for-the-test-sets-in-the-enwiki9-dataset_fig2_263736381
 * HashKey -> {1610612741,805306457,402653189, 201326611}
 * 256 bit HashKey => Hash256(line.getBytes(), 0, line.getBytes().length, key) 
 * Bucket Size : Depending on 16GB ram memory - tough to build inmemory indexes on large data so limiting to the 
 * size of bucket 3079.
 */
public class Wiki9256HighWayHashLargePrimeCollisionAnalysis {

	static List<Long> highwayMap = new ArrayList<Long>();
	static List<String> duplicates = new ArrayList<String>();
	static final Set<Long> tHashes = new HashSet<Long>();

	/*
	 * Defining Parallel Arrays O(1) for building minor Inmemory Indexes in Heap
	 * Memory of RAM. Select bucketSize as prime.
	 */
	static final int bucket_size = 10;
	static final int divisional_factor = 100;
	static final int milli_seconds_conversional_factor = 1000000;

	/*
	 * Select Bleed Red Strategy for building in-memory arrays
	 */
	static long[] key_inmemory = new long[bucket_size];
	static String[] val_inmemory = new String[bucket_size];

	public static void main(String args[]) {

		// long prime_primary_lowest_bound_error_rate =
		// 1610612741,805306457,402653189, 201326611;

		String inboundInputFilePath = "C:/Users/krichandran/Documents/LargeFile-Reading-Dump-File/enwik9/enwik9";
		AtomicInteger insertCnt = new AtomicInteger(0);

		try {

			FileInputStream inputStream = new FileInputStream(new File(inboundInputFilePath));
			Scanner s = new Scanner(inputStream, "UTF-8");
			long[] key = { 1610612741, 805306457, 402653189, 201326611 };

			while (s.hasNextLine()) {

				String line = s.nextLine();

				if (!line.isEmpty() || line.length() != 0) {

					System.out.println(line);
					long[] hashes = HighwayHash.hash256(line.getBytes(), 0, line.getBytes().length, key);

					for (long l : hashes) {
						System.out.println("Hashes ===> " + l);
						tHashes.add(l);
					}

					highwayMap.parallelStream().forEach((t) -> {

						if (tHashes.contains(t)) {
							System.out.println("Duplicate Hash Key found  ----> " + hashes);
							duplicates.add(t + "--> " + line);
							key_inmemory[insertCnt.get()] = t;
							val_inmemory[insertCnt.get()] = line;
						} else {
							System.out.println(" Hashes :: ===========> " + Arrays.toString(hashes));
							highwayMap.addAll(tHashes);
						}
					});
					tHashes.clear();
				}
				int internalCounter = insertCnt.incrementAndGet();
				if (internalCounter == bucket_size - 1)
					break;
			}
			s.close();
		} catch (FileNotFoundException fexp) {
			fexp.printStackTrace();
		}

		duplicates.forEach((t) -> {
			try {
				writeDuplicatesToLargeFile(t);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		});

		System.out.println("List of total Duplicates ===> " + duplicates.size());

		CalculateTimetoAccessInMemoryIndexes(key_inmemory, val_inmemory);

		System.out.println("::Compeleted::");

	}

	public static void writeDuplicatesToLargeFile(String content) throws IOException {
		RandomAccessFile stream = null;
		FileChannel channel = null;

		try {
			File f = new File("C:/Users/krichandran/Documents/duplicates.txt");
			stream = new RandomAccessFile("C:/Users/krichandran/Documents/duplicates.txt", "rw");
			stream.seek(f.length());
			channel = stream.getChannel();

			ByteBuffer buff = ByteBuffer.allocate(content.getBytes().length);

			buff.put(content.getBytes());
			buff.flip();
			channel.write(buff);

			stream.close();
			channel.close();
		} catch (IOException ioex) {
			System.out.println(ioex.getMessage());
		} finally {
			if (stream != null)
				stream.close();
			if (channel != null)
				channel.close();
		}
	}

	public static void CalculateTimetoAccessInMemoryIndexes(long[] key_inmem, String[] val_inmem) {

		for (int i = 0; i < key_inmem.length - 2000; i++) {

			long startTime = System.nanoTime();

			System.out.println("Inmemory Access Key ===> " + key_inmem[i]);
			System.out.println("Inmemory Access Value ===> " + val_inmem[i]);

			long time = System.nanoTime() - startTime;

			System.out.println("Time Taken In-Memory Index Access :: > " + time / milli_seconds_conversional_factor);
		}

	}

}
