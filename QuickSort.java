package Utility;

public class QuickSort {
	
	public static final void main(String[] args) {
		QuickSort t = new QuickSort();
		int[] array = {3,2,4,1,5,7,5,3,2,8,6};
		t.quicksort(array);
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}

    public void quicksort(int[] array){
        quicksortHelper(array, 0, array.length-1);
    }
    
    private void quicksortHelper(int[] array, int l, int r){
    	if (l >= r) return;
    	
        int pivotVal = array[r];
        int next = 0;
        for (int i = 0; i < r; i++) {
            if (array[i] <= pivotVal) { // be careful its <= cuz even equal you should move !!!!
                swap(array, next, i);
                next++;
            }
        }
        swap(array, next, r);
        quicksortHelper(array, l, next-1);
        quicksortHelper(array, next+1, r);
    }
    
    private void swap(int[] array, int a, int b){
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
