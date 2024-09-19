import java.util.Arrays;
import java.util.Random;

public class SortTest {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Error: Please specify a mode ('run' or 'cleanup').");
            return;
        }

        String mode = args[0];

        if ("run".equals(mode)) {
            runLoadTest(args);
        } else if ("cleanup".equals(mode)) {
            cleanup();
        } else {
            System.out.println("Error: Unknown mode " + mode);
        }
    }

    private static void runLoadTest(String[] args) {
        System.out.println("Starting sort test");

        int n = 0;
        for (int i = 1; i < args.length; i++) {
            if ("-n".equals(args[i]) && i + 1 < args.length) {
                n = Integer.parseInt(args[i + 1]);
            }
        }

        if (n > 0) {
            System.out.println("Generating array of size: " + n);
            int[] largeArray = generateRandomArray(n);
            System.out.println("Sorting array...");
            long startTime = System.currentTimeMillis();
            
            Arrays.sort(largeArray);

            long endTime = System.currentTimeMillis();
            System.out.println("Sorting completed in " + (endTime - startTime) + " ms");
        } else {
            System.out.println("Please supply -n argument");
        }
    }

    private static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt();
        }
        return array;
    }

    private static void cleanup() {
        System.out.println("Performing cleanup...");
    }
}
