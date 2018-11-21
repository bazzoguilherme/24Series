package Tests.Test_Arquivo;

import Program.Arquivos.ProcessadorArquivo;
import Program.Controle_Midias.Catalogo;
import Program.Controle_Midias.Colecao;
import Program.Controle_Midias.Repositorio;
import Program.Midias.Filme;
import Program.Midias.Registro;
import Program.Midias.Serie;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ProcessadorArquivoTest {
    private static ProcessadorArquivo processaArq;
    private static final String NOMETESTE1 = "Mr. Robot";
    private static final String NOMETESTE2 = "Haikyuu";
    private static final String NOMETESTE3 = "Your Name";
    private static final String NOMEARQUIVOTESTE = "24catalogoTeste.csv";
    private static final String NOMEARQUIVOTESTEERRO = "23catalogoTeste.csv";
    private static final String NOMEARQUIVOTESTESAIDA = "novo24TesteSaida.csv";
    private static final String NOMEARQUIVOTESTEREPOSITORIO = "24RepositorioUsuario.csv";
    private static final String NOMEARQUIVOTESTEREPOSITORIOSAIDA = "24RepositorioUsuarioSAIDA.csv";
    private static final String NOMEARQUIVOTESTECOLECAO = "24ColecoesUsuario.csv";
    private static final String NOMEARQUIVOTESTECOLECAOSAIDA = "24ColecoesUsuarioSAIDA.csv";
    private static final String NOMECOLECAO1 = "Favoritos";

    @BeforeAll
    static void setUpClass(){
        processaArq = new ProcessadorArquivo();
    }

    @Test
    void criaCatalogo() {
        Catalogo catalogoTeste;
        catalogoTeste = processaArq.criaCatalogo(NOMEARQUIVOTESTE);
        assertEquals(NOMETESTE1, catalogoTeste.selecionaSerie(NOMETESTE1).getNome());
        assertEquals(NOMETESTE2, catalogoTeste.selecionaSerie(NOMETESTE2).getNome());
        assertEquals(NOMETESTE3, catalogoTeste.selecionaFilme(NOMETESTE3).getNome());
    }

    @Test
    void arquivoNaoEncontrado(){ // Verifica se não há erro durante a execução com um arquivo inexistente
        processaArq.criaCatalogo(NOMEARQUIVOTESTEERRO);
    }

    @Test
    void gravaCatalogo(){
        Catalogo catalogoTeste;
        catalogoTeste = processaArq.criaCatalogo(NOMEARQUIVOTESTE);
        processaArq.gravaCatalogo(NOMEARQUIVOTESTESAIDA, catalogoTeste);
    }

    @Test
    void criaRepositorio(){
        Repositorio repositorio;
        repositorio = processaArq.criaRepositorio(NOMEARQUIVOTESTEREPOSITORIO);
        for(String key : repositorio.getFilmes().keySet()){
            System.out.println(repositorio.getFilmes().get(key).toArq());
        }
        for(String key : repositorio.getSeries().keySet()){
            System.out.println(repositorio.getSeries().get(key).toArq());
        }
    }

    @Test
    void gravaRepositorio(){
        Repositorio repositorio = processaArq.criaRepositorio(NOMEARQUIVOTESTEREPOSITORIO);
        processaArq.gravaRepositorio(NOMEARQUIVOTESTEREPOSITORIOSAIDA, repositorio);
    }

    @Test
    void criaColecoes(){
        Repositorio repositorio = new Repositorio();
        processaArq.criaColecoes(NOMEARQUIVOTESTECOLECAO, repositorio);
        for (String nomeCol : repositorio.getColecoes().keySet()){
            for(String registro : repositorio.selecionaColecao(nomeCol).getRegistros().keySet()){
                System.out.println(repositorio.selecionaColecao(nomeCol).getRegistros().get(registro));
            }
        }
    }

    @Test
    void gravaColecoes(){
        Repositorio repositorio = processaArq.criaRepositorio(NOMEARQUIVOTESTEREPOSITORIO);
        repositorio.adicionaColecao(new Colecao(NOMECOLECAO1));
        repositorio.getColecoes().get(NOMECOLECAO1).adicionaRegistro((Registro) repositorio.getSeries().get("Haikyuu"));
        processaArq.gravaColecao(NOMEARQUIVOTESTECOLECAOSAIDA, repositorio);
    }

}