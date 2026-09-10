import java.util.*;
import java.io.*;

public class InsertionSort{

    protected int tid = 0;
    protected int cmp = 0;
    protected int swaps = 0;

    public int[] getInfo(int[] list){

        tid = 0;
        cmp = 0;
        swaps = 0;

        insertionSort(list);

        int[] info = {cmp, swaps, tid};

        return info;
    }

    public int[] insertionSort(int[] list){

        long timer = System.nanoTime();
        int[] ny = list;
        for(int i = 0; i < ny.length; i++){

            int t = i;

            cmp++;
            while(t > 0 && ny[t - 1] > ny[t]){
                swaps++;
                int holder = ny[t];
                ny[t] = ny[t - 1];
                ny[t-1] = holder;

                t = t-1;
                cmp++;
            }
        }
        long time = (System.nanoTime() - timer)/1000;
        tid = (int)time;
        return ny;
    }
}