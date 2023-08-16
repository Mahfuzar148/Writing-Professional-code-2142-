import java.util.Random;

public class RandomStringFromArray {
    public static void main(String[] args) {
        String[] stringArray = {
                "Hello",
                "World",
                "Java",
                "Random",
                "String"
        };

        String randomChoice = chooseRandomString(stringArray);
        System.out.println("Randomly Chosen String: " + randomChoice);
    }

    public static String chooseRandomString(String[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Array is empty or null");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(array.length);
        return array[randomIndex];
    }
}
