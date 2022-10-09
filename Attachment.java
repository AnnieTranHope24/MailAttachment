
/**
 * Write a description of class Attachment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public abstract class Attachment
{
    protected String filename;
    protected long size;
    /**
     * Constructor for objects of class Attachment
     */
    public Attachment(String filename, long size)
    {
        this.filename = filename;
        this.size = size;
    }
    
    /**
     * Print all details
     */
    protected void preview(){
        System.out.println(this);
    }
    /**
     * Return a String that contains all details of the attachment.
     */
    public String toString(){
        String text = "Filename: " + filename + " Size: " + size + " ";
        return text;
    }
    
    /**
     * Get the filename of the attachment.
     * @return the filename of the attachment.
     */
    protected String getFilename(){
        return filename;
    }
    
    /**
     * Get the size of the attachment.
     * @return an int of the size of the attachment.
     */
    protected long getSize(){
        return size;
    }    
    
    


}
