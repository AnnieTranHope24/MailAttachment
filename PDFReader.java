
/**
 * Write a description of class PDFReader here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PDFReader implements Application
{


    /**
     * Constructor for objects of class PDFReader
     */
    public PDFReader()
    {

    }

    /**
     * Prints out details relevant to the pdf file attachment.
     * Return a true if it was able to open the attachment, otherwise it returns a false.
     */    
    public boolean open(Attachment theAttachment){
        if(theAttachment instanceof PdfFileAttachment){
            PdfFileAttachment pdffileAttachment = (PdfFileAttachment) theAttachment;
            String txt =  "I am the PDFReader. You are viewing a pdf file of " + pdffileAttachment.getDescription(); 
            txt += " whose title is " + "\"" + pdffileAttachment.getTitle() + ".\"";
            System.out.println(txt);
            return true;
        }
        System.out.println("I am the PDFReader. I do not know how to open attachments of that type.");
        return false;      
    }  
    
    /**
     * Create an Attachment of the appropriate type matching the filename extension.
     * @param filename The filename for the Attachment.
     * @param size The size of the Attachment (in kilobytes).
     * @param otherDetails An array of application-specific details about the Attachment.
     */    
    public Attachment create(String filename, long size, String[] otherDetails){
        PdfFileAttachment pdfAttachment = new PdfFileAttachment(filename, size, otherDetails[0], otherDetails[1]);
        return pdfAttachment;
    }       
}
