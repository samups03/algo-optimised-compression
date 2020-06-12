import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.nio.ByteBuffer;

public class Start {



    public static void main(String args[]) throws IOException {

        String byteString = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        BitInputStream readFile = new BitInputStream((fileName));
        BitOutputStream writeFile = new BitOutputStream("C:\\Users\\Samuel\\Documents\\algo-optimised-compression\\temp");

        while(readFile.readBit()!=-1){

            writeFile.writeBit(readFile.readBit());
            byteString += Integer.toString(readFile.readBit());

        }

        byte[] byteTable = new byte[byteString.length() / 8];

        for(int i = 0; i<byteTable.length; i++ ){

            for(int j=0; j<=7; j++){

                byteTable[i] |= (byte)((byteString.toCharArray()[i*8+j] == '1' ? 1:0)<<(7-j));
            }
        }

        Compressor c1  = new Compressor(byteString);
        System.out.println(c1.compress());


        System.out.print("test");
        readFile.close();
        writeFile.close();


    }
}