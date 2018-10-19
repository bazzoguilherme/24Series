package Tests.Test_User_Admin.Test_Usuario;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import Program.User_Admin.Usuario;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class UsuarioTestVoid {
    private static Usuario user;

    @BeforeAll
    static void initAll(){
        user = new Usuario();
    }

    @Test
    void getNome(){
        assertSame("", user.getNome());
    }

    @Test
    void getEmail(){
        assertEquals("", user.getEmail());
    }

    @Test
    void getAmigosVoid(){ assertTrue(user.getAmigos().isEmpty()); }

    @Test
    void getAmigosQuantidade(){
        assertEquals(0 , user.getAmigos().size());
        addAmigosTest();
        assertEquals(2 , user.getAmigos().size());

    }

    @Test
    void getAmigos() {
        addAmigosTest();

        assertEquals(user.getAmigos().get("Amigo1").getNome(), "Amigo1");
        assertEquals(user.getAmigos().get("Amigo2").getNome(), "Amigo2");
    }


    @Test
    void nomeAmigos(){
        addAmigosTest();

        assertTrue(user.nomeAmigos().contains("Amigo1"));
        assertTrue(user.nomeAmigos().contains("Amigo2"));
    }

    @Test
    void selecionaAmigos(){
        addAmigosTest();

        assertEquals("Amigo1", user.selecionaAmigo("Amigo1").getNome());
        assertEquals("Amigo2", user.selecionaAmigo("Amigo2").getNome());
        assertNotEquals("Amigo2", user.selecionaAmigo("Amigo1").getNome());
    }

    private static void addAmigosTest(){
        Usuario user1 = new Usuario("Amigo1", "amigo1@gmail.com");
        Usuario user2 = new Usuario("Amigo2", "amigo2@gmail.com");
        user.addAmigo(user1);
        user.addAmigo(user2);
    }

    @AfterEach
    void tearDown(){
        user.clearAmigos();
    }

}