import java.util.*;
import java.io.*;

public class HeapSort{

    protected int tid = 0;
    protected int cmp = 0;
    protected int swaps = 0;

    public int[] getInfo(int[] list){
        
        tid = 0;
        cmp = 0;
        swaps = 0;

        heapSort(list);

        int[] info = {cmp, swaps, tid};

        return info;
    }

    public int[] heapSort(int[] list){
        
        long t = System.nanoTime();

        int[] ny = list;
        byggHeap(ny, ny.length-1);
        
        //Spoer om det her i dag
        for(int i = ny.length - 1; i >= 0; i--){
            int holder = ny[0];
            ny[0] = ny[i];
            ny[i] = holder;
            bubbleDown(ny, 0, ny.length - 1);
        }

        long time = (System.nanoTime() - t)/1000;
        tid = (int)time;

        return ny;
    }

    public void byggHeap(int [] a, int n){
        for(int i = (n/2); i >= 0; i--){
            bubbleDown(a, i, n);
        }
    }

    public void bubbleDown(int[] a, int i, int antall){
    
        int storst = i;
        int venstre = 2*i + 1;
        int hoyre = 2*i + 2;

        cmp++;
        if(venstre <= antall && a[storst] < a[venstre]){

            swaps++;
            int holder = a[storst];
            a[storst] = a[venstre];
            a[venstre] = holder;

            bubbleDown(a, venstre, antall);
    
        }

        cmp++;
        if(hoyre <= antall && a[storst] < a[hoyre]){
            
            swaps++;
            int holder = a[storst];
            a[storst] = a[hoyre];
            a[hoyre] = holder;

            bubbleDown(a, hoyre, antall);
        }
    }
}