package org.example;
// PokemonManager.java
import java.io.*;
import java.util.*;

public class PokemonManager {
    private Map<String, Pokemon> pokemonMap;
    private Set<String> userCollection;

    public PokemonManager(Map<String, Pokemon> pokemonMap) {
        this.pokemonMap = pokemonMap;
        this.userCollection = new HashSet<>();
    }

    // Método para agregar un Pokémon a la colección del usuario
    public void addPokemonToCollection(String name) {
        if (pokemonMap.containsKey(name)) {
            if (userCollection.contains(name)) {
                System.out.println("El Pokémon ya está en tu colección.");
            } else {
                userCollection.add(name);
                System.out.println("Pokémon agregado a tu colección.");
            }
        } else {
            System.out.println("Error: El Pokémon no existe en los datos leídos.");
        }
    }

    // Método para mostrar los datos de un Pokémon
    public void showPokemonData(String name) {
        Pokemon pokemon = pokemonMap.get(name);
        if (pokemon != null) {
            System.out.println(pokemon);
        } else {
            System.out.println("Error: El Pokémon no existe en los datos leídos.");
        }
    }

    // Método para mostrar el nombre y tipo1 de los Pokémon en la colección del usuario, ordenados por tipo1
    public void showUserCollectionByType1() {
        userCollection.stream()
                .map(pokemonMap::get)
                .sorted(Comparator.comparing(p -> p.type1))
                .forEach(p -> System.out.println("Name: " + p.name + ", Type1: " + p.type1));
    }

    // Método para mostrar el nombre y tipo1 de todos los Pokémon, ordenados por tipo1
    public void showAllPokemonByType1() {
        pokemonMap.values().stream()
                .sorted(Comparator.comparing(p -> p.type1))
                .forEach(p -> System.out.println("Name: " + p.name + ", Type1: " + p.type1));
    }

    // Método para mostrar los Pokémon que tienen una habilidad específica
    public void showPokemonByAbility(String ability) {
        pokemonMap.values().stream()
                .filter(p -> p.abilities.contains(ability))
                .forEach(p -> System.out.println("Name: " + p.name));
    }

    // Método para guardar la colección del usuario en disco
    public void saveUserCollectionToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String name : userCollection) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("Colección guardada en " + filename);
        } catch (IOException e) {
            System.out.println("Error al guardar la colección: " + e.getMessage());
        }
    }

    public Set<String> getUserCollection() {
        return userCollection;
    }
}
}
