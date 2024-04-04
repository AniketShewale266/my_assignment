//Q1: Merge two arrays by satisfying given constraints
//Given two sorted arrays X[] and Y[] of size m and n each where m >= n and X[] has exactly n vacant cells,
// merge elements of Y[] in their correct position in array X[], i.e., merge (X, Y) by keeping the sorted order.
//
//For example,
//
//Input: X[] = { 0, 2, 0, 3, 0, 5, 6, 0, 0 }
//Y[] = { 1, 8, 9, 10, 15 } The vacant cells in X[] is represented by 0
//Output: X[] = { 1, 2, 3, 5, 6, 8, 9, 10, 15 }

package myassignment;

import java.util.Arrays;

public class MergeTwoArrays
{
    private static void merge(int[] X, int[] Y, int m, int n)
    {
        int k = m + n + 1;


        while (m >= 0 && n >= 0)
        {
            if (X[m] > Y[n]) {
                X[k--] = X[m--];
            }
            else {
                X[k--] = Y[n--];
            }
        }

        while (n >= 0) {
            X[k--] = Y[n--];
        }

        Arrays.fill(Y, 0);
    }

    public static void reArrange(int[] X, int[] Y)
    {
        if (X.length == 0) {
            return;
        }

        int k = 0;
        for (int value: X)
        {
            if (value != 0) {
                X[k++] = value;
            }
        }

        merge(X, Y, k - 1, Y.length - 1);
    }

    public static void main (String[] args)
    {
        int[] X = { 0, 2, 0, 3, 0, 5, 6, 0, 0};
        int[] Y = { 1, 8, 9, 10, 15 };

        reArrange(X, Y);

        System.out.println(Arrays.toString(X));
    }
}
