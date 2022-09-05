package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void wordCountTestEmpty() {
        assertEquals(0, TextStatistics.wordCount(""));
        assertEquals(1, TextStatistics.wordCount("one"));
        assertEquals(1, TextStatistics.wordCount("one "));
        assertEquals(2, TextStatistics.wordCount(" one two"));
    }

    @Test
    void wordCountTest() {
        assertEquals(1, TextStatistics.wordCount("one"));
        assertEquals(1, TextStatistics.wordCount("one "));
        assertEquals(2, TextStatistics.wordCount("one two"));
    }

    @Test
    void wordCountTestCornerCases() {
        assertEquals(1, TextStatistics.wordCount(" one"));
        assertEquals(1, TextStatistics.wordCount("one "));
    }

    @Test
    void uniqueWordCountTest() {
        assertEquals(1, TextStatistics.uniqueWordCount("one one"));
    }

    @Test
    void uniqueWordCountTestCase() {
        assertEquals(1, TextStatistics.uniqueWordCount("One one"));
    }

    @Test
    void uniqueWordCountTestDuplicates() {
        assertEquals(2, TextStatistics.uniqueWordCount("one two one"));
        assertEquals(2, TextStatistics.uniqueWordCount("one one two"));
    }

    @Test
    void wordStatsTestEmpty() {
        Map<String, Integer> results = TextStatistics.wordStats("");
        assert results.isEmpty();
    }

    @Test
    void wordStatsTestSingle() {
        Map<String, Integer> results = TextStatistics.wordStats("one one");
        assert (!results.containsKey("ONE") && results.get("one") == 2) || results.get("ONE") == 2;
        assert !results.containsKey("two") && !results.containsKey("TWO");
        assert !results.containsValue(0) && !results.containsValue(1) && !results.containsValue(3);
    }

    @Test
    void wordStatsTestCase() {
        Map<String, Integer> results = TextStatistics.wordStats("One one");
        assert (!results.containsKey("ONE") && results.get("one") == 2) ||
                (!results.containsKey("one") && results.get("ONE") == 2);
        assert !results.containsKey("two") && !results.containsKey("TWO");
        assert !results.containsValue(0) && !results.containsValue(1) && !results.containsValue(3);
    }

    @Test
    void wordStatsTest() {
        Map<String, Integer> results = TextStatistics.wordStats("one two one");
        assert (!results.containsKey("ONE") && results.get("one") == 2) ||
                (!results.containsKey("one") && results.get("ONE") == 2);
        assert (!results.containsKey("TWO") && results.get("two") == 1) ||
                (!results.containsKey("two") && results.get("TWO") == 1);
        assert !results.containsValue(0) && !results.containsValue(3);
    }

    @Test
    void letterCountTest() {
        assertEquals(1, TextStatistics.letterCount("aa"));
    }

    @Test
    void letterCountTestCase() {
        assertEquals(1, TextStatistics.letterCount("aA"));
    }

    @Test
    void letterCountTestDuplicates() {
        assertEquals(2, TextStatistics.letterCount("aba"));
        assertEquals(2, TextStatistics.letterCount("aab"));
    }

    @Test
    void letterCountTestCornerCases() {
        assertEquals(2, TextStatistics.letterCount(" aba"));
        assertEquals(2, TextStatistics.letterCount("a A b "));
    }

    @Test
    void letterStatsTestEmpty() {
        assert TextStatistics.letterStats("").isEmpty();
    }

    @Test
    void letterStatsTestSingle() {
        Map<Character, Integer> results = TextStatistics.letterStats("aa");
        assert (!results.containsKey('A') && results.get('a') == 2) ||
                (!results.containsKey('a') && results.get('A') == 2);
        assert !results.containsKey('b') && !results.containsKey('B');
        assert !results.containsValue(0) && !results.containsValue(1) && !results.containsValue(3);
    }

    @Test
    void letterStatsTestCase() {
        Map<Character, Integer> results = TextStatistics.letterStats("Aa");
        assert (!results.containsKey('A') && results.get('a') == 2) ||
                (!results.containsKey('a') && results.get('A') == 2);
        assert !results.containsKey('b') && !results.containsKey('B');
        assert !results.containsValue(0) && !results.containsValue(1) && !results.containsValue(3);
    }

    @Test
    void letterStatsTest() {
        Map<Character, Integer> results = TextStatistics.letterStats("aba");
        assert (!results.containsKey('A') && results.get('a') == 2) ||
                (!results.containsKey('a') && results.get('A') == 2);
        assert (!results.containsKey('B') && results.get('b') == 1) ||
                (!results.containsKey('b') && results.get('B') == 1);
        assert !results.containsValue(0) && !results.containsValue(3);
    }
}