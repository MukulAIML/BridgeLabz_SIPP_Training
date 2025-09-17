import java.lang.reflect.*;

class Calculator {
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class CalculatorReflection {
    public static void main(String[] args) throws Exception {
        Calculator calc = new Calculator();
        Method multiply = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);
        multiply.setAccessible(true);
        int result = (int) multiply.invoke(calc, 5, 7);
        System.out.println("Multiplication Result: " + result);
    }
}