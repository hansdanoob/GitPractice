
public class Tetroot {
    
    public static void main(String[] args) {
        final double RESULT = 65;
        final double ROOT = 3;
        final double PRECISION = 0.000000000000001;

        /*
        Testing changing something to see how
        git works.
        This is a comment
         */
        double increment = 0.1;
        double potentialBase = increment;

        double tetrationResult = 0;
        while (increment > PRECISION) { //will stop once level of precision reached

            tetrationResult = tetrate(potentialBase, ROOT);

            if (tetrationResult < RESULT) {
                potentialBase += increment;
            } else if (tetrationResult > RESULT) {
                potentialBase -= increment;
                increment /= 10;
            } else {
                System.out.println("\nPerfect found!");
                increment = Double.MIN_VALUE;     //Stops loop
            }
        }
        System.out.println(String.format("\nThe %.0fth tetroot of %.0f is approximately %.20f", ROOT, RESULT, potentialBase));
        System.out.println(String.format("because %.20f tetrated to %.0f equals %.20f\n", potentialBase, ROOT, tetrationResult));
    }


    private static double tetrate(double base, double exponent) {
        double result = base;
        for (int i = 1; i < exponent; i++) {
            result = Math.pow(base,result);
        }
        return result;
    }
}
