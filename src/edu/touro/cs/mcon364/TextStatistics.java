package edu.touro.cs.mcon364;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextStatistics {
    /**
     * Counts the number of words in some text.
     * @param text a block of text.
     * @return the number of words in the input.
     */
    public static int wordCount(String text) {
        //Pattern p = Pattern.compile("\\S+(\\s|$)");
        //Matcher m = p.matcher(text);

        Pattern p = Pattern.compile("\\S+\\s");
        Matcher m = p.matcher(text+" ");
        return (int) m.results().count();
    }

    /**
     * Counts the number of unique words in some text.
     * @param text a block of text.
     * @return the number of unique words in the input.
     */
    public static int uniqueWordCount(String text) {
        // DRY
        return wordStats(text).size();

        // not DRY - case-sensitive
        //return (int) Pattern.compile("\\S+(\\s|$)").matcher(text).results().distinct().count();
    }

    /**
     * Compiles all the words that appear in text into a Map. This method is case-insensitive.
     * @param text a block of text.
     * @return A mapping of the text with word as key and number of occurrences as value.
     */
    public static Map<String, Integer> wordStats(String text) {
        // From https://stackoverflow.com/a/56974911
        // I feel like there's a more efficient way to do this, especially trim the results.
        return Pattern.compile("(\\S+)(\\s|$)").matcher(text).results().collect(
                Collectors.groupingBy(word -> word.group().toLowerCase().trim(), Collectors.summingInt(i -> 1)));
    }

    /**
     * Counts the number of distinct letters in text. The method takes into account only alphabetical characters (a-z),
     * and is case-insensitive.
     * @param text a block of text.
     * @return the count of each letter in the text.
     */
    public static int letterCount(String text) { // unique
        return letterStats(text).size();
    }

    /**
     * Maps all the letters that appear in text. This method is case-insensitive.
     * @param text a block of text.
     * @return A mapping of the text with letter as key and number of occurrences as value.
     */
    public static Map<Character, Integer> letterStats(String text) {
        return Pattern.compile("([a-zA-Z])").matcher(text).results().collect(Collectors.groupingBy(
                word -> word.group().toLowerCase().charAt(0), Collectors.summingInt(i -> 1)));
    }
}
