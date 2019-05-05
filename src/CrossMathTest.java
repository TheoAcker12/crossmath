import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CrossMathTest {


	@Test
	void testSolve() {
		// set up
		Operation[] ops = { Operation.ADD, Operation.ADD, Operation.ADD, Operation.MULTIPLY, Operation.ADD, Operation.SUBTRACT,
				Operation.ADD, Operation.SUBTRACT, Operation.MULTIPLY, Operation.SUBTRACT, Operation.DIVIDE, Operation.DIVIDE };
		int[] solutions = { 15, 24, 14, 3, 12, 4 };
		Equation[] eqs = setEqs(ops, solutions);
		int[] vars = CrossMath.solve(eqs);
		
		assertNotNull(vars);
		
		assertEquals(4, vars[0]);
		assertEquals(3, vars[1]);
		assertEquals(8, vars[2]);
		
		assertEquals(5, vars[3]);
		assertEquals(7, vars[4]);
		assertEquals(2, vars[5]);
		
		assertEquals(6, vars[6]);
		assertEquals(9, vars[7]);
		assertEquals(1, vars[8]);
		
		Operation[] ops1 = { Operation.SUBTRACT, Operation.DIVIDE, Operation.MULTIPLY, Operation.SUBTRACT, Operation.SUBTRACT, Operation.SUBTRACT,
				Operation.ADD, Operation.DIVIDE, Operation.ADD, Operation.MULTIPLY, Operation.MULTIPLY, Operation.SUBTRACT };
		int[] solutions1 = { 1, 66, 2, 2, 10, 14 };
		eqs = setEqs(ops1, solutions1);
		vars = CrossMath.solve(eqs);
		
		assertNotNull(vars);
		
		assertEquals(5, vars[0]);
		assertEquals(2, vars[1]);
		assertEquals(3, vars[2]);
		
		assertEquals(9, vars[3]);
		assertEquals(8, vars[4]);
		assertEquals(6, vars[5]);
		
		assertEquals(7, vars[6]);
		assertEquals(1, vars[7]);
		assertEquals(4, vars[8]);
		
		//fail("Not yet implemented");
	}

	@Test
	void testGenerate() {
		//fail("Not yet implemented");
	}

	@Test
	void testCheck() {
		//fail("Not yet implemented");
	}
	
	private Equation[] setEqs(Operation[] ops, int[] solutions) {
		Equation[] eqs = new Equation[6];
		for (int i = 0; i < 6; i++) {
			eqs[i] = new Equation(ops[i*2], ops[i*2+1], solutions[i]);
		}
		return eqs;
	}

}
