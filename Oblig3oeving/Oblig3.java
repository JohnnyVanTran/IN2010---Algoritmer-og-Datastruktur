import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class Oblig3 {
    public static void main(String[] args) {
        Oblig3 oblig3 = new Oblig3();
        oblig3.lesInn(args[0],args[1]);

        System.out.println("-------OPPGAVE 1------");
        oblig3.printDataset();

        System.out.println("-------OPPGAVE 3-------");
        oblig3.djiekstra(oblig3.actorList.get("nm2255973"),oblig3.actorList.get("nm0000460"));
        oblig3.djiekstra(oblig3.actorList.get("nm0424060"),oblig3.actorList.get("nm0000243"));

        System.out.println("-------OPPGAVE 4-------");

    }

    class Movies{
        String id, name;
        double rating;
        List<Actor> actors;
        Movies(String id, String name, double rating){
            this.id = id;
            this.name = name;
            this.rating = rating;
            actors = new ArrayList<>();
        }
        @Override
        public String toString(){
            return name + " (" + rating + ")";
        }
    }

    class Actor{
        String id, name;
        List<Movies> movies;
        Actor(String id, String name){
            this.id = id;
            this.name = name;
            movies = new ArrayList<>();
        }
        //Liste med alle kanter den er involvert i
        @Override
        public String toString() {
            return name;
        }
    }

    class Edge implements Comparable<Edge>{
        Actor actor1;
        Actor actor2;
        Movies movie;
        double weight;
        Edge(Movies movie, Actor actor1, Actor actor1, double weight){
            this.actor1 = actor;
            this.actor2 = actor2;
            this.movie = movie;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Double.compare(weight, o.weight);
        }
        @Override
        public String toString(){
            return actor.toString();
        }
    }

    HashMap<String,Actor> actorList;
    HashMap<String,Movies> movieList;

    Oblig3(){
        actorList = new HashMap<>();
        movieList = new HashMap<>();
    }


    void lesInn(String movies, String actors){
        try {
            BufferedReader br = new BufferedReader(new FileReader(movies));
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.strip().split("\t");
                movieList.put(data[0], new Movies(data[0], data[1], Double.parseDouble(data[2])));
            }

            br = new BufferedReader(new FileReader(actors));

            while ((line = br.readLine())!=null) {
                String[] data = line.strip().split("\t");
                Actor a = new Actor(data[0], data[1]);
                for (int i = 2; i < data.length; i++) {
                    try {
                        movieList.get(data[i]).actors.add(a);
                        a.movies.add(movieList.get(data[i]));
                    } catch (NullPointerException ignored) {
                    }
                }
                actorList.put(data[0], a);
            }
        }
        catch (Exception e){
            System.out.println(e.getLocalizedMessage());
        }
    }
    void printDataset(){
        System.out.println("Antall skuespillere: " + actorList.size());
        int count =0;
        for (Movies movies: movieList.values()){
            count = count + ((movies.actors.size()-1)*movies.actors.size()/2);
        }
        System.out.println("Antall kanter: "+ count + "\n");

    }
    /* void bfs(Actor a, Actor b){
        HashMap<Actor,Edge> road = new HashMap<>();
        ArrayList<Edge> queue = new ArrayList<>();
        Edge first = new Edge(null,b,0);
        Edge end = first;
        queue.add(first);
        road.put(b,null);
        while(!queue.isEmpty()){
            Edge edge = queue.remove(0);
            for (Movies m:edge.actor.movies){
                for (Actor actor: m.actors){
                    if (road.get(actor)==null){
                        road.put(actor,edge);
                        Edge placeholder = new Edge(m,actor,0);
                        if (actor == a){
                            end = placeholder;
                            break;
                        }
                        queue.add(placeholder);
                    }
                }
            }
        }
        System.out.println(end.actor);
         while (end != first)
        {
            System.out.println("===[" + end.movie + "] ===> " + road.get(end.actor) );
            end = road.get(end.actor);
        }
        System.out.println("\n");
    } */


    void djiekstra(Actor a, Actor b){
        HashMap<Actor,Edge> road = new HashMap<>();
        PriorityQueue<Edge> queue = new PriorityQueue<>();
        Edge first = new Edge(null,b,null,0);
        Edge end = first;
        queue.add(first);
        road.put(b,null);

        while(!queue.isEmpty()){
            Edge kant = queue.poll();

            if(kant.actor1 == a){
                end = kant;
                break;
            }
            for(Movies m : kant.actor1.movies){
                for(Actor actor : m.actors){
                    double vekt = kant.vekt + (10 - m.rating);

                    if(road.get(actor) == null)
                }
            }
        }
        double totWeight = end.weight;
        System.out.println(end.actor);
        while(end.actor!=first.actor){
            System.out.println("===[" + end.movie + "] ===> " + road.get(end.actor) );
            end = road.get(end.actor);
        }
        System.out.print("TOTAL WEIGHT: " + String.format("%.3s", totWeight) + "\n");
        System.out.println("\n");
    }
}
