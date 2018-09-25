
    public static final String MY_FONT = "SANS_SERIF";

    public static final int MY_FONT_SIZE = 12;



    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer();
        sb.append("Celebrating the transformation of more than 150 banking "
            + "wwwwww wwwwww wwwwww wwwwww wwwwww wwwwww wwwwww wwwwww wwwwww wwwwww "
            + "Strategy and Planning team launched this initiative to bring our frontline"
            + " team closer to our clients and focus on the conversations that help us "
            + "acquire and deepen client relationships.");

        wrapperDelimiterByPixels(sb, 200, ' ');
        System.out.println(sb);
    }
    
    
    /**
     * wrap line by max pixels 
     * @param textBuffer
     * @param ch
     * @return 
     */
    protected static void wrapperDelimiterByPixels(StringBuffer description, int numberOfPixels, char ch) {
        
        StringBuffer stringBufferTemp = new StringBuffer(description);
        String lastLine = stringBufferTemp.delete(0, findDelimiterPositionFromEnd(description)).toString(); // adding separator
        description.delete(findDelimiterPositionFromEnd(description), description.length()); // everything before last line
        
        int flag = 0; // 
        int charPosition = 0;

        while (!lastLine.equals("")) {
            flag = calculatePixelSize(lastLine);
            if (flag < 192) {
                description.append(lastLine);
                lastLine = "";
                return;
            }
            else {
                charPosition = findCharPosition(lastLine, numberOfPixels, ch);
                if (charPosition == 0) {
                    description.append(lastLine.substring(0, maxNumberOfCharsInLine(lastLine, numberOfPixels)-1));
                    description.append("*");
                    lastLine = lastLine.substring(maxNumberOfCharsInLine(lastLine, numberOfPixels)-1);

                }
                description.append(lastLine.substring(0, charPosition));
                description.append("*");
                lastLine = lastLine.substring(charPosition);
            }
        }
        return;
    }
    
    /**
     * returning integer position of delimiter + 1 from the end
     * @param StringBuffer sb
     * @return int
     */
    protected static int findDelimiterPositionFromEnd(StringBuffer sb){
        String st = sb.toString();
        int num = st.lastIndexOf("*");
        return num+1;
    }
    
    /**
     * cutting string(long one - without space or either separator) for certain number of pixel
     * @param String text
     * @return int
     */
    protected static int maxNumberOfCharsInLine(String text, int numberOfPixels){
        StringBuffer stringBuffertemp = new StringBuffer();
        int check = 0;
        int charPosition = 0;
        
        for (char c : text.toCharArray()) {
            stringBuffertemp.append(c);
            check = calculatePixelSize(stringBuffertemp.toString());
            if (check < numberOfPixels) {
                charPosition++;
            }
        }
        return charPosition;
    }
    

    /**
     * find last character in a string for requested pixels and requested char
     * @param String text
     * @param char ch
     * @return int
     */
    protected static int findCharPosition(String text, int numberOfPixels, char ch) {
        StringBuffer stringBuffertemp = new StringBuffer();
        int check = 0;
        int charPosition = 0;
        int emptySpacePosition = 0;

        for (char c : text.toCharArray()) {
            stringBuffertemp.append(c);
            charPosition++;
            check = calculatePixelSize(stringBuffertemp.toString());
            if (c == ch && check < numberOfPixels) {
                emptySpacePosition = charPosition;
            }
        }
        return emptySpacePosition;
    }

    /**
     * calculate pixels for string WIDTH
     * @param String text
     * @return int
     */
    protected static int calculatePixelSize(String text) {
        AffineTransform affinetransform = new AffineTransform();
        FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
        Font font = new Font(MY_FONT, MY_FONT_SIZE, MY_FONT_SIZE);
        int textwidth = (int) (font.getStringBounds(text, frc).getWidth());
        return textwidth;
    }


