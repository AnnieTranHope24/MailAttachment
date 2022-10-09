
/**
 * Write a description of class PdfFileAttachment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PdfFileAttachment extends Attachment
{
    private String title;
    private String description;

    /**
     * Constructor for objects of class PdfFileAttachment
     */
    public PdfFileAttachment(String filename, long size, String title, String description)
    {
        super(filename, size);
        this.title = title;
        this.description = description;
    }

    /**
     * Return all details of the pdf file attachment.
     */
    public String toString(){
        String text = super.toString();
        text += "Title: " + title + " Description: " + description;
        return text;
    }    
    
    /**
     * Print all details of the picture attachment.
     */
    public void preview(){
        System.out.println(this);
    }     
    
    /**
     * Get the title of the pdf file.
     * @return the title of the pdf file.
     */
    public String getTitle(){
        return title;
    }  
    
    /**
     * Get the description of the pdf file.
     * @return the description of the pdf file.
     */
    public String getDescription(){
        return description;
    } 
    
  
}
