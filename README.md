CrossMath class, Equation class, and Operation enum
- given 12 operations and 6 solutions, returns 9 variables
- given nothing, returns 12 operations and 6 solutions
- given 12 operations, 6 solutions, and 9 variables, returns whether the puzzle has been correctly solved

View class, IntegerFormatter class
- View implements ActionListener
- IntegerFormatter extends NumberFormatter
- uses GridBagLayout to display operations, variables, and solutions
- provides buttons for solve, generate, and check solution
- buttons are hooked up to methods that call model

Driver
- creates model
- creates view and provides model