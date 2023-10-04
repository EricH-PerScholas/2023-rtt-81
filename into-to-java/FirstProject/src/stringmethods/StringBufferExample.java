package stringmethods;

public class StringBufferExample {

	// pos 01234567890
	// buf 4321
	
	public static void main(String[] args) {
		//StringBuffer sb = new StringBuffer("135");
        //sb.replace(0, 5, "6789").insert(0, "12345");
        //System.out.println(sb.reverse().delete(0, 5));
		
		
		StringBuffer sb = new StringBuffer("135"); // 135     
		System.out.println(sb.toString());
		
		sb.replace(0, 5, "6789");// 6789 
		System.out.println(sb.toString());
		
		sb.insert(0, "12345"); // 123456789
		System.out.println(sb.toString());
		
		sb.reverse(); // 987654321
		System.out.println(sb.toString());
		
		sb.delete(0, 5); // 4321
		System.out.println(sb.toString());
	}

}
