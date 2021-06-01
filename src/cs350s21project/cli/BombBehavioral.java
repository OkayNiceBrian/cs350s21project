package cs350s21project.cli;

import cs350s21project.cli.Bomb.E_ErrorType;

public class BombBehavioral {

	public static void main(String[] args) {

		System.out.println("No Error No Wind:");
		Bomb bombNoErrorNoWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.NONE, 0.0, 0.0, 0.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombNoErrorNoWind.drop());
		}
		System.out.println();
		
		System.out.println("No Error With Wind:");
		Bomb bombNoErrorWithWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.NONE, 0.0, 60.0, 25.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombNoErrorWithWind.drop());
		}
		System.out.println();
		
		System.out.println("Uniform Error No Wind:");
		Bomb bombUniformErrorNoWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.UNIFORM, 150.0, 0.0, 0.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombUniformErrorNoWind.drop());
		}
		System.out.println();
		
		System.out.println("Gaussian Error No Wind:");
		Bomb bombGaussianErrorNoWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.GAUSSIAN, 150.0, 0.0, 0.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombGaussianErrorNoWind.drop());
		}
		System.out.println();
		
		System.out.println("Uniform Error With Wind:");
		Bomb bombUniformErrorWithWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.UNIFORM, 150.0, 60.0, 25.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombUniformErrorWithWind.drop());
		}
		System.out.println();
		
		System.out.println("Gaussian Error With Wind:");
		Bomb bombGaussianErrorWithWind = new Bomb(200.0, 300.0, 1500.0, 100.0, E_ErrorType.GAUSSIAN, 150.0, 60.0, 25.0);
		for (int i = 0; i < 100; i++) {
			System.out.println(bombGaussianErrorWithWind.drop());
		}
		System.out.println();

	}

}
