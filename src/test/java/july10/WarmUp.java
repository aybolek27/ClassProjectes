package july10;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
public class WarmUp {
	
	public static void main(String[] args) {
		
		
		/*	HashMap vs HashTable
		 * HashMap can have 1 null key and many null value
		 *	HashTable can not have any null key and null value
		 *  HashMap is not synchronized / HashTable is synchronized
		 * */
		
		//Map<String, String> mp=new HashTable<>();
		HashMap<String, String> mp=new HashMap<>();
		
		mp.put("cake", "one");
		mp.put("candy", "Two");
		mp.put("cookie", "Three");
		mp.put("icecream", "Four");
		mp.put("chocolate", "Five");
		
		Set<Entry<String, String>> entries=mp.entrySet();
		

	    for (Entry<String, String> each : entries) {
	      System.out.print(each.getKey() + " "); 
	      System.out.println(each.getValue()); 
	  

	    }
	    System.out.println(mp);
	    

	  }
	

}
