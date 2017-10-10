import java.util.Scanner;

public class ReplaceEmtySpace {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.println("enter String: ");
		String str = console.nextLine();

		System.out.println(replaceCharacter(str));
	}

	public static String replaceCharacter(String str) {
		char[] ch = str.toCharArray();
		int len = 0;
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == ' ') {
				len++;
			}
		}
		int fullLen = str.length() + len * 2;
		char[] res = new char[fullLen];
		int j = 0;
		for (int i = 0; i < str.length(); i++) {
			if (ch[i] == ' ') {
				res[j] = '%';
				res[j + 1] = '2';
				res[j + 2] = '0';
				j = j + 3;
			} else {
				res[j] = ch[i];
				j++;
			}
		}

		String finalRes = new String(res);

		return finalRes;

	}

}
