public class Person {
    private CalculatorInterface calculatorInterface;

    public Person(CalculatorInterface calculatorInterface) {
        this.calculatorInterface = calculatorInterface;
    }

    public void show(){
        System.out.println(calculatorInterface.calculate(4, 5));
    }
}
