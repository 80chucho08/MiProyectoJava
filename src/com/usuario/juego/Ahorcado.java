package src.com.usuario.juego;
import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) {
        Scanner lee = new Scanner(System.in);

        
        String user_word;
        // Palabra a adivinar
        System.out.println("Escribe una palabra");
        user_word = lee.nextLine();

        
        
        char[] palabraOculta = new char[user_word.length()];
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
            char letra = lee.nextLine().toLowerCase().charAt(0);

            // Verificar si la letra está en la palabra
            boolean acierto = false;
            for (int i = 0; i < user_word.length(); i++) {
                if (user_word.charAt(i) == letra) {
                    palabraOculta[i] = letra;
                    acierto = true;
                }
            }

            if (!acierto) {
                intentos--;
                System.out.println("Letra incorrecta.");
            }

            // Verificar si se ha ganado o perdido
            if (String.valueOf(palabraOculta).equals(user_word)) {
                System.out.println("\n¡Felicidades! Has adivinado la palabra: " + user_word);
                juegoTerminado = true;
            } else if (intentos == 0) {
                System.out.println("\nTe has quedado sin intentos. La palabra era: " + user_word);
                juegoTerminado = true;
            }
        }

        lee.close();
    }
}
