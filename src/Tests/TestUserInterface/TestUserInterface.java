package Tests.TestUserInterface;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Program.UserInterface.UserInterface;

class TestUserInterface {
	UserInterface ui = new UserInterface();
	
//	@Test
//	void pedeInt() {	
//		int pedido = ui.pedeInt("Digite o numero 89:");
//		assertEquals(89, pedido);
//	}

	
//	@Test
//	void pedeString() {
//		String pedido = ui.pedeString("uma string:");
//		System.out.println("String: " + pedido);
//		assertEquals(true, pedido.getClass().equals(String.class));
//	}

	
//	@Test
//	void pedeArrayInt() {
//		ArrayList<Integer> nums = new ArrayList<>();
//		
//		nums = ui.pedeArrayInt("os numeros.");
//		assertEquals(true, nums.size()>0);
//	}
	
	@Test
	void pedeArrayString() {
		ArrayList<String> strings = new ArrayList<>();
		
		strings = ui.pedeArrayString("as strings.");
		for(String s : strings) {
			System.out.println(s);
		}

		assertEquals(true, strings.size()>0);
	}

}
