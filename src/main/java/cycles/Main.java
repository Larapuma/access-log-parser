package cycles;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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


            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;

                int YandexCounter = 0;
                int GoogleCounter = 0;
                int lines = 0;

                while ((line = reader.readLine())!= null){
                    LogEntry logEntry = new LogEntry(line);
                    lines+=1;
                    throwMyCustomException(line);
                    String[] parts = line.split(";");

                    if (parts.length >= 2) {
                        parts[0] = parts[0].replaceAll("\\s+","");
                        parts[1] = parts[1].replaceAll("\\s+","");

                        if(parts[1].indexOf("/")>0) {

                            if(parts[1].substring(0, parts[1].indexOf("/")).equals("Googlebot")){
                                GoogleCounter+=1;
                                continue;
                            }
                            if(parts[1].substring(0, parts[1].indexOf("/")).equals("YandexBot")){
                                YandexCounter+=1;
                                continue;

                            }

                        }
                        System.out.println(logEntry);
                    }
                }
                System.out.println("GoogleCounter: " +GoogleCounter +" , YandexCounter "+ YandexCounter );
                System.out.println((double) GoogleCounter/(double) lines + "     "+ (double) YandexCounter/(double) lines);



            }catch (FileNotFoundException fileNotFoundException){
                System.out.println(fileNotFoundException);
            }
            catch (IOException ioException){
                System.out.println(ioException);
            }catch (MaxLenException maxLenException) {
                System.out.println(maxLenException);

            }


        }
    }
    public static void throwMyCustomException(String line) throws MaxLenException {
        if(line.length()>1024) throw new MaxLenException("Ошибка, длина этой строки больше 1024");
    }
}

/*C:\Users\'user\Downloads\access.log

 */