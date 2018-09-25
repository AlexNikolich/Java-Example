package xwing2;



public class Probna {

    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("EOD CAD Log Summary");

        StringBuffer ss = new StringBuffer();
        wrapLineByCharactersEOD(sb,7, ' ');
        System.out.println(sb);
    }
    
    
    protected static void wrapLineByCharactersEOD(StringBuffer description, int length, char marker) {
        int markerPosition = 0;
        String lastLine = description.toString();
        description.delete(0, description.length());

        int onePositionAfterLength = 0;

        while (!lastLine.equals("")) {
            if (lastLine.length() > length) {
                onePositionAfterLength = length+1;
                markerPosition = findCharPosition(lastLine, onePositionAfterLength, marker);
                if (markerPosition == 0) {
                    length--;
                    description.append(lastLine.substring(0, length));
                    description.append("-");
                    description.append("\n");
                    lastLine = lastLine.substring(length);
                    length++;
                    continue;
                }
                if(lastLine.charAt(length) == ' '){
                    markerPosition--;
                    description.append(lastLine.substring(0, markerPosition));
                    description.append("\n");
                    markerPosition++;
                    lastLine = lastLine.substring(markerPosition);
                }else{
                description.append(lastLine.substring(0, markerPosition));
                description.append("\n");
                lastLine = lastLine.substring(markerPosition);
                }
            }
            else {
                
                description.append(lastLine + "\n");
                lastLine = "";
            }
        }
    }


  
    
    //formating transaction name (e.g. EOD ^Summary^) before setting / sending to FE 
//    String txnNameToFormat = transactionName.toString();
//    int pos = txnNameToFormat.lastIndexOf("^");
//    
//    if(pos > -1){
//        int len = txnNameToFormat.length();
//        if (pos == len - 1){
//            txnNameToFormat = txnNameToFormat.substring(0, len - 1);
//        }
//        
//        StringBuffer sb = new StringBuffer(txnNameToFormat);
//        int pos1 = sb.indexOf("^");
//        while (pos1 > -1) {
//            sb.replace(pos1, pos1 + "^".length(), "\n");
//            pos1 = sb.indexOf("^");
//        }
//        txnNameToFormat = sb.toString();
//
//    }

    

    /**
     * wrapper - wrap last line in String buffer by number of characters
     * @param description - string buffer
     * @param length - max number of characters in the line
     * @param marker - char that define delimiter in the string, for example 'EMPTY_SPACE' ',' '.'
     */
    protected static void wrapLineByCharacters(StringBuffer description, int length, char marker) {
        int markerPosition = 0;
        StringBuffer stringBufferTemp = new StringBuffer(description);
        String lastLine = stringBufferTemp.delete(0, findDelimiterPositionFromEnd(description)).toString();
        description.delete(findDelimiterPositionFromEnd(description), description.length()); // everything before last
                                                                                             // line
        int flag = 0;

        while (!lastLine.equals("")) {
            if (lastLine.length() > length) {
                markerPosition = findCharPosition(lastLine, length, marker);
                if (markerPosition == 0) {
                    if (flag == 0) {
                        length = length - 3;
                    }
                    description.append(lastLine.substring(0, length));
                    description.append("-");
                    description.append("^");
                    lastLine = lastLine.substring(length);
                    flag++;
                    continue;
                }
                description.append(lastLine.substring(0, markerPosition));
                description.append("^");
                lastLine = lastLine.substring(markerPosition);

            }
            else {
                description.append(lastLine + "^");
                lastLine = "";
            }
        }
    }

    /**
     * for requested char limiter find position in the string from the end
     * @param sb
     * @return int
     */
    protected static int findDelimiterPositionFromEnd(StringBuffer description) {
        String desc = description.toString();
        int num = desc.lastIndexOf("^");
        return num + 1;
    }

    /**
     * find specific char from THE END of the string. if the char is not in the string - return 0
     * @param text
     * @param maxLength
     * @param ch
     * @return int
     */
    protected static int findCharPosition(String text, int maxLength, char ch) {
        StringBuffer stringBuffertemp = new StringBuffer();
        int check = 0;
        int charPosition = 0;
        int position = 0;

        for (char c : text.toCharArray()) {
            stringBuffertemp.append(c);
            position++;
            check = stringBuffertemp.length();
            if (c == ch && check <= maxLength) {
                charPosition = position;
            }
        }
        return charPosition;
    }

}
