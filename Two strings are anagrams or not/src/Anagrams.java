import java.util.Arrays;
import java.util.Scanner;

public class Anagrams {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("enter String1: ");
		String str1 = console.nextLine();
		System.out.println("enter String2: ");
		String str2 = console.nextLine();

		System.out.println(removeCharacters(str1, str2));
	}

	public static boolean removeCharacters(String str1, String str2) {

		if (str1.length() != str2.length()) {
			return false;
		}
		str1 = sorting(str1);
		str2 = sorting(str2);
		if (!str1.equals(str2)) {
			return false;
		}
		return true;
	}

	private static String sorting(String str1) {
		char[] ch = str1.toCharArray();
		Arrays.sort(ch);
		String sortString = new String(ch);
		return sortString;

		/*
		char[] word=str1.toCharArray();

	    for(int i=0;i<(word.length-1);i++){
	        for(int j=i+1;j>0;j--){
	            if(word[j]<word[j-1]){
	                char temp=word[j-1];
	                word[j-1]=word[j];
	                word[j]=temp;
	            }
	        }
	    }
	    String wordSort = new String(word);
	    return wordSort;
	    */
	}

}
