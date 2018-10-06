public class Elefante implements Comparable<Elefante> {
    int peso, iq, id;

    public int compareTo(Elefante elefante) {
        return this.peso - elefante.peso;
    }
}