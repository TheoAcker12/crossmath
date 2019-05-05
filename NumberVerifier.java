import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

class NumberVerifier extends InputVerifier {
    private int maxLength;

    public NumberVerifier(int maxLength) {
        super();
        this.maxLength = maxLength;
    }


    public boolean verify(JComponent input) {
        JTextField field = (JTextField) input;
        String str = field.getText();
        try {
            int num = Integer.parseInt(str);
            if (num < 0) return false;
            if (maxLength==1 && num == 0) return false;
            if (num != 0) {
                int length = (int) (Math.log10(num) + 1);
                if (length > maxLength) return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}