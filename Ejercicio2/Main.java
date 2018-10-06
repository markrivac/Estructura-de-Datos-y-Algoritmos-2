
// En el Readme está el análisis para encontrar la solución

import java.io.*;
import java.util.*;

class Main {
    public Tortuga[] listaTortugas;
    public int cantidadTortugas;

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.init();
        System.out.println(main.solve());
    }

    public void init() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        listaTortugas = new Tortuga[5607];
        cantidadTortugas = 0;
        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            Tortuga tortuga = new Tortuga();
            tortuga.peso = Integer.parseInt(st.nextToken());
            tortuga.fuerza = Integer.parseInt(st.nextToken());
            listaTortugas[cantidadTortugas++] = tortuga;
        }
    }

    public int solve() {
        Arrays.sort(listaTortugas,0,cantidadTortugas);
        int tamañoLista = cantidadTortugas;
        int[] arraySolucion = new int[tamañoLista + 1];
        Arrays.fill(arraySolucion, Integer.MAX_VALUE);
        arraySolucion[0] = 0;
        int result = -1;

        for (int i = 1; i < tamañoLista; i++) {
            Tortuga tortugaA = listaTortugas[i-1];
            for (int j = tamañoLista-1; j > 0; j--) {
                int pesoTortugaB = arraySolucion[j-1];
                if (tortugaAPuedeTortugaB(tortugaA, pesoTortugaB)) {
                    arraySolucion[j] = Math.min(arraySolucion[j], arraySolucion[j-1]+listaTortugas[i-1].peso);
                }
            }
        }
        for(int i=0;i<cantidadTortugas;i++){
            if(arraySolucion[i]!=Integer.MAX_VALUE){
                result = i;
            }
        }
        return result;
    }
    public boolean tortugaAPuedeTortugaB(Tortuga tortugaA, int pesoTortugaB){
        if ((tortugaA.fuerza-tortugaA.peso) >= pesoTortugaB) {
            return true;
        }
        return false;
    }
}