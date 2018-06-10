import java.util.Arrays;

public class msTester {
    static int inversions = 0;
    public static void main(String[] args) {
        double[] d = new double[]{1, 20, 6, 4, 5};
        double[] m = mergeSort(d);
//        for (double i : m) {
//            System.out.println(i);
//        }
        System.out.println(inversions);

    }

    public static double[] mergeSort(double[] l) {
//        if (l.length == 0 || l.length == 1) {
//            return new double[]{l[0]};
        if (l.length == 1) {
            return new double[]{l[0]};
        } else {
            int mid = l.length/2;

            //mistake 1, forgetting to call mergeSort on the arrays
            double[] left = mergeSort(Arrays.copyOfRange(l, 0, mid));
            double[] right = mergeSort(Arrays.copyOfRange(l, mid, l.length));
            return merge(left, right);
        }

    }

    public static double[] merge(double[]l1, double[] l2) {
        int lIndex = 0;
        int rIndex = 0;
        int mIndex = 0;
        double[] merged = new double[l1.length+l2.length];

        while (lIndex < l1.length || rIndex < l2.length) {
            if (lIndex >= l1.length) {
                merged[mIndex] = l2[rIndex];
                rIndex += 1;
            } else if (rIndex >= l2.length) {
                merged[mIndex] = l1[lIndex];
                lIndex += 1;
            } else if (l1[lIndex] < l2[rIndex]) {
                merged[mIndex] = l1[lIndex];
                lIndex += 1;
            } else {
                inversions += (l1.length - lIndex);
                merged[mIndex] = l2[rIndex];
                rIndex += 1;
            }

            mIndex += 1;
        }
        return merged;
    }
}
