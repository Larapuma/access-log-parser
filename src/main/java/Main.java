import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите число: ");
        int number1 = new Scanner(System.in).nextInt();
        System.out.println("Введите число: ");
        int number2 = new Scanner(System.in).nextInt();
        System.out.println("Сумма = "+number1 + " + " + number2 + " = " + (number2+number1));
        System.out.println("Разность = "+ number1 + " - " + number2 + " = " + (number1-number2));
        System.out.println("Произведение = "+number1 + " * " + number2 + " = " + (number2*number1));

        double quotient = (double) number1/number2;
        System.out.println("Отношение = "+number1 + " / " + number2 + " = " + (quotient));



    }
}
