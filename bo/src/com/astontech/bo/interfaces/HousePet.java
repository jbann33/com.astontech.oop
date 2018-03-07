package com.astontech.bo.interfaces;

public class HousePet implements IPet {

    private int weight;
    private String name;
    private int numberOfPets;
    private String color;

    //region GETTERS / SETTERS
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getNumberOfPets() {
        return numberOfPets;
    }

    public void setNumberOfPets(int numberOfPets) {
        this.numberOfPets = numberOfPets;
    }
    //endregion

    @Override
    public String getPetName() { return this.name; }

    @Override
    public boolean isLarge() {
        if (this.weight > 60)
            return true;
        else
            return false;
    }

    @Override
    public boolean moreThanOnePet() {
        if (this.numberOfPets > 0)
            return true;
        else
            return false;
    }

    @Override
    public String colorOfPet() {
        return this.color;
    }
}
