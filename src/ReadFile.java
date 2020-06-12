import java.io.*;
/*
    Class is inspired by example given in LOG320 for reading files.
 */

public class ReadFile {
    private String fileName;
    private File file;
    private FileReader fileReader;


    public ReadFile(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        file = new File(fileName);
        fileReader = new FileReader(fileName);
    }

    public void read(){
        try(BufferedReader bufferedReader = new BufferedReader(fileReader)){
            String line;
            while((line = bufferedReader.readLine()) != null) {
                System.out.println(String.format(line));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




