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
        
        // Test Case 1 of 5

        // Initialize the image
        final int [][] image2 = new int[][] {
                    { 0,  1,  0,  1},
                    { 1,  0,  1,  0},
                    { 0,  1,  0,  1},
                    { 1,  0,  1,  0}
                    };
        // Set the intensity graph weight
        final int intensityWeight2 = 24;
        // Set the pruned graph weight
        final int prunedWeight2 = 15;
        
        // Test Case 2 of 5

        // Initialize the image
        final int [][] image3 = new int[][] {
                    {   1,  56, 19, 178},
                    {  76,  20, 81, 132},
                    { 202,  73, 34,   2},
                    {  68, 156,  0,  49}
                    };
        // Set the intensity graph weight
        final int intensityWeight3 = 24;
        // Set the pruned graph weight
        final int prunedWeight3 = 15;
        
        // Test Case 3 of 5

        // Initialize the image
        final int [][] image4 = new int[][] {
                    { 1, 2, 3, 4},
                    { 2, 2, 3, 4},
                    { 3, 3, 3, 4},
                    { 4, 4, 4, 4}
                    };
        // Set the intensity graph weight
        final int intensityWeight4 = 24;
        // Set the pruned graph weight
        final int prunedWeight4 = 15;
        
        // Test Case 4 of 5

        // Initialize the image
        final int [][] image5 = new int[][] {
                    { 1, 2, 3, 5},
                    { 2, 1, 2, 4},
                    { 3, 0, 1, 3},
                    { 5, 2, 3, 5}
                    };
        // Set the intensity graph weight
        final int intensityWeight5 = 24;
        // Set the pruned graph weight
        final int prunedWeight5 = 15;
        
        // Test Case 5 of 5

        // Initialize the image
        final int [][] image6 = new int[][] {
                    { 10, 11, 12, 2},
                    { 11, 10, 11, 3},
                    { 12, 11, 12, 5},
                    { 4,   6,  7, 6}
                    };
        // Set the intensity graph weight
        final int intensityWeight6 = 24;
        // Set the pruned graph weight
        final int prunedWeight6 = 15;

        
		
        System.out.println("----- Running Tests ------");

        List<TestCase> tests = new ArrayList<TestCase>();

        // Create and add test case based on specified image and intensity and pruned graph weights
        tests.add(new TestCase(image0, intensityWeight0, prunedWeight0));
        tests.add(new TestCase(image1, intensityWeight1, prunedWeight1));
        tests.add(new TestCase(image2, intensityWeight2, prunedWeight2));
        tests.add(new TestCase(image3, intensityWeight3, prunedWeight3));
        tests.add(new TestCase(image4, intensityWeight4, prunedWeight4));
        tests.add(new TestCase(image5, intensityWeight5, prunedWeight5));
        tests.add(new TestCase(image6, intensityWeight6, prunedWeight6));




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
