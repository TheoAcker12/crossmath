import javax.swing.*;
import java.awt.*;

class View {
    
    private JFrame frame;
    private JPanel panel;
    private JLabel[] equalsLabels;
    private JTextField[] variableFields, solutionFields;
    private JComboBox<Operation>[] operationBoxes;
    private JButton solveButton, generateButton, checkButton;
    private ButtonListener listener;

    public View() {
        frame = new JFrame("Cross Math App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // create components
        makePanel();

        frame.pack();
        frame.setVisible(true);
    }


    private void makePanel() {
        panel = new JPanel(new GridBagLayout());

        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.weighty = 1;
        c.fill = GridBagConstraints.BOTH;

        createEqualsLabels(c);
        createVarFields(c);
        createOpBoxes(c);
        createSolutionFields(c);

        c.weightx = 2;
        c.gridx = 7;

        listener = new ButtonListener(this);

        solveButton = new JButton("Solve");
        solveButton.setVerticalTextPosition(AbstractButton.CENTER);
        solveButton.setHorizontalTextPosition(AbstractButton.CENTER);
        solveButton.setActionCommand("solve");
        solveButton.addActionListener(listener);
        c.gridy = 4;
        panel.add(solveButton, c);

        generateButton = new JButton("Generate New");
        generateButton.setVerticalTextPosition(AbstractButton.CENTER);
        generateButton.setHorizontalTextPosition(AbstractButton.CENTER);
        generateButton.setActionCommand("generate");
        generateButton.addActionListener(listener);
        c.gridy = 5;
        panel.add(generateButton, c);

        checkButton = new JButton("Check Solution");
        checkButton.setVerticalTextPosition(AbstractButton.CENTER);
        checkButton.setHorizontalTextPosition(AbstractButton.CENTER);
        checkButton.setActionCommand("check");
        checkButton.addActionListener(listener);
        c.gridy = 6;
        panel.add(checkButton, c);
    }

    private void createOpBoxes(GridBagConstraints c) {
        operationBoxes = new JComboBox[12];
        String[] ops = { "+", "-", "x", "/" };
        createOpBox(c, ops, 0, 0, 1);
		createOpBox(c, ops, 1, 0, 3);
		createOpBox(c, ops, 2, 1, 0);
		createOpBox(c, ops, 3, 1, 2);
		createOpBox(c, ops, 4, 1, 4);
		createOpBox(c, ops, 5, 2, 1);
		createOpBox(c, ops, 6, 2, 3);
		createOpBox(c, ops, 7, 3, 0);
		createOpBox(c, ops, 8, 3, 2);
		createOpBox(c, ops, 9, 3, 4);
		createOpBox(c, ops, 10, 4, 1);
		createOpBox(c, ops, 11, 4, 3);
    }

    private void createOpBox(GridBagConstraints c, String[] ops, int i, int x, int y) {
        operationBoxes[i] = new JComboBox(ops);
        operationBoxes[i].setSelectedIndex(0);
        c.gridx = x;
        c.gridy = y;
        panel.add(operationBoxes[i], c);
    }

    private void createSolutionFields(GridBagConstraints c) {
        solutionFields = new JTextField[6];
        createSolutionField(c, 0, 0, 6);
        createSolutionField(c, 1, 2, 6);
        createSolutionField(c, 2, 4, 6);
        createSolutionField(c, 3, 6, 0);
        createSolutionField(c, 4, 6, 2);
        createSolutionField(c, 5, 6, 4);
    }

    private void createSolutionField(GridBagConstraints c, int i, int x, int y) {
        solutionFields[i] = new JTextField();
        solutionFields[i].setHorizontalAlignment(JTextField.CENTER);
        solutionFields[i].setInputVerifier(new NumberVerifier(3));
        c.gridx = x;
        c.gridy = y;
        panel.add(solutionFields[i], c);
    }

    private void createVarFields(GridBagConstraints c) {
        variableFields = new JTextField[9];
        createVarField(c, 0, 0, 0);
        createVarField(c, 1, 0, 2);
        createVarField(c, 2, 0, 4);
        createVarField(c, 3, 2, 0);
        createVarField(c, 4, 2, 2);
        createVarField(c, 5, 2, 4);
        createVarField(c, 6, 4, 0);
        createVarField(c, 7, 4, 2);
        createVarField(c, 8, 4, 4);
    }

    private void createVarField(GridBagConstraints c, int i, int x, int y) {
        variableFields[i] = new JTextField();
        variableFields[i].setHorizontalAlignment(JTextField.CENTER);
        variableFields[i].setInputVerifier(new NumberVerifier(1));
        c.gridx = x;
        c.gridy = y;
        panel.add(variableFields[i], c);
    }

    private void createEqualsLabels(GridBagConstraints c) {
        equalsLabels = new JLabel[6];
        createEqualsLabel(c, 0, 0, 5);
        createEqualsLabel(c, 1, 2, 5);
        createEqualsLabel(c, 2, 4, 5);
        createEqualsLabel(c, 3, 5, 0);
        createEqualsLabel(c, 4, 5, 2);
        createEqualsLabel(c, 5, 5, 4);
    }

    private void createEqualsLabel(GridBagConstraints c, int i, int x, int y) {
        equalsLabels[i] = new JLabel("=", JLabel.CENTER);
        c.gridx = x;
        c.gridy = y;
        panel.add(equalsLabels[i], c);
    }

    public JTextField[] getVariableFields() {
        return variableFields;
    }

    public JTextField[] getSolutionFields() {
        return solutionFields;
    }

    public JComboBox<Operation>[] getOperationBoxes() {
        return operationBoxes;
    }

    public void setVariables(int[] variables) {
        for (int i = 0; i < 9; i++) {
        }
    }
}