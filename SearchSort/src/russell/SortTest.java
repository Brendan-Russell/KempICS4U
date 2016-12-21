package russell;

public class SortTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] a = {7,1,2,8,6,3,5,4};
		int[] b = {2,3,6,9,10};
		String[] s = {"z","o","i","a","p"};
		String[] t = {"b","c","j","x"};
		//System.out.println(Sort.partition(a, 0, a.length-1));
		Sort.quickSort(a);
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + " ");
		}
		
	}
}
