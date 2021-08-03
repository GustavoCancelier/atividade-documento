package br.com.triersistemas.atividadecpf;

public abstract class Pessoa {
	private String documento;

	public Pessoa (String documento) {
		this.documento = documento;
	}

	public abstract Boolean verificar();

	public String getDocumento() {
		return documento;
	}

}
