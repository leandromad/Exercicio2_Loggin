package com.Calculadora;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;

public class Principal {

	public static void main(String[] args) throws IOException{
		Log meuLogger = new Log("Log.txt");
		try {
			
			

		} catch (Exception e) {
			
			meuLogger.logger.info("Exception" + e.getMessage());
			e.printStackTrace();
		}
		
		//Mensagens escritas no Log
		meuLogger.logger.info("\n O programa iniciou a chamada da Calculadora!!");//escrever no log
		
		try (Scanner leitura = new Scanner(System.in)) {
			Calculadora c = new Calculadora();
			float a = 0, b = 0, resultado = 0;
			String operador;
			System.out.println("Calculadora");
			do {
				System.out.println("Insira o operador +, -, *, /");
				operador = leitura.nextLine();
			} while (!(operador.contains("+") || operador.contains("-") || operador.contains("*")
					|| operador.contains("/")));

			System.out.println("Insira o 1o valor");
			a = leitura.nextFloat();
			System.out.println("Insira o 2o valor");
			b = leitura.nextFloat();

			resultado = c.calcular(a, b, operador.charAt(0));
			if (operador.contains("-") & b > a) {
				System.out.println("O resultado de " + b + " " + operador + " " + a + " é:" + resultado);
				meuLogger.logger.warning("Foi efetuada a troca de valor entre a e b para a subtração voltar positiva");
			} else if (operador.contains("-") & a > b) {
				System.out.println("O resultado de " + a + " " + operador + " " + b + " é:" + resultado);
			} else if (operador.contains("/") & b == 0) {
				meuLogger.logger.warning("Impossível realizar divisão por 0");
			}else {
				System.out.println("O resultado de " + b + " " + operador + " " + a + " é:" + resultado);
			}
			
			//Mensagens escritas no Log
			meuLogger.logger.info("\n O programa terminou as operações da calculadora com Resultado="+resultado);//escrever no log
			
		}

	}

}
