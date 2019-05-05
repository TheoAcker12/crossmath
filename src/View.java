import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.BoxLayout;

public class View {

	private JFrame frame;
	private JTextField[] variables, solutions;
	private JLabel[] equals, p1Blanks, p2Blanks;
	private JComboBox[] operations;
	private JPanel mathPanel, btnPanel;
	private JButton solveBtn, generateBtn, checkBtn;
	private Font font, btnFont;
	
	private ButtonListener btnListener;
	

	
	public View() {
		frame = new JFrame("Cross Math App");
		frame.setSize(new Dimension(900, 700));
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS));
		
		font = new Font("Tahoma", Font.PLAIN, 55);
		setMathPanel();
		
		btnFont = new Font("Tahoma", Font.PLAIN, 25);
		setBtnPanel();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void setMathPanel() {
		JPanel mathPanel = new JPanel();
		frame.getContentPane().add(mathPanel);
		mathPanel.setLayout(new GridLayout(0, 7, 0, 0));
		
		setVarFields();
		setSolFields();
		setEqLabels();
		setOpBoxes();
		setP1Blanks();
		
		mathPanel.add(variables[0]);
		mathPanel.add(operations[0]);
		mathPanel.add(variables[1]);
		mathPanel.add(operations[1]);
		mathPanel.add(variables[2]);
		mathPanel.add(equals[0]);
		mathPanel.add(solutions[0]);
		
		mathPanel.add(operations[6]);
		mathPanel.add(p1Blanks[0]);
		mathPanel.add(operations[8]);
		mathPanel.add(p1Blanks[1]);
		mathPanel.add(operations[10]);
		mathPanel.add(p1Blanks[2]);
		mathPanel.add(p1Blanks[3]);
		
		mathPanel.add(variables[3]);
		mathPanel.add(operations[2]);
		mathPanel.add(variables[4]);
		mathPanel.add(operations[3]);
		mathPanel.add(variables[5]);
		mathPanel.add(equals[1]);
		mathPanel.add(solutions[1]);
		
		mathPanel.add(operations[7]);
		mathPanel.add(p1Blanks[4]);
		mathPanel.add(operations[9]);
		mathPanel.add(p1Blanks[5]);
		mathPanel.add(operations[11]);
		mathPanel.add(p1Blanks[6]);
		mathPanel.add(p1Blanks[7]);
		
		mathPanel.add(variables[6]);
		mathPanel.add(operations[4]);
		mathPanel.add(variables[7]);
		mathPanel.add(operations[5]);
		mathPanel.add(variables[8]);
		mathPanel.add(equals[2]);
		mathPanel.add(solutions[2]);
		
		mathPanel.add(equals[3]);
		mathPanel.add(p1Blanks[8]);
		mathPanel.add(equals[4]);
		mathPanel.add(p1Blanks[9]);
		mathPanel.add(equals[5]);
		mathPanel.add(p1Blanks[10]);
		mathPanel.add(p1Blanks[11]);
		
		mathPanel.add(solutions[3]);
		mathPanel.add(p1Blanks[12]);
		mathPanel.add(solutions[4]);
		mathPanel.add(p1Blanks[13]);
		mathPanel.add(solutions[5]);
		
	}
	
	private void setBtnPanel() {
		btnPanel = new JPanel();
		btnPanel.setPreferredSize(new Dimension(200, 100));
		frame.getContentPane().add(btnPanel);
		btnPanel.setLayout(new GridLayout(0, 1, 0, 0));
		
		p2Blanks = new JLabel[8];
		for (int i = 0; i < 8; i++) {
			p2Blanks[i] = new JLabel("");
			btnPanel.add(p2Blanks[i]);
		}
		
		btnListener = new ButtonListener(this);
		
		solveBtn = new JButton("Solve");
		solveBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		solveBtn.setPreferredSize(new Dimension(200, 100));
		solveBtn.setFont(btnFont);
		solveBtn.setActionCommand("solve");
		solveBtn.addActionListener(btnListener);
		btnPanel.add(solveBtn);
		
		generateBtn = new JButton("Generate New");
		generateBtn.setPreferredSize(new Dimension(200, 100));
		generateBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		generateBtn.setFont(btnFont);
		generateBtn.setActionCommand("generate");
		generateBtn.addActionListener(btnListener);
		btnPanel.add(generateBtn);
		
		checkBtn = new JButton("Check Solution");
		checkBtn.setPreferredSize(new Dimension(200, 100));
		checkBtn.setHorizontalTextPosition(SwingConstants.CENTER);
		checkBtn.setFont(btnFont);
		checkBtn.setActionCommand("check");
		checkBtn.addActionListener(btnListener);
		btnPanel.add(checkBtn);
		
		
	}
	
	private void setVarFields() {
		variables = new JTextField[9];
		for (int i = 0; i < 9; i++) {
			variables[i] = new JTextField();
			variables[i].setPreferredSize(new Dimension(100, 100));
			variables[i].setHorizontalAlignment(SwingConstants.CENTER);
			variables[i].setFont(font);
			variables[i].setColumns(1);
		}
	}
	
	private void setSolFields() {
		solutions = new JTextField[6];
		for (int i = 0; i < 6; i++) {
			solutions[i] = new JTextField();
			solutions[i].setPreferredSize(new Dimension(100, 100));
			solutions[i].setHorizontalAlignment(SwingConstants.CENTER);
			solutions[i].setFont(font);
			solutions[i].setColumns(1);
		}
	}
	
	private void setEqLabels() {
		equals = new JLabel[6];
		for (int i = 0; i < 6; i++) {
			equals[i] = new JLabel("=");
			equals[i].setPreferredSize(new Dimension(100, 100));
			equals[i].setHorizontalTextPosition(SwingConstants.CENTER);
			equals[i].setHorizontalAlignment(SwingConstants.CENTER);
			equals[i].setFont(font);
		}
	}
	
	private void setOpBoxes() {
		operations = new JComboBox[12];
		String[] str = { "+", "-", "x", "/" };
		for (int i = 0; i < 12; i++) {
			operations[i] = new JComboBox(str);
			operations[i].setSelectedIndex(0);
			operations[i].setPreferredSize(new Dimension(100, 100));
			operations[i].setFont(font);
			((JLabel)operations[i].getRenderer()).setHorizontalAlignment(SwingConstants.CENTER);
		}
	}
	
	private void setP1Blanks() {
		p1Blanks = new JLabel[14];
		for (int i = 0; i < 14; i++) {
			p1Blanks[i] = new JLabel("");
			p1Blanks[i].setPreferredSize(new Dimension(100, 100));
			p1Blanks[i].setHorizontalTextPosition(SwingConstants.CENTER);
			p1Blanks[i].setHorizontalAlignment(SwingConstants.CENTER);
			p1Blanks[i].setFont(font);
		}
	}
	
	public JTextField[] getVariables() {
        return variables;
    }

    public JTextField[] getSolutions() {
        return solutions;
    }

    public JComboBox<Operation>[] getOperations() {
        return operations;
    }

    public void setVariables(int[] variables) {
        for (int i = 0; i < 9; i++) {
        	this.variables[i].setText(Integer.toString(variables[i]));
        }
    }
    
    public void resetVariables() {
    	for (int i = 0; i < 9; i++) {
    		this.variables[i].setText("");
    	}
    }
    
    public void setOperations(int[] ops) {
    	for (int i = 0; i < 12; i++) {
    		operations[i].setSelectedIndex(ops[i]);
    	}
    }
    
    public void setSolutions(int[] sols) {
    	for (int i = 0; i < 6; i++) {
    		solutions[i].setText(Integer.toString(sols[i]));
    	}
    }
    
    public void setEquations(Equation[] eqs) {
    	for (int i = 0; i < 6; i++) {
    		solutions[i].setText(Integer.toString(eqs[i].getSolution()));
    		operations[i*2].setSelectedIndex(eqs[i].getOp1().getIndex());
    		operations[i*2+1].setSelectedIndex(eqs[i].getOp2().getIndex());
    	}
    }
	
}

