import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Elefante> listaElefantes = new ArrayList<>();
        int contador = 1;

        String s;
        while (true) {
            s = br.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            StringTokenizer st = new StringTokenizer(s);
            Elefante elefante = new Elefante();
            elefante.peso = Integer.parseInt(st.nextToken());
            elefante.iq = Integer.parseInt(st.nextToken());
            elefante.id = contador++;
            listaElefantes.add(elefante);
        }

        Elefante[] arrayElefantes = listaElefantes.toArray(new Elefante[listaElefantes.size()]);
        Arrays.sort(arrayElefantes);

        int[] noMaximoElefantes = new int[arrayElefantes.length];
        noMaximoElefantes[0] = 1;
        for (int i = 1; i < noMaximoElefantes.length; i++) {
            noMaximoElefantes[i] = Math.max(1, noMaximoElefantes[i]);
            for (int j = 0; j < i; j++) {
                if (arrayElefantes[i].iq < arrayElefantes[j].iq && arrayElefantes[i].peso > arrayElefantes[j].peso) {
                    noMaximoElefantes[i] = Math.max(noMaximoElefantes[j] + 1, noMaximoElefantes[i]);
                }
            }
        }

        int max = 0;
        for (int i : noMaximoElefantes) {
            max = Math.max(i, max);
        }

        System.out.println(max);
        int[] soluciones = new int[max];

        boolean first = true;
        int last = 0;
        for (int i = noMaximoElefantes.length - 1; i >= 0 && max > 0; i--) {
            if (noMaximoElefantes[i] == max && (first || last < arrayElefantes[i].iq)) {
                last = arrayElefantes[i].iq;
                soluciones[--max] = arrayElefantes[i].id;
                first = false;
            }
        }

        for (int i = 0; i < soluciones.length; i++) {
            System.out.println(soluciones[i]);
        }
    }
}