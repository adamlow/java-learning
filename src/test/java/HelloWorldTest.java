import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

    @Test
    public void testArray() {
        int[] dogAges;

        dogAges = new int[5];

        dogAges[0] = 2;
        dogAges[1] = 4;
        dogAges[2] = 6;

        System.out.println(dogAges[0]);
    }

    @Test
    public void testArrayLoops() {
        int[] dogAges;

        dogAges = new int[5];

        dogAges[0] = 2;
        dogAges[1] = 4;
        dogAges[2] = 6;

        for(int dogAge : dogAges) {
            dogAge++;
            System.out.println(dogAge);
        }
    }

    @Test
    public void testArrayLoopsTwo() {
        int[] dogAges;

        dogAges = new int[5];

        dogAges[0] = 2;
        dogAges[1] = 4;
        dogAges[2] = 6;

        for(int index = 0; index < dogAges.length; index++) {
            dogAges[index]++;
            System.out.println(dogAges[index]);
        }

        for(int dogAge : dogAges) {
            System.out.println(dogAge);
        }
    }

    @Test
    public void testArrayCopy() {
        int[] dogAges;

        dogAges = new int[5];

        dogAges[0] = 2;
        dogAges[1] = 4;
        dogAges[2] = 6;
        dogAges[3] = 6;
        dogAges[4] = 6;

        int[] newDogAges = dogAges.clone();


        for(int index = 0; index < dogAges.length; index++) {
            System.out.println(dogAges[index]);
            System.out.println(newDogAges[index]);
        }
    }

    @Test
    public void testArrayResize() {
        int[] dogAges;

        dogAges = new int[5];

        dogAges[0] = 2;
        dogAges[1] = 4;
        dogAges[2] = 6;
        dogAges[3] = 6;
        dogAges[4] = 6;

        int[] newDogAges = new int[10];


        for(int index = 0; index < dogAges.length; index++) {
            newDogAges[index] = dogAges[index];
        }

        newDogAges[5] = 10;
        newDogAges[6] = 100;

        for(int dogAge : newDogAges) {
            System.out.println(dogAge);
        }
    }

    @Test
    public void testMultiDimensionalArrays() {
        int[][] dogAges = new int[10][10];
    }

    @Test
    public void testList() {
        java.util.List<Integer> catAges = new ArrayList<>();

        catAges.add(5);
        catAges.add(10);
        catAges.add(199);

        for(int catAge : catAges) {
            System.out.println(catAge);
        }

        catAges.remove(2);
        catAges.add(1, 7);

        for(int catAge : catAges) {
            System.out.println(catAge);
        }

        System.out.println(catAges.contains(5));

        catAges.set(0, 56);

        System.out.println(catAges.get(0));

        catAges.isEmpty();


    }

    @Test
    public void testListIterator() {
        java.util.List<Integer> catAges = new ArrayList<>();

        catAges.add(5);
        catAges.add(10);
        catAges.add(199);

        Iterator<Integer> catAgeIterator = catAges.iterator();

        while (catAgeIterator.hasNext()) {
            int catAge = catAgeIterator.next();
            System.out.println(catAge);
        }
    }

    @Test
    public void testIteratorEfficiency() {
        java.util.List<Integer> catAges = new ArrayList<>();

        for(int count = 0; count < 10000000; count++) {
            catAges.add(count);
        }

        Iterator<Integer> catAgeIterator = catAges.iterator();

        while (catAgeIterator.hasNext()) {
            int catAge = catAgeIterator.next();
            System.out.println(catAge);
        }
    }

    @Test
    public void testLoopEfficiency() {
        List<Integer> catAges = new ArrayList<>();

        for(int count = 0; count < 10000000; count++) {
            catAges.add(count);
        }

        for(int index = 0; index < catAges.size(); index++) {
            System.out.println(catAges.get(index));
        }
    }

//    Write a method that can print out a 2D grid of variable size with the following requirements:
//
//            * Each spot in the grid is a random number between 0 - 9
//            * The grid can never be completely "empty" (all 0s)

    @Test
    public void testGrid() {
        int firstNumber = ThreadLocalRandom.current().nextInt(1, 11);
        int secondNumber = ThreadLocalRandom.current().nextInt(1, 11);
        int[][] newGrid = new int[firstNumber][secondNumber];

        for(int i = 0; i < firstNumber; i++){
            for(int j = 0; j < secondNumber; j++){
                newGrid[i][j] = ThreadLocalRandom.current().nextInt(0, 10);
            }
        }

        for (int row = 0; row < firstNumber; row++ ) {
            for (int col = 0; col < secondNumber; col++) {
                System.out.printf("%7d", newGrid[row][col]);
            }
            System.out.println();
        }
    }
//
//    Write a second method that takes three arguments:
//            * two-dimensional Array
//            * number to change (old)
//            * number to change it to (new)
//
//    Then given the arguments, search through the array and change all values of 'old' to 'new'
//
//            return the new array.

    public int[][] numberChange(int[][] theList, int oldNum, int newNum) {
        for(int rows = 0; rows < theList.length; rows++){
            for(int cols = 0; cols < theList[0].length; cols++){
                if(theList[rows][cols] == oldNum){
                    theList[rows][cols] = newNum;
                }
            }
        }
        return theList;
    }

    @Test
    public void testNumberChange(){
        int[][] theList = {{1, 2}, {2, 3}, {3, 4}, {4, 3}, {3, 2}, {2, 1}};
        int oldNum = 2;
        int newNum = 8;

        System.out.println("Old List:");
        for (int row = 0; row < theList.length; row++ ) {
            for (int col = 0; col < theList[0].length; col++) {
                System.out.printf("%7d", theList[row][col]);
            }
            System.out.println();
        }

        System.out.println("New List:");
        int [][] newList = numberChange(theList, oldNum, newNum);

        for (int row = 0; row < newList.length; row++ ) {
            for (int col = 0; col < newList[0].length; col++) {
                System.out.printf("%7d", newList[row][col]);
            }
            System.out.println();
        }
    }

    private boolean greaterThanOne(int num) {
        return num > 1;
    }

    private boolean backwardsGreaterThanOne(int num) {
        return (num > 1) ? false : true;
    }
}