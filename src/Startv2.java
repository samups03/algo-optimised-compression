import java.io.FileNotFoundException;

public class Startv2 {

    public static void main(String args[]) throws FileNotFoundException {

        ReadFile readFile = new ReadFile("C:\\Users\\Samuel\\Documents\\algo-optimised-compression\\test.txt");
        readFile.read();
    }
}
