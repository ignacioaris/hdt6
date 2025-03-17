package org.example;

import org.example.Pokemon;
import org.example.PokemonManager;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class PokemonManagerTest {

    @org.junit.jupiter.api.Test
    void addPokemonToCollection() {
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "25", "Electric", "", "Mouse", 0.4, 6.0, "Static", 1, "No"));
        PokemonManager manager = new PokemonManager(pokemonMap);

        manager.addPokemonToCollection("Pikachu");
        assertTrue(manager.getUserCollection().contains("Pikachu"));
    }

    @org.junit.jupiter.api.Test
    void showPokemonData() {

        Map<String, Pokemon> pokemonMap = new HashMap<>();
        pokemonMap.put("Pikachu", new Pokemon("Pikachu", "25", "Electric", "", "Mouse", 0.4, 6.0, "Static", 1, "No"));
        PokemonManager manager = new PokemonManager(pokemonMap);

        manager.showPokemonData("Pikachu"); // Debería imprimir los datos de Pikachu
    }
}