import java.io.*;
import java.text.*;
import java.util.*;

public class StudentList {
    public static void main(String[] args) {
        if (args[0].equals("a")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt")));
                String studentData = reader.readLine();
                String[] studentNames = studentData.split(",");
                for (String name : studentNames) {
                    System.out.println(name);
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].equals("r")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt")));
                String studentData = reader.readLine();
                String[] studentNames = studentData.split(",");
                Random random = new Random();
                int index = random.nextInt(studentNames.length);
                System.out.println(studentNames[index]);
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("+")) {
            System.out.println("Loading data ...");
            try {
                BufferedWriter writer = new BufferedWriter(
                        new FileWriter("C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt", true));
                String newStudentName = args[0].substring(1);
                Date currentDate = new Date();
                String dateFormatPattern = "dd/MM/yyyy-hh:mm:ss a";
                DateFormat dateFormat = new SimpleDateFormat(dateFormatPattern);
                String formattedDate = dateFormat.format(currentDate);
                writer.write(", " + newStudentName + "\nList last updated on " + formattedDate);
                writer.close();
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("?")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt")));
                String studentData = reader.readLine();
                String[] studentNames = studentData.split(",");
                boolean found = false;
                String searchName = args[0].substring(1);
                for (String name : studentNames) {
                    if (name.equals(searchName)) {
                        System.out.println("We found it!");
                        found = true;
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        } else if (args[0].contains("c")) {
            System.out.println("Loading data ...");
            try {
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream("C:\\Users\\mahfu\\Desktop\\mahfuz\\Professional code practice\\src\\student.txt")));
                String studentData = reader.readLine();
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
            } catch (Exception e) {
                System.out.println(e);
            }
            System.out.println("Data Loaded.");
        } else {
            System.out.println("!Your entered argument is invalid");
        }
    }
}
