package JavaCore_3_1_Files;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        List<File> folderList = Arrays.asList(
                new File("/Users/albina/Games"),
                new File("/Users/albina/Games//temp"),
                new File("/Users/albina/Games//src"),
                new File("/Users/albina/Games//res"),
                new File("/Users/albina/Games//savegames"),
                new File("/Users/albina/Games//src//main"),
                new File("/Users/albina/Games//src//test"),
                new File("/Users/albina/Games//res//drawables"),
                new File("/Users/albina/Games//res//vectors"),
                new File("/Users/albina/Games//res//icons")
        );
        List<File> fileList = Arrays.asList(
                new File("/Users/albina/Games//src//main//Main.java"),
                new File("/Users/albina/Games//src//main//Utils.java"),
                new File("/Users/albina/Games//temp//temp.txt")
        );
        folderList.stream().forEach(folder -> {
            if (folder.mkdir()) sb.append("Каталог " + folder + " создан\n");
            else sb.append("Каталог " + folder + " не создан\n");
        });
        fileList.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException ex) {
                sb.append(ex.getMessage() + '\n');
            }
        });
        try (FileWriter log = new FileWriter("/Users/albina/Games//temp//temp.txt", false)) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException ex) {
            sb.append(ex.getMessage() + '\n');
        }
        try (BufferedReader br = new BufferedReader(new FileReader("/Users/albina/Games//temp//temp.txt"))) {
            String s;
            while ((s = br.readLine()) != null) System.out.println(s);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
