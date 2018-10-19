package Program.Controle_Midias;

import Program.Midias.Registro;

import java.util.Hashtable;

public class Colecao {
    private String nome;
    private Hashtable<String, Registro> registros;
    private final String COLECAOPADRAO = "Colecao Padrao";

    public Colecao(){
        this.nome = COLECAOPADRAO;
        this.registros = new Hashtable<>();
    }

    public Colecao(String nomeColecao){
        this.nome = nomeColecao;
        this.registros = new Hashtable<>();
    }


    public String getNome() {
        return this.nome;
    }

    public Hashtable<String, Registro> getRegistros() {
        return this.registros;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionaRegistro(Registro reg){
        this.registros.put(reg.getNome(), reg);
    }

    public void removeRegistro(String nomeReg){
        this.registros.remove(nomeReg);
    }

}
