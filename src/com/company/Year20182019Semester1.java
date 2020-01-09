package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Year20182019Semester1 {

    /*
    Note: Just assume the final output is exactly the same as on the question paper. Goodluck!
     */

    Year20182019Semester1() {

        /*
        Q3
         */
        int firstIndex = 0, lastIndex = 0;
        int lastIndexTemp = -1;
        String[] lastIndexString = {"TAG", "TAA", "TGA"};
        String input = "";
        String output = "";
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter genome string [quit to stop] : ");
            input = scanner.nextLine();

            if (input.equals("quit")) break;

            while (true)  {
                // Remove any ATGs in front
                while (input.contains("ATG")) {
                    firstIndex = input.indexOf("ATG") + 3;
                    input = input.substring(firstIndex);
                    if (!input.startsWith("ATG")) break;
                }

                if (input.contains("TAG") || input.contains("TAA") || input.contains("TGA")) {
                    for (int i = 0; i < lastIndexString.length; i++) {
                        lastIndex = lastIndexTemp;
                        if (input.contains(lastIndexString[i])) {
                            lastIndexTemp = input.indexOf(lastIndexString[i]);
                        } else {
                            continue;
                        }
                        if (lastIndex > lastIndexTemp) {
                            lastIndex = lastIndexTemp;
                        }
                    }
                } else {
                    System.out.println("No gene is found");
                    break;
                }
                output = input.substring(0, lastIndex);
                if (output.isEmpty() || output.length() % 3 != 0) {
                    System.out.println("No gene is found");
                    break;
                }
                System.out.println(output);

                //Loop back by the part after TAG/TGA/TAA
                input = input.substring(lastIndex + 3);

                if (!input.contains("ATG")) break;
            }
        }

        /*
        Q4
         */
        int sentenceCount = 0, wordCount = 0;
        int[] letterArray = new int[26];

        String line = "";
        try {
            Scanner scanner = new Scanner(new FileInputStream(new File("myAmbition.txt")));
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                char letter;
                int asciiIndex;
                for (int i = 0; i < line.length(); i++) {
                    letter = line.charAt(i);
                    asciiIndex = letter; // A char is also an integer
                    if (letter == '.') sentenceCount++;
                    if (letter == ' ') wordCount++;
                    if (asciiIndex >= 65 && asciiIndex <= 90)letterArray[asciiIndex - 65]++;
                    if (asciiIndex >= 97 && asciiIndex <= 122) letterArray[asciiIndex - 97]++;
                }
                System.out.println(line);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        wordCount++; // Since we were only counting spaces, word count has to increment by one

        System.out.println("Number of sentences: " + sentenceCount);
        System.out.println("Number of words: " + wordCount);
        char ascii;
        for (int i = 0; i < letterArray.length; i++) {
            ascii = (char) (65 + i);
            System.out.printf(ascii + " : " + letterArray[i] + " ");
            if ((i+1) % 8 == 0) System.out.println();
        }

    }
}
