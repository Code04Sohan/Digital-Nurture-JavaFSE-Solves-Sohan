import java.io.IOException; //Try{} catch(IOExceptino)
import java.nio.file.Files; //Files.writeString or Files.readString
import java.nio.file.Path; //Path class , method Path.of("example.txt") find the path
import java.util.*;

class Read {
    public Read(Path filePath) {
        try {
            String text = Files.readString(filePath);
            System.out.println(text);
        } catch (IOException exception) {
            System.out.println(exception);
        }
    }
}

class Write {
    public Write(Path filePath, String inputText) {
        try {
            Files.writeString(filePath, inputText);
            System.out.println("Successcfull");
        } catch (IOException exception) {
            System.out.println(exception);
        }

    }
}

public class q22q23 {
    public static void main(String[] args) {
        Path filePath = Path.of("output.txt");
        Scanner sc = new Scanner(System.in);
        String inputText = sc.nextLine();
        sc.close();
        new Write(filePath, inputText);
        new Read(filePath);
    }
}