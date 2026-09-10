import java.util.*;
import java.io.*;

class Korrekthet{

    public static void main(String[] args){

        Korrekthet test = new Korrekthet();
        int[] arr = test.lesfil(args[0]);
        test.insertion(arr, args[0]);
        test.quicksort(arr, args[0]);
        test.selectionSort(arr, args[0]);
    }

    public int[] lesfil(String filNavn){
          
        File fil = new File(filNavn);
        int[] arr = null;
        ArrayList<Integer> arl = new ArrayList<>();

        try{
            //lager scanner og leser fil
            Scanner scanner = new Scanner(fil);
            while(scanner.hasNextLine()){
                arl.add(scanner.nextInt());
            }
            //instanserer array som vi skal returnere
            scanner.close();
            arr = new int[arl.size()];
            //kopierer over alle elementer fra arraylist til array
            //tidskompleksitet O(1) som betyr at den kan vaere treig
            //ved kopi av stoerre array
            for(int i = 0; i <= arl.size() - 1; i++){
                arr[i] = arl.get(i);
            }
        } catch(FileNotFoundException e){
            System.out.println("Fil ikke funnet");
            e.printStackTrace();
        }
        return arr;
    }

    //implementering av insertion sort
    public void insertion(int[] list, String filNavn){

        InsertionSort sort = new InsertionSort();
        int[] sortertListe = sort.insertionSort(list);
        outputFil(sortertListe, filNavn, "insertion");

    }
    
    
    //implementering av quicksort
    public void quicksort(int[] list, String filNavn){
        
        QuickSort sort = new QuickSort();
        int[] sortertListe = sort.quicksort(list, 0, list.length - 1);
        outputFil(sortertListe, filNavn, "quicksort");

    }

    //implementering av heap Sort
    public void heapSort(int[] list, String filNavn){
        
        HeapSort sort = new HeapSort();
        int[] sortertListe = sort.heapSort(list);
        outputFil(sortertListe, filNavn, "heapsort");

    }

    //implementering av Selection sort
    public void selectionSort(int[] a, String filNavn){

        SelectionSort sort = new SelectionSort();
        int[] sortertListe = sort.selectionSort(a);
        outputFil(sortertListe, filNavn, "selectionSort");

    }

    //lager outputfiler
    public void outputFil(int[] list, String filNavn, String kodeNavn){
        
        String navn = filNavn + "_" + kodeNavn;

        try{
            File fil = new File("/Users/johnnytran/Documents/bachelor/2010/oblig2/" + navn);
            if (fil.createNewFile()){
                System.out.println("Laget: " + fil.getName());
            }
        } catch (IOException e){
            System.out.println("Noe gikk galt");
            e.printStackTrace();
        }
        
        try{
            FileWriter skriver = new FileWriter(navn);
            for(int i : list){
                skriver.write(String.valueOf(i) + "\n");
            }
            skriver.close();
        } catch (IOException e){
            System.out.println("Noe gikk galt");
            e.printStackTrace();
        }
    }
}