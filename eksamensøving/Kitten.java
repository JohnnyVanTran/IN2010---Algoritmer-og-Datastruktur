import java.util.*;

class Kitten{

    HashMap<Integer, int[]> ordbok = new HashMap <Integer, int[]>();
    int gren = 0;

    private void inputs(String s){
        
        String[] inp = s.split(" ");
        if(inp.length == 1){
            gren = Integer.parseInt(inp[0]);
        }
        else{
            int[] list = new int[inp.length - 1];
            for(int i = 1; i <= inp.length - 1; ){
                list[i - 1] = Integer.parseInt(inp[i]);
            }
            ordbok.put(Integer.parseInt(inp[0]), list);
        }
    }
    public static void main(String[] args){

        Scanner leser = new Scanner(System.in);
        Kitten katt = new Kitten();

    }
}