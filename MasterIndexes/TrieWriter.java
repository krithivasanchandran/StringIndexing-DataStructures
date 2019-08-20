package MasterIndexes;

public class TrieWriter {
	
	/*
	                 Root 
	                / /\ \
	               / /  \ \ 
	              $ h    $ $
	               /|\
	              e a o
	             /  |  \
	            l   p   l
	           /    |    \
	          l     p     l
	         /      |      \
	        o       y       y
	        
	        
	*/
	
	public static void main(String args[]) throws InterruptedException{
		
		long beforeUsedMem = Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		System.out.println("Initial Memory During Start of Program Execution :" + beforeUsedMem);
		
		System.out.format("Initial Memory During Start of Program Execution : %d%n", beforeUsedMem);

		Trie tn =  new Trie();	
		tn.insert("hello");
		tn.insert("happy");
		tn.insert("holly");
		tn.insert("Amazon was founded by Jeff Bezos on July 5, 1994, in Bellevue, Washington. The company initially started as an online marketplace for books but later expanded to sell electronics, software, video games, apparel, furniture, food, toys, and jewelry. In 2015, Amazon surpassed Walmart as the most valuable retailer in the United States by market capitalization.[17] In 2017, Amazon acquired Whole Foods Market for $13.4 billion, which vastly increased Amazon's presence as a brick-and-mortar retailer.[18] In 2018, Bezos announced that its two-day delivery service, Amazon Prime, had surpassed 100 million subscribers worldwide.");
		tn.insert("In 1994, Jeff Bezos incorporated Amazon. He chose the location Seattle because of technical talent as Microsoft is located there.[25] In May 1997, the organization went public. The company began selling music and videos in 1998, at which time it began operations internationally by acquiring online sellers of books in United Kingdom and Germany. The following year, the organization also sold video games, consumer electronics, home-improvement items, software, games, and toys in addition to other items.");
		tn.insert("Former employees, current employees, the media, and politicians have criticized Amazon for poor working conditions at the company.[22][153][154] In 2011, it was publicized that workers had to carry out tasks in 100 °F (38 °C) heat at the Breinigsville, Pennsylvania warehouse. As a result of these inhumane conditions, employees became extremely uncomfortable and suffered from dehydration and collapse. Loading-bay doors were not opened to allow in fresh air because of concerns over theft.[155] Amazon's initial response was to pay for an ambulance to sit outside on call to cart away overheated employees.[155] The company eventually installed air conditioning at the warehouse.[156]");
		boolean result = tn.search("Seattle");
		
		System.out.println("Search Result :-> " + result);
		
		String p = tn.findsuffix("ho");
		
		System.out.println(" Suffix is : ====> "+ p);
		
		long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		
		System.out.println(" End of Program - Trie - Of program Execution : " + afterUsedMem);
		
		System.out.format("End of Program - Trie - Of program Execution : %d%n", afterUsedMem);
		
		long actualMemUsed=afterUsedMem-beforeUsedMem;

		System.out.println("Actual Memory Used :: Trie :: Suffix Lookup and Search : HashMap : =>" + actualMemUsed);
	}
	
	
	/*
	 * Sample Output : 
	 */
	
	/*
	 * 
	 * 
	Initial Memory During Start of Program Execution :4026744
    Initial Memory During Start of Program Execution : 4026744
    Search Result :-> false
    InBound Variable Names --> o
    Print Suffixes Length ---> 3
    Tnode is leaf -----> false
    Tnode is leaf -----> false
    Tnode is leaf -----> true
    Suffix is : ====> lly$$$
    End of Program - Trie - Of program Execution : 4026744
    End of Program - Trie - Of program Execution : 4026744
    Actual Memory Used :: Trie :: Suffix Lookup and Search : HashMap : =>0
	 
	 */

}
