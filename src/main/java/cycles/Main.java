package cycles;

import java.io.*;
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
                int maxlen = 0;
                int minlen = Integer.MAX_VALUE;
                int lineCounter = 0;
                while ((line = reader.readLine())!= null){
                    throwMyCustomException(line);
                    maxlen = Integer.max(maxlen,line.length());
                    minlen = Integer.min(minlen,maxlen);
                    lineCounter+=1;

                }
                System.out.println("Файл номер " + counter + ". Самая длинная строка длиной " + maxlen + " символов, "+ "Самая короткая " +
                        "строка "+ minlen +". "+ "Всего " + lineCounter + " строк.");


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

