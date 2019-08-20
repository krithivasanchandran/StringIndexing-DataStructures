package MasterIndexes;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;

public class Trie {
	
	private TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String word){
		
		if(word == null || word.isEmpty())
			throw new IllegalArgumentException("The word to be inserted into cannot be null");
		
		if(root == null)
			throw new NullPointerException("Root Node of Trie cannot be null !");
		
		int len = word.length();
		
		Map<Character,TrieNode> children = root.children;
		
		for(int i=0;i<len;i++){
			char ch = word.charAt(i);
			
			TrieNode t;
			
			if(children.containsKey(ch)){
				t = children.get(ch);
			}else{
				t = new TrieNode(ch);
				children.put(ch, t);
			}
			
			children = t.children;
			
			if(i == word.length() - 1)
				t.isLeaf = true;
		}
	}
	
	public boolean search(String word){
		TrieNode t = searchNode(word);
		
		if(t != null && t.isLeaf){
			return true;
		}else{
			return false;
		}
	}
	
	
	private TrieNode searchNode(String searchtxt){
	   
		Map<Character,TrieNode> children	= root.children;
	    
	    TrieNode t = null;
	    
	    for(int i=0;i< searchtxt.length(); i++)
	    {
	    	char c = searchtxt.charAt(i);
	    	if(children.containsKey(c)){
	    		t = children.get(c);
	    		children = t.children;
	    	}else{
	    		return null;
	    	}
	    }
	    return t;
	}
	
	public String findsuffix(String suffexp) throws InterruptedException{
		
		Map<Character,TrieNode> tmap = root.children;
		int occurence = suffexp.length()-1;
		
		TrieNode t = null;
		
		for(int i=0;i<suffexp.length(); i++){
			
			char d = suffexp.charAt(i);
			
			if(tmap.containsKey(d)){
				if(occurence == 0){
					return printSuffixes(d,tmap);
				}
				t = tmap.get(d);
				tmap = t.children;
				--occurence;
			}
		}
		return "nosuffixesfound";
	}

	private String printSuffixes(char gotchas,Map<Character, TrieNode> meals) throws InterruptedException {

		StringBuilder suffixExp = new StringBuilder();
		
		System.out.println(" InBound Variable Names --> " + gotchas);
		System.out.println("Print Suffixes Length ---> " + meals.size());
		
        TrieNode tnode = null;
        
        for(tnode = meals.get(gotchas);!(tnode.isLeaf);) {
        	
   			for(Entry<Character, TrieNode> mi : tnode.children.entrySet()){
    				suffixExp.append(mi.getKey());
    				tnode = mi.getValue();
    			}
				System.out.println("Tnode is leaf -----> " + tnode.isLeaf);
    		}
        	suffixExp.append("$$$");
        	
		return suffixExp.toString();

	}
}
