import java.io.*;
import java.util.*;

class Innlevering3{

    HashMap<String, NodeFilm> ordbokFilmer = new HashMap<String, NodeFilm>();
    List<NodeFilm> listeOverFilmer = new ArrayList<>();
    List<NodeSkuespiller> listeOverSkuespillere = new ArrayList<>();
    
    public void lesFil(String filmer, String skuespillere){
        try{
            //Leser fil med filmer
            BufferedReader readerFilm = new BufferedReader(new FileReader(filmer));

            String linje = null;

            while((linje = readerFilm.readLine()) != null){

                String[] data = linje.split("\t");
                NodeFilm film = new NodeFilm(data[0], data[1], Float.parseFloat(data[2]));
                ordbokFilmer.put(data[0], film);
            }

             //Leser fil med Skuespillere
            BufferedReader readerSkuespillere = new BufferedReader(new FileReader(skuespillere));
            
            while((linje = readerSkuespillere.readLine()) != null){
                String[] data = linje.split("\t");
                List<String> film = new ArrayList<>();

                for(int i = 2; i <= data.length - 1; i++){
                    film.add(data[i]);
                }

                NodeSkuespiller actor = new NodeSkuespiller(data[0], data[1], film);
                listeOverSkuespillere.add(actor);
            }
            for(NodeFilm f : ordbokFilmer.values()){
                for(NodeSkuespiller s : listeOverSkuespillere){
                    List<String> list = s.hentListe();
                    if(list.contains(f.hentID())){
                        f.leggTilSkue(s);
                    }
                }
            }


        } catch(Exception e){
            System.out.println("Noe galt med metode lesfil");
            e.printStackTrace();
        }
    }

    public NodeFilm finnFilm(String id){
        NodeFilm film = ordbokFilmer.get(id);
        if(film == null){
            return null;
        }
        return film;
    }
    public int hentTotalKanter(){
        int kanter = 0;

        for(NodeFilm s : ordbokFilmer.values()){
            for(int i = s.hentCoStars().size(); i > 0; i--){
                kanter += i-1;
            }
        }
        return kanter;
    }

    public String breddeForstSok(String skuspillerID1, String skuspillerID2){

        NodeSkuespiller one = finnSkuespiller(skuspillerID1);
        NodeSkuespiller two = finnSkuespiller(skuspillerID2);

        if(one == null || two == null){
            if(one == null){
                System.out.println("Ugyldig ID for: " + skuspillerID1);
                return null;
            }
            System.out.println("Ugyldig ID for: " + skuspillerID2);
            return null;
        }
        
        String vei = one.hentNavn();

        for(String filmid : one.hentListe()){
            
            NodeFilm film = finnFilm(filmid);

            List<NodeSkuespiller> temp = film.hentCoStars();

            if(temp.contains(two)){
                //System.out.println("Er jeg inni her?");
                vei = vei + "\n" + "==[" + film.hentTittel() + "] ==> " + two.hentNavn();
                return vei;
            }
            vei = vei + "\n" + "==[" + film.hentTittel() + "] ==> ";
            //System.out.println(vei);
            vei = breddeForstSokDel2(vei, temp, one, two, filmid);
        }
        return vei;
    }
    public String breddeForstSokDel2(String vei, List<NodeSkuespiller> list, NodeSkuespiller start, NodeSkuespiller slutt, String filmid){
        
        String returVei = vei;
        //System.out.println("Kommer jeg hit?");
        for(NodeSkuespiller nss : list){
            if(nss != start){
                for(String filmidDenne : nss.hentListe()){
                    
                    if(filmidDenne != filmid){
                        NodeFilm film = finnFilm(filmid);

                        List<NodeSkuespiller> temp = film.hentCoStars();

                        if(temp.contains(slutt)){
                            returVei = nss.hentNavn() + "\n" + "==[" + film.hentTittel() + "] ==> " + slutt.hentNavn();
                            return returVei;
                        }
                        returVei = returVei + nss.hentNavn() + "\n" + "==[" + film.hentTittel() + "] ==> ";
                        breddeForstSokDel2(returVei, temp, nss, slutt, filmidDenne);
                    }
                }
            }
        }

        return returVei;
    }

    public NodeSkuespiller finnSkuespiller(String id){
        for(NodeSkuespiller s : listeOverSkuespillere){
            if(s.hentID().equals(id)){
                return s;
            }
        }
        System.out.println("Uguldig ID");
        return null;
    }
    /* public void Dijkstra(Node[] listeNoder, Node start, Node slutt){

    } */
}