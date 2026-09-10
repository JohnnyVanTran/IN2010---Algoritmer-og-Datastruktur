

public class SelectionSort{

    protected int tid = 0;
    protected int cmp = 0;
    protected int swaps = 0;

    public int[] getInfo(int[] list){
        
        tid = 0;
        cmp = 0;
        swaps = 0;

        selectionSort(list);

        int[] info = {cmp, swaps, tid};

        return info;
    }

    public int[] selectionSort(int[] a){

        long t = System.nanoTime();

        int[] ny = a;
        
        for(int i = 0; i < ny.length-1; i++){
            for(int k = i + 1; k <= a.length - 1; k++){
                cmp++;
                if(ny[k] < ny[i]){
                    swaps++;
                    int holder = a[k];
                    ny[k] = ny[i];
                    ny[i] = holder;
                }
            }
        }

        long time = (System.nanoTime() - t)/1000;
        tid = (int)time;

        return ny;
    }

}