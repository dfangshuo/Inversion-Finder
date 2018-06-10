import java.math.BigDecimal;
import java.util.*;
import java.io.*;

public class inversionFinder {
    static double inversions = 0;

    public static void main(String[] args) throws IOException {

        double[] unsorted = new double[100000];
        int i = 0;

        File f = new File("inversions.txt");
        Scanner scanner = new Scanner(f);
        scanner.useDelimiter("\n");
        while (scanner.hasNext()) {
            String s = scanner.next();
            if (s.trim().isEmpty()) {
                continue;
            }
            s.replaceAll(" ","");
            double d = Double.parseDouble(s);
            unsorted[i] = d;
            i += 1;
        }

        int inv = 0;

        for (double d : unsorted) {

        }




        double[] sorted = mergeSort(unsorted);

//        for (double d: sorted) {
//            System.out.println(d);
//
//        }
        System.out.println(inversions);
//         d = 2407905288;
//        System.out.println(2407905288);
        System.out.println(Double.NEGATIVE_INFINITY);
//        System.out.println(sorted[2]);
//        System.out.println(sorted[3]);


    }


    public static double[] mergeSort(double[] l) {
//        if (l.length == 0 || l.length == 1) {
//            return new double[]{l[0]};
        if (l.length == 1) {
            return new double[]{l[0]};
        } else {
            int mid = l.length/2;

            //MISTAKE 1: forgetting to call mergeSort on the arrays
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

        // MISTAKE 2: USING AND INSTEAD OF OR
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
            } else if (l1[lIndex] > l2[rIndex]) {
//                System.out.println(l1.length - lIndex);
//                System.out.println(inversions);
//                if (inversions >= 2147476396) {
//
//                }
                double inv = l1.length - lIndex;
                inversions += inv;
                merged[mIndex] = l2[rIndex];
                rIndex += 1;
            }

            mIndex += 1;
        }
        return merged;
    }
}


            /* List<Double> unsorted = new ArrayList<>();

            File f = new File("inversions.txt");
	        Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\n");
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (s.trim().isEmpty()) {
                    continue;
                }
                s.replaceAll(" ","");
                double d = Double.parseDouble(s);
                unsorted.add(d);
            }
            System.out.println(unsorted.get(0));
            scanner.close();

            mergeSort(unsorted);
            String g = "hi";
        }


        public static void mergeSort(List<Double> l) {


        }
        */


