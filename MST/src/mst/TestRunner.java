package mst;

import java.util.ArrayList;
import java.util.List;

/**
 * INPUT:
 *
 *  14	10	10	17	 2
 *   6	 3	 8	15	 7
 *   5	18	 9	14	19
 *
 * OUTPUT:
 *  135, 51
 *
 * ORIGINAL GRAPH:
 *
 *   * - 4-  * -0-  * -7-  * -15-  *
 *   |       |      |      |       |
 *   8       7      2      2       5
 *   |       |      |      |       |
 *   * - 3-  * -5-  * -7-  * - 8-  *
 *   |       |      |      |       |
 *   1      15      1      1      12
 *   |       |      |      |       |
 *   * -13-	 * -9-  * -5-  * - 5-  *
 *
 * PRUNED GRAPH:
 *
 *   * - 4-  * -0-  *      *       *
 *                  |      |       |
 *                  2      2       5
 *                  |      |       |
 *   * - 3-  * -5-  *      * - 8-  *
 *   |              |      |       
 *   1              1      1      
 *   |              |      |       
 *   *    	 * -9-  * -5-  * - 5-  *
 */


public class TestRunner {
    public static void main(String[] args){

        Program2 prog2 = new Program2();

        // Sample image using the example in the assignment handout

        // Initialize the image
        final int [][] image0 = new int[][] {
                    { 5,  4,  3,  2},
                    { 3, 10, 11,  1},
                    { 1, 12, 10,  0},
                    { 0,  3,  2,  1}
                    };
        // Set the intensity graph weight
        final int intensityWeight0 = 91;
        // Set the pruned graph weight
        final int prunedWeight0 = 23;
		
		//Sample image using the example in the comments above
		
		// Initialize the image
        final int [][] image1 = new int[][] {
                    { 14, 10, 10, 17,  2},
                    {  6,  3,  8, 15,  7},
                    {  5, 18,  9, 14, 19},
                    };
        // Set the intensity graph weight
        final int intensityWeight1 = 135;
        // Set the pruned graph weight
        final int prunedWeight1 = 51;
		
		/**
		TODO: Add your own image, intensity weight and pruned weight for 3 to 5 interesting tests
		Reminder: your test case graphs should be of size 4 by 4 or larger
		**/
		
        System.out.println("----- Running Tests ------");

        List<TestCase> tests = new ArrayList<TestCase>();

        // Create and add test case based on specified image and intensity and pruned graph weights
        tests.add(new TestCase(image0, intensityWeight0, prunedWeight0));
        tests.add(new TestCase(image1, intensityWeight1, prunedWeight1));

		/**
		TODO: Create 3 to 5 test case objects using the image, intensity weight and pruned weight you created and add them to "tests"
		**/
		
        // Compare your Program2 graphs against the solutions specified above

        int totalPoints = 0;
        for(TestCase test : tests){
            long start = System.currentTimeMillis();

            try{
                int intensityResult = prog2.constructIntensityGraph(test.getImage());
                int prunedResult = prog2.constructPrunedGraph(test.getImage());
                //int prunedResult = 0; // uncomment and comment above to hack and only run intensity creation
                long end = System.currentTimeMillis();
                long duration = end-start;
                totalPoints += test.check(intensityResult, prunedResult);
                System.out.println("Duration in ms: " +  duration + "\n");
            } catch(Exception e){
                System.out.println("Test failed due to Exception");
                e.printStackTrace();
            } catch(OutOfMemoryError me){
                System.out.println("Test failed due to running out of memory");
            }
        }
        System.out.println("Total Points Earned: " + totalPoints + "/32");
    }
}
