package br.com.java.prova.v2;

public class MediaArrayBidimensional {

	public float[][] calcularMedia(float vetor[][]) {

		float vetorMedia[][] = new float[vetor.length][vetor[0].length];

		for (int linha = 0; linha < vetor.length; linha++) {
			for (int coluna = 0; coluna < vetor[0].length; coluna++) {

				float mediaVizinhos = this.mediaVizinhos(vetor, linha, coluna);

				vetorMedia[linha][coluna] = mediaVizinhos;
			}
		}
		return vetorMedia;
	}

	private float mediaVizinhos(float[][] vetor, int linha, int coluna) {

		float contador = 1;
		float soma = 0;

		soma += vetor[linha][coluna];

		// esquerda
		if (coluna - 1 >= 0) {
			contador++;
			soma += vetor[linha][coluna - 1];
		}

		// direita
		if (coluna + 1 < vetor[linha].length) {
			contador++;
			soma += vetor[linha][coluna + 1];
		}

		// acima
		if (linha - 1 >= 0) {
			contador++;
			soma += vetor[linha - 1][coluna];
		}

		// abaixo
		if (linha + 1 < vetor.length) {
			contador++;
			soma += vetor[linha + 1][coluna];
		}

		return soma / contador;

	}

	public static void main(String[] args) {

		float vetor[][] = { { 15, 5, 10 }, { 18, 11, 5 }, { 16, 18, 7 } };

		MediaArrayBidimensional bidimensional = new MediaArrayBidimensional();
		float mediaMatriz[][]  = bidimensional.calcularMedia(vetor);
		
		for (int linha = 0; linha < mediaMatriz.length; linha++) {
			for (int coluna = 0; coluna < mediaMatriz[0].length; coluna++) {
				System.out.println(mediaMatriz[linha][coluna]);
			}
			System.out.println();
		}

	}

}