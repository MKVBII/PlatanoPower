import java.util.LinkedList;

/**
 * Linear Probing Class 
 * 
 * @Author Michael Brown
 */
class LinearProbing {
// TEstubuvjhh
    //int[] table;
    int[] indexTracker = new int[933102];
    int probeCount;

    /**
     *  hashes the elements from the inputted table to an array
     * @param hashFrom list of words that are to be hashed
     * @param size size of the to-be returned array
     * @return array with words hashed 
     */
    public String[] hashing(LinkedList<String> hashFrom, int size) {

        probeCount = 0;
        int col = 0;

        String hashTo[] = new String[size];
        //this.table = new int[hashTo.length];

        for (String word : hashFrom) {

            //int total = 0;

            //extracts an integer value for the word
            // for (Character c : word.toCharArray()) {
            //     total += c;
            // }

            int hv = word.hashCode() % hashTo.length; // Computing the hash value

            if (hv < 0) {
                hv *= -1;
            } 

            
            if (hashTo[hv] == null) { // NO COLLISION
                
                hashTo[hv] = word;
                indexTracker[hv]++;
                //noCol++;

            } else { // COLLISION

               for (int i = hv; hashTo[hv] != null;i++) { // LINEAR PROBING

                    if (i == hashTo.length){
                        i = 0;
                    }

                    probeCount++;
                    col++;
                    hv++;
                    hv %= hashTo.length;
                }

                hashTo[hv] = word;
                indexTracker[hv]++;

            }

        }

        System.out.println("hashing complete\nCollisions: " + col);
        return hashTo;

    }

    /**
     * searches for words within an inputted list from another, also inputted list
     * @param search list of to be searched words
     * @param wordList list that is being searched from
     * @return a string of the words found from the list 
     */
    public String[] search(String[] search, String[] wordList) {

        probeCount = 0; 
        String[] indexArray = new String[wordList.length];
        int i = 0;

        for (String word : search) {

            int hv = word.hashCode() % wordList.length;
            if (hv < 0) {
                hv *= -1;
            }

            if (wordList[hv] == word) {
                indexArray[i] = word;
                i++;

            } else {

            
                for (int l = hv; wordList[hv] != word && l < wordList.length; l++) {
                    if (l == wordList.length) {
                        l = 0;
                    }
                    probeCount++;
                    hv++;
                    hv %= wordList.length; 
                }

                indexArray[i] = word;
                i++;

            }
        }

        System.out.println("search complete");
        return indexArray;
    }
}