/**
 * @author Theo Orion Acker
 *
 */
public class Equation {
	private Operation op1, op2;
    private int solution;

    public Equation(Operation op1, Operation op2, int solution) {
        this.op1 = op1;
        this.op2 = op2;
        this.solution = solution;
    }
    
    private boolean isValid(double x) {
    	// must be a whole number between 1 and 9 inclusive
    	if (x % 1 == 0 && x >= 1 && x <= 9) return true;
    	return false;
    }

    // solve method
    public int solve(double b, double c) {
    	double temp = op2.reverseOperation().solve(solution, c);
    	temp = op1.reverseOperation().solve(temp, b);
    	if (isValid(temp)) return (int)temp;
    	return -111;
    }
    
    public boolean check(int a, int b, int c) {
    	double temp = op1.solve(a, b);
    	temp = op2.solve(temp, c);
    	return(temp == solution);
    }
    
    public Operation getOp1() {
    	return op1;
    }
    
    public Operation getOp2() {
    	return op2;
    }
    
    public int getSolution() {
    	return solution;
    }
}
