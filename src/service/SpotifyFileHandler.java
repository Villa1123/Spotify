package service;

import Model.SongHandler.Genre;
import Model.SongHandler.Song;
import Model.SongHandler.PlayList;

import java.io.*;
import java.util.ArrayList;

/*
 Handles all file IO.
 No UI logic.
 No throws — exceptions handled internally.
*/

public class SpotifyFileHandler {

    private static final String FILE_PATH = "songs.txt";

    public ArrayList<String> getSongNames() {

        ArrayList<String> recipes = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {

            String line;

            while ((line = reader.readLine()) != null) {

                if (!line.contains(",") && !line.isEmpty()) { //den her linje har chat rettet
                    recipes.add(line);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recipes;
    }

    public ArrayList<Song> loadPlayList(String recipeName) {

        ArrayList<Song> ingredients = new ArrayList<>();

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
                    Genre genre = Genre.valueOf(parts[1]);
                    String artist = String.valueOf(parts[2]);

                    Song ingredient;

                    // Polymorphic instantiation
                    if (genre == Genre.ROCK) {
                        ingredient = new Song(name, genre, artist);
                    } else {
                        ingredient = new Song(name, genre, artist);
                    }

                    ingredients.add(ingredient);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return ingredients;
    }

    public void writePlayList(ArrayList<Song> ingredients) {

        try (BufferedWriter writer =
                     new BufferedWriter(new FileWriter("PlayList.txt"))) {

            for (Song ingredient : ingredients) {

                // Polymorphism in action
                writer.write(ingredient.formatForPlayList());
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}