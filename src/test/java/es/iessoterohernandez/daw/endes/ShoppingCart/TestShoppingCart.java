package es.iessoterohernandez.daw.endes.ShoppingCart;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestShoppingCart {

	private Product p;
	private ShoppingCart s;
	private ProductNotFoundException pnf;

	@BeforeEach
	public void init() {

		p = new Product("Leche", 1);
		s = new ShoppingCart();
		pnf = new ProductNotFoundException();

	}

	@Test
	public void crearCarroVacioTest() {

		assertTrue(s.getItemCount() == 0);

	}

	@Test
	public void carroVacioTest() {

		s.empty();
		assertTrue(s.getItemCount() == 0);

	}

	@Test
	public void incrementarNumElem() {

		s.addItem(p);
		assertTrue(s.getItemCount() > 0);

	}

	@Test
	public void nuevoBalance() {

		double resultado = s.getBalance() + p.getPrice();
		s.addItem(p);
		assertTrue(s.getBalance() == resultado);

	}

	@Test
	public void decrementarNumElem() throws ProductNotFoundException {

		s.addItem(p);
		int numElem = s.getItemCount();
		s.removeItem(p);
		assertTrue(s.getItemCount() < numElem);

	}

	@Test
	public void eliminarProductoNoEncontrado() {

		try {

			s.removeItem(p);
			fail("Se esperaba una excepción ProductNotFoundException");
			
		} catch (ProductNotFoundException e) {

		}

	}

}
