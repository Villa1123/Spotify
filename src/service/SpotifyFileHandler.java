package service;

import Lesson15.Recipes.model.*;

import java.io.*;
import java.util.ArrayList;

/*
 Handles all file IO.
 No UI logic.
 No throws — exceptions handled internally.
*/

public class SpotifyFileHandler {

    private static final String FILE_PATH = "src\\Lesson15\\Recipes\\recipes.txt";

    public ArrayList<String> getRecipeNames() {

        ArrayList<String> recipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.contains(",")) {
                    recipes.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public ArrayList<Ingredient> loadRecipe(String recipeName) {

        ArrayList<Ingredient> ingredients = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;
            boolean foundRecipe = false;

            while ((line = reader.readLine()) != null) {

                if (line.equals(recipeName)) {
                    foundRecipe = true;
                    continue;
                }

                if (foundRecipe) {

                    if (line.isEmpty()) break;

                    String[] parts = line.split(",");

                    String name = parts[0];
                    double amount = Double.parseDouble(parts[1]);
                    Unit unit = Unit.valueOf(parts[2]);
                    Category category = Category.valueOf(parts[3]);

                    Ingredient ingredient;

                    // Polymorphic instantiation
                    if (category == Category.SOLID) {
                        ingredient = new SolidIngredient(name, amount, unit);
                    } else {
                        ingredient = new LiquidIngredient(name, amount, unit);
                    }

                    ingredients.add(ingredient);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public void writeShoppingList(ArrayList<Ingredient> ingredients) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("shopping_list.txt"))) {

            for (Ingredient ingredient : ingredients) {

                // Polymorphism in action
                writer.write(ingredient.formatForShoppingList());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}