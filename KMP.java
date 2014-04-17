package Utility;

public class KMP {

	/*The first try seems more relative. KMP algorithm*/
	public static final void main(String[] args) {
		KMP t = new KMP();
		t.KMPtest("abcdabd");
	}
	private void KMPtest(String needle){
		int[] T = new int[needle.length()];
        char[] W = needle.toCharArray();
        T[0] = 0;
        int pos = 1; // current position we are computing in T
        int cur = 0; // zero-based index in W of the next candidate substring
        while (pos<needle.length()) {
            if(W[cur] == W[pos]){ // a little bit different from wiki, cuz no -1
                cur++;
                T[pos] = cur; // longest proper prefix
                pos++;
            } else if (cur > 0){
                cur = T[cur];// call back to exam shorter longest proper prefix 
            } else {        // cur alreasy equals 0 here;
                T[pos] = 0; 
                pos++;
            }
        }
        for (int i=0; i<needle.length(); i++){
        	System.out.print(W[i]+" | ");
        }
        System.out.println();
        for (int i=0; i<needle.length(); i++){
        	System.out.print(T[i]+" | ");
        }
	}
}
