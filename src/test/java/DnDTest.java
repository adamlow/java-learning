
//Create a base class for a D&D character.
//Field Descriptions:
//    * General descriptors (name, race, alignment, etc.)
//    * stats (Str, Dex, Con, Int, Wis, Cha)
//    * Health
//    * AC
//    * Attack Stats (How much damage they do, express this however you want but it should be a range)

//Method Descriptions:
//    1. Method to make an Attack Roll
//    2. Method to roll Attack Damage
//    3. Method to take damage
//    4. Method to get Stat Modifier, calculated by the following formula: ([STAT] - 10)/2;

//Additional Requirements:
//    * Should have a constructor
//    * Should have public/private/protected methods/fields
//    * Getters/Setters are encouraged for private fields
//
//Extend the base class & change methods 1 & 2 to be modified by stats:
//    Cleric - Methods modified by Wisdom modifier
//    Fighter - Methods modified by Strength modifier
//    Rogue - Methods modified by Dexterity modifier
//
//Write a simple method that takes two instances of your base class & makes them fight to the death.
//
//*BONUS* Give each of your extended classes a custom catch phrase when they die

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class DnDTest {

    public interface DiceRoller {
        public int rollDice(int diceNum, int diceFace);
    }

    public interface Inventory {
        public int getInventory();
    }

    public class DiceRollerClass {
        private int diceNum;
        private int diceFace;

        public DiceRollerClass(int diceNum, int diceFace) {
            this.diceNum = diceNum;
            this.diceFace = diceFace;
        }

        public int rollDice() {
            return diceNum * diceFace;
        }
    }

    public static int rollDice(int numDice, int diceFace) {
        return numDice * diceFace;
    }

    //Basic enum, a series of constants
    public enum DamageType {
        BLUDGEONING, PIERCING, SLASHING, MAGIC;
    }

    //Longer enum, still just a series of constants but we will use the names of the enums themselves
    public enum DnDRaces {
        AASIMAR, DRAGONBORN, DWARF, ELF, GNOME, HALF_ELF, HALFLING, HALF_ORC, HUMAN, TIEFLING;
    }

    public enum DnDClasses {
        FIGHTER, ROGUE, CLERIC
    }

    //More complicated enum, instead of using the names we assign a string value to each & then you can print that out instead of the name
    //Now if you use .toString() it will print the display text
    public enum Alignment {
        LG("Lawful Good"), G("Good"), CG("Chaotic Good"),
        LN("Lawful Neutral"), N("Neutral"), CN("Chaotic Neutral"),
        LE("Lawful Evil"), E("Evil"), CE("Chaotic Evil");

        private final String displayText;

        Alignment(final String displayText) {
            this.displayText = displayText;
        }

        @Override
        public String toString() {
            return displayText;
        }
    }

    public class BaseCharacter implements DiceRoller, Inventory {
        public static final String DND_EDITION = "5th Edition";

        private String name;
        private DnDRaces race;
        private DnDClasses classType;
        private Alignment alignment;
        private DiceRollerClass diceRoller;
        private DamageType attackDamageType;//Enum variable declaration
        private int strength;
        private int dexterity;
        private int constitution;
        private int intelligence;
        private int wisdom;
        private int charisma;
        private int proficiencyBonus;
        private int walkingSpeed;
        private int hitPoints;
        private int initiativeBonus;
        private int armorClass;
        private int attackDiceType;
        private int numberOfAttackDice;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        //This getter function returns the name of the race. This is done by getting the name from the enum value.
        public String getRace() {
            return race.name();
        }

        public void setRace(DnDRaces race) {
            this.race = race;
        }

        public String getClassName() {
            return classType.name();
        }

        public void setClassType(DnDClasses classType) {
            this.classType = classType;
        }

        public String getAlignment() {
            return alignment.toString();
        }

        public void setAlignment(Alignment alignment) {
            this.alignment = alignment;
        }

        public int getStrength() {
            return strength;
        }

        public void setStrength(int strength) {
            if(3 <= strength && strength <= 18) {
                this.strength = strength;
            } else {
                this.strength = 10;
            }

        }

        public int getDexterity() {
            return dexterity;
        }

        public void setDexterity(int dexterity) {
            if(3 <= dexterity && dexterity <= 18) {
                this.dexterity = dexterity;
            } else {
                this.dexterity = 10;
            }
        }

        public int getConstitution() {
            return constitution;
        }

        public void setConstitution(int constitution) {
            if(3 <= constitution && constitution <= 18){
                this.constitution = constitution;
            } else {
                this.constitution = 10;
            }
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setIntelligence(int intelligence) {
            if(3 <= intelligence && intelligence <= 18) {
                this.intelligence = intelligence;
            } else {
                this.intelligence = 10;
            }
        }

        public int getWisdom() {
            return wisdom;
        }

        public void setWisdom(int wisdom) {
            if(3 <= wisdom && wisdom <= 18) {
                this.wisdom = wisdom;
            } else {
                this.wisdom = 10;
            }
        }

        public int getCharisma() {
            return charisma;
        }

        public void setCharisma(int charisma) {
            if(3 <= charisma && charisma <= 18) {
                this.charisma = charisma;
            } else {
                this.charisma = 10;
            }
        }

        public int getProficiencyBonus() {
            return proficiencyBonus;
        }

        public void setProficiencyBonus(int proficiencyBonus) {
            this.proficiencyBonus = proficiencyBonus;
        }

        public int getWalkingSpeed() {
            return walkingSpeed;
        }

        public void setWalkingSpeed(int walkingSpeed) {
            this.walkingSpeed = walkingSpeed;
        }

        public int getHitPoints() {
            return hitPoints;
        }

        public void setHitPoints(int hitPoints) {
            this.hitPoints = hitPoints;
        }

        public int getInitiativeBonus() {
            return initiativeBonus;
        }

        public void setInitiativeBonus(int initiativeBonus) {
            this.initiativeBonus = initiativeBonus;
        }

        public int getArmorClass() {
            return armorClass;
        }

        public void setArmorClass(int armorClass) {
            this.armorClass = armorClass;
        }

        public int getAttackDiceType() {
            return attackDiceType;
        }

        public void setAttackDiceType(int attackDiceType) {
            this.attackDiceType = attackDiceType;
        }

        public int getNumberOfAttackDice() {
            return numberOfAttackDice;
        }

        public void setNumberOfAttackDice(int numberOfAttackDice) {
            this.numberOfAttackDice = numberOfAttackDice;
        }

        public DamageType getAttackDamageType() {
            return attackDamageType;
        }

        public void setAttackDamageType(DamageType attackDamageType) {
            this.attackDamageType = attackDamageType;
        }

        public BaseCharacter() {
            armorClass = 15;
            attackDiceType = 4;
            numberOfAttackDice = 2;
            diceRoller = new DiceRollerClass(numberOfAttackDice, attackDiceType);

            setAttackDamageType(DamageType.BLUDGEONING);//You can only set the damage type to one of the values in the enum
//            attackDamageType = "FIRE";//THIS wouldn't work because damage type isn't a string it's an enum
        }

        public BaseCharacter(String name, DnDRaces race, DnDClasses classType, Alignment alignment, int strength, int dexterity,
                             int constitution, int intelligence, int wisdom, int charisma, int proficiencyBonus,
                             int walkingSpeed, int hitPoints, int initiativeBonus, int armorClass, int attackDiceType,
                             int numberOfAttackDice) {
            this.name = name;
            this.race = race;
            this.classType = classType;
            this.alignment = alignment;
            this.strength = strength;
            this.dexterity = dexterity;
            this.constitution = constitution;
            this.intelligence = intelligence;
            this.wisdom = wisdom;
            this.charisma = charisma;
            this.proficiencyBonus = proficiencyBonus;
            this.walkingSpeed = walkingSpeed;
            this.hitPoints = hitPoints;
            this.initiativeBonus = initiativeBonus;
            this.armorClass = armorClass;
            this.attackDiceType = attackDiceType;
            this.numberOfAttackDice = numberOfAttackDice;
        }

        @Override
        public int rollDice(int diceNum, int diceFace) {
            return diceRoller.rollDice();
        }

        @Override
        public int getInventory() {
            return rollDice(numberOfAttackDice, attackDiceType);
        }

        //I don't know if we've covered switch statements... If not here you go!
        public String getAttackAdjective() {
            switch (attackDamageType) {
                case MAGIC:
                    return "Magical";
                case PIERCING:
                    return "Stabbing";
                case SLASHING:
                    return "Slicing";
                case BLUDGEONING:
                    return "Crushing";
                default:
                    return "Unknown!";
            }
        }
    }

    public int attackToHit(int hitModifier) {
        // Returning the sum of a random number between 1 and 20 and the hit modifier sent in.
        int hitRoll = ThreadLocalRandom.current().nextInt(1, 20) + hitModifier;
        return hitRoll;
    }

    public int attackDamage(int diceType, int numberOfDice) {
        // Returning the total number of damage calculated from the dice type (d4, d12, etc.) and the number of dice needed.
        int damageRoll = 0;
        for(int dice = 1; dice <= numberOfDice; dice++){
            damageRoll += ThreadLocalRandom.current().nextInt(1, diceType);
        }
        return damageRoll;
    }

    public int takeDamage(int currentHitPoint, int damage) {
        // Returning the character's hit points based on the current hit points sent in and the amount of damage to take.
        currentHitPoint -= damage;
        return currentHitPoint;
    }

    public int statModifier(int statTotal) {
        // Returning the stat modifier based on the stat (Strength, Dexterity, etc.) set in.
        int statModifierNumber = (statTotal - 10)/2;
        return statModifierNumber;
    }

    //Extend the base class & change methods 1 & 2 to be modified by stats:
    //    Cleric - Methods modified by Wisdom modifier
    //    Fighter - Methods modified by Strength modifier
    //    Rogue - Methods modified by Dexterity modifier

    public void clericCharacter() {
        BaseCharacter cleric = new BaseCharacter();
        cleric.name = "Alinda Huntinghawk";
        cleric.race = DnDRaces.ELF;
        cleric.classType = DnDClasses.CLERIC;
        cleric.alignment = Alignment.LG;
        cleric.strength = 10;
        cleric.dexterity = 8;
        cleric.constitution = 13;
        cleric.intelligence = 14;
        cleric.wisdom = 15;
        cleric.charisma = 12;
        cleric.proficiencyBonus = 2;
        cleric.walkingSpeed = 30;
        cleric.armorClass = 15;
        cleric.attackDiceType = 4;
        cleric.numberOfAttackDice = 3;
    }

    public void fighterCharacter() {
        BaseCharacter fighter = new BaseCharacter();
        fighter.name = "Adokul the Fighter";
        fighter.race = DnDRaces.valueOf("HUMAN");//This will take the String "HUMAN" and convert it to the HUMAN enum value
        fighter.classType = DnDClasses.values()[0];//Enums are actually an array of values, you can use this to make assignments using array accessors
        fighter.alignment = Alignment.CG;
        fighter.strength = 15;
        fighter.dexterity = 14;
        fighter.constitution = 13;
        fighter.intelligence = 8;
        fighter.wisdom = 10;
        fighter.charisma = 12;
        fighter.proficiencyBonus = 2;
        fighter.walkingSpeed = 35;
        fighter.armorClass = 17;
        fighter.attackDiceType = 6;
        fighter.numberOfAttackDice = 3;
    }

    public void rogueCharacter() {
        BaseCharacter rogue = new BaseCharacter();
        rogue.name = "Dardiana Milltall";
        rogue.race = DnDRaces.GNOME;
        rogue.classType = DnDClasses.ROGUE;
        rogue.alignment = Alignment.CN;
        rogue.strength = 8;
        rogue.dexterity = 15;
        rogue.constitution = 13;
        rogue.intelligence = 14;
        rogue.wisdom = 10;
        rogue.charisma = 12;
        rogue.proficiencyBonus = 2;
        rogue.walkingSpeed = 40;
        rogue.armorClass = 16;
        rogue.attackDiceType = 6;
        rogue.numberOfAttackDice = 2;
    }
}
