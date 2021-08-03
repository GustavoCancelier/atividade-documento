package br.com.triersistemas.atividadecpf;

import java.math.BigDecimal;

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

}
