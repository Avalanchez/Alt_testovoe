import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ScannerExceptions {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String a;
        String b;
        if (s.charAt(0) == '\"') {
            if (s.contains("+")) {
                a = s.substring(0, s.indexOf('+'));
                a = a.trim();
                b = s.substring(s.indexOf('+') + 1);
                b = b.trim();
                a = a.replaceAll("\"", "");
                if (a.length() <= 10) {
                    if (b.length() <= 10) {
                        Plus p = new Plus();
                        p.plus(a, b);
                    } else System.out.println("В исходных строках должно быть не больше 10 знаков");
                } else {
                    System.out.println("В исходных строках должно быть не больше 10 знаков");
                }
            } else if (s.contains("-")) {
                a = s.substring(0, s.indexOf('-'));
                a = a.trim();
                b = s.substring(s.indexOf('-') + 1);
                a = a.replaceAll("\"", "");
                if (a.length() <= 10 && b.length() <= 10) {
                    Minus m = new Minus();
                    m.minus(a, b);
                } else System.out.println("В исходных строках должно быть не больше 10 знаков");
            } else if (s.contains("*")) {
                a = s.substring(0, s.indexOf('*'));
                a = a.trim();
                b = s.substring(s.indexOf('*') + 1);
                a = a.replaceAll("\"", "");
                if (a.length() <= 10 && b.length() <= 10) {
                    Multiple m = new Multiple();
                    m.multiply(a, b);
                } else System.out.println("В исходных строках должно быть не больше 10 знаков");
            } else if (s.contains("/")) {
                a = s.substring(0, s.indexOf('/'));
                a = a.trim();
                b = s.substring(s.indexOf('/') + 1);
                a = a.replaceAll("\"", "");
                if (a.length() <= 10 && b.length() <= 10) {
                    Divide d = new Divide();
                    d.divide(a, b);
                } else System.out.println("В исходных строках должно быть не больше 10 знаков");
            }
        } else {
            throw new ScannerExceptions("Введеное выражение не соответствует заложенным операциям");
        }
    }
}

class Plus {
    void plus(String a, String b) throws ScannerExceptions {
        b = b.trim();
        if (b.charAt(0) == '\"') {
            b = b.replaceAll("\"", "");
            Print p = new Print();
            p.print(a + b);
        } else {
            throw new ScannerExceptions("Сложение строки возможно только с другой строкой");
        }
    }
}

class Minus {
    void minus(String a, String b) throws ScannerExceptions {
        b = b.trim();
        if (b.charAt(0) == '\"') {
            b = b.replaceAll("\"", "");
            a = a.replace(b, "");
            Print p = new Print();
            p.print(a);
        } else {
            throw new ScannerExceptions("Из строки можно вычитать только другую строку");
        }
    }
}

class Divide {
    void divide(String a, String b) {
        b = b.trim();
        int bInteger = 0;
        try {
            bInteger = Integer.parseInt(b);
        } catch (NumberFormatException e) {
            System.out.println("Деление возможно только на целое число");
        }
        if (1 <= bInteger && bInteger <= 10) {
            a = a.substring(0, bInteger);
            Print p = new Print();
            p.print(a);
        } else {
            System.out.println("Умножение возможно только на число от 1 до 10");
        }
    }

}

class Multiple {
    void multiply(String a, String b) {
        b = b.trim();
        int bInteger = 0;
        try {
            bInteger = Integer.parseInt(b);
        } catch (NumberFormatException e) {
            System.out.println("Умножение возможно только на целое число");
        }
        if (1 <= bInteger && bInteger <= 10) {
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 1; i < bInteger; i++) {
                aBuilder.append(a);
            }
            a = aBuilder.toString();
            Print p = new Print();
            p.print(a);
        } else {
            System.out.println("Умножение возможно только на число от 1 до 10");
        }
    }
}

class Print {
    void print(String a) {
        if (a.length() < 40) {
            System.out.println("\"" + a + "\"");
        } else {
            StringBuilder aBolshe40 = new StringBuilder(a);
            System.out.println("\"" + aBolshe40.substring(0, 40) + "..." + "\"");
        }
    }
}
