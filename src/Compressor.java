import java.nio.ByteBuffer;
import java.nio.ShortBuffer;

public class Compressor {
    private byte[] array;
    private short[] dictionnary = new short[256];
    private int compteur=1;
    private ShortBuffer buffer;
    private String byteString;

    public Compressor(String byteString){
        this.byteString = byteString;

    }

    public int compress(){
//        int returnValue = 0;
//        short tempUse;
//        short cursor = array[0];
//        dictionnary[0] = cursor;
//
//        for(int i = 1; i< array.length; i++){
//            short tempByte = this.array[i];
//            tempUse = (short) ((cursor << 8) | tempByte);
//
//            if(elementOfArray(tempByte, dictionnary)){
//                cursor = (short) ((cursor << 8) | tempByte);
//                //System.out.print(cursor);
//                dictionnary[compteur] = cursor;
//            }
//            else{
//                dictionnary[compteur] = tempByte;
//                cursor = tempByte;
//            }
//            compteur +=1;
//        }
//
//        buffer = ShortBuffer.wrap(dictionnary);
//        returnValue = buffer.get();
//
//        return returnValue;
        while (this.byteString.length() > 0) {
            String s = st.longestPrefixOf(this.byteString);  // Find max prefix match s.
            BinaryStdOut.write(st.get(s), W);      // Print s's encoding.
            int t = s.length();
            if (t < this.byteString.length() && code < L)    // Add s to symbol table.
                st.put(this.byteString.substring(0, t + 1), code++);
            this.byteString = this.byteString.substring(t);            // Scan past s in input.

    }

    private boolean elementOfArray(short texte, short[] dictionnary){
        boolean value = false;

        for(short item: dictionnary){

            if(texte == item)
               value = true;
        }
        return value;
    }




}
