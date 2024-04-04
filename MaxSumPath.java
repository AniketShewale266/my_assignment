//Q2:Find maximum sum path involving elements of given arrays
//Given two sorted arrays of integers, find a maximum sum path involving elements of both arrays whose sum is maximum.
//We can start from either array, but we can switch between arrays only through its common elements.
//
//For example,
//
//Input: X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 }
//Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 }
//The maximum sum path is: 1 —> 2 —> 3 —> 6 —> 7 —> 9 —> 10 —> 12 —> 15 —> 16 —> 18 —> 100
//The maximum sum is 199

package myassignment;

public class MaxSumPath {
    public static int maxSumPath(int[] X, int[] Y) {
        int sumX = 0, sumY = 0, maxSum = 0;
        int i = 0, j = 0;

        while (i < X.length && j < Y.length) {
            if (X[i] < Y[j]) {
                sumX += X[i++];
            } else if (X[i] > Y[j]) {
                sumY += Y[j++];
            } else {
                maxSum += Math.max(sumX, sumY) + X[i];
                sumX = 0;
                sumY = 0;
                i++;
                j++;
            }
        }

        while (i < X.length) {
            sumX += X[i++];
        }

        while (j < Y.length) {
            sumY += Y[j++];
        }

        maxSum += Math.max(sumX, sumY);

        return maxSum;
    }

    public static void main(String[] args) {
        int[] X = { 3, 6, 7, 8, 10, 12, 15, 18, 100 };
        int[] Y = { 1, 2, 3, 5, 7, 9, 10, 11, 15, 16, 18, 25, 50 };

        System.out.println("Maximum sum path: " + maxSumPath(X, Y));
    }
}
