package Trie.Performance.FastLookup;

public class Trie {
	
	private TrieArr root;
	
	Trie(){
		root = new TrieArr();
	}
	
	public void insert(String popword) throws Exception{
		
		 TrieArr p = root;
		
		if(popword.isEmpty() || popword.length() == 0 || popword == null)
			throw new IllegalArgumentException("Word to be inserted into Trie is null");
		
		if(root == null)
			throw new Exception("Root of a Trie cannot be null. Please initialize the Trie.java class");
		
		int len = popword.length();
		String word = popword.toLowerCase();
		int i=0;
		while(i < len - 1){
			char c = word.charAt(i);
			int index = c - 'a';
			if(p.arr[index] == null){
				TrieArr parr = new TrieArr();
				p.arr[index] = parr;
				p = parr;
			}else{
				p = p.arr[index];
			}
		}
		p.isLeaf = true;
	}
	
	public boolean search(String word) {
        TrieArr p = searchNode(word.toLowerCase());
        if(p==null){
            return false;
        }else{
            if(p.isLeaf)
                return true;
        }
        return false;
    }
	
	 public boolean startsWith(String prefix) {
	        TrieArr p = searchNode(prefix);
	        if(p==null){
	            return false;
	        }else{
	            return true;
	        }
	    }
	 
	
	public TrieArr searchNode(String s){
		
		TrieArr p = root; 
		
		for(int i=0; i<s.length(); i++){
			
            char c= s.charAt(i);
            int index = c-'a';
            if(p.arr[index]!=null){
                p = p.arr[index];
            }else{
                return null;
            }
        }
 
        if(p==root)
            return null;
 
        return p;
	}
	
}
