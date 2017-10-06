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
	    if(str.isEmpty()){
	    	return null;
	    }else{
	    	ourString+= str.charAt(0);
		    for (int i=0; i<str.length()-1 ; i++){
		        j = i+1;
		     
		        
				 if (str.charAt(i)!=str.charAt(j)) {
		        	ourString+=str.charAt(j);
				}
		    }
	    }
	    return ourString;
	}

}
