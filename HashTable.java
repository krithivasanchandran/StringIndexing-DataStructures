package hashing.code;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HashTable{
	
	private int buckets = 100000000; 
	private HashEntry[] hashtableindex;
	private final static Set<Integer> hashesContainer = new HashSet<Integer>();
	
	HashTable(){
		hashtableindex = new HashEntry[buckets];
	}
	
	HashTable(int loadFactorNoofBuckets){
		hashtableindex = new HashEntry[loadFactorNoofBuckets];
	}
	
	public void put(String key, String value){
		int indexHashes = getHash(key);
        final HashEntry createHashEntry = new HashEntry(key, value);

        if(hashtableindex[indexHashes] == null){
        	hashtableindex[indexHashes] = createHashEntry;
        }else{
         	HashEntry temp = hashtableindex[indexHashes];
         	
         	while(temp.next != null){
         		temp = temp.next;
         	}
         	temp.next = createHashEntry;
        }
	}
	
	public String get(String key){
		int hash = getHash(key);
		
		if(hashtableindex[hash] != null){
			
			if(hashtableindex[hash].next == null)
			return hashtableindex[hash].value;
			else{
				HashEntry ptr = hashtableindex[hash];
				while(! ptr.key.equals(key) && ptr.next != null){
					ptr = ptr.next;
				}
				return ptr.value;
			}
		}
		return null;
	}
	
	private int getHash(String key){
		return HashEntry.convertKeyToIndex(key) % buckets;
	}
	
	

	public static class HashEntry implements Comparable<HashEntry>{
		
		private String key;
		private String value;
		HashEntry next = null;
		private static int primeNo = 13;
		
		public HashEntry(String key, String value){
			this.key = key;
			this.value = value;
			this.next = null;
		}
		
		public String toString(){
			return "[" + key + "," +value +"]";
		}
		
		@Override
		public int compareTo(HashEntry o) {
			return convertKeyToIndex(this.key) - convertKeyToIndex(o.key);
		}
		
		private static int convertKeyToIndex(String in_b){
			int index = 0;
			int strlen = in_b.length();
			int computehashcode = 0;
			
			while(index < strlen){
				char c = in_b.charAt(index);
				int ascii = c;
				computehashcode += (ascii*index)^primeNo;
				index++;
			}
			System.out.println("HashCode -------> " + computehashcode);
			if(hashesContainer.contains(computehashcode)){
				System.out.println("----------------------------------> Duplicate HashCode Bucket COllision");
			}else{
				hashesContainer.add(computehashcode);
			}
			return computehashcode;
		}
	}
	
	@Override
    public String toString() {
		
        int bucket = 0;
        StringBuilder hashTableStr = new StringBuilder();
        for (HashEntry entry : hashtableindex) {
            if(entry == null) {
                continue;
            }
            hashTableStr.append("\n bucket[")
                    .append(bucket)
                    .append("] = ")
                    .append(entry.toString());
            bucket++;
            HashEntry temp = entry.next;
            while(temp != null) {
                hashTableStr.append(" -> ");
                hashTableStr.append(temp.toString());
                temp = temp.next;
            }
        }
        return hashTableStr.toString();
    }

	public static void main(String args[]){
		
		HashTable ht = new HashTable();
		String inboundInputFilePath = "C:/Users/krichandran/Documents/LargeFile-Reading-Dump-File/enwik9/enwik9";

		int insertCnt = 0;
		
		try{
			FileInputStream inputStream = new FileInputStream(new File(inboundInputFilePath));
			Scanner s = new Scanner(inputStream,"UTF-8");
			
			while(s.hasNextLine()){
				String line = s.nextLine();
				if(!line.isEmpty() || line.length() != 0){
					ht.put(line, line);
				}
				insertCnt = insertCnt + 1;
				if(insertCnt == 100000000) break;
			}
		}catch(FileNotFoundException fexp){
			fexp.printStackTrace();
		}
		
		// Print the HashTable structure
        log("****   HashTable  ***");
        log(ht.toString());
        log("\nValue for key(20) : " + ht.get("In France") );
	}
	
	 private static void log(String msg) {
	        System.out.println(msg);
	    }
}
