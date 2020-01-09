package com.company;

import java.util.Scanner;

public class Year20182019Semester1 {

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
    }
}
