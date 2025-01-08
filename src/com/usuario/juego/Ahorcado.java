import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Palabra a adivinar
        String palabra = "programacion";
        char[] palabraOculta = new char[palabra.length()];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = '_';
        }

        int intentos = 6; // Máximo de intentos
        boolean juegoTerminado = false;

        System.out.println("¡Bienvenido al juego del Ahorcado!");

        while (!juegoTerminado) {
            System.out.println("\nPalabra: " + String.valueOf(palabraOculta));
            System.out.println("Intentos restantes: " + intentos);
            System.out.print("Ingresa una letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            // Verificar si la letra está en la palabra
            boolean acierto = false;
            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    palabraOculta[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentos--;
                System.out.println("Letra incorrecta.");
            }

            // Verificar si se ha ganado o perdido
            if (String.valueOf(palabraOculta).equals(palabra)) {
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + palabra);
                juegoTerminado = true;
            } else if (intentos == 0) {
                System.out.println("\nTe has quedado sin intentos. La palabra era: " + palabra);
                juegoTerminado = true;
            }
        }

        scanner.close();
    }
}
