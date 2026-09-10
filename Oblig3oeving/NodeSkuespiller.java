import java.io.*;
import java.util.*;

class NodeSkuespiller{

    private String id;
    private String navn;
    private List<String> skuespillerFilmer;

    public NodeSkuespiller(String id, String navn, List<String> filmID){
        this.id = id;
        this.navn = navn;
        this.skuespillerFilmer = filmID;
    }
    public String hentID(){
        return id;
    }
    public String hentNavn(){
        return navn;
    }
    public List<String> hentListe(){
        return skuespillerFilmer;
    }
}