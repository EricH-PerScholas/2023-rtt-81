package stringmethods;

public class StringBufferExample {

	public static void main(String[] args) {
		// change x to be abc123xyz
		String x = "abcxyz";
		x = x.substring(0,3) + "123" + x.substring(3);
		
		// change x from abc123xyz to abcxyz
		x = x.substring(0,3) + x.substring(6);
		
		
		String y = x.toUpperCase();
		
		
		// zyxbca
		
		StringBuffer buffer = new StringBuffer();
		buffer.append("abc").append("xyz");
		
		buffer.reverse();
		
		// StringBuffer substring does the same as String substring
		String sub = buffer.substring(0, 3);
		
		// zyx123cba
		// you can insert into the string buffer anywhere
		buffer.insert(3, "123");
		
		// remove from string buffer
		buffer.delete(3, 6);
		
		// replace some characters in the string buffer
		StringBuffer sT = new StringBuffer("Java");
	    sT.replace(0, 2, "Hello"); 
	    System.out.println(sT);

		
		System.out.println(buffer.toString());
	}

}
