import java.util.Scanner;
import java.io.File;
import java.util.*;

public class Oppgave1{

    Node rot;

    public Oppgave1(){
        rot = null;
    }
    
    public static void main(String[] args){
        Oppgave1 hei = new Oppgave1();

        hei.lesFil();
        
    }

    //Nodeklasse
    class Node{

        int data;

        Node venstre, hoyre;

        public Node(int data){

            this.data = data;

            venstre = hoyre = null;

        }
    }

    public void lesFil(){

        Scanner leser = new Scanner(System.in);

        try{
            //Leser linjene og finner nokkelord

            int les = Integer.parseInt(leser.nextLine());

            for(int i = 0; i < les; i++){
                
                String[] linje = leser.nextLine().split(" ");
                //kjorer legg til som kaller paa insert(x, data)
                if(linje[0].equals("insert")){
                    leggTil(Integer.valueOf(linje[1]));
                }
                //sjekker om node er i treet
                else if(linje[0].equals("contains")){
                    contains(rot, Integer.parseInt(linje[1]));
                }
                //fjerner node
                else if(linje[0].equals("remove")){
                    remove(rot, Integer.valueOf(linje[1]));
                }
                else if(linje[0].equals("size")){
                    size(rot);
                }
            }
        }
        catch(Throwable e){
            e.printStackTrace();
        }
    }

    public void contains(Node node, int data){

        System.out.print(inneholder(node, data) + "\n");

    }

    public boolean inneholder(Node node, int data){
        
        if(node == null){
            return false;
        }
        if(node.data == data){
            return true;
        }
        
        boolean sjekk1 = inneholder(node.venstre, data);

        if (sjekk1){
            return true;
        }

        boolean sjekk2 = inneholder(node.hoyre, data);

        return sjekk2;
    }

    public void leggTil(int data){
        rot = insert(rot, data);
    }

    public Node insert(Node node, int data){

        if(node == null){
            node = new Node(data);
            return node;
        }

        else if(node.data > data){
            node.venstre = insert(node.venstre, data);
        }
        else if(node.data < data){
            node.hoyre = insert(node.hoyre, data);
        }
        //Dersom data er lik, returner node siden ingen duplikater
        return node;
    }

    public Node remove(Node node, int data){

        if(node == null){
            return node;
        }
        
        if(rot.data == data){
            if(rot.venstre == null && rot.hoyre == null){
                rot = null;
                return rot;
            }
            if(rot.venstre == null || rot.hoyre == null){
                if(rot.venstre == null){
                    rot.data = rot.hoyre.data;
                    rot.hoyre = rot.hoyre.hoyre;
                    return rot;
                }
                else{
                    rot.data = rot.venstre.data;
                    rot.venstre = rot.venstre.venstre;
                    return rot;
                }
            }
        }
        
        if(node.data > data){
            node.venstre = remove(node.venstre, data);
            return node;
        }
        else if(node.data < data){
            node.hoyre = remove(node.hoyre, data);
            return node;
        }

        //sletting av node

        if(node.hoyre == null && node.venstre == null){
            return null;
        }
        else if(node.hoyre == null){

            node = node.venstre;
            return node;

        }
        else if(node.venstre == null){

            Node temp = node.hoyre;
            return temp ;

        }

        //kommer hit hvis begge barn finnes

        Node pappa = node;
        Node temp = node.hoyre;

        while(temp.venstre != null){
            pappa = temp;
            temp = temp.venstre;
        }

        if(pappa != node){           
            pappa.venstre = temp.hoyre; 
        }

        else{
            pappa.hoyre = temp.hoyre;
        }

        node.data = temp.data;
        
        return node;

    }

    public void size(Node node){
        System.out.println(strlse(node));
    }
    public int strlse(Node node){
        
        if(node == null){
            return 0;
        }
        else{
            return (1 + strlse(node.venstre) + strlse(node.hoyre));
        }

    }

    public void printTree(Node node){
        
        if(node != null){
            System.out.println(node.data);
            printTree(node.venstre);
            printTree(node.hoyre);
        }

    }
}