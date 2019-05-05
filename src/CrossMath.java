import java.util.ArrayList;
import java.util.Random;
/**
 * @author Theo Orion Acker
 *
 */
public class CrossMath {

	// solve based on equations
    public static int[] solve(Equation[] equations) {
        int a, b, c, d, e, f, g, h, i;
        boolean[] available = new boolean[10];
        for (int j = 1; j < 10; j++) {
        	available[j] = true;
        }
        
        for (i = 1; i <= 9; i++) {
        	available[i] = false;
        	for (h = 1; h <= 9; h++) {
        		if (available[h]) {
        			available[h] = false;
        			g = equations[2].solve(h, i);
        			if (g != -111 && available[g]) {
        				available[g] = false;
        				for (f = 1; f <= 9; f++) {
        					if (available[f]) {
        						available[f] = false;
        						c = equations[5].solve(f, i);
        						if (c != -111 && available[c]) {
        							available[c] = false;
        							for (e = 1; e <= 9; e++) {
        								if (available[e]) {
        									available[e] = false;
        									d = equations[1].solve(e, f);
        									if (d != -111 && available[d]) {
        										available[d] = false;
        										b = equations[4].solve(e, h);
        										if (b != -111 && available[b]) {
        											available[b] = false;
        											a = equations[0].solve(b, c);
        											if (a != -111 && available[a] && equations[3].solve(d, g) == a) {
        												return new int[] {a, b, c, d, e, f, g, h, i};
        											}
        											available[b] = true;
        										}
        										available[d] = true;
        									}
        									available[e] = true;
        								}
        							}
        							available[c] = true;
        						}
        						available[f] = true;
        					}
        				}
        				available[g] = true;
        			}
        			available[h] = true;
        		}
        	}
        	available[i] = true;
        }

        return null;

    }
    
    public static boolean check(int[] vars, Equation[] eqs) {
    	return (eqs[0].check(vars[0], vars[1], vars[2]) && eqs[1].check(vars[3], vars[4], vars[5]) && eqs[2].check(vars[6], vars[7], vars[8]) &&
    			eqs[3].check(vars[0], vars[3], vars[6]) && eqs[4].check(vars[1], vars[4], vars[7]) && eqs[5].check(vars[2], vars[5], vars[8]));
    }

    // creates puzzle
    public static Equation[] generate() {
        Equation[] equations = new Equation[6];
        int[] solutions = new int[6];
        Operation[] ops = new Operation[12];
        Random rand = new Random();
        boolean ready = false;
        while (!ready) {
        	ArrayList<Integer> list = new ArrayList(9);
        	int[] vars = new int[9];
        	for (int i = 1; i < 10; i++) {
        		list.add(i);
        	}
        	for (int i = 9; i > 0; i--) {
        		int x = rand.nextInt(i);
        		vars[i-1] = list.get(x);
        		list.remove(x);
        	}
        	// get operations
        	for (int i = 0; i < 12; i++) {
        		ops[i] = Operation.get(rand.nextInt(4));
        	}
        	
        	// find out if the solution works
        	double[] sols = new double[6];
        	sols[0] = ops[1].solve(ops[0].solve(vars[0], vars[1]), vars[2]);
        	sols[1] = ops[3].solve(ops[2].solve(vars[3], vars[4]), vars[5]);
        	sols[2] = ops[5].solve(ops[4].solve(vars[6], vars[7]), vars[8]);
        	sols[3] = ops[7].solve(ops[6].solve(vars[0], vars[3]), vars[6]);
        	sols[4] = ops[9].solve(ops[8].solve(vars[1], vars[4]), vars[7]);
        	sols[5] = ops[11].solve(ops[10].solve(vars[2], vars[5]), vars[8]);
        	ready = true;
        	for (int i = 0; i < 6; i++) {
        		if (sols[i] % 1 != 0 || sols[i] < 0) ready = false;
        		else solutions[i] = (int) sols[i];
        	}
        }
        // make equations
        
        for (int i = 0; i < 6; i++) {
        	equations[i] = new Equation(ops[i*2], ops[i*2+1], solutions[i]);
        }
        return equations;
    }
    
}
