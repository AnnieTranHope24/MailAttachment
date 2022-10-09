
/**
 * Write a description of class TextFileAttachment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextFileAttachment extends Attachment
{
    private String text;

    /**
     * Constructor for objects of class TextFileAttachment
     */
    public TextFileAttachment(String filename, long size, String text)
    {
        super(filename, size);
        this.text = text;
    }

    /**
     * Return all details of the text file attachment.
     */
    public String toString(){
        String txt = super.toString();
        txt += "Text: " + text;
        return txt;
    }    
    
    /**
     * Print all details of the text file attachment.
     */
    public void preview(){
        System.out.println(this);
    }    
    
    /**
     * Get the text of the text fie attachment.
     * @return a string of the text.
     */
    public String getText(){
        return text;
    }

}
