import java.util.TreeMap;

import static java.lang.Integer.MAX_VALUE;

public class Nodo {
    private String label;
    private int peso =MAX_VALUE;
    public TreeMap <Nodo, Integer> links;
    private Nodo prev = null;

    //get e set degli attributi
    public Nodo(String label){
        this.label=label;
        links=new TreeMap<>((a,b) -> a.label.compareTo(b.label));
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public int getpeso() {
        return peso;
    }

    public void setpeso(int weight) {
        this.peso = weight;
    }

    public TreeMap<Nodo, Integer> getLinks() {
        return links;
    }

    public void setLinks(TreeMap<Nodo, Integer> links) {
        this.links = links;
    }

    public Nodo getPrev() {
        return prev;
    }

    //metodo per collegare due nodi
    public void link(Nodo nodo2, Integer weight) {
        this.links.put(nodo2, weight);
        nodo2.links.put(this, weight);
    }
    //pre calcolare il costo per raggiungere un nodo
    public int weightTo(Nodo n){
        return peso + links.get(n); //get-> restituisce il valore associato alla key specificata
    }

    //istruzione per stampare ricorsivamente il percorso ottimale
    public String getPath(){
        String weight = "";
        if(this.peso <MAX_VALUE){
            peso +=this.peso;
        }else{
            peso = Integer.parseInt("inf");
        }
        String out=null;
        if(prev!=null){
            out=prev.getPath() +"-"+prev.links.get(this) + "->" + out;
        }
        return out;
    }
}

