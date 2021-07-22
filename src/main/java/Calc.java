import java.util.Scanner;

public class Calc {

    private String inputStr;
    private Integer firstNum;
    private Integer secondNum;
    private String mathOperator;
    private Integer result;

    public static void main(String[] args) {
        Calc myCalc = new Calc();
        myCalc.consoleStrInput();
        myCalc.getComponents();
        myCalc.getResult();
        myCalc.consoleResultOutput();
    }

    public void consoleStrInput() {
        System.out.print("Введите строку с выражением (два числа, раздёлённые пробелами и знаком математической операции: '+','-','*','/'): ");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        this.inputStr = str;
    }

    public void getComponents() {
        String[] arrStr = this.inputStr.split(" ");
        
        try {
            this.firstNum = Integer.parseInt(arrStr[0]);
        }
        catch (NumberFormatException e) {
            System.out.println("Входные данные неверны. На вход ожидались два числа, разделённые пробелами и знаком математической операции: '+','-','*','/'.");
        }

        try {
            this.secondNum = Integer.parseInt(arrStr[2]);
        }
        catch (NumberFormatException e) {
            System.out.println("Входные данные неверны. На вход ожидались два числа, разделённые пробелами и знаком математической операции: '+','-','*','/'.");
        }
        
        this.mathOperator = arrStr[1];

        if (arrStr.length > 3) {
            System.out.println("Входные данные неверны. На вход ожидались два числа, разделённые пробелами и знаком математической операции: '+','-','*','/'.");
            java.lang.System.exit(1); 
        }
    }

    public void getResult(){
        Integer res = 0;
        switch (this.mathOperator) {
            case "+": res = this.firstNum + this.secondNum; break;
            case "-": res = this.firstNum - this.secondNum; break;
            case "*": res = this.firstNum * this.secondNum; break;
            case "/": try {
                res = Math.round(this.firstNum / this.secondNum);
            }
            catch (ArithmeticException e) {
                System.out.println("Деление на 0 невозможно!");
            }; break;
            default: res = null;
        }
        this.result = res;
    }

    public void consoleResultOutput() {
        if (this.result == null) {
            System.out.println("Входные данные неверны. На вход ожидались два числа, разделённые пробелами и знаком математической операции: '+','-','*','/'.");
        } else {
            System.out.println("Результат вычислений: " + this.result);
        } 
    }

}

