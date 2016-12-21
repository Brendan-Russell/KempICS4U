package russell;

public class Sort {
	public static int[] swap(int[] a, int i, int j){
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
	public static double[] swap(double[] a, int i, int j){
		double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}
	public static String[] swap(String[] a, int i, int j){
		String temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		return a;
	}

	private static int[] merge(int[] a, int[] b){
		int[] c = new int[a.length+b.length];
		int aIndex = 0, bIndex = 0;
		for(int i=0; i<c.length; i++){
			if(a[aIndex]<b[bIndex]){
				c[i] = a[aIndex];
				if(aIndex==a.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = b[bIndex];
						bIndex++;
					}
					break;
				}
				else{
					aIndex++;
				}
			}
			else{
				c[i] = b[bIndex];
				if(bIndex==b.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = a[aIndex];
						aIndex++;
					}
					break;
				}
				else{
					bIndex++;
				}
			}
		}
		return c;
	}
	private static double[] merge(double[] a, double[] b){
		double[] c = new double[a.length+b.length];
		int aIndex = 0, bIndex = 0;
		for(int i=0; i<c.length; i++){
			if(a[aIndex]<b[bIndex]){
				c[i] = a[aIndex];
				if(aIndex==a.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = b[bIndex];
						bIndex++;
					}
					break;
				}
				else{
					aIndex++;
				}
			}
			else{
				c[i] = b[bIndex];
				if(bIndex==b.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = a[aIndex];
						aIndex++;
					}
					break;
				}
				else{
					bIndex++;
				}
			}
		}
		return c;
	}
	private static String[] merge(String[] a, String[] b){
		String[] c = new String[a.length+b.length];
		int aIndex = 0, bIndex = 0;
		for(int i=0; i<c.length; i++){
			if(a[aIndex].compareTo(b[bIndex])<0){
				c[i] = a[aIndex];
				if(aIndex==a.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = b[bIndex];
						bIndex++;
					}
					break;
				}
				else{
					aIndex++;
				}
			}
			else{
				c[i] = b[bIndex];
				if(bIndex==b.length-1){
					for(int j=aIndex+bIndex+1; j<c.length; j++){
						c[j] = a[aIndex];
						aIndex++;
					}
					break;
				}
				else{
					bIndex++;
				}
			}
		}
		return c;
	}
	
	public static int partition(int[] a, int left, int right) {
        int pivot = a[right];
        int i = left-1, j = left;
        while(j<right){
        	if(a[j]<pivot){
        		i++;
        		swap(a, i, j);
        	}
        	j++;
        }
        i++;
        swap(a, i, right);
        return i;  
    }
	public static int partition(double[] a, int left, int right) {
		double pivot = a[right];
        int i = left-1, j = left;
        while(j<right){
        	if(a[j]<pivot){
        		i++;
        		swap(a, i, j);
        	}
        	j++;
        }
        i++;
        swap(a, i, right);
        return i; 
    }
	public static int partition(String[] a, int left, int right){
		String pivot = a[right];
        int i = left-1, j = left;
        while(j<right){
        	if(a[j].compareTo(pivot)<0){
        		i++;
        		swap(a, i, j);
        	}
        	j++;
        }
        i++;
        swap(a, i, right);
        return i; 
	}
	
	public static void selectionSort(int[] a){
		for (int i=0; i<a.length-1; i++){
			int index = i;
			for(int j=i+1; j<a.length; j++)
				if (a[j]<a[index]){
					index = j;
				}
			int smallerNumber = a[index]; 
			a[index] = a[i];
			a[i] = smallerNumber;
		}
	}
	public static void selectionSort(double[] a){
		for (int i=0; i<a.length-1; i++){
			int index = i;
			for(int j=i+1; j<a.length; j++)
				if (a[j]<a[index]){
					index = j;
				}
			double smallerNumber = a[index]; 
			a[index] = a[i];
			a[i] = smallerNumber;
		}
	}
	public static void selectionSort(String[] a){
		for (int i=0; i<a.length-1; i++){
			int index = i;
			for(int j=i+1; j<a.length; j++)
				if (a[j].compareTo(a[index])<0){
					index = j;
				}
			String smallerNumber = a[index]; 
			a[index] = a[i];
			a[i] = smallerNumber;
		}
	}

	public static void insertionSort(int[] a){
		for(int i=1; i< a.length; i++){
			int temp = a[i];
			int j = i-1;
			while((j>=0)&&(a[j]>temp)){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	public static void insertionSort(double[] a){
		for(int i=1; i<a.length; i++){
			double temp = a[i];
			int j = i-1;
			while((j>=0)&&(a[j]>temp)){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	public static void insertionSort(String[] a){
		for(int i=1; i< a.length; i++){
			String temp = a[i];
			int j = i-1;
			while((j>=0)&&(a[j].compareTo(temp))>0){
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = temp;
		}
	}
	
	public static void bubbleSort(int[] a){
		bubbleSort(a, true, 0);
	}
	public static void bubbleSort(double[] a){
		bubbleSort(a, true, 0);
	}
	public static void bubbleSort(String[] a){
		bubbleSort(a, true, 0);
	}
	
	public static void bubbleSort(int[] a, boolean swap, int passes){
		if(!swap||passes==a.length-1){
			return;
		}
		swap = false;
		for(int i=0; i<a.length-1-passes; i++){
			if(a[i]>a[i+1]){
				swap(a, i, i+1);
				swap = true;
			}
		}
		bubbleSort(a, swap, passes+1);
	}
	public static void bubbleSort(double[] a, boolean swap, int passes){
		if(!swap||passes==a.length-1){
			return;
		}
		swap = false;
		for(int i=0; i<a.length-1; i++){
			if(a[i]>a[i+1]){
				swap(a, i, i+1);
				swap = true;
			}
		}
		bubbleSort(a, swap, passes+1);
	}
	public static void bubbleSort(String[] a, boolean swap, int passes){
		if(!swap||passes==a.length-1){
			return;
		}
		swap = false;
		for(int i=0; i<a.length-1; i++){
			if(a[i].compareTo(a[i+1])>0){
				swap(a, i, i+1);
				swap = true;
			}
		}
		bubbleSort(a, swap, passes+1);
	}

	public static int[] mergeSort(int[] a){
		if(a.length==1){
			return a;
		}
		int[] leftHalf = new int[a.length/2];
		for(int i=0; i<leftHalf.length; i++){
			leftHalf[i] = a[i];
		}
		int[] rightHalf;
		if(a.length%2==0){
			rightHalf = new int[a.length/2];
		}
		else{
			rightHalf = new int[a.length/2+1];
		}
		int j = 0;
		for(int i=leftHalf.length; i<a.length; i++){
			rightHalf[j] = a[i];
			j++;
		}
		leftHalf = mergeSort(leftHalf);
		rightHalf = mergeSort(rightHalf);
		return merge(leftHalf, rightHalf);
	}
	public static double[] mergeSort(double[] a){
		if(a.length==1){
			return a;
		}
		double[] leftHalf = new double[a.length/2];
		for(int i=0; i<leftHalf.length; i++){
			leftHalf[i] = a[i];
		}
		double[] rightHalf;
		if(a.length%2==0){
			rightHalf = new double[a.length/2];
		}
		else{
			rightHalf = new double[a.length/2+1];
		}
		int j = 0;
		for(int i=leftHalf.length; i<a.length; i++){
			rightHalf[j] = a[i];
			j++;
		}
		leftHalf = mergeSort(leftHalf);
		rightHalf = mergeSort(rightHalf);
		return merge(leftHalf, rightHalf);
	}
	public static String[] mergeSort(String[] a){
		if(a.length==1){
			return a;
		}
		String[] leftHalf = new String[a.length/2];
		for(int i=0; i<leftHalf.length; i++){
			leftHalf[i] = a[i];
		}
		String[] rightHalf;
		if(a.length%2==0){
			rightHalf = new String[a.length/2];
		}
		else{
			rightHalf = new String[a.length/2+1];
		}
		int j = 0;
		for(int i=leftHalf.length; i<a.length; i++){
			rightHalf[j] = a[i];
			j++;
		}
		leftHalf = mergeSort(leftHalf);
		rightHalf = mergeSort(rightHalf);
		return merge(leftHalf, rightHalf);
	}
	
	public static void quickSort(int[] a){
		quickSort(a, 0, a.length-1);
	}
	public static void quickSort(double[] a){
		quickSort(a, 0, a.length-1);
	}
	public static void quickSort(String[] a){
		quickSort(a, 0, a.length-1);
	}
	
	public static void quickSort(int[] a, int left, int right){
		int pivot = partition(a, left, right);
		if(left<pivot-1){
			quickSort(a, left, pivot-1);
		}
		if(right>pivot){
			quickSort(a, pivot, right);
		}
	}
	public static void quickSort(double[] a, int left, int right){
		int pivot = partition(a, left, right);
		if(left<pivot-1){
			quickSort(a, left, pivot-1);
		}
		if(right>pivot){
			quickSort(a, pivot, right);
		}
	}
	public static void quickSort(String[] a, int left, int right){
		int pivot = partition(a, left, right);
		if(left<pivot-1){
			quickSort(a, left, pivot-1);
		}
		if(right>pivot){
			quickSort(a, pivot, right);
		}
	}
	
}

