import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class HelloWorldTest {

    @Test
    public void testMain() {
        HelloWorld.main();
    }

    @Test
    public void testVariables() {
        int numberOne = 1;
        int numberTwo = 2;

        System.out.println(numberOne);
        System.out.println(numberTwo);

        doStuff(numberOne, numberTwo);

        System.out.println(numberOne);
        System.out.println(numberTwo);
    }

    void doStuff(int firstNum, int secondNum) {
        firstNum = 10;
        secondNum = firstNum;
    }

    @Test
    public void testTrickyVariables()
    {
        Point pnt1 = new Point(0,0);
        Point pnt2 = new Point(0,0);
        System.out.println("X: " + pnt1.x + " Y: " +pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
        System.out.println(" ");
        tricky(pnt1,pnt2);
        System.out.println("X: " + pnt1.x + " Y:" + pnt1.y);
        System.out.println("X: " + pnt2.x + " Y: " +pnt2.y);
    }

    public void tricky(Point arg1, Point arg2)
    {
        arg1.x = 100;
        arg1.y = 100;
        Point temp = arg1;
        arg1 = arg2;
        arg2 = temp;
    }

    @Test
    public void testOperators() {
        int number = 2;

        System.out.println(number);

        number = (int)(number + 5l);
        number += 5l;

        System.out.println(number);

    }

    @Test
    public void testStrings() {
        String stringVariable = "Hello";

        System.out.println(stringVariable);

        stringVariable = stringVariable + " world";

        System.out.println(stringVariable);
    }

    @Test
    public void testOperatorsTwo() {
        int number = 5;
        int smallNumber = -5;

        System.out.println(number == smallNumber);
        System.out.println(number != smallNumber);
        System.out.println(number > smallNumber);
        System.out.println(number < smallNumber);
        System.out.println(number >= smallNumber);
        System.out.println(number <= smallNumber);

        System.out.println(true && true);
        System.out.println(true && false);

        boolean bad = true;

        System.out.println(bad && printHi());
        System.out.println(false && printHi());
        System.out.println(printHi() && false);
        System.out.println(false || printHi());
    }

    private boolean printHi() {
        System.out.println("HI!");
        return true;
    }

    @Test
    public void testWeirdThing() {
        System.out.println(greaterThanOne(0));
        System.out.println(greaterThanOne(2));

        System.out.println(backwardsGreaterThanOne(0));
        System.out.println(backwardsGreaterThanOne(2));
    }

    private boolean greaterThanOne(int num) {
        return num > 1;
    }

    private boolean backwardsGreaterThanOne(int num) {
        return (num > 1) ? false : true;
    }
}