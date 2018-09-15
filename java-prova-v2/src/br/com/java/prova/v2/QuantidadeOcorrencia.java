package br.com.java.prova.v2;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuantidadeOcorrencia {

	public List<Ocorrencia> listarQuantidadPorNomes() {

		List<String> nomeList = Arrays.asList("Pedro", "João", "Maria", "JOAO", "Alberto", "João", "MARiA");

		Collections.sort(nomeList);
		List<String> nomes = this.converterToUpperCase(nomeList);

		Integer quantidade = 0;
		List<Ocorrencia> ocorrencias = new ArrayList<>();

		for (int i = 0; i < nomes.size(); i++) {

			quantidade = 0;

			for (int j = 0; j < nomes.size(); j++) {

				if (nomes.get(i).equalsIgnoreCase(nomes.get(j))) {
					quantidade++;
				}
			}

			boolean possui = this.possuiOcorrencia(ocorrencias, nomes.get(i));

			if (!possui) {
				ocorrencias.add(new Ocorrencia(nomes.get(i), quantidade));
			}
		}

		return ocorrencias;
	}

	private boolean possuiOcorrencia(List<Ocorrencia> ocorrencias, String nome) {

		boolean possui = false;

		for (Ocorrencia ocorrencia : ocorrencias) {
			if (nome.equals(ocorrencia.getNome())) {
				possui = true;
				break;
			}
		}

		return possui;
	}

	private List<String> converterToUpperCase(List<String> nomesList) {

		List<String> nomes = new ArrayList<>();
		for (String nome : nomesList) {
			nomes.add(removerAcentos(nome).toUpperCase());
		}

		return nomes;
	}

	public static String removerAcentos(String str) {
		return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
	}

	public static void main(String[] args) {
		QuantidadeOcorrencia oco = new QuantidadeOcorrencia();
		List<Ocorrencia> ocorrencias = oco.listarQuantidadPorNomes();

		for (Ocorrencia ocorrencia : ocorrencias) {
			System.out.println("Nome:" + ocorrencia.getNome() + " Quantidade:" + ocorrencia.getQuantidade());
		}
	}

}
