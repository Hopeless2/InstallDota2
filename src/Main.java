import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        createDir("Games//src", sb);
        createDir("Games//res", sb);
        createDir("Games//savegames", sb);
        createDir("Games//temp", sb);

        createDir("Games//src//main", sb);
        createDir("Games//src//test", sb);

        createFile("Games//src//main//Main.java", sb);
        createFile("Games//src//main//Utils.java", sb);

        createDir("Games//res//drawables", sb);
        createDir("Games//res//vectors", sb);
        createDir("Games//res//icons", sb);

        createFile("Games//temp//temp.txt", sb);

        try (FileWriter writer = new FileWriter("Games//temp//temp.txt", true)) {
            writer.write(sb.substring(0));
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public static void createDir(String path, StringBuilder sb) {
        File dir = new File(path);
        if (dir.mkdir()) {
            sb.append("Папка " + path + " создана");
            sb.append("\n");
        }
    }

    public static void createFile(String path, StringBuilder sb) {
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                sb.append("Файл " + path + " создан");
                sb.append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void writeTemp(StringBuilder sb) {

    }
}
