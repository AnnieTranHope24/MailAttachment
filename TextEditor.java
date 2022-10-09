
/**
 * Write a description of class TextEditor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TextEditor implements Application

{


    /**
     * Constructor for objects of class TextEditor
     */
    public TextEditor()
    {

    }

    /**
     * Prints out details relevant to the text file attachment.
     * Return a true if it was able to open the attachment, otherwise it returns a false.
     */    
    public boolean open(Attachment theAttachment){
        if(theAttachment instanceof TextFileAttachment){
            TextFileAttachment txtfileAttachment = (TextFileAttachment) theAttachment;
            String txt =  "I am the TextEditor. You are viewing a text file with the text: " + txtfileAttachment.getText() + ".";
            System.out.println(txt);
            return true;
        }
        System.out.println("I am the TextEditor. I do not know how to open attachments of that type.");
        return false;      
    }
    
    /**
     * Create an Attachment of the appropriate type matching the filename extension.
     * @param filename The filename for the Attachment.
     * @param size The size of the Attachment (in kilobytes).
     * @param otherDetails An array of application-specific details about the Attachment.
     */    
    public Attachment create(String filename, long size, String[] otherDetails){
        TextFileAttachment txtAttachment = new TextFileAttachment(filename, size, otherDetails[0]);
        return txtAttachment;
    }    
}
