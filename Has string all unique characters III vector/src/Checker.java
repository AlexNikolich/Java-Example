
public class Checker {
	
	 public static void main(String[] args) {
	        String ss = "helo";
	        System.out.println("The string is " + ss);
	        
	        Checker check = new Checker();
	        
	        if (check.checkUniqueChar(ss)) System.out.println("all unique");
	        else System.out.println("noop, has duplicated values");
	        return;
	}
	 
	 public static boolean checkUniqueChar(String str) {
		    int checker = 0;
		    for (int i = 0; i < str.length(); ++i) {
		        int val = str.charAt(i) - 'a';
		        if ((checker & (1 << val)) > 0)
		            return false;
		        checker |= (1 << val);
		    }
		    return true;
		}

}
