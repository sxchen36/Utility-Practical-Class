package Utility;

public class DualPavotQuicksort {

	public static final void main(String[] args) {
		QuickSort t = new QuickSort();
		int[] array = {3,2,4,1,5,7,5,3,2,8,6,0,-1,-3,1,1,1,5};
		t.quicksort(array);
		for (int i=0; i<array.length; i++){
			System.out.print(array[i]+" ");
		}
	}
	
	public void dualquicksort(int[] array){
		helper(array, 0, array.length-1);
	}
	
	private void helper(int[] array, int l, int r){
		if (array[l] > array[r]) swap(array, l, r);
		//assert array[l] < array[r]
		
		/*l ~ L-1 are smaller than lpivot on L*/
		int lpivot = array[l];
		int L = l+1;
		/*G+1 ~ r are larger than rpivot on G*/
		int rpivot = array[r];
		int G = r-1;

		int k = l+1;
		while (k <= G) { // Must until equals to G! otherwise G will not be exam
			if (array[k] < lpivot) {
				swap(array, L, k);
				L++;
			} else if (array[k] > rpivot) {
				swap(array, k,G);
				G--;
			} else { 
				//assert are lpivot<= <= rpivot
				//do nothing
			}
			k++;
		}
		swap(array, l, L-1);
		swap(array, G+1, r);
		
		helper(array, l, L-1);
		helper(array, L, G);
		helper(array, G+1, r);
	
	}
	
	private void swap (int[] array, int a, int b){
		int tmp = array[a];
		array[a] = array[b];
		array[b] = tmp;
	}
}
