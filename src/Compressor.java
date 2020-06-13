import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.lang.*;
import java.util.HashMap;
import java.util.Objects;

public class Compressor {
    private final int DICTIONNARY_SIZE = 256;
    private byte[] array;
    private HashMap<String, Integer> dictionnary = new HashMap<String, Integer>(512);
    private int compteur=DICTIONNARY_SIZE+1;
    private ByteBuffer buffer;
    private String byteString;

    public Compressor(byte[] array){
        this.array = array.clone();

    }

    public int compress(){
        int returnValue = 0;
        byte tempUse;
        Byte cursor = array[0];
        String cursorStr = Character.toString((char) array[0]);
        String tempString ="";

        initialiseDictionnary();

        for(int i = 1; i< array.length; i++){
            Byte tempByte = this.array[i];
            String tempByteStr = Character.toString((char)this.array[i]);
            int tempByteStringInt = 0;
            tempString = cursorStr + tempByteStr;
            tempUse = (byte) (cursor + tempByte);

            if(dictionnary.containsKey(tempString)){
                cursorStr = tempString;
            }
//            if(elementOfArray(tempByte, dictionnary)){
//                cursor = (byte) (cursor + tempByte);
//                while(elementOfArray(cursor, dictionnary)){
//                    tempByte = array[i+2];
//                    cursor = (byte)(cursor<<8 | tempByte);
//                }
//                System.out.print(cursor);
//                dictionnary[compteur] = cursor;
//            }
            else{
                tempByteStringInt = Integer.parseInt(String.valueOf((Byte.toUnsignedInt(cursor) + Byte.toUnsignedInt(tempByte))));
                dictionnary.put(tempString, compteur);
                cursorStr = tempByteStr;
                compteur +=1;
            }
        }

        //buffer = ByteBuffer.wrap(dictionnary);
        //returnValue = buffer.get();

        //return returnValue;

        return 1;
    }

    private void initialiseDictionnary(){

        for(int i = 0; i<DICTIONNARY_SIZE; i++){
            char tempCharacter = (char)i;
            dictionnary.put(Character.toString(tempCharacter), i);
        }
    }

}
