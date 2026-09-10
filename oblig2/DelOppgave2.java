import java.util.*;
import java.io.*;

class DelOppgave2{

    public static void main(String[] args){

        DelOppgave2 test = new DelOppgave2();
        int[] arr = test.lesFil(args[0]);

        //For aa velge sorteringsalgoritme, gaa til outputfil()
        test.outputFil(arr, args[0]);

    }

    public int[] lesFil(String filNavn){

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
    
    public void outputFil(int[] list, String filNavn){
        
        String navn = filNavn + "_results.CSV";

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

            skriver.write("alg1_cmp, alg1_swaps, alg1_time");

            for(int i = 0; i < list.length + 1; i++){
                
                int[] array1 = new int[i];
                int[] array2 = new int[i];

                for(int k = 0; k < i; k++){
                    if(i == 0){
                        break;
                    }
                    else{
                        array1[k] = list[k];  
                    }
                }
                skriver.write("\n" + i  + ", ");
                /* 
                HeapSort heap = new HeapSort();
                int[] infoHeap = heap.getInfo(array1);
                skriver.write(infoHeap[0] + ", " + infoHeap[1] + ", " + infoHeap[2] + ", ");
                 */
                
                QuickSort quick = new QuickSort();
                int[] infoQuick = quick.getInfo(array2);
                skriver.write(infoQuick[0] + ", " + infoQuick[1] + ", " + infoQuick[2] + ", ");
                

                /* 
                SelectionSort selection = new SelectionSort();
                int[] infoSelect = selection.getInfo(array1);
                skriver.write(infoSelect[0] + ", " + infoSelect[1] + ", " + infoSelect[2] + ", ");
                 */

                /* 
                InsertionSort insertion = new InsertionSort();
                int[] infoInsertion = insertion.getInfo(array1);
                skriver.write(infoInsertion[0] + ", " + infoInsertion[1] + ", " + infoInsertion[2] + ", ");
                 */
            }
            skriver.close();
            
        } catch (IOException e){
            System.out.println("Noe gikk galt");
            e.printStackTrace();
        }
    }
}