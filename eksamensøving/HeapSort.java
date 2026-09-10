import java.util.*;

class HeapSort{

    private void bubbledown(int[] a, int i, int n){

        int largest = i;
        int l = 2*i + 1;
        int r = 2*i + 2;

        if(l < n && a[largest] < a[l]){
            largest = l;
        }
        if(r < n && a[largest] < a[r]){
            largest = r;
        }
        if(largest != i){
            int temp = a[i];
            a[i] = a[largest];
            a[largest] = temp;
            bubbledown(a, largest, n);
        }
    }
    private void buildMaxHeap(int[] a, int n){
        for(int i = n/2; i >= 0; i--){
            bubbledown(a,i,n);
        }
    }
    private void sort(int[] a){

        buildMaxHeap(a, a.length);
        for(int i = a.length - 1; i > 0; i--){
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
            bubbledown(a,0,i);
        }
    }

    public static void main(String[] args){

        HeapSort lol = new HeapSort();
        int[] haha = {1,2,3,4,5,6,7};
        lol.sort(haha);

        System.out.println("Heap");
        for (int i = 0; i < haha.length; ++i)
            System.out.print(haha[i] + " ");
        System.out.println();
    }
}
