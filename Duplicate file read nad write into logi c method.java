import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {

    private static final String FILE_PATH = "C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt";

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("No argument provided.");
            return;
        }

        String operation = args[0];
        switch (operation) {
            case "a":
                displayStudentNames();
                break;
            case "r":
                displayRandomStudent();
                break;
            case "+":
                if (args.length < 2) {
                    System.out.println("Missing student name.");
                    return;
                }
                String newStudentName = args[1];
                addNewStudent(newStudentName);
                break;
            case "?":
                if (args.length < 2) {
                    System.out.println("Missing search name.");
                    return;
                }
                String searchName = args[1];
                searchStudent(searchName);
                break;
            case "c":
                countWords();
                break;
            default:
                System.out.println("Invalid argument.");
        }
    }

    private static String readFile() throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }

    private static void writeFile(String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(content);
        }
    }

    private static void displayStudentNames() {
        try {
            String studentData = readFile();
            String[] studentNames = studentData.split(",");
            for (String name : studentNames) {
                System.out.println(name);
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void displayRandomStudent() {
        try {
            String studentData = readFile();
            String[] studentNames = studentData.split(",");
            Random random = new Random();
            int index = random.nextInt(studentNames.length);
            System.out.println(studentNames[index]);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void addNewStudent(String newStudentName) {
        try {
            Date currentDate = new Date();
            DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss a");
            String formattedDate = dateFormat.format(currentDate);
            String content = ", " + newStudentName + "\nList last updated on " + formattedDate + "\n";
            writeFile(content);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void searchStudent(String searchName) {
        try {
            String studentData = readFile();
            String[] studentNames = studentData.split(",");
            boolean found = false;
            for (String name : studentNames) {
                if (name.equals(searchName)) {
                    System.out.println("We found it!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Name not found.");
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    private static void countWords() {
        try {
            String studentData = readFile();
            char[] characters = studentData.toCharArray();
            boolean inWord = false;
            int wordCount = 0;
            for (char c : characters) {
                if (c == ' ') {
                    if (!inWord) {
                        wordCount++;
                        inWord = true;
                    } else {
                        inWord = false;
                    }
                }
            }
            System.out.println(wordCount + " word(s) found " + characters.length);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
