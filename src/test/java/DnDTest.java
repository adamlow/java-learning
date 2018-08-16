
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

    public class BaseCharacter {
        private String name;
        private String race;
        private String classType;
        private String alignment;
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

        public String getRace() {
            return race;
        }

        public void setRace(String race) {
            final String[] validRaces = new String[] {"Aasimar", "Dragonborn", "Dwarf", "Elf", "Gnome", "Half-Elf",
                    "Halfling", "Half-Orc", "Human", "Tiefling"};
            if(Arrays.asList(validRaces).contains(race)) {
                this.race = race;
            } else {
                this.race = "Unknown";
            }
        }

        public String getClassType() {
            return classType;
        }

        public void setClassType(String classType) {
            final String[] validClasses = new String[] {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk",
                    "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
            if(Arrays.asList(validClasses).contains(classType)){
                this.classType = classType;
            } else {
                this.classType = "Unknown";
            }
        }

        public String getAlignment() {
            return alignment;
        }

        public void setAlignment(String alignment) {
            final String[] validAlignments = new String[] {"Lawful Good", "Neutral Good", "Chaotic Good",
                    "Lawful Neutral", "Neutral", "Chaotic Neutral", "Lawful Evil", "Neutral Evil", "Chaotic Evil"};
            if(Arrays.asList(validAlignments).contains(alignment)) {
                this.alignment = alignment;
            } else {
                this.alignment = "Unknown";
            }
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

    protected void clericCharacter() {
        BaseCharacter cleric = new BaseCharacter();
        cleric.name = "Alinda Huntinghawk";
        cleric.race = "Elf";
        cleric.classType = "Cleric";
        cleric.alignment = "Lawful Good";
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

    protected void fighterCharacter() {
        BaseCharacter fighter = new BaseCharacter();
        fighter.name = "Adokul the Fighter";
        fighter.race = "Human";
        fighter.classType = "Fighter";
        fighter.alignment = "Chaotic Good";
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

    protected void rogueCharacter() {
        BaseCharacter rogue = new BaseCharacter();
        rogue.name = "Dardiana Milltall";
        rogue.race = "Gnome";
        rogue.classType = "Rogue";
        rogue.alignment = "Chaotic Neutral";
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
