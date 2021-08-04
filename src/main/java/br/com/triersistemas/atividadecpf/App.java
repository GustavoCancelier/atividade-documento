package br.com.triersistemas.atividadecpf;

public class App {

    public static void main(String[] args) {
    	PessoaFisica pf = new PessoaFisica("12300009927");
    	PessoaJuridica pj = new PessoaJuridica("18781203000128"); 
    	PessoaFisica pp  = new PessoaFisica(pf.geraDoc());
    	System.out.println(pp.formataDoc());
        System.out.println(pp.verificar());
        //System.out.println(pj.verificar());
        //System.out.println(pf.geraDoc());
        //System.out.println(pj.geraDoc());
        
        //System.out.println(pj.formataDoc());
    	
    }
}
