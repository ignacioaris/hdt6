package org.example;
// Pokemon.java
public class Pokemon {
    String name;
    String pokedexNumber;
    String type1;
    String type2;
    String classification;
    double height;
    double weight;
    String abilities;
    int generation;
    String legendaryStatus;

    // Constructor
    public Pokemon(String name, String pokedexNumber, String type1, String type2, String classification,
                   double height, double weight, String abilities, int generation, String legendaryStatus) {
        this.name = name;
        this.pokedexNumber = pokedexNumber;
        this.type1 = type1;
        this.type2 = type2;
        this.classification = classification;
        this.height = height;
        this.weight = weight;
        this.abilities = abilities;
        this.generation = generation;
        this.legendaryStatus = legendaryStatus;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Type1: " + type1 + ", Type2: " + type2 + ", Abilities: " + abilities;
    }
}