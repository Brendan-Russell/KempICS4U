package russell;

public class Search {
	/**
	 * Linear search for an integer array
	 * @param a The array to search
	 * @param target The number to find
	 * @return the index of the target or -1 if the target does not exist
	 */
	public static int linearSearch(int[] a, int target){
        for (int i = 0; i <a.length; i++) {
            if (a[i]==target){
                return i;
            }
        }
        return -1;
    }
	/**
	 * Linear search for a double array
	 * @param a The array to search
	 * @param target The number to find
	 * @return the index of the target or -1 if the target does not exist
	 */
    public static int linearSearch(double[] a, double target){
        for (int i = 0; i <a.length; i++) {
            if(a[i]==target){
                return i;
            }
        }
        return -1;
    }
    /**
     * Linear search for a string array
     * @param a The array to search
	 * @param target The string to find
	 * @return the index of the target or -1 if the target does not exist
     */
    public static int linearSearch(String[] a, String target){
        for (int i = 0; i <a.length; i++) {
            if(a[i].equals(target)){
                return i;
            }
        }
        return -1;
    }
    /**
     * Binary search for an integer array
     * @param a The array to search
     * @param target The target to find
     * @return The index of the target or -1 if the target does not exist
     */
    public static int binarySearch(int[] a, int target){
        return binarySearch(a, target, 0, a.length-1);
    }
    /**
     * Helper method for the binary search for an integer array
     * @param a The array to search
     * @param target The target to find
     * @param start The start index
     * @param end The end index
     * @return The index of the target or -1 if the target does not exist
     */
    private static int binarySearch(int[] a, int target, int start, int end){
        int mid = (start+end)/2;
        if(start>end){
            return -1;
        }
        if(a[mid]==target){
            return mid;
        }
        else if(a[mid]>target){
            return binarySearch(a, target, start, mid-1);
        }
        else if(a[mid]<target){
            return binarySearch(a, target, mid+1, end);
        }
        return -1;
    }
    /**
     * Helper method for the binary search for a double array
     * @param a The array to search
     * @param target The target to find
     * @param start The start index
     * @param end The end index
     * @return The index of the target or -1 if the target does not exist
     */
    public static int binarySearch(double[] a, double target){
        return binarySearch(a, target, 0, a.length-1);
    }
    /**
     * Binary search for a double array
     * @param a The array to search
     * @param target The target to find
     * @param start The start index
     * @param end The end index
     * @return The index of the target or -1 if the target does not exist
     */
    private static int binarySearch(double[] a, double target, int start, int end){
        int mid = (start+end)/2;
        if(start>end){
            return -1;
        }
        if(a[mid]==target){
            return mid;
        }
        else if(a[mid]>target){
            return binarySearch(a, target, start, mid-1);
        }
        else if(a[mid]<target){
            return binarySearch(a, target, mid+1, end);
        }
        return -1;
    }
    /**
     * Helper method for the binary search for a string array
     * @param a The array to search
     * @param target The target to find
     * @param start The start index
     * @param end The end index
     * @return The index of the target or -1 if the target does not exist
     */
    public static int binarySearch(String[] a, String target){
        return binarySearch(a, target, 0, a.length-1);
    }
    /**
     * Binary search for a string array
     * @param a The array to search
     * @param target The target to find
     * @param start The start index
     * @param end The end index
     * @return The index of the target or -1 if the target does not exist
     */
    private static int binarySearch(String[] a, String target, int start, int end){
        int mid = (start+end)/2;
        if(start>end){
            return -1;
        }
        if(a[mid].equals(target)){
            return mid;
        }
        else if(a[mid].compareTo(target)==1){
            return binarySearch(a, target, start, mid-1);
        }
        else if(a[mid].compareTo(target)==-1){
            return binarySearch(a, target, mid+1, end);
        }
        return -1;
    }
}
