
import java.io.*;

class WriterThread extends Thread {
    private PipedOutputStream pos;

    WriterThread(PipedOutputStream pos) {
        this.pos = pos;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                pos.write(("Message " + i + "\n").getBytes());
                Thread.sleep(500);
            }
            pos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class ReaderThread extends Thread {
    private PipedInputStream pis;

    ReaderThread(PipedInputStream pis) {
        this.pis = pis;
    }

    public void run() {
        try {
            int data;
            while ((data = pis.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class Q8_PipedStreams {
    public static void main(String[] args) {
        try {
            PipedOutputStream pos = new PipedOutputStream();
            PipedInputStream pis = new PipedInputStream(pos);

            new WriterThread(pos).start();
            new ReaderThread(pis).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
