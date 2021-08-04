package br.com.triersistemas.atividadecpf;

import java.math.BigDecimal;
import java.util.SplittableRandom;

public class PessoaFisica extends Pessoa {

	public PessoaFisica(String documento) {
		super(documento);
	}

	@Override
	public Boolean verificar() {
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer j = 1;
		char[] arrayDoc = super.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];
		
		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
		}
		primeiroVerificador = soma % 11;
		j = 0;
		System.out.println(primeiroVerificador);
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
		}
		segundoVerificador = somaSegundo % 11;
		System.out.println(segundoVerificador);
		
		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[9])) && segundoVerificador.equals(Integer.parseInt(arrayString[10]))) {
			return true;
		}
		return false;
	}

	@Override
	public String geraDoc() {
		Integer[] vetor = new Integer [11];
		String[] vetorString = new String[11];
		String cpf = "";
		for (int i = 0; i < 11; i++) {
			 vetor[i] = new SplittableRandom().nextInt(0, 10);
			 vetorString[i] = String.valueOf(vetor[i]);
		}
		
		for (int i = 0; i < vetorString.length; i++) {
			cpf += vetorString[i];
		}
		return cpf;
	}

	@Override
	public String formataDoc() {
		String cpf = super.getDocumento();
		cpf = cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-" + cpf.substring(9, 11);
		return cpf;
	}

}
