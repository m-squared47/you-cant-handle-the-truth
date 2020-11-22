import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        HandleTruth.wordCount(getTestCase(3));
    }

    @Test
    //test if the words are counted correctly
    public void testCount(){
        for(int j = 0; j <= 2; j++) {
            String testCase = getTestCase(j);
            int[] expected = getExpectedCount(j);
            HashMap<String, Integer> actual = HandleTruth.wordCount(testCase);
            String[] words = testCase.split(" ");

            int i = 0;
            for (String word : words) {
                int count = actual.get(word);
                assertEquals(expected[i], count);
                i++;
            }
        }
    }

    @Test
    //test if a specific string is contained in a dictionary
    public void testContains(){
        HashMap<String, Integer> testMap = HandleTruth.wordCount(getTestCase(0));
        //The quick brown fox jumps over the lazy dog.
        String[] expected = getExpectedContains(0);

        for(int i = 0; i < expected.length; i++){
            assertTrue(testMap.containsKey(expected[i]));
        }

        assertFalse(testMap.containsKey("test"));
    }

    @Test
    public void test3(){
        //code
    }
    @Test
    public void test4(){
        //code
    }

    @Test
    public void test5(){
        //code
    }

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