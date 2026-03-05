package ui;

import Model.SongHandler.Song;
import service.SpotifyFileHandler;

import java.util.ArrayList;
import java.util.Scanner;

/*
 UI layer.
 Handles user interaction only.
*/

public class SpotifyApp {

    public static void main(String[] args) {

        SpotifyFileHandler handler = new SpotifyFileHandler();
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> songs = getSongs(handler);

        printSongs(songs);

        int choice = getUserChoice(scanner);

        handleChoice(choice, songs, handler);

        scanner.close();
    }

    /*
     Retrieves recipe names from file handler
    */
    private static ArrayList<String> getSongs(SpotifyFileHandler handler) {
        return handler.getSongNames();
    }

    /*
     Prints available songs
    */
    private static void printSongs(ArrayList<String> recipes) {

        System.out.println("Available songs:");

        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i));
        }
    }

    /*
     Gets user input
    */
    private static int getUserChoice(Scanner scanner) {

        System.out.print("Choose a song number: ");
        return scanner.nextInt();
    }

    /*
     Handles user selection logic
    */
    private static void handleChoice(int choice,
                                     ArrayList<String> recipes,
                                     SpotifyFileHandler handler) {

        if (choice > 0 && choice <= recipes.size()) {

            String selectedRecipe = recipes.get(choice - 1);

            ArrayList<Song> ingredients =
                    handler.loadPlayList(selectedRecipe);

            handler.writePlayList(ingredients);

            System.out.println("PlayList created successfully.");

        } else {
            System.out.println("Invalid choice.");
        }
    }
}