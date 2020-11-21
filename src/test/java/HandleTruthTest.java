import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class HandleTruthTest {
    @Test
    public void makeshiftTest() {
        HandleTruth.wordCount(getTestCase(1));
    }

    @Test
    //test if the words are counted correctly
    public void testCount(){
        String testCase = getTestCase(0);
        int[] expected = getExpectedCount(0);
        HashMap<String, Integer> actual = HandleTruth.wordCount(testCase);
        String[] words = testCase.split(" ");

        int i = 0;
        for(String word : words) {
            int count = actual.get(word);
            assertEquals(expected[i], count);
            i++;
        }
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
            default:
                break;
        }

        return expected;
    }
}