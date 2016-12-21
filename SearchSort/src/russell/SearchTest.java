package russell;

import java.util.Scanner;

public class SearchTest {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("What type would you like to search with?\nPlease enter either 'Int', 'Double', or 'String'");
		String firstChoice = scan.nextLine().toLowerCase();
		while(!firstChoice.equals("string")&&!firstChoice.equals("int")&&!firstChoice.equals("double")){
			System.out.println("Please enter either 'Int', 'Double', or 'String'");
			firstChoice = scan.nextLine().toLowerCase();
		}

		switch(firstChoice){
		case "int":
			System.out.println("Input the sorted list of numbers separated by a space");
			String iLine = scan.nextLine();
			int[] iNums = new int[iLine.split(" ").length];
			for (int i = 0; i <iLine.split(" ").length; i++) {
				iNums[i] = Integer.parseInt(iLine.split(" ")[i]);
			}
			System.out.println("Which number would you like to find?");
			int iTarget = scan.nextInt();
			System.out.println("The number " + iTarget + " is located at spot " + (Search.binarySearch(iNums, iTarget)+1) + " on the list");
			break;
		case "double":
			System.out.println("Input the sorted list of numbers separated by a space");
			String dLine = scan.nextLine();
			double[] dNums = new double[dLine.split(" ").length];
			for (int i = 0; i <dLine.split(" ").length; i++) {
				dNums[i] = Double.parseDouble(dLine.split(" ")[i]);
			}
			System.out.println("Which number would you like to find?");
			double dTarget = scan.nextDouble();
			System.out.println("The number " + dTarget + " is located at spot " + (Search.binarySearch(dNums, dTarget)+1) + " on the list");
			break;
		case "string":
			System.out.println("Input the sorted list of strings separated by a space");
			String sLine = scan.nextLine();
			String[] sNums = new String[sLine.split(" ").length];
			for (int i = 0; i <sLine.split(" ").length; i++) {
				sNums[i] = sLine.split(" ")[i];
			}
			System.out.println("Which string would you like to find?");
			String sTarget = scan.nextLine();
			System.out.println("The string " + sTarget + " is located at spot " + (Search.binarySearch(sNums, sTarget)+1) + " on the list");
			break;
		}
		scan.close();

	}

}
