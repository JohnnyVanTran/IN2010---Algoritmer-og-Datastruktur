import java.io.FileNotFoundException;
import java.util.Scanner;

class Oppgave2{

    class Node {
        Node neste = null;
        Node forrige = null;
        int data;
        Node(int x) {
            data = x;
        }
    }
    protected Node start = null;
    protected Node siste = null;
    protected int teller = 0;

    public void lesInn() {
        Scanner scanner = new Scanner(System.in);
        int antKomando = scanner.nextInt();
        int i = 0;
        while (i < antKomando+1){
            String data = scanner.nextLine();
            String[] oppdeltData = data.strip().split(" ");
            if (oppdeltData[0].equalsIgnoreCase("push_back")){
                test(Integer.parseInt(oppdeltData[1]),"b");

            }
            else if (oppdeltData[0].equalsIgnoreCase("push_front")){
                test(Integer.parseInt(oppdeltData[1]),"f");
            }
            else if (oppdeltData[0].equalsIgnoreCase("push_middle")){
                test(Integer.parseInt(oppdeltData[1]),"m");
            }
            else if (oppdeltData[0].equalsIgnoreCase("get")){
                System.out.println("Henter: " + hent(Integer.parseInt(oppdeltData[1])));
            }
            i++;
        }
    }

    public int stoerrelse(){
        return teller;
    }

    public void test(int x, String s){
        Node ny = new Node(x);
        if (start == null) start = siste = ny;

        if (s.equalsIgnoreCase("f")){
            ny.neste = start;
            start = ny;
            if (stoerrelse()==1){
                siste = ny;
            }
            teller++;
        }
        else if (s.equalsIgnoreCase("m")){
            Node tmp = start;
            for (int i = 0; i < ((stoerrelse()) / 2); i++) {
                tmp = tmp.neste;
            }
            ny.neste = tmp.neste;
            tmp.neste = ny;
            if (stoerrelse() == 1){
                siste = ny;
            }
            teller++;
        }
        else if (s.equalsIgnoreCase("b")){
            siste.neste = ny;
            ny.forrige = siste;
            siste = ny;
            teller++;
        }
    }

    public int hent(int pos) {
        Node tmp = start;
        for (int i = 0; i< pos; i++){
            tmp = tmp.neste;
        }
        return tmp.data;
    }
    public static void main(String[] args) throws FileNotFoundException {
        Oppgave2 test = new Oppgave2();
        test.lesInn();
    }
}