package co.learn.unitesting.unittesting.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

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
		
		System.out.println(item);
	}

}
