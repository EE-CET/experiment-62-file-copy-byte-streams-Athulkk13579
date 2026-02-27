import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopyByteStreams {
    public static void main(String[] args) {
        String sourceFile = "source.txt";
        String destFile = "destination.txt";

        try (FileInputStream fis = new FileInputStream(sourceFile);
             FileOutputStream fos = new FileOutputStream(destFile)) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            
            System.out.println("File Copied");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (FileInputStream fisDest = new FileInputStream(destFile)) {
            int byteData;
            while ((byteData = fisDest.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
