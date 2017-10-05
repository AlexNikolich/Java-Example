
public class ReverseAString {

	public static void main(String[] args) {
		
		/*
		String hi = "abcd";
		String hi1 = new StringBuilder(hi).reverse().toString();
		System.out.println(hi1);
		*/
		
		/////////////////////////////New example
		
		/*
		String st1 = "zxcvb";
		st1 = reverseIt(st1);
		System.out.println(st1);
		
		
		public static String reverseIt(String source) {
		    int i, len = source.length();
		    StringBuilder dest = new StringBuilder(len);
	
		    for (i = (len - 1); i >= 0; i--){
		        dest.append(source.charAt(i));
		    }
	
		    return dest.toString();
		}
	    */
		
		/////////////////////////////New example
		
		String st = "abcde";
		st = reverse(st);
		System.out.println(st);

	}
	
	public static String reverse(String input){
	    char[] in = input.toCharArray();
	    int begin=0;
	    int end=in.length-1;
	    char temp;
	    for(int i=0; i<end;i++){  	
	    	temp = in[i];
	    	in[i]=in[end];
	    	in[end]=temp;
	    	end--;
	    	
	    /*
	    // we can use while instead for
	    while(end>begin){
	        temp = in[begin];
	        in[begin]=in[end];
	        in[end] = temp;
	        end--;
	        begin++;
	     */
	    }
	    return new String(in);
	}
	
	
}
