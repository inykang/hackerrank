package pe.inykang.permutation;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    private List<int[]> list = new ArrayList<>();

    public void permute(int arr[], int n, int r) {
        if (n == 1)
            addArrayList(arr, r);

        for (int i = 0; i < n; i++) {
            permute(arr, n -1, r);
            swap(arr, n, i);
        }
    }

    private void swap(int[] arr, int n, int idx) {
        if (n % 2 == 1) {
            int temp = arr[0];
            arr[0] = arr[n - 1];
            arr[n - 1] = temp;
        } else {
            int temp = arr[idx];
            arr[idx] = arr[n - 1];
            arr[n -1] = temp;
        }
    }

    private void addArrayList(int arr[], int r) {
        int[] ints = new int[r];
        for (int i = 0; i < r; i++) {
            ints[i] = arr[i];
        }
        list.add(ints);
    }

    public List<int[]> getList() {
        return list;
    }
}
