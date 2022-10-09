
/**
 * Write a description of class ZipFileAttachment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ZipFileAttachment extends Attachment
{
    private String description;

    /**
     * Constructor for objects of class ZipFileAttachment
     */
    public ZipFileAttachment(String filename, long size, String description)
    {
        super(filename, size);
        this.description = description;
    }

    /**
     * Return all details of the zip file attachment.
     */
    public String toString(){
        String txt = super.toString();
        txt += "Description: " + description;
        return txt;
    }    
    
    /**
     * Print all details of the picture attachment.
     */
    public void preview(){
        System.out.println(this);
    }    
    
    /**
     * Get the description of the text fie attachment.
     * @return a string of the description.
     */
    public String getDescription(){
        return description;
    }
}
