package asdasdasda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class testaondao {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite os nomes: ");

        try {
            String[] vector = scanner.nextLine().split(" ");
            System.out.println("Nome de qual posição? ");
            int posicao = scanner.nextInt();
            System.out.println(vector[posicao -1]);
        } catch (InputMismatchException e) {
            System.out.println("Erro de input! ");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Posição inválidada!");
        } finally {
            scanner.close();
        }

        System.out.println("Fim do programa.");
    }
}
