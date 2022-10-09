
/**
 * Write a description of interface Application here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Application
{
    public boolean open(Attachment theAttachment);

    /**
     * Create an Attachment of the appropriate type matching the filename extension.
     * @param filename The filename for the Attachment.
     * @param size The size of the Attachment (in kilobytes).
     * @param otherDetails An array of application-specific details about the Attachment.
     */
    public Attachment create(String filename, long size, String[] otherDetails);    
}

