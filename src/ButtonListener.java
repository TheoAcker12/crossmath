import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JTextField;
/**
 * @author Theo Orion Acker
 *
 */
public class ButtonListener implements ActionListener {
	
	View view;
	
	public ButtonListener(View view) {
        super();
        this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
        switch(e.getActionCommand()) {
            case "solve":
                solve();
                break;
            case "generate":
                generate();
                break;
            case "check":
                check();
                break;
            default:
        }
	}
	
	private void solve() {
        // requires valid equations
        Equation[] equations = makeEquations();
        if (equations == null) {
            System.out.println("Unable to set equations");
            return;
        }
        int[] variables = CrossMath.solve(equations);
        if (variables == null) {
            System.out.println("Unable to find a solution");
            return;
        }
        view.setVariables(variables);
	}
	
	private void generate() {
		view.resetVariables();
		Equation[] eqs = CrossMath.generate();
		view.setEquations(eqs);
    }

    private void check() {
    	int[] vars = verifyVariables();
    	Equation[] eqs = makeEquations();
    	if (vars != null && eqs != null && CrossMath.check(vars, eqs)) {
    		System.out.println("Correct!");
    	}
    	System.out.println("Incorrect.");

    }

    private int[] verifyVariables() {
        JTextField[] variableFields = view.getVariables();
        int[] variables = new int[9];
        // each field must have a number from 1 to 9
        for (int i = 0; i < 9; i++) {
            String str = variableFields[i].getText();
            try {
                int num = Integer.parseInt(str);
                if (num < 1 || num > 9) return null;
                variables[i] = num;
            } catch (Exception e) {
                return null;
            }
        }
        return variables;
    }

    private int[] verifySolutions() {
        JTextField[] solutionFields = view.getSolutions();
        int[] solutions = new int[6];
        for (int i = 0; i < 6; i++) {
            String str = solutionFields[i].getText();
            try {
                int num = Integer.parseInt(str);
                if (num < 0 || num > 999) return null;
                solutions[i] = num;
            } catch (Exception e) {
                return null;
            }
        }
        return solutions;
    }

    private Equation[] makeEquations() {
        int[] solutions = verifySolutions();
        if (solutions == null) return null;
        JComboBox[] operationBoxes = view.getOperations();
        Operation[] operations = new Operation[12];
        for (int i = 0; i < 12; i++) {
            switch (operationBoxes[i].getSelectedIndex()) {
                case 0:
                    operations[i] = Operation.ADD;
                    break;
                case 1:
                    operations[i] = Operation.SUBTRACT;
                    break;
                case 2:
                    operations[i] = Operation.MULTIPLY;
                    break;
                case 3:
                    operations[i] = Operation.DIVIDE;
                    break;
                default:
                    return null;
            }
        }
        Equation[] equations = new Equation[6];
        for (int i = 0; i < 6; i++) {
            equations[i] = new Equation(operations[i*2], operations[i*2+1], solutions[i]);
        }
        return equations;
    }
	
}
