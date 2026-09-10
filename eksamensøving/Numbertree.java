import java.util.*;

class Numbertree{

    public static void main(String[] args){
        
        Scanner scanner = new Scanner(System.in);
        Numbertree hallo = new Numbertree();
        
        while(scanner.hasNext()){
            hallo.funksjon(scanner.nextLine());
        }
        
    }
    
    private int getRight(int i){
        return (2*i + 2);
    }
    private int getLeft(int i){
        return (2*i + 1);
    }
    
    private void funksjon(String s){
        
        String[] input = s.split(" ");

        int tall = Integer.parseInt(input[0]);
        int tallTilTre = 0;
        
        while(tall >= 0){
            tallTilTre += (1 << tall);
            tall--;
        }
        
        int[] tree = new int[tallTilTre];
        
        for(int i = 0; i < tree.length; i++){
            tree[i] = tallTilTre;
            tallTilTre--;
        }
        if(input.length == 1){
            System.out.println(tree[0]);
        }
        else{
            String[] retning = input[1].split("");
            int i = 0;
            int index = 0;
            while(i < retning.length){
                if(retning[i].equals("R")){
                    index = getRight(index);
                }
                else if (retning[i].equals("L")){
                    index = getLeft(index);
                }
                i++;
            }
            System.out.println(tree[index]);
        }
    }
}