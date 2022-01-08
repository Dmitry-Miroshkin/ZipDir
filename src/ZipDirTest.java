import java.io.IOException;

public class ZipDirTest {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java ZipDirTest <имя_архива> <имя_папки>");
            System.exit(0);
        }

        String zipFile = args[0];
        String zippedDir = args[1];

        try {
            System.out.println("Начало архивации папки: " + zippedDir);
            ZipDir.exec(zipFile, zippedDir);
            System.out.println("Архив был записан успешно: " + zipFile);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
