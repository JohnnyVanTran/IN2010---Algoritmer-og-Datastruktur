import java.util.*;
import java.io.*;

public class QuickSort{
    
    protected int tid = 0;
    protected int cmp = 0;
    protected int swaps = 0;

    public int[] getInfo(int[] list){
        
        tid = 0;
        cmp = 0;
        swaps = 0;

        quicksort(list, 0, list.length - 1);

        int[] info = {cmp, swaps, tid};

        return info;
    }

    public int[] quicksort(int[] list, int low, int high){
        
        long t = System.nanoTime();

        int[] ny = list;

        if (low >= high){
            return ny;
        }
        int p = partition(ny, low, high);
        quicksort(ny, low, p - 1);
        quicksort(ny, p + 1, high);

        long time = (System.nanoTime() - t)/1000;
        tid = (int)time;

        return ny;

    }
    public int partition(int[] a, int low, int high){
        
        int pivot = a[high];

        int venstre = low;
        int hoyre = high - 1;

        cmp++;
        while (venstre < hoyre){
            cmp++;
            while (venstre < hoyre && a[venstre] <= pivot){
                venstre += 1;
                cmp++;
            }
            cmp++;
            while (hoyre > venstre && a[hoyre] >= pivot){
                hoyre -= 1;
                cmp++;
            }
            if (venstre < hoyre){
                swaps++;
                int nokkel = a[venstre];
                a[venstre] = a[hoyre];
                a[hoyre] = nokkel;
            }
        }
        swaps++;
        a[high] = a[venstre];
        a[venstre] = pivot;

        return venstre;
    }
}