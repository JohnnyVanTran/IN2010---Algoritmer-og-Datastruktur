import java.io.*;
import java.util.*;

class NodeFilm{

    private String id;
    private String tittel;
    private float rating;
    private List<NodeSkuespiller> coStars = new ArrayList<>();

    public NodeFilm(String id, String tittel, float rating){
        this.id = id;
        this.tittel = tittel;
        this.rating = rating;
    }
    public String hentID(){
        return id;
    }
    public String hentTittel(){
        return tittel;
    }
    public float hentRating(){
        return rating;
    }
    public void leggTilSkue(NodeSkuespiller s){
        coStars.add(s);
    }
    public List<NodeSkuespiller> hentCoStars(){
        return coStars;
    }
}