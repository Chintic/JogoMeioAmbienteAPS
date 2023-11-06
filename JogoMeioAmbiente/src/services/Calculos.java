package services;

public class Calculos {
	
	private final int POS_X_MINIMA = 0;
	private final int POS_X_MAXIMA = 530;
	private final int POS_Y_MINIMA = 0;
	private final int POS_Y_MAXIMA = 350;

	public int gerarPosXAleatoria() {
		return (int) Math.floor(Math.random() * (POS_X_MAXIMA - POS_X_MINIMA + 1) + POS_X_MINIMA);
	}

	public int gerarPosYAleatoria() {
		return (int) Math.floor(Math.random() * (POS_Y_MAXIMA - POS_Y_MINIMA + 1) + POS_Y_MINIMA);
	}

	public double calcularDistancia(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
	}
}
