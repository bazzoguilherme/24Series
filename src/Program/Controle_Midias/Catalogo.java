package Program.Controle_Midias;

import Program.Midias.Midia;

public class Catalogo extends Banco {

    public Catalogo(){
        super();
    }

    public void coletaEstatisticas(){

    }

    public Midia selecionaMidia(String nomeMidia){
        return this.selecionaMidiaEspecifica(nomeMidia);
    }

    private Midia selecionaMidiaEspecifica(String nomeMidia){
        Midia midiaRetorno = super.selecionaSerie(nomeMidia);
        if (midiaRetorno == null){
            midiaRetorno = super.selecionaFilme(nomeMidia);
        }
        return midiaRetorno;
    }

}
