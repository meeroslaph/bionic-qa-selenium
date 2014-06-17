package core;

/**
 * Created by meeroslaph on 17.06.14.
 */
public class QuadraticEquation {
    public double a;
    public double b;
    public double c;

    public static void main(String[] args) {
        QuadraticEquation qe1 = new QuadraticEquation();

        qe1.setValues(-2, 24, -70);
        if(qe1.a == 0) {
            System.out.println("Sorry, 'a' cannot be '0'.");
        }
        else {
            System.out.println("D = " + qe1.calcD() + ", x1 = " + qe1.calcX1() + ", x2 = " + qe1.calcX2());
        }
    }

    private void setValues(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double calcD() {
        return (b * b) - (4 * a * c);
    }

    public double calcX1() {
        return (-b - Math.sqrt(calcD())) / (2 * a);
    }

    public double calcX2() {
        return (-b + Math.sqrt(calcD())) / (2 * a);
    }
}