import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * @author Theo Orion Acker
 *
 */
class EquationTest {

	@Test
	void testSolve() {
		//3 + 7 + 2 = 12
		// 9 - 1 * 8 = 64
		// 1 + 3 / 2 = 2
		Equation eq1 = new Equation(Operation.ADD, Operation.ADD, 12);
		Equation eq2 = new Equation(Operation.SUBTRACT, Operation.MULTIPLY, 64);
		Equation eq3 = new Equation(Operation.ADD, Operation.SUBTRACT, 2);
		
		assertEquals(eq1.solve(7, 2), 3);
		assertEquals(eq1.solve(20, 4), -111);
		assertEquals(eq1.solve(1.3, 4.5), -111);
		
		assertEquals(eq2.solve(1, 8), 9);
		assertEquals(eq3.solve(3, 2), 1);
	}
	
	@Test
	void testCheck() {
		Equation eq1 = new Equation(Operation.ADD, Operation.ADD, 12);
		Equation eq2 = new Equation(Operation.SUBTRACT, Operation.MULTIPLY, 64);
		Equation eq3 = new Equation(Operation.ADD, Operation.SUBTRACT, 2);
		
		assertTrue(eq1.check(3, 2, 7));
		assertTrue(eq2.check(9, 1, 8));
		assertTrue(eq3.check(1, 3, 2));
	}

}
