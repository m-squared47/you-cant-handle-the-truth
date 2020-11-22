import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        HandleTruth.wordCount(getTestCase(3), true);
    }

    @Test
    //test if the words are counted correctly
    public void testCount(){
        for(int j = 0; j <= 2; j++) {
            String testCase = getTestCase(j);
            int[] expected = getExpectedCount(j);
            Map<String, Integer> actual = (Map<String, Integer>)HandleTruth.wordCount(testCase, true);
            String[] words = testCase.split(" ");

            int i = 0;
            for (String word : words) {
                int count = actual.get(word);
                assertEquals(expected[i], count);
                i++;
            }
        }
    }   //test passes, words are counted correctly

    @Test
    //test if a specific string is contained in a dictionary
    public void testContains(){
        Map<String, Integer> testMap =
                (Map<String, Integer>)HandleTruth.wordCount(getTestCase(0), true);
        //The quick brown fox jumps over the lazy dog.
        String[] expected = getExpectedContains(0);

        for(int i = 0; i < expected.length; i++){
            assertTrue(testMap.containsKey(expected[i]));
        }

        assertFalse(testMap.containsKey("test"));
    }//test passes, all required strings are included.

    @Test
    //test if the sorted array is correct
    public void testSorted(){
        TreeMap<Integer, Set<String>> sorted =
                (TreeMap<Integer, Set<String>>)HandleTruth.wordCount(getTestCase(1), false);

        Set<Set<String>> expected = new HashSet<>();
        Set<String> once = new HashSet<>();
        once.add("once");
        Set<String> twice = new HashSet<>();
        for(int i = 0; i < 2; i++){
            twice.add("twice");
        }
        Set<String> thrice = new HashSet<>();
        for(int i = 0; i < 3; i++){
            thrice.add("thrice");
        }
        Set<String> quads = new HashSet<>();
        for(int i = 0; i < 4; i++){
            quads.add("quads");
        }
        expected.add(once);
        expected.add(twice);
        expected.add(thrice);
        expected.add(quads);

        for(Map.Entry<Integer, Set<String>> entry : sorted.entrySet()){
            assertTrue(expected.contains(entry.getValue()));
        }
    }//test passes, all words are counted correctly

    @Test
    //test case 3 (empty string input)
    public void testEmptyInput(){
        Map<String, Integer> testMap =
                (Map<String, Integer>)HandleTruth.wordCount(getTestCase(3), true);
        String stringOfZero = "[";
        stringOfZero = stringOfZero.replace("[", "");
        //string length of 0
        assertEquals(0, stringOfZero.length());

        for(Map.Entry<String, Integer> entry : testMap.entrySet()){
            assertEquals(stringOfZero.length(), entry.getKey().length());
        }
    }   //test passes, the space is removed and the only string left is a string length of 0
        //String should be removed and not replaced by a blank character

    @Test
    public void test5(){
        //code
    }

    //All test case and expected case getters
    public static String getTestCase(int caseNum){
        String testCase = null;
        switch(caseNum){
            case 0:
                testCase = "The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog. The quick brown fox jumps over the lazy dog.";
                //repeating sentences
                break;
            case 1:
                testCase = "once twice twice thrice thrice thrice quads quads quads quads";
                //each word occurring different times
                break;
            case 2:
                testCase = "are, are. are these, these. these the, the. the same, same. same";
                //each word followed by some punctuation. Same words, different punctuation, different key values
                break;
            case 3:
                testCase = "";
                //just an empty string
                break;
            default:
                break;
        }

        return testCase;
    }

    public static int[] getExpectedCount(int caseNum){
        int[] expected = null;
        switch(caseNum){
            case 0:
                expected = new int[]{   5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5,
                                        5, 5, 5, 5, 5};
                break;
            case 1:
                expected = new int[]{1, 2, 2, 3, 3, 3, 4, 4, 4, 4};
                break;
            case 2:
                expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
                break;
            case 3:
                expected = new int[]{};
                break;
            default:
                break;
        }

        return expected;
    }

    public static String[] getExpectedContains(int caseNum){
        String[] expected = null;
        switch(caseNum){
            case 0:
                expected = new String[]{"The", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog."};
                break;
            case 1:
                expected = new String[]{"once", "twice", "thrice", "quads"};
                break;
            case 2:
                expected = new String[]{"are,", "are.", "are", "these,", "these.", "these", "the,", "the.", "the",
                                        "same,", "same.", "same"};
                break;
            default:
                break;
        }

        return expected;
    }
}