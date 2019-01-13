package org.greeksforgreeks.permutation;

public class HeapPermutation {
    //Prints the array
    void printArr(int a[], int n)
    {
        for (int i=0; i<n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }

    //Generating permutation using Heap Algorithm
    void heapPermutation(int a[], int n, int r)
    {
        // if n becomes 1 then prints the obtained
        // permutation
        if (n == 1)
            printArr(a,r);

        for (int i = 0; i < n; i++)
        {
            heapPermutation(a, n-1, r);

            // if n is odd, swap first and last
            // element
            if (n % 2 == 1)
            {
                int temp = a[0];
                a[0] = a[n-1];
                a[n-1] = temp;
            }

            // If n is even, swap ith and last
            // element
            else
            {
                int temp = a[i];
                a[i] = a[n-1];
                a[n-1] = temp;
            }
        }
    }
}
