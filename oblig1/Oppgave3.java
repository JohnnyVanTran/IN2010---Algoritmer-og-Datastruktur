import java.util.HashMap;
import java.util.Scanner;

public class Oppgave3 {
    public static void lesInn(){
        Scanner scanner = new Scanner(System.in);
        int x = Integer.parseInt(scanner.nextLine());
        HashMap<Integer,Integer> map = new HashMap<>();

        String[] data = scanner.nextLine().strip().split(" ");
        int rot = Integer.parseInt(data[0]);
        int y = 0;
        for (int i=1; i < data.length;i++){
            map.put(Integer.parseInt(data[y+1]),Integer.parseInt(data[0]));
            y++;
        }
        while (!data[0].equalsIgnoreCase("")){
            try {
                data = scanner.nextLine().strip().split(" ");
            }
            catch (Exception e){
                break;
            }
            int teller = 0;
            for (int i=1; i < data.length;i++){
             map.put(Integer.parseInt(data[teller+1]),Integer.parseInt(data[0]));
             teller++;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(x).append(" ");
        while (x != rot){
            x = map.get(x);
            stringBuilder.append(x).append(" ");
        }
        System.out.println(stringBuilder);
    }

    public static void main(String[] args){
        lesInn();
    }
}
