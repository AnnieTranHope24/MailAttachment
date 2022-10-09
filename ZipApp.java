
/**
 * Write a description of class ZipApp here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ZipApp implements Application
{
    /**
     * Constructor for objects of class ZipApp
     */
    public ZipApp()
    {

    }

    /**
     * Prints out details relevant to the pdf file attachment.
     * Return a true if it was able to open the attachment, otherwise it returns a false.
     */    
    public boolean open(Attachment theAttachment){
        if(theAttachment instanceof ZipFileAttachment){
            ZipFileAttachment zipfileAttachment = (ZipFileAttachment) theAttachment;
            String txt =  "I am the ZipApp. You are viewing a zip file of " + zipfileAttachment.getDescription(); 
            System.out.println(txt);
            return true;
        }
        System.out.println("I am the ZipApp. I do not know how to open attachments of that type.");
        return false;      
    }  
    
    /**
     * Create an Attachment of the appropriate type matching the filename extension.
     * @param filename The filename for the Attachment.
     * @param size The size of the Attachment (in kilobytes).
     * @param otherDetails An array of application-specific details about the Attachment.
     */    
    public Attachment create(String filename, long size, String[] otherDetails){
        ZipFileAttachment zipAttachment = new ZipFileAttachment(filename, size, otherDetails[0]);
        return zipAttachment;
    } 
}
