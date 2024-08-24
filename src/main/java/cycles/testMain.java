package cycles;

import java.io.*;
import java.util.Scanner;

public class testMain {
    public static void main(String[] args) throws IOException {
        String path = new Scanner(System.in).nextLine();
        File file = new File(path);
        try (FileInputStream inputStream = new FileInputStream(file)) {
            FileReader fileReader = new FileReader(path);
            BufferedReader reader = new BufferedReader(fileReader);
            String line = reader.readLine();
            LogEntry logEntry= new LogEntry(line);
            System.out.println(logEntry.toString());
        }



    }
}
