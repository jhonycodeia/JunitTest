package co.learn.unitesting.unittesting.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import lombok.extern.java.Log;

@Log
@ExtendWith(MockitoExtension.class)
public class CartTest {
	
	@Test
	public void pruebaLombo() {
		
		CartItem item = CartItem.builder()
				.itemId(1)
				.itemName("prueba")
				.quantity(1500)
				.rate(2)
				.isExpired(false)
				.build();
		
		log.info("el objecto creado es "+item);
	}

}
