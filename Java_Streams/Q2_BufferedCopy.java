
import java.io.*;

public class Q2_BufferedCopy {
    public static void main(String[] args) {
        String source = "largefile.dat";
        String dest1 = "copy_unbuffered.dat";
        String dest2 = "copy_buffered.dat";

        try {
            // Unbuffered
            long start = System.nanoTime();
            try (FileInputStream fis = new FileInputStream(source);
                 FileOutputStream fos = new FileOutputStream(dest1)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            long end = System.nanoTime();
            System.out.println("Unbuffered copy time: " + (end - start) + " ns");

            // Buffered
            start = System.nanoTime();
            try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
                 BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest2))) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = bis.read(buffer)) != -1) {
                    bos.write(buffer, 0, bytesRead);
                }
            }
            end = System.nanoTime();
            System.out.println("Buffered copy time: " + (end - start) + " ns");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
