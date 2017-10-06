import java.util.Scanner;

public class Remove {

	public static void main(String[] args) {
	     Scanner console = new Scanner(System.in);
	        System.out.println("enter String: ");
	        String str = console.nextLine();

	        System.out.println(removeCharacters(str));        
	    }
		
	public static String removeCharacters(String str){
	    String ourString="";
	    int j = 0;
	    for (int i=0; i<str.length() ; i++){
	        j = i+1;
	        if(i==str.length()-1){
	        	if(str.charAt(i-1)!=str.charAt(i-2))
	        		ourString+=str.charAt(i);
			} else if (str.charAt(i)!=str.charAt(j)) {
	        	ourString+=str.charAt(i);
			}
	    }
	    return ourString;
	}

}
