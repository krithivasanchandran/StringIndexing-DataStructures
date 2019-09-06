package chegg.code;

import java.util.Hashtable;
import java.util.Map;

public class TrieStructure {
	
	Trie trieptr;
	
	public TrieStructure() {
		trieptr = new Trie('a');
	}
	
	public void insert(String trieKey){
		
		Hashtable<String,String> pinsert = new Hashtable<String,String>(100);
		
		if(trieKey == null)
			 throw new IllegalArgumentException();
		
		int len = trieKey.length();
		int cnt = 0;
		
		for(char t : trieKey.toCharArray()){
			
			Map<Character,Trie> p = trieptr.children;
			Trie trie = new Trie(t);
			
			if(!p.containsKey(t)){
				p.put(t,trie);
			}else{
				System.out.println("Already contains the key");
			}
			
			++cnt;
			if(cnt == len) trie.isleaf = true;
		}
	}

}
