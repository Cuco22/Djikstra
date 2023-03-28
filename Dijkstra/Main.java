public class Main {
    public static void main(String[] args) {
        Nodo n1=new Nodo("A");
        Nodo n2=new Nodo("B");
        Nodo n3=new Nodo("C");
        Nodo n4=new Nodo("D");
        n1.link(n2,10);

        Dijkstra dijkstra = new Dijkstra();

        System.out.println(dijkstra.toString());
    }
}