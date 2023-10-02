package stringmethods;

public class StringBufferExample {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("135");
		
		sb.replace(0, 5, "6789");
		sb.insert(0, "12345");
		sb.reverse();
		sb.delete(0, 5);
		
		System.out.println(sb.toString());
	}

}
