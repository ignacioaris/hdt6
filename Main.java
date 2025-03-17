package org.example;
// Main.java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Leer el archivo CSV y cargar los datos en un Map
        Map<String, Pokemon> pokemonMap = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/pokemon.csv"))) {
            String line;
            br.readLine(); // Saltar la primera línea (encabezados)
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                // Limpiar los datos y asegurarse de que no haya espacios en blanco
                String name = data[0].trim();
                String pokedexNumber = data[1].trim();
                String type1 = data[2].trim();
                String type2 = data[3].trim();
                String classification = data[4].trim();
                double height = Double.parseDouble(data[5].trim());
                double weight = Double.parseDouble(data[6].trim());
                String abilities = data[7].trim();
                int generation = Integer.parseInt(data[8].trim());
                String legendaryStatus = data[9].trim();

                // Crear el objeto Pokemon
                Pokemon pokemon = new Pokemon(name, pokedexNumber, type1, type2, classification, height, weight, abilities, generation, legendaryStatus);
                pokemonMap.put(name, pokemon);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo CSV: " + e.getMessage());
            return;
        }

        // Seleccionar la implementación de Map
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map (1: HashMap, 2: TreeMap, 3: LinkedHashMap):");
        int choice = scanner.nextInt();
        Map<String, Pokemon> selectedMap = MapFactory.createMap(choice);

        // Cargar los datos en el Map seleccionado
        selectedMap.putAll(pokemonMap);

        // Crear una instancia de PokemonManager
        PokemonManager manager = new PokemonManager(selectedMap);

        // Ejemplo de uso
        manager.addPokemonToCollection("Pikachu");
        manager.showPokemonData("Pikachu");
        manager.showUserCollectionByType1();
        manager.showAllPokemonByType1();
        manager.showPokemonByAbility("Static");
        manager.saveUserCollectionToFile("user_collection.txt");
    }
}