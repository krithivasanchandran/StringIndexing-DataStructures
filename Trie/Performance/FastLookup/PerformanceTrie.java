package Trie.Performance.FastLookup;

public class PerformanceTrie {
	
	public static void main(String args[]) throws Exception{
		Trie t = new Trie();
		
		t.insert("Good Morning Chennai");
		
		boolean isFound = t.search("Good");
		
		System.out.println(" Result  :: ====> " + isFound);
		
//		String s = "Yahoo";
//		
//		for(int i=0;i< s.length() -1; i++) {
//			
//			char f = s.charAt(i);
//			int index = f - 'a';
//			
//			System.out.println("Index value ---> " + index);
//		}
	}

}
