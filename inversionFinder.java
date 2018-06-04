import java.util.*;
import java.io.*;

public class inversionFinder {
	public static void main (String[] args) throws IOException {
            File f = new File("inversions.txt");
	        Scanner scanner = new Scanner(f);
            scanner.useDelimiter("\n");
            List<Double> unsorted = new ArrayList<>();
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (s.trim().isEmpty()) {
                    continue;
                }
                s.replaceAll(" ","");
                double d = Double.parseDouble(s);
                unsorted.add(d);
            }
            System.out.println(unsorted.size());
        scanner.close();
        }
    }

