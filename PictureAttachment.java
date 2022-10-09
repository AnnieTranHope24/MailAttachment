
/**
 * Write a description of class PictureAttachment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PictureAttachment extends Attachment
{
   private String description;
   private String height;
   private String width;

    /**
     * Constructor for objects of class PictureAttachment
     */
    public PictureAttachment(String filename, long size, String description, String height, String width)
    {
        super(filename, size);
        this.description = description;
        this.height = height;
        this.width = width;
    }
    /**
     * Return all details of the picture attachment.
     */
    public String toString(){
        String text = super.toString();
        text += "Description: " + description + " Height: " + height + " Width: " + width;
        return text;
    }
    /**
     * Print all details of the picture attachment.
     */
    public void preview(){
        System.out.println(this);
    }
    
    /**
     * Get the description of the picture.
     * @return the description of the picture.
     */
    public String getDescription(){
        return description;
    }
    /**
     * Get the width of the picture.
     * @return the width of the picture.
     */
    public String getWidth(){
        return width;
    }    

    /**
     * Get the height of the picture.
     * @return the height of the picture.
     */
    public String getHeight(){
        return height;
    }   
}
