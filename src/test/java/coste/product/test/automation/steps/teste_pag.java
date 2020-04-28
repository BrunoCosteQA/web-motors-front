package coste.product.test.automation.steps;

import java.util.Scanner;

public class teste_pag {

	public static void main(String[] args) throws InterruptedException {

//        Scanner entrada = new Scanner(System.in);
//        System.out.println("Digite um número:");
//        int num = entrada.nextInt();

		for (int i = 1; i <= 10; i++) {
			if (i % 2 == 0) {
				System.out.println("Números Pares: " + i);
			}
		}
	}
}
