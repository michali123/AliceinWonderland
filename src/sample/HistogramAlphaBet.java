package sample;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

class HistogramAlphaBet {


        //updates the frequency of each letter appearance
    public static <K> void incrementFrequency(Map<K, Integer> frequency, K key) {

        frequency.putIfAbsent(key, 0);
        frequency.put(key, frequency.get(key) + 1);
    }

    public static LinkedHashMap<Character, Integer> sortHashMapByValues(
            HashMap<Character, Integer> passedMap) {
        List<Character> mapKeys = new ArrayList<>(passedMap.keySet());
        List<Integer> mapValues = new ArrayList<>(passedMap.values());
        Collections.sort(mapValues);
        Collections.sort(mapKeys);

        LinkedHashMap<Character, Integer> sortedMap =
                new LinkedHashMap<>();

        Iterator<Integer> valueIt = mapValues.iterator();
        while (valueIt.hasNext()) {
            Integer val = valueIt.next();
            Iterator<Character> keyIt = mapKeys.iterator();

            while (keyIt.hasNext()) {
                Character key = keyIt.next();
                Integer comp1 = passedMap.get(key);
                Integer comp2 = val;

                if (comp1.equals(comp2)) {
                    keyIt.remove();
                    sortedMap.put(key, val);
                    break;
                }
            }
        }
        return sortedMap;
    }

    public static void main(String[] args) throws Exception {
        String st = "";
        try {
            st = new String(Files.readAllBytes(Paths.get("C:\\Users\\stree\\Desktop\\SCHOOL\\java\\PROJECT3\\AliceInWonderland.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        st = st.replaceAll("[^a-zA-Z]", "").toLowerCase();
        System.out.println("The following is \"Alice in Wonderland\" book Alphabet in lower case only: \n\n" + st + '\n');

        System.out.println("Number of Characters:" + (st.length() - 1) + '\n');
        Map<Character, Integer> frequency = new HashMap<Character, Integer>();

        for (int i = 0; i < st.length(); i++) {
            Character Ch = st.charAt(i);
            incrementFrequency(frequency, Ch);
        }

        int frequencies_sum = 0;
        LinkedHashMap<Character, Integer> sortedFrequencies = new LinkedHashMap<>();
        // converting sortedFrequencies list to an array for accessing top n events (it's declared as a public static in order to use it
        //in MyPieChart class.
        sortedFrequencies = sortHashMapByValues((HashMap<Character, Integer>) frequency);

        System.out.println("Frequency of Characters sorted by key:");
        for (Character s : frequency.keySet()) {
            System.out.println(s + " = " + frequency.get(s));
        }
        System.out.println("Frequency of Characters sorted by value:");
        for (Character s : sortedFrequencies.keySet()) {
            System.out.println(s + " = " + sortedFrequencies.get(s));
        }

        for (Character s : sortedFrequencies.keySet()) {
            frequencies_sum = frequencies_sum + sortedFrequencies.get(s);
        }

        System.out.println("Sum of frequencies of all events: " + frequencies_sum);

        //Getting Collection of values from HashMap
        //copying all sortedFrequencies values to sortedArrayFrequencies array list
        Collection<Integer> values = sortedFrequencies.values();
        List<Integer> sortedArrayFrequencies = new ArrayList<>(values);

        // Setting number of events 'n'
        int n = 3, numOfevents = n;

        ArrayList<Integer> topFrequencies = new ArrayList<>();
        int maxLetterIndex = 25;
        while (n > 0) {
            topFrequencies.add(sortedArrayFrequencies.get(maxLetterIndex));
            maxLetterIndex--;
            n--;
        }

        // calculating n frequencies probabilities:
        // letter probability = (letter frequency / sum of all letter frequencies)
        double[] letter_probability = new double[numOfevents];
        int i = 0, counter = 0;

        while (!topFrequencies.isEmpty()) {

            letter_probability[counter] = topFrequencies.get(i); //getting max letter frequency from topFrequency list.
            System.out.println("topFrequency at " + counter + " is : " + topFrequencies.get(i));

            letter_probability[counter] = letter_probability[counter] / frequencies_sum;  //calculating letter portability
            System.out.println("prob. of " + counter + " letter is " + letter_probability[counter]);

            topFrequencies.remove(i); //making the next max frequent event to the head of the list
            counter++;
        }

        int k = 0; //calculating the angle for each letter; using toRadians(360 * letter probability)
        letterAngle = new double[numOfevents];
        for (k = 0; k < letter_probability.length; k++) {
            letterAngle[k] = Math.toRadians(letter_probability[k] * 360);
            System.out.println(letterAngle[k]);
        }
        double restOfeventsProb= 0;
        restOfeventsProb = 1 - letter_probability[0];
        for (int h=1 ; h < letter_probability.length; h++){
            restOfeventsProb= restOfeventsProb- letter_probability[h];
        }
        System.out.println("rest of event probability: " + restOfeventsProb);

    }
    public static double[] letterAngle;

}