
public enum Operation {
	ADD, SUBTRACT, MULTIPLY, DIVIDE;

    public Operation reverseOperation() {
        switch (this) {
            case ADD:       return SUBTRACT;
            case SUBTRACT:  return ADD;
            case MULTIPLY:  return DIVIDE;
            case DIVIDE:    return MULTIPLY;
            default: return null;
        }
    }

    public double solve(double x, double y) {
        switch (this) {
            case ADD:       return x + y;
            case SUBTRACT:  return x - y;
            case MULTIPLY:  return x * y;
            case DIVIDE:    return x / y;
            default: return -111;
        }
    }
    
    public static Operation get(int i) {
    	switch (i) {
    	case 0: 		return Operation.ADD;
    	case 1:			return Operation.SUBTRACT;
    	case 2:			return Operation.MULTIPLY;
    	case 3:			return Operation.DIVIDE;
    	default:		return null;
    	}
    }
    
    public int getIndex() {
    	switch (this) {
    	case ADD:       return 0;
        case SUBTRACT:  return 1;
        case MULTIPLY:  return 2;
        case DIVIDE:    return 3;
        default: return -111;
    	}
    }
}
