package helix;

import org.junit.Test;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class MatrixHelixMorphTest {

    /** Check if two integer matrices have the same contents
     *
     * @param matrix1
     * @param matrix2
     * @return true if the contents of matrix1 and matrix2 are identical and false otherwise
     */
    public static boolean testEqual(int[][] matrix1, int[][] matrix2) {

        /*
            Basic sanity checking:
                Verify that lengths are equal
         */
        if (matrix1 == null || matrix2 == null) {
            return true;
        }
        if (matrix1.length != matrix2.length) {
            return false;
        }
        if (matrix1[0].length != matrix2[0].length) {
            return false;
        }

        /*
            Test the contents of the matrices
         */
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix1[0].length; j++) {
                if (matrix1[i][j] != matrix2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    @Test
    public void test2x2() {
        int[][] inMatrix  = { {1, 2}, {3, 4} };
        int[][] expOutput = { {1, 2}, {4, 3} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test1x1() {
        int[][] inMatrix  = { {1} };
        int[][] expOutput = { {1} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    // ADD TESTS TO CHECK PARTITIONS
    /**
     *  CSIS 3275
     *  Hye Kyung Ko  (300323007)
     */

    @Test
    public void test3X3() {
        int[][] inMatrix  = { {1, 2, 3},{4, 5, 6}, {7, 8,9} };
        int[][] expOutput = { {1, 2, 3}, {8, 9, 4}, {7, 6, 5} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test4x5() {

        int[][] inMatrix  = { {7, 5, 1, 4, 6},{3, 2, 9, 1, 8}, {8, 3, 2, 4, 1}, {10, 11, 15, 19, 14}};
        int[][] expOutput = { {7, 5, 1, 4, 6}, {4, 1, 10, 11, 3}, {2, 14, 19, 15, 2}, {3, 8, 8, 1, 9} };
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));

    }

    @Test
    public void test1x6() {
        int[][] inMatrix = {{3, 2, 4, 1, 5, 8}};
        int[][] expOutput = {{3, 2, 4, 1, 5, 8}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test2x4() {
        int[][] inMatrix = {{3, 2, 4, 9}, {1, 5, 8, 10}};
        int[][] expOutput = {{3, 2, 4, 9}, {10, 8, 5, 1}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test7x7() {
        int[][] inMatrix = {{ 1, 13, 55, 67, 68, 99, 103},
                            {25,  2, 14, 56, 66, 69, 100},
                            {36, 26,  3, 15, 57, 65,  70},
                            {46, 37, 27,  4, 16, 58,  64},
                            {79, 47, 38, 28,  5, 17,  59},
                            {80, 87, 48, 39, 29,  6,  18},
                            {81, 88, 93, 49, 40, 30,   7}};

        int[][] expOutput = {{ 1, 13, 55, 67, 68, 99, 103},
                             {27,  4, 16, 58, 64, 79,  25},
                             {37, 29,  6, 18, 81, 47,   2},
                             {46, 39, 30,  7, 88, 38,  14},
                             {70, 48, 40, 49, 93, 28,  56},
                             {65, 87, 80, 59, 17,  5,  66},
                             {57, 15,  3, 26, 36, 100, 69}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test15x12() {
        int[][] inMatrix = {{  1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,  12},
                            { 13,  14,  15,  16,  17,  18,  19,  20,  21,  22,  23,  24},
                            { 25,  26,  27,  28,  29,  30,  31,  32,  33,  34,  35,  36},
                            { 37,  38,  39,  40,  41,  42,  43,  44,  45,  46,  47,  48},
                            { 49,  50,  51,  52,  53,  54,  55,  56,  57,  58,  59,  60},
                            { 61,  62,  63,  64,  65,  66,  67,  68,  69,  70,  71,  72},
                            { 73,  74,  75,  76,  77,  78,  79,  80,  81,  82,  83,  84},
                            { 85,  86,  87,  88,  89,  90,  91,  92,  93,  94,  95,  96},
                            { 97,  98,  99, 100, 101, 102, 103, 104, 105, 106, 107, 108},
                            {109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120},
                            {121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132},
                            {133, 134, 135, 136, 137, 138, 139, 140, 141, 142, 143, 144},
                            {145, 146, 147, 148, 149, 150, 151, 152, 153, 154, 155, 156},
                            {157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168},
                            {169, 170, 171, 172, 173, 174, 175, 176, 177, 178, 179, 180}};

        int[][] expOutput = {{  1,   2,   3,   4,   5,   6,   7,   8,   9,  10,  11,  12},
                             { 50,  51,  52,  53,  54,  55,  56,  57,  58,  59,  60,  13},
                             { 49,  92,  93,  94,  95,  96,  97,  98,  99, 100,  61,  14},
                             { 48,  91, 126, 127, 128, 129, 130, 131, 132, 101,  62,  15},
                             { 47,  90, 125, 152, 153, 154, 155, 156, 133, 102,  63,  16},
                             { 46,  89, 124, 151, 170, 171, 172, 157, 134, 103,  64,  17},
                             { 45,  88, 123, 150, 169, 180, 173, 158, 135, 104,  65,  18},
                             { 44,  87, 122, 149, 168, 179, 174, 159, 136, 105,  66,  19},
                             { 43,  86, 121, 148, 167, 178, 175, 160, 137, 106,  67,  20},
                             { 42,  85, 120, 147, 166, 177, 176, 161, 138, 107,  68,  21},
                             { 41,  84, 119, 146, 165, 164, 163, 162, 139, 108,  69,  22},
                             { 40,  83, 118, 145, 144, 143, 142, 141, 140, 109,  70,  23},
                             { 39,  82, 117, 116, 115, 114, 113, 112, 111, 110,  71,  24},
                             { 38,  81,  80,  79,  78,  77,  76,  75,  74,  73,  72,  25},
                             { 37,  36,  35,  34,  33,  32,  31,  30,  29,  28,  27,  26}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test10x8() {
        int[][] inMatrix = {{ 1, 13, 55, 67, 68, 99, 103, 106},
                            {25,  2, 14, 56, 66, 69, 100, 104},
                            {36, 26,  3, 15, 57, 65,  70, 101},
                            {46, 37, 27,  4, 16, 58,  64,  71},
                            {79, 47, 38, 28,  5, 17,  59,  63},
                            {80, 87, 48, 39, 29,  6,  18,  60},
                            {81, 88, 93, 49, 40, 30,   7,  19},
                            {82, 89, 94, 97, 50, 41,  31,   8},
                            {83, 90, 95, 98, 51, 42,  32,  21},
                            {84, 91, 96, 52, 43, 33,  22,  10}};

        int[][] expOutput = {{  1, 13, 55, 67, 68, 99, 103, 106},
                             { 71, 79, 47, 38, 28,  5,  17,  25},
                             { 64, 19, 82, 89, 94, 97,  59,   2},
                             { 58,  7, 21, 84, 91, 50,  63,  14},
                             { 16, 30, 32, 10, 96, 41,  80,  56},
                             {  4, 40, 42, 22, 52, 31,  87,  66},
                             { 27, 49, 51, 33, 43,  8,  48,  69},
                             { 37, 93, 98, 95, 90, 83,  39, 100},
                             { 46, 88, 81, 60, 18,  6,  29, 104},
                             {101, 70, 65, 57, 15,  3,  26,  36}};

        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void test5x1() {
        int[][] inMatrix = {{1}, {2}, {3}, {4}, {5}};
        int[][] expOutput = {{1}, {2}, {3}, {4}, {5}};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testNull() {
        int[][] inMatrix  = {};
        int[][] expOutput = {};
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }

    @Test
    public void testNull2() {
        int[][] inMatrix = null;
        int[][] expOutput = null;
        assertTrue(testEqual(expOutput, MatrixHelixMorph.helix(inMatrix)));
    }
}
