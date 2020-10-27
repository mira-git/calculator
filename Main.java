package com.engeto;

import java.util.Locale;
import java.util.Scanner;

class SingleOperationCalculator {

    public enum Operator {
        ADD ('+'),
        SUBTRACT ('-'),
        MULTIPLY ('*'),
        DIVIDE ('/');
        private char symbol;

        Operator(char symbol) {
            this.symbol=symbol;
        }

        public static Operator findBySymbol(char symbol) {
            Operator result = null;
            for (Operator op : Operator.values()) {
                if ( symbol == op.symbol ) {
                    return op;
                }
            }
            System.out.println("Operator "+symbol+" not recognized ...");
            return null;
        }

        int calculate(int n1, int n2) {
            int result = -1;
            switch (this.ordinal()) {
                case 0:
                    result = n1 + n2; break;
                case 1:
                    result = n1 - n2; break;
                case 2:
                    result = n1 * n2; break;
                case 3:
                    result = n1 / n2; break;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        int first, second, result;
        char operatorSymbol;
        Operator o;
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);

        while (true) {
            System.out.println();
            System.out.println("Enter two numbers (or x to exit): ");
            try {
                System.out.print("first: ");
                first = scanner.nextInt();
                scanner.nextLine();

                System.out.print("Enter an operator (+, -, *, /): ");
                operatorSymbol = scanner.nextLine().charAt(0);
                o = Operator.findBySymbol(operatorSymbol);
                if ( o == null ) continue;  // operator not recognized

                System.out.print("second: ");
                second = scanner.nextInt();
                scanner.nextLine();

                System.out.println(first + " " + operatorSymbol + " " + second + " = " + o.calculate(first,second));
            } catch (Exception e) {
                String buffer = scanner.nextLine();
                if (buffer.toUpperCase().equals("X")) {
                    System.exit(0);
                }
                System.out.println(buffer + " is not valid number, try again ..");
                continue;
            }

        }

    }

}