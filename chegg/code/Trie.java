package chegg.code;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	private char c;
	public boolean isleaf;
	public Map<Character,Trie> children = new HashMap<Character,Trie>();
	
	Trie(char t){
		c = t;
	}
	
	public boolean leaf(){return isleaf;}

}
