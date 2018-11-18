package Program.Controle_Midias;

import Program.Midias.Midia;

public class Catalogo extends Banco {

    public Catalogo(){
        super();
    }
    
    public Midia selecionaMidia(String nomeMidia){
        Midia midiaRetorno = super.selecionaSerie(nomeMidia);
        if (midiaRetorno == null){
            return super.selecionaFilme(nomeMidia);
        }
        return midiaRetorno;
    }
}
