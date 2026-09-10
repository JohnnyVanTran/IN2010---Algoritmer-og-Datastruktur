import java.util.*;
import java.lang.*;

public class Oppgave4{

    ArrayList<Integer> liste = new ArrayList<>();
    int[] ny;
    static int index = 0;


    public void sorter(){

        ny = new int[liste.size()];

        hentTall(0, liste.size() - 1);
        //ny[ny.length - 1] = liste.get(0);
    }
    public void finn() {

        String input = " ";

        while (input != "stop") {
            
            try{
                Scanner scanner = new Scanner(System.in);
                input = scanner.nextLine();

                liste.add(Integer.parseInt(input));
            }
            catch(Exception e){
                return;
            }
            
        }
    }

    public void hentTall(int low, int high){
        
        int mid = (low + high)/2;

        ny[index] = liste.get(mid);

        index += 1;

        hentVenstre(low, mid);
        hentHoyre(mid, high);
   
    }
    public void hentVenstre(int low, int high){
        
         int mid = (low + high)/2;

         if(mid == low){
             ny[index] = liste.get(low); 
             return;
         }
        if(high == low + 1){
            ny[index] = liste.get(high);
            return;
        }

        ny[index] = liste.get(mid);
        index += 1;
        hentVenstre(low, mid);
        hentHoyre(mid, high);
        
    }
    public void hentHoyre(int low, int high){
        
        double lav = low;
        double hoy = high;

        int mid = (int)Math.ceil((hoy + lav)/2.0);

        if(mid == high){
            ny[index] = liste.get(mid);
            return;
        }
        if(low == high - 1){
            ny[index] = liste.get(high);
            return;
        }
        ny[index] = liste.get(mid);
        index += 1;
        hentVenstre(low, mid);
        hentHoyre(mid, high);
    }

    public static void main(String[] args){
        Oppgave4 hei = new Oppgave4();
        hei.finn();
        hei.sorter();
        
        
        for(int i : hei.ny){
            System.out.println("ny: " + i);
        }
        for(int i : hei.liste){
            System.out.println("liste: " + i);
        }
        System.out.println("index: " + hei.index);
    }
}