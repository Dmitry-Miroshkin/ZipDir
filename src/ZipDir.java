import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDir {
    public static void exec(String zipFile, String zippedDir) throws IOException{
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipFile));
        walkingDir(zos, zippedDir);
        zos.close();
    }

    public static void walkingDir(ZipOutputStream zos, String zippedDir){

        File zipDir = new File(zippedDir);
        String[] dirList = zipDir.list();

        assert dirList != null;
        for (String s : dirList) {

            File f = new File(zippedDir + '/'+ s);
            if (f.isDirectory()) {
                walkingDir(zos, f.getPath());
            } else {
                try {
                    byte[] readBuffer = new byte[2048];
                    int bytesReaded;

                    String fullPath =  f.getPath();
                    System.out.println("\t архивируется " + fullPath);
                    FileInputStream fis = new FileInputStream(fullPath);
                    ZipEntry ze = new ZipEntry(fullPath);
                    zos.putNextEntry(ze);

                    while ((bytesReaded = fis.read(readBuffer)) != -1) {
                        zos.write(readBuffer, 0, bytesReaded);
                    }
                } catch (IOException fnfe) {
                    System.out.println(fnfe.getMessage());
                }
            }
        }
    }
}
