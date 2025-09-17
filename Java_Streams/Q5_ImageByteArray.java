
import java.io.*;

public class Q5_ImageByteArray {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("image.jpg");
             ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesRead);
            }
            byte[] imageBytes = baos.toByteArray();

            try (FileOutputStream fos = new FileOutputStream("copy_image.jpg");
                 ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes)) {
                while ((bytesRead = bais.read(buffer)) != -1) {
                    fos.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("Image copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
