
/**
 * Write a description of class PhotoViewer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PhotoViewer implements Application
{

    /**
     * Constructor for objects of class PhotoViewer
     */
    public PhotoViewer()
    {

    }

    /**
     * Prints out details relevant to the picture attachment.
     * Return a true if it was able to open the attachment, otherwise it returns a false.
     */
    public boolean open(Attachment theAttachment){
        if(theAttachment instanceof PictureAttachment){
            PictureAttachment picAttachment = (PictureAttachment) theAttachment;
            String txt =  "I am the PhotoViewer. You are viewing a picture of " + picAttachment.getDescription();
            txt += ". It is " + picAttachment.getHeight() + " pixels by " + picAttachment.getWidth() + " pixels.";
            System.out.println(txt);
            return true;
        }
        System.out.println("I am the PhotoViewer. I do not know how to open attachments of that type.");
        return false;
    }

    /**
     * Create an Attachment of the appropriate type matching the filename extension.
     * @param filename The filename for the Attachment.
     * @param size The size of the Attachment (in kilobytes).
     * @param otherDetails An array of application-specific details about the Attachment.
     */    
    public Attachment create(String filename, long size, String[] otherDetails){
        PictureAttachment picAttachment = new PictureAttachment(filename, size, otherDetails[0], otherDetails[1], otherDetails[2]);
        return picAttachment;
    }

}
