package com.coding.challenge.coursera;

public class SegmentTree {


    int st[];


    int getMin(int x1, int x2) {
        return (x1 < x2) ? x1 : x2;
    }

    int getMid(int x1, int x2) {
        return x1 + (x2 - x1) / 2;
    }

    int getMinValInGivenRangeUtil(int ss, int se, int qs, int qe, int index)
    {
        // If segment of this node is a part of given range, then
        // return the min of the segment
        if (qs <= ss && qe >= se)
            return st[index];

        // If segment of this node is outside the given range
        if (se < qs || ss > qe)
            return Integer.MAX_VALUE;

        // If a part of this segment overlaps with the given range
        int mid = getMid(ss, se);
        return getMin(getMinValInGivenRangeUtil(ss, mid, qs, qe, 2 * index + 1),
                getMinValInGivenRangeUtil(mid + 1, se, qs, qe, 2 * index + 2));
    }

    int getMinValInGivenRange(int n, int qs, int qe) {
        if (qs < 0 || qe > n - 1 || qs > qe) {
            System.out.println("Invalid Input");
            return -1;
        }

        return getMinValInGivenRangeUtil(0, n - 1, qs, qe, 0);
    }

    int constructSTUtil(int arr[], int start, int end, int index) {
        if (start == end) {
            st[index] = arr[start];
            return arr[start];
        }

        int mid = getMid(start, end);
        st[index] = getMin(constructSTUtil(arr, start, mid, index * 2 + 1),
                constructSTUtil(arr, mid + 1, end, index * 2 + 2));
        return st[index];
    }

    void constructST(int arr[], int n) {

        int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
        int max_size = 2 * (int) Math.pow(2, x) - 1;
        st = new int[max_size];
        constructSTUtil(arr, 0, n - 1, 0);
    }


    public static void main(String args[])
    {
        int arr[] = {1, 3, 2, 7, 9, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree();

        // Build segment tree from given array
        tree.constructST(arr, n);

        int qs = 1;  // Starting index of query range
        int qe = 5;  // Ending index of query range

        // Print minimum value in arr[qs..qe]
        System.out.println("Minimum of values in range [" + qs + ", "
                + qe + "] is = " + tree.getMinValInGivenRange(n, qs, qe));
    }
}
