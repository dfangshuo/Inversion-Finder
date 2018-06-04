import java.util.*;
import java.io.*;

public class inversionFinder {
	public static void main (String[] args) {
		File file = new File("inversions.txt");
		Scanner scanner = new Scanner(file);
		List<Integer> integers = new ArrayList<>();

		while (scanner.hasNext()) {
		    if (scanner.hasNextInt()) {
		        integers.add(scanner.nextInt());
		    } 
		    else {
		        scanner.next();
		    }
		}
		System.out.println(integers);
		// System.out.println("Hello World");
	}	
}

