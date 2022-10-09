import java.util.HashMap;
/**
 * Write a description of class OperatingSystem here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class OperatingSystem
{
    private static OperatingSystem instance = null;
    private HashMap<String, Application> filenameMap;
    /**
     * Constructor for objects of class OperatingSystem
     */
    private OperatingSystem()
    {
        filenameMap= new HashMap<>();

    }
    
    /**
     * Get one and only OperatingSystem instance.
     * If no instance has been created, initiate a new OperatingSystem.
     */
    public static OperatingSystem getInstance(){
        if (instance == null) {
            instance = new OperatingSystem();
        }
        return instance;
    }
    
    /**
     * Store mappings from file extensions to Applications in filenameMap.
     * @param nameExtension a filename extension(e.g., "jpg")
     * @param app an instance of an Application (e.g., a PhotoViewer)
     */
    public void registerApplication(String nameExtension, Application app){
        filenameMap.put(nameExtension, app);
    }

    /**
     * 
     */
    public Attachment createAttachment(String filename, long size, String[] otherDetails){
        String[] charArray = filename.split("\\.");
        String extension = charArray[1];
        Application app = filenameMap.get(extension);
        if(app!= null){
            return app.create(filename, size, otherDetails);
        }
        System.out.println("Cannot creat an attachment for that file.");
        return null;
    }
    
    public void openAttachment(Attachment theAttachment){
        String[] charArray = theAttachment.getFilename().split("\\.");
        String extension = charArray[1];
        Application app = filenameMap.get(extension);
        if(app!= null){
            app.open(theAttachment);
            return;
        }    
        
        System.out.println("Your file cannot be opened by this operating system.");
    }
}
