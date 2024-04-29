
// Imports 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;
import java.time.Instant;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;

// Main Class
public class PlatanoPower {

    // Main Method
    public static void main(String[] args) {

        // Used to store all the words in the file
        LinkedList<String> words = new LinkedList<>();
        System.out.println();
        System.out.println(System.getProperty("user.dir"));
        System.out.println();
        // Reads all the words int the "words.txt" file in windows
        // /Users/mikebrown/Documents/VSCode/Projects/src/GroupProject/Platano-Power/src/words.txt
        try {
            Scanner reader = new Scanner(new File(System.getProperty("user.dir") + "\\words.txt"));
            while (reader.hasNextLine()) {
                words.add(reader.nextLine());
            }
            reader.close();

            // Catches the error is the file is not found
        } catch (FileNotFoundException e) {

            // Reads all the words in the "words.txt" file in macBook (not tested)
            try {
                Scanner reader = new Scanner(new File(System.getProperty("user.dir") + "/src/words.txt"));
                while (reader.hasNextLine()) {
                    words.add(reader.nextLine());
                }
                reader.close();

                // Catches the error is the file is not found
            } catch (FileNotFoundException i) {
                System.out.println("File Not Found");
                System.exit(0);
            }
        }

        // Random words used for the search
        String[] words10 = { "polydactylism", "dolcissimo", "superimpersonal", "air-braving", "diagonals",
                "semiministerial", "untoadying", "enrough", "theory-spinning", "proagreement" };
        String[] words20 = { "immanacled", "beholders", "impartance", "post-cyclic", "pauropod", "berreaves",
                "monkhoods", "interlibelling", "Aufmann", "mutton-legger", "spick-and-spandy", "geosid", "scranny",
                "aetiotropically", "vagotony", "biverbal", "harmless", "De-hellenize", "ecotypes", "suitableness" };
        String[] words30 = { "overfroth", "pospolite", "luteinization", "quaffs", "prejustifying", "nannander",
                "ryking", "when-issued", "coshed", "Actinistia", "pulmonical", "subrisory", "turboprop-jet",
                "low-camp",
                "meat-hungry", "whistlefishes", "afflicts", "fulth", "legalese", "honey-sweet", "cross-bedding",
                "accumulates", "deforesting", "memorizers", "unfaithworthy", "uncalmed", "stramash",
                "unpresentably",
                "dossing", "Cassino", };
        String[] words40 = { "ketoheptose", "sclerophyllous", "repudiator", "Santolina", "carpent", "double-bitted",
                "diarial", "unmedical", "Towson", "inebriety", "Tonies", "untantalising", "subversiveness",
                "Euglena",
                "fourre", "Tepehuane", "averments", "Bosnian", "stag-headed", "subsegment's", "loculicidal",
                "rathe",
                "bathing-machine", "furculae", "saguaros", "iwa", "Aganice", "pernyi", "plankless", "l'oeil",
                "quassation", "pantywaists", "cantando", "Etheria", "parosmia", "Francyne", "noblenesses",
                "unshipment",
                "wood-eating", "Stargell" };
        String[] words50 = { "ebonies", "faithlessnesses", "peneplain", "Jonben", "ischiocerite", "monosyllabical",
                "parvanimity", "warabi", "great-granduncle", "dentinitis", "amyloplast", "arisaid", "cowlstaff",
                "spiritlevel", "footgeld", "nurseries", "orbital", "blacknesses", "lophiodontoid", "Gloxinia",
                "discomfort", "unvagrantness", "irrelated", "planosubulate", "postage", "chloridated",
                "hymenopteron",
                "ash-throated", "quadrijugate", "Ialysos", "Dermochelys", "seam", "sputumose", "flare-up",
                "record-setting", "Hydrophidae", "typhoidin", "Clackmannan", "slumberingly", "laumonite", "rearray",
                "tenotomies", "minigroups", "laughingly", "Bernadette", "nowhere-dense", "inconform", "tanginess",
                "dogma", "roles" };

        // Used to store the lists of words
        // LinkedList<String[]> searchWords = new LinkedList<>();
        // searchWords.add(words10);
        // searchWords.add(words20);
        // searchWords.add(words30);
        // searchWords.add(words40);
        // searchWords.add(words50);

        // // Array that stores all the arrays for it
        // QuadraticProbing[] quadraticHashTables = new QuadraticProbing[4];
        // quadraticHashTables[0] = new QuadraticProbing(933102); // load factor of .5 (non-prime)
        // quadraticHashTables[1] = new QuadraticProbing(666501); // load factor of .7 (non-prime)
        // quadraticHashTables[2] = new QuadraticProbing(933073); // load factor of .5 (prime)
        // quadraticHashTables[3] = new QuadraticProbing(666493); // load factor of .7 (prime)

        // Array that stores the time it takes to add words to each table
        double[] addTimeQP = new double[4];

        // Array that stores the probes used when adding words to each table
        int[] addProbesUsedQP = new int[4];

        // // Used to to track the begining of time when tracking
        // double startTime;

        // // Loop to add words
        // for (int i = 0; i < quadraticHashTables.length; i++) {
        //     startTime = System.nanoTime();
        //     quadraticHashTables[i].add(words);
        //     addTimeQP[i] = (System.nanoTime() - startTime) / 1000000000;
        //     addProbesUsedQP[i] = quadraticHashTables[i].getProbesUsed();
        // }

        // // Loop to print the time and probes used per table
        // for (int i = 0; i < addTimeQP.length; i++) {
        //     System.out.printf("Table " + (i + 1) + " -> Time: %.4f | Probes Used: " + addProbesUsedQP[i] + "\n",
        //             addTimeQP[i]);
        // }
        // System.out.println();

        // // Array that stores the time it takes to search words for each table
        // LinkedList<double[][]> searchTimeQP = new LinkedList<>();
        // searchTimeQP.add(new double[4][words10.length]);
        // searchTimeQP.add(new double[4][words20.length]);
        // searchTimeQP.add(new double[4][words30.length]);
        // searchTimeQP.add(new double[4][words40.length]);
        // searchTimeQP.add(new double[4][words50.length]);
        // Array that stores the time it takes to search words for each table
        LinkedList<double[][]> listSearchTimeQP = new LinkedList<>();
        listSearchTimeQP.add(new double[4][words10.length]);
        listSearchTimeQP.add(new double[4][words20.length]);
        listSearchTimeQP.add(new double[4][words30.length]);
        listSearchTimeQP.add(new double[4][words40.length]);
        listSearchTimeQP.add(new double[4][words50.length]);

        // // Array that stores the probes used when adding words for each table
        // int[][] searchProbesUsedQP = new int[4][5];
        // Array that stores the probes used when adding words for each table
        LinkedList<int[][]> listSearchProbesUsedQP = new LinkedList<>();
        listSearchProbesUsedQP.add(new int[4][words10.length]);
        listSearchProbesUsedQP.add(new int[4][words20.length]);
        listSearchProbesUsedQP.add(new int[4][words30.length]);
        listSearchProbesUsedQP.add(new int[4][words40.length]);
        listSearchProbesUsedQP.add(new int[4][words50.length]);

        // // Loop to search for words
        // for (int i = 0; i < 4; i++) {
        //     for (int j = 0; j < 5; j++) {
        //         startTime = System.nanoTime();
        //         for (int e = 0; e < (j + 1) * 10; e++) {
        //             quadraticHashTables[i].get(searchWords.get(j)[e]);
        //         }
        //         searchTimeQP[i][j] = (System.nanoTime() - startTime) / 1000000000;
        //         searchProbesUsedQP[i][j] = quadraticHashTables[i].getProbesUsed();

        //     }
        // }

        // // Loop to print the time and probes used per table
        // for (int i = 0; i < 4; i++) {
        //     System.out.print("Table " + (i + 1) + ":\n");
        //     for (int j = 0; j < searchTimeQP[i].length; j++) {
        //         System.out.printf(
        //                 "\tItems searched for " + (j + 1) * 10 + " ->\nTime: %.4f | Probes Used: "
        //                         + searchProbesUsedQP[i][j] + "\n",
        //                 getMin(searchTimeQP.get(j)[i]));
        //     }
        // }
        // System.out.println();
        // Loop to print the time and probes used per table
        for (int i = 0; i < 4; i++) {
            System.out.print("Table " + (i + 1) + ":\n");
            for (int j = 0; j < listSearchTimeQP.size(); j++) {
                System.out.printf(
                        "\tItems searched for " + (j + 1) * 10
                                + " ->\n\tMin Time: %f\n\tAvg Time: %f\n\tMax Time: %f\n\tMin Probes: %d\n\tAvg Probes: %d\n\tMax Probes: %d\n",
                        getMin(listSearchTimeQP.get(j)[i]), getAverage(listSearchTimeQP.get(j)[i]),
                        getMax(listSearchTimeQP.get(j)[i]), getMin(listSearchProbesUsedQP.get(j)[i]),
                        getAverage(listSearchProbesUsedQP.get(j)[i]),
                        getMax(listSearchProbesUsedQP.get(j)[i]));
            }
        }
        System.out.println();

        LinearProbing h = new LinearProbing();
        Instant i1, i2;
        long duration;
        double time;
        ArrayList<Double> timeList = new ArrayList<>();// stores the times of the operations
        String[] search10, search20, search30, search40, search50;
        String[] wrinkleproof = {"winkleproof"};// for the single word search
        String output = "";

        for (int i = 0; i < h.indexTracker.length; i++) {// sets indexTracker's indice values to 0
            h.indexTracker[i] = 0;
        }

        for (int i = 1; i <= 2; i++) {
            System.out.println("\n\n\nROUND " + i + " of 2\n\n");
            output += "\n\n\nROUND " + i + " of 2\n\n";

            //***********************************************//

            // ***********************************************//
            // TABLE 1, 0.5 LOAD FACTOR, NON-PRIME TABLE SIZE //
            System.out.println("\nTABLE 1 : 0.5 load factor : NON-PRIME table size\n");

            i1 = Instant.now();
            System.out.println("hashing commenced");
            String[] str5 = h.hashing(words, 933102); // .5 lf (non prime)
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("Hashing Duration: " + time + " sec" + "\nProbe Count: " + h.probeCount);

            System.out.println("\n\nSINGLE WORD SEARCH: 'wrinkleproof'");
            i1 = Instant.now();
            h.search(wrinkleproof, str5);
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            System.out.println(time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 10 items"); // 10 ITEM SEARCH

            i1 = Instant.now();
            search10 = h.search(words10, str5);
            for (String word : search10) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 20 items"); // 20 ITEM SEARCH

            i1 = Instant.now();
            search20 = h.search(words20, str5);
            for (String word : search20) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 30 items"); // 30 ITEM SEARCH

            i1 = Instant.now();
            search30 = h.search(words30, str5);
            for (String word : search30) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 40 items"); // 40 ITEM SEARCH

            i1 = Instant.now();
            search40 = h.search(words40, str5);
            for (String word : search40) {
                if (word != null)
                    System.out.print(word + " : ");

            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 50 items"); // 50 ITEM SEARCH

            i1 = Instant.now();
            search50 = h.search(words50, str5);
            for (String word : search50) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            // **********************************************//
            // TABLE 2, 0.5 LOAD FACTOR, PRIME TABLE SIZE
            System.out.println("\nTABLE 2 : 0.5 load factor : PRIME table size\n");

            i1 = Instant.now();
            System.out.println("hashing commence");
            String[] str5p = h.hashing(words, 933073); // .5 lf (prime)
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("Hashing Duration: " + time + " sec" + "\nProbe Count: " + h.probeCount);

            System.out.println("\n\nSINGLE WORD SEARCH: 'wrinkleproof'");
            i1 = Instant.now();
            h.search(wrinkleproof, str5p);
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            System.out.println(time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 10 items"); // 10 ITEM SEARCH

            i1 = Instant.now();
            search10 = h.search(words10, str5p);
            for (String word : search10) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 20 items"); // 20 ITEM SEARCH

            i1 = Instant.now();
            search20 = h.search(words20, str5p);
            for (String word : search20) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 30 items"); // 30 ITEM SEARCH

            i1 = Instant.now();
            search30 = h.search(words30, str5p);
            for (String word : search30) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 40 items"); // 40 ITEM SEARCH

            i1 = Instant.now();
            search40 = h.search(words40, str5p);
            for (String word : search40) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 50 items"); // 50 ITEM SEARCH

            i1 = Instant.now();
            search50 = h.search(words50, str5p);
            for (String word : search50) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            // **********************************************//
            // TABLE 3, 0.7 LOAD FACTOR, NON-PRIME TABLE SIZE
            System.out.println("\nTABLE 3 : 0.7 load factor : NON-PRIME table size\n");

            i1 = Instant.now();
            System.out.println("hashing commence");
            String[] str7 = h.hashing(words, 666501); // .7 lf (non prime)
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("Hahsing Duration: " + time + " sec" + "\nProbe Count: " + h.probeCount);

            System.out.println("\n\nSINGLE WORD SEARCH: 'wrinkleproof'");
            i1 = Instant.now();
            h.search(wrinkleproof, str7);
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            System.out.println(time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 10 items"); // 10 ITEM SEARCH

            i1 = Instant.now();// ***********************//
            search10 = h.search(words10, str7);
            for (String word : search10) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 20 items");

            i1 = Instant.now();// *******************//
            search20 = h.search(words20, str7);
            for (String word : search20) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 30 items");

            i1 = Instant.now();// ***********************//
            search30 = h.search(words30, str7);
            for (String word : search30) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 40 items");

            i1 = Instant.now();// **************************//
            search40 = h.search(words40, str7);
            for (String word : search40) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearcb for 50 items");

            i1 = Instant.now();// ***************************//
            search50 = h.search(words50, str7);
            for (String word : search50) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            // **********************************************//
            // TABLE 4, 0.7 LOAD FACTOR, PRIME TABLE SIZE
            System.out.println("\nTABLE 4 : 0.7 load factor : PRIME table size\n");

            i1 = Instant.now();
            System.out.println("hashing commence");
            String[] str7p = h.hashing(words, 666493); // .7 lf (prime)
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("Hashing Duration: " + time + " sec" + "\nProbe Count: " + h.probeCount);

            System.out.println("\n\nSINGLE WORD SEARCH: 'wrinkleproof'");
            i1 = Instant.now();
            h.search(wrinkleproof, str7p);
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            System.out.println(time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 10 items");

            i1 = Instant.now();// ***********************//
            search10 = h.search(words10, str7p);
            for (String word : search10) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 20 items");

            i1 = Instant.now();// **********************//
            search20 = h.search(words20, str7p);
            for (String word : search20) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 30 items");

            i1 = Instant.now();// ***********************//
            search30 = h.search(words30, str7p);
            for (String word : search30) {
                if (word != null)
                    System.out.print(word + " :");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);

            System.out.println("\nSearch for 40 items");

            i1 = Instant.now();/************************/
            search40 = h.search(words40, str7p);
            for (String word : search40) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Coun: " + h.probeCount);

            System.out.println("\nSearch for 50 items");

            i1 = Instant.now();/**********************/
            search50 = h.search(words50, str7p);
            for (String word : search50) {
                if (word != null)
                    System.out.print(word + " : ");
            }
            i2 = Instant.now();
            duration = Duration.between(i1, i2).toNanos();
            time = (double) duration / 1000000000;
            timeList.add(time);
            System.out.println("\n" + time + " sec duration" + "\nProbe Count: " + h.probeCount);
        }

        System.out.println("\n" + timeList.toString());

        for (int i = 0; i < h.indexTracker.length; i++) {
            System.out.println(i + ":" + h.indexTracker[i]);
        }

        /**************************
         * MIKE BROWN CODE ENDING *
         **************************/

        // for (int i = 0; i < h.indexTracker.length; i++) {
        //     if (h.indexTracker[i] != 0)
        //     System.out.print(i + ", " + h.indexTracker[i] + " : ");
        // }        
        // // SEARCH FOR MIN VALUE
         ArrayList<Double> al = new ArrayList<>();
        double temp = -1;
         double temp2 = -1;
         Double[] arr = {1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0, 8.0, 9.0, 10.0};
        for (int i = 0; i < arr.length; i++) {
        al.add(arr[i]);
         }
         for (int i = 1; i < al.size(); i++) {
         temp = al.get(i);
         temp2 = al.get(i - 1);
         if (temp > temp2)
         temp = temp2;
        }
         System.out.println("MIN: " + temp);

        // FIRST SEARCH (10)************//
        System.out.println("\n.5 load factor 10 item search:");
        // DbleHash h = new LinearProbing]();
        // Instant i1 = Instant.now();
        // String[] str5 = h.hashing(words, 933102); // .5 lf (non prime table size)
        // Instant i2 = Instant.now();
        // long duration1 = Duration.between(i1,i2).toSeconds();
        // System.out.println("Hashing Duration: " + duration1 + "min : Hashing Probe
        // Count: " + h.probeCount);
        // String[] searchResults = h.search(words10, str5);
        // for (int i = 0; i < searchResults.length; i++) {
        // if (searchResults[i] != null)
        // System.out.print(searchResults[i] + ", ");
        // }
        // Instant i3 = Instant.now();
        // long duration2 = Duration.between(i2, i3).toSeconds();
        // System.out.println(duration2 + "min duration" + "\nSearch Probe Count: " +
        // h.probeCount);

        // //SECOND SEARCH (20)************//
        // System.out.println("\n\n20 item search:");
        // Instant i4 = Instant.now();
        // String[] str5p = h.hashing(words, 933073); // .5 lf (prime table size)
        // Instant i5 = Instant.now();
        // long duration3 = Duration.between(i4,i5).toSeconds();
        // System.out.println("Hashing Duration: " + duration3 + "min : Hashing Probe
        // Count: " + h.probeCount);
        // String[] searchResults2 = h.search(words20, str5p);
        // for (int i = 0; i < searchResults2.length; i++) {
        // if (searchResults2[i] != null)
        // System.out.print(searchResults2[i] + ", ");
        // }
        // Instant i6 = Instant.now();
        // long duration4 = Duration.between(i5, i6).toSeconds();
        // System.out.println(duration4 + "min duration" + "\nSearch Probe Count: " +
        // h.probeCount);

        // //THIRD SEARCH (30)************//
        // System.out.println("\n\n30 item search:");
        // Instant i7 = Instant.now();
        // String[] str7 = h.hashing(words, 666501); // .7 lf (non prime)
        // Instant i8 = Instant.now();
        // long duration5 = Duration.between(i7,i8).toSeconds();
        // System.out.println("Hashing Duration: " + duration5 + "min : Hashing Probe
        // Count: " + h.probeCount);
        // String[] searchResults3 = h.search(words30, str7);
        // for (int i = 0; i < searchResults3.length; i++) {
        // if (searchResults3[i] != null)
        // System.out.print(searchResults3[i] + ", ");
        // }
        // Instant i9 = Instant.now();
        // long duration6 = Duration.between(i8, i9).toSeconds();
        // System.out.println(duration6 + "min duration" + "\nSearch Probe Count: " +
        // h.probeCount);

        // //FOURTH SEARCH (40)************//
        // System.out.println("\n\n40 item search:");
        // Instant i10 = Instant.now();
        // String[] str7p = h.hashing(words, 666493); // .7 lf (prime)
        // Instant i11 = Instant.now();
        // long duration7 = Duration.between(i10,i11).toSeconds();
        // System.out.println("Hashing Duration: " + duration7 + "min : Hashing Probe
        // Count: " + h.probeCount);
        // String[] searchResults4 = h.search(words40, str7p);
        // for (int i = 0; i < searchResults4.length; i++) {
        // if (searchResults4[i] != null)
        // System.out.print(searchResults4[i] + ", ");
        // }
        // Instant i12 = Instant.now();
        // long duration8 = Duration.between(i11, i12).toSeconds();
        // System.out.println(duration8 + "min duration" + "\nSearch Probe Count: " +
        // h.probeCount);

        // //FIFTH SEARCH (50)************//
        // System.out.println("\n\n50 item search:");
        // Instant i13 = Instant.now();
        // // String[] fifth = h.hashing(words, 933102);
        // Instant i14 = Instant.now();
        // long duration9 = Duration.between(i13,i14).toSeconds();
        // System.out.println("Hashing Duration: " + duration9 + "min : Hashing Probe
        // Count: " + h.probeCount);
        // String[] searchResults5 = h.search(words50, str5);
        // for (int i = 0; i < searchResults5.length; i++) {
        // if (searchResults5[i] != null)
        // System.out.print(searchResults[i] + ", ");
        // }
        // Instant i15 = Instant.now();
        // long duration10 = Duration.between(i14, i15).toSeconds();
        // System.out.println(duration10 + "min duration" + "\nSearch Probe Count: " +
        // h.probeCount);

    }

    private static double getMin(double[] searchTimes) {
        double temp = searchTimes[0];
        for (double time : searchTimes) {
            if (time < temp) {
                temp = time;
            }
        }
        return temp;
    }

    private static double getMax(double[] searchTimes) {
        double temp = searchTimes[0];
        for (double time : searchTimes) {
            if (time > temp) {
                temp = time;
            }
        }
        return temp;
    }

    private static double getAverage(double[] searchTimes) {
        double temp = 0;
        for (double time : searchTimes) {
            temp += time;
        }
        temp /= searchTimes.length;
        return temp;
    }

    private static int getMin(int[] searchTimes) {
        int temp = searchTimes[0];
        for (int time : searchTimes) {
            if (time < temp) {
                temp = time;
            }
        }
        return temp;
    }

    private static int getMax(int[] searchTimes) {
        int temp = searchTimes[0];
        for (int time : searchTimes) {
            if (time > temp) {
                temp = time;
            }
        }
        return temp;
    }

    private static int getAverage(int[] searchTimes) {
        double temp = 0;
        for (int time : searchTimes) {
            temp += time;
        }
        temp /= searchTimes.length;
        if (temp % 1 != 0) {
            temp++;
        }
        return (int) temp;
    }

}
