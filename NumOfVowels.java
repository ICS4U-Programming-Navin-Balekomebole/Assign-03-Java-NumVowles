import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* The program will take a string and
* will return the total count
* of the number of vowels.
*
* @author  Navin Balekomebole
* @version 1.0
* @since   2023-05-02
*/

public final class NumOfVowels {
    /**
    * For Style.
    *
    * @exception IllegalStateException Utility Class
    * @see IllegalStateException
    */
    private NumOfVowels() {
        throw new IllegalStateException("Utility Class");
    }

    /**
    * Recursive function to count vowels in a string.
    *
    * @param str from a file
    * @return num of vowels
    */
    public static int countVowels(String str) {
        // base case: empty string has zero vowels
        if (str.isEmpty()) {
            return 0;
        }
        // recursive case: count the vowel in the first character
        // and add it to the count of vowels in the rest of the string
        final char firstChar = str.charAt(0);
        int vowelCount = 0;
        if (isVowel(firstChar)) {
            vowelCount = 1;
        }
        return vowelCount + countVowels(str.substring(1));
    }

    /**
    * Helper for previous function.
    *
    * @param letter from previous function
    * @return index of vowels
    */
    private static boolean isVowel(char letter) {
        return "aeiouAEIOU".indexOf(letter) != -1;
    }

    /**
    * Main class.
    *
    * @param args unused
    */
    public static void main(String[] args) {
        try {
            // read input from a file called input.txt
            final Scanner scanner = new Scanner(new File("input.txt"));
            final FileWriter writer = new FileWriter(new File("output.txt"));
            // Loop so each line is sent to function.
            while (scanner.hasNextLine()) {
                final String inputString = scanner.nextLine();
                // calculate the number of vowels using the recursive function
                final int vowelCount = countVowels(inputString);
                // write output to a file called output.txt
                writer.write("Number of vowels in the input string: "
                    + vowelCount + "\n");
                System.out.println("Number of vowels in the input string: "
                    + vowelCount);
            }
            writer.close();
        } catch (IOException err) {
            System.out.println("An error occurred: " + err.getMessage());
        }
    }
}
