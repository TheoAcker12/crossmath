enum Operation {
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
}