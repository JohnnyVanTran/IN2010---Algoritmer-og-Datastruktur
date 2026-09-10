class Lol{

    private String title;
    private String author;
    private int nop;

    public Lol(String title, String a, int n){
        title = t;
        author = a;
        nop = n;
    }

    public void skrivUt(){
        System.out.println(title + ", " + author + ", " + nop);
    }

    public static void main(String[] args){
        Lol l = new Lol("Johnny", "Magnus", 123);
        l.skrivUt();
    }
}