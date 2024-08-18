package cycles;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        while (true){
            System.out.println("Введите путь: ");
            String path = new Scanner(System.in).nextLine();
             File file = new File(path);
             boolean fileExists = file.exists();
             boolean isDirectory = file.isDirectory();
             if(!fileExists|| isDirectory){
                 System.out.println("Путь указан неверно.");
                 continue;
             }
            System.out.println("Путь указан верно");
             counter +=1;
            System.out.println("Это файл номер " + counter + ".");
        }
    }
}
