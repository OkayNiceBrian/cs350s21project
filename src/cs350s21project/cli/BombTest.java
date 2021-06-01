package cs350s21project.cli;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class BombTest {

	@Test
	public void testWind() {
		Bomb bomb = new Bomb(0.0, 0.0, 0.0, 0.0, Bomb.E_ErrorType.NONE, 0.0, 45.0, 10.0);
		
		assertEquals(bomb.getWindDirection(), 45.0, 0.0001, "getWindDirection()");
		
		assertEquals(bomb.getWindSpeed(), 10.0, 0.0001, "getWindSpeed()");
	}
}
