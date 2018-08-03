import org.junit.Test;

import java.awt.*;

public class ClassesTest {



    public class Cat {
        int age;
        int legCount;
        int tailCount;
        String name;

        public Cat() {
            legCount = 4;
            tailCount = 1;
        }

        public Cat(int age, String name) {
            this.legCount = 4;
            this.tailCount = 1;
            this.age = age;
            this.name = name;
        }

        public void happyBirthday() {
            age++;
            System.out.println("Happy Birthday to myself. PS: my name is: " + name + ". and I am now " + age + " years old.");
        }
    }



    @Test
    public void testCat() {
        Cat firstCat = new Cat();

        firstCat.age = 8;
        firstCat.name = "Bob";

        Cat secondCat = new Cat(2, "Sally");

        System.out.println(firstCat.toString());
        System.out.println(secondCat.toString());
    }

    @Test
    public void testCatHappyBirthday() {
        Cat firstCat = new Cat(1, "Bob");
        Cat secondCat = new Cat(2, "Sally");
        Cat thirdCat = new Cat(19, "Grouchy");

        firstCat.happyBirthday();
        secondCat.happyBirthday();
        thirdCat.happyBirthday();
    }

    public class Animal {
        int age;
        private int legCount;
        private int tailCount;
        String name;

        public int getLegCount() {
            return legCount;
        }

        public int getTailCount() {
            return tailCount;
        }

        public void setLegCount(int legCount) {
            if(legCount < 0) {
                this.legCount = 0;
            }

            this.legCount = legCount;
        }

        public void setTailCount(int tailCount) {
            this.tailCount = tailCount;
        }

        public Animal() {
            legCount = 4;
            tailCount = 1;
        }

        public Animal(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public void sayHello() {
            System.out.println("Hello! My name is: " + name);
        }

        protected void protectedMethod() {
            System.out.println("HI");
        }

        private void privateMethod() {
            System.out.println("Its a secret");
        }
    }

    public class Dog extends Animal {
        String lastName;

        public Dog(int age, String name) {
            super(age, name);
        }

        @Override
        public void sayHello() {
            System.out.println("Hello! My name is: " + name + " " + lastName);
        }

        @Override
        protected void protectedMethod() {
            super.protectedMethod();
        }
    }

    public class Horse extends Animal {
        public Horse(int age, String name) {
            super(age, name);
        }

        @Override
        public void sayHello() {
            System.out.println("Hello! My name is: " + name + " and I have " + this.getLegCount() + " legs.");
        }
    }

    @Test
    public void testAnimals() {
        Dog dogOne = new Dog(4, "Dog");
        Horse horse = new Horse(10, "Horsey");
        dogOne.lastName = "smiles";

        dogOne.sayHello();
        horse.sayHello();
    }

    @Test
    public void testPrivateAnimalStuff() {
        Animal animal = new Animal(10, "test");
        animal.privateMethod();

        Horse horse = new Horse(10, "sam");

        horse.sayHello();
        horse.protectedMethod();
    }

}
