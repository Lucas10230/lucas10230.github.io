public class ExceptionProject {
    public static void main(String[] args) {

        // Array out of bounds exception
        try {
            int[] numbers = {1, 2, 3};
            System.out.println(numbers[5]);
        } 
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: You tried to access a position that does not exist in the array.");
        }

        // Divide by zero exception
        try {
            int answer = 10 / 0;
            System.out.println(answer);
        } 
        catch (ArithmeticException e) {
            System.out.println("Error: You cannot divide by zero.");
        }

        System.out.println("The program caught both errors and closed without crashing.");
    }
}
