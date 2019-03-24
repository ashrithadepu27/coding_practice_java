package com.coding.sites.geeksforgeeks;

public class Merge2Array {

    public int[] mergeArray(int mPlusN[], int N[])   {

        int n = N.length;
        int m = mPlusN.length - n;
        int temp = n+m-1;
        for (int i = n+m - 1; i >= 0; i--)
        {
            if (mPlusN[i] != -1)
            {
                mPlusN[temp] = mPlusN[i];
                temp--;
            }
        }
        printArray(mPlusN);
        System.out.println();
        int i =n, j=0, k = 0;
        while (k < (m + n))
        {
            /* Take an element from mPlusN[] if
            a) value of the picked element is smaller and we have
                not reached end of it
            b) We have reached end of N[] */
            if ((i < (m + n) && mPlusN[i] <= N[j]) || (j == n))
            {
                mPlusN[k] = mPlusN[i];
                k++;
                i++;
            }
            else // Otherwise take element from N[]
            {
                mPlusN[k] = N[j];
                k++;
                j++;
            }
        }
        return mPlusN;
    }

    public void printArray(int mPlusN[]) {
        for(int m : mPlusN) {
            System.out.print(m + " ");
        }
    }

    public static void main(String[] args)  {
        int mPlusN[] = {2, 8, -1, -1, -1, 13, -1, 15, 20};
        int N[] = {5, 7, 9, 25};
        Merge2Array m = new Merge2Array();
        mPlusN = m.mergeArray(mPlusN, N);
        m.printArray(mPlusN);

    }
}
