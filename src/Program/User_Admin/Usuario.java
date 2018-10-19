package Program.User_Admin;

import java.util.ArrayList;
import java.util.Hashtable;

public class Usuario {
    private String nome;
    private String email;
    private Hashtable<String, Usuario> amigos;

    public Usuario(){
        this.nome = "";
        this.email = "";
        this.amigos = new Hashtable<>();
    }

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
        this.amigos = new Hashtable<>();
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }

    public Hashtable<String, Usuario> getAmigos(){
        return this.amigos;
    }

    public void addAmigo(Usuario novoAmigo){
        this.amigos.put(novoAmigo.getNome(), novoAmigo);
    }

    public ArrayList nomeAmigos(){
        ArrayList<String> nomeAmigos = new ArrayList<>();
        for (String key : amigos.keySet()){
            nomeAmigos.add(key);
        }
        return nomeAmigos;
    }

    public Usuario selecionaAmigo(String nomeAmigo){
        return this.amigos.get(nomeAmigo);
    }

    public void clearAmigos(){
        this.amigos.clear();
    }

    public void exibeInterface(){

    }

    @Override
    public String toString() {
        return this.nome + this.email;
    }
}
