package br.com.triersistemas.atividadecpf;

public class App {

    public static void main(String[] args) {
    	PessoaFisica pf = new PessoaFisica("12300009927");
    	PessoaJuridica pj = new PessoaJuridica("18781203000128"); 
        System.out.println(pf.verificar());
        System.out.println(pj.verificar());
    }
}
