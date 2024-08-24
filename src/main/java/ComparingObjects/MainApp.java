package ComparingObjects;

import java.util.ArrayList;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        List<String> lst = new ArrayList<>();
        String a = "123";
        lst.add("123");
        System.out.println("123"==lst.get(0));
        System.out.println(a=="123");
        System.out.println(a==lst.get(0));
    }
}
