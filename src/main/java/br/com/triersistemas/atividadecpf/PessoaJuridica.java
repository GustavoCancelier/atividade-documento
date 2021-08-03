package br.com.triersistemas.atividadecpf;

public class PessoaJuridica extends Pessoa {
	
	public PessoaJuridica(String documento) {
		super(documento);
	}

	@Override
	public Boolean verificar() {
		Integer primeiroVerificador = 0;
		Integer segundoVerificador = 0;
		Integer oitavoDig = 0;
		Integer soma = 0;
		Integer somaSegundo = 0;
		Integer somaOitavo = 0;
		Integer j = 6;
		char[] arrayDoc = super.getDocumento().toCharArray();
		String[] arrayString = new String[arrayDoc.length];
		Integer[] digitosInt = new Integer[arrayDoc.length];
		
		for (int i = 0; i < arrayDoc.length-2; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			soma += digitosInt[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		primeiroVerificador = soma % 11;
		j = 5;
		System.out.println(primeiroVerificador);
		
		for (int i = 0; i < arrayDoc.length-1; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaSegundo += digitosInt[i] * j;
			j++;
			if (j > 9) {
				j = 2;
			}
		}
		segundoVerificador = somaSegundo % 11;
		System.out.println(segundoVerificador);
		
		j = 2;
		for (int i = 0; i < arrayDoc.length-6; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
			digitosInt[i] = Integer.parseInt(arrayString[i]);
			somaOitavo += digitosInt[i] * j;
			System.out.println(somaOitavo);
			if (j == 2) {
				j = 1;
			} else if (j == 1) {
				j = 2;
			}
		}
		System.out.println(somaOitavo);
		oitavoDig = 30 - somaOitavo;
		System.out.println(oitavoDig);
		for (int i = 0; i < digitosInt.length; i++) {
			arrayString[i] = String.valueOf(arrayDoc[i]);
		}
		if (primeiroVerificador.equals(Integer.parseInt(arrayString[12])) && segundoVerificador.equals(Integer.parseInt(arrayString[13])) && oitavoDig.equals(Integer.parseInt(arrayString[7]))) {
			return true;
		}
		return false;
	}
}
