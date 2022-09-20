package edu.touro.cs.mcon364;

import java.util.*;
//import java.util.regex.Matcher;
//import java.util.regex.Pattern;
//import java.util.stream.Collectors;

public class TextStatistics {
//    private static final Pattern p = Pattern.compile("\\S+(\\s|$)"); // one or more non-whitespace characters followed by whitespace or end of string.

    /**
     * Counts the number of words in some text.
     *
     * @param text a block of text.
     * @return the number of words in the input.
     */
    public static int wordCount(String text) {
        if (text.length() == 0) {
            return 0;
        }

        int count = 0;
        Scanner sc = new Scanner(text);

        do {
            count++;
            sc.next();
        } while (sc.hasNext());
        return count;


        // using regex
//        Matcher m = p.matcher(text);
//        return (int) m.results().count();
    }

    /**
     * Counts the number of unique words in some text.
     *
     * @param text a block of text.
     * @return the number of unique words in the input.
     */
    public static int uniqueWordCount(String text) {
        HashSet<String> uniqueWords = new HashSet<>();
        Scanner sc = new Scanner(text);

        while (sc.hasNext()) {
            uniqueWords.add(sc.next().toLowerCase());
        }
        return uniqueWords.size();

        // using regex
//        Matcher m = p.matcher(text);
//
//        HashSet<String> uniqueWords = new HashSet<>();
//
//        while (m.find()) {
//            uniqueWords.add(m.group().toLowerCase().trim());
//        }
//        return uniqueWords.size();

        // DRY option
//         return wordStats(text).size();
    }

    /**
     * Compiles all the words that appear in text into a Map. This method is case-insensitive.
     *
     * @param text a block of text.
     * @return A mapping of the text with word as key and number of occurrences as value.
     */
    public static Map<String, Integer> wordStats(String text) {
        HashMap<String, Integer> uniqueMap = new HashMap<>();
        Scanner sc = new Scanner(text);

        while (sc.hasNext()) {
            String word = sc.next().toLowerCase();
            uniqueMap.putIfAbsent(word, 0);
            uniqueMap.put(word, uniqueMap.get(word) + 1);
        }
        return uniqueMap;

        // using regex
//        Matcher m = p.matcher(text);
//
//        HashMap<String, Integer> uniqueMap = new HashMap<>();
//
//        while (m.find()) {
//            String word = m.group().toLowerCase().trim();
//            uniqueMap.putIfAbsent(word, 0);
//            uniqueMap.put(word, uniqueMap.get(word) + 1);
//        }
//        return uniqueMap;


        // Using Streams
        // From https://stackoverflow.com/a/56974911
        // I feel like there's a more efficient way to do this, especially trim the results.
//         return p.matcher(text).results().collect(
//                Collectors.groupingBy(word -> word.group().toLowerCase().trim(), Collectors.summingInt(i -> 1)));
    }

    /**
     * Counts the number of distinct letters in text. The method takes into account only alphabetical characters (a-z),
     * and is case-insensitive.
     *
     * @param text a block of text.
     * @return the count of each letter in the text.
     */
    public static int letterCount(String text) { // unique
        HashSet<Character> uniqueLetters = new HashSet<>();

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c >= 'a' && c <= 'z') {
                uniqueLetters.add(c);
            }
        }
        return uniqueLetters.size();

        // using regex
//        Pattern p = Pattern.compile("([a-zA-Z])");
//        Matcher m = p.matcher(text);
//
//        // Even though we're only looking for letters, there's no reason to convert them from Strings if we don't have to.
//        HashSet<String> uniqueWords = new HashSet<>();
//
//        while (m.find()) {
//            uniqueWords.add(m.group().toLowerCase());
//        }
//        return uniqueWords.size();

        // DRY option
//        return letterStats(text).size();
    }

    /**
     * Maps all the letters that appear in text. This method is case-insensitive.
     *
     * @param text a block of text.
     * @return A mapping of the text with letter as key and number of occurrences as value.
     */
    public static Map<Character, Integer> letterStats(String text) {
        HashMap<Character, Integer> uniqueMap = new HashMap<>();

        for (int i = 0; i < text.length(); i++) {
            char c = Character.toLowerCase(text.charAt(i));
            if (c >= 'a' && c <= 'z') {
                uniqueMap.putIfAbsent(c, 0);
                uniqueMap.put(c, uniqueMap.get(c) + 1);
            }
        }
        return uniqueMap;


        // using regex
//        Pattern p = Pattern.compile("([a-zA-Z])");
//        Matcher m = p.matcher(text);
//
//        HashMap<Character, Integer> uniqueMap = new HashMap<>();
//
//        while (m.find()) {
//            char letter = m.group().toLowerCase().charAt(0);
//            uniqueMap.putIfAbsent(letter, 0);
//            uniqueMap.put(letter, uniqueMap.get(letter) + 1);
//        }
//        return uniqueMap;

        // Using Streams
//        return Pattern.compile("([a-zA-Z])").matcher(text).results().collect(Collectors.groupingBy(
//                word -> word.group().toLowerCase().charAt(0), Collectors.summingInt(i -> 1)));
    }
}
