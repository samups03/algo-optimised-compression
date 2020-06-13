import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.lang.*;
import java.util.Objects;

public class Compressor {
    private final int DICTIONNARY_SIZE = 256;
    private byte[] array;
    private byte[] dictionnary = new byte[2048];
    private int compteur=DICTIONNARY_SIZE;
    private ByteBuffer buffer;
    private String byteString;

    public Compressor(byte[] array){
        this.array = array.clone();

    }

    public int compress(){
        int returnValue = 0;
        byte tempUse;
        byte cursor = array[0];

        initialiseDictionnary();

        for(int i = 1; i< array.length; i++){
            byte tempByte = this.array[i];
            if(i<array.length - 1) {
                cursor = this.array[i+1];
            }
            tempUse = (byte) (cursor + tempByte);

            if(elementOfArray(tempByte, dictionnary)){
                cursor = (byte) (cursor + tempByte);
                while(elementOfArray(cursor, dictionnary)){
                    tempByte = array[i+2];
                    cursor = (byte)(cursor<<8 | tempByte);
                }
                System.out.print(cursor);
                dictionnary[compteur] = cursor;
            }
            else{
                dictionnary[compteur] = tempByte;
                cursor = tempByte;
            }
            compteur +=1;
        }

        buffer = ByteBuffer.wrap(dictionnary);
        returnValue = buffer.get();

        return returnValue;


    }

    private void initialiseDictionnary(){

        for(int i = 0; i<DICTIONNARY_SIZE; i++){
            char tempCharacter = (char)i;
            dictionnary[i] = (byte)tempCharacter;
        }
    }

    private boolean elementOfArray(byte texte, byte[] dictionnary){
        boolean value = false;
        boolean output;

        for(byte item: dictionnary){
            output = Objects.equals(texte, item);
            if(output);
               value = true;
        }
        return value;
    }




}
