class Tortuga implements Comparable<Tortuga> {
    public int peso;
    public int fuerza;

    @Override
    public int compareTo(Tortuga tortuga) {
        if (this.fuerza == tortuga.fuerza)
            return this.peso - tortuga.peso;
        return (this.fuerza) - (tortuga.fuerza);
    }
}