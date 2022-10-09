
/**
 * Write a description of class Tester here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Tester
{
    private PictureAttachment picAttch;
    private TextFileAttachment textAttch;
    private PdfFileAttachment pdfAttch;
    private UnsupportedAttachment unsupportedAttch;
    private PhotoViewer pviewer;
    private TextEditor txteditor;
    private PDFReader pdfreader;
    private ZipApp zipapp;

    /**
     * Constructor for objects of class Tester
     */
    public Tester()
    {
        picAttch = new PictureAttachment("Meow.jpg", 12, "a cute cat", "640", "480");
        textAttch = new TextFileAttachment("Script.txt", 8, "content table");
        pdfAttch = new PdfFileAttachment("fys.pdf", 20, "fys final project", "the fys final");
        unsupportedAttch = new UnsupportedAttachment("app.exe", 50);
        pviewer = new PhotoViewer();
        txteditor = new TextEditor();
        pdfreader = new PDFReader();
        zipapp = new ZipApp();
    }
    
    public void test1(){
        MailItem m1 = new MailItem("Annie", "Mike", "My cat..", picAttch);
        MailItem m2 = new MailItem("John", "Kat", "The play script", textAttch );
        MailItem m3 = new MailItem("Cham", "Hung", "Our PDF for the final project.", pdfAttch );
        MailItem m4 = new MailItem("Ben", "Darcy", "The app", unsupportedAttch );
        m1.print();
        m2.print();
        m3.print();
        m4.print();
    }
    
    public void test2(){
        System.out.println("PhotoViewer Test");
        System.out.println("Expect: succeed to open the first file - return true, fail to open others - return false.");
        System.out.println(pviewer.open(picAttch));
        System.out.println(pviewer.open(textAttch));
        System.out.println(pviewer.open(pdfAttch));
        System.out.println(pviewer.open(unsupportedAttch));
        System.out.println("TextEditor Test");
        System.out.println("Expect: succeed to open the first file - return true, fail to open others - return false.");  
        System.out.println(txteditor.open(textAttch));
        System.out.println(txteditor.open(picAttch));        
        System.out.println(txteditor.open(pdfAttch));
        System.out.println(txteditor.open(unsupportedAttch));
        System.out.println("PDFReader Test");
        System.out.println("Expect: succeed to open the first file - return true, fail to open others - return false."); 
        System.out.println(pdfreader.open(pdfAttch));
        System.out.println(pdfreader.open(picAttch));
        System.out.println(pdfreader.open(textAttch));        
        System.out.println(pdfreader.open(unsupportedAttch));          
    }
    
    //test part2
    public void testp2(){
        System.out.println("Expect: 1 PictureAttachment, 1 TextFileAttachment, 1 PdfFileAttachment");
        String[] picDetails = {"a cute dog","540","310"};
        pviewer.create("dog.jpg", 30, picDetails).preview();
        String[] txtDetails = {"hello world!"};
        txteditor.create("lesson1.txt", 15, txtDetails).preview();
        String[] pdfDetails = {"marketing pdf", "how to promote your products"};
        pdfreader.create("marketing.pdf", 40, pdfDetails).preview();        
        
    }

    public void test3(){
        OperatingSystem opSystem = OperatingSystem.getInstance();  
        opSystem.registerApplication("jpg", pviewer);
        opSystem.registerApplication("txt", txteditor);
        opSystem.registerApplication("pdf", pdfreader);
        opSystem.registerApplication("zip", zipapp );
        Attachment pic = opSystem.createAttachment("village.jpg", 50, new String[] {"a picturesque village", "1080", "690"});
        Attachment txt = opSystem.createAttachment("syllabus.txt", 64, new String[] {"this is the course syllabus"});
        Attachment pdf = opSystem.createAttachment("chemistry101.pdf", 30, new String[] {"chemistry 101", "the pdf for chemistry 101"});
        opSystem.createAttachment("bluej.zip", 100, new String[]{"bluej zip file"});
        MailServer server = new MailServer();
        MailClient mai = new MailClient(server, "Mai"); 
        MailClient ngoc = new MailClient(server, "Ngoc");
        mai.sendMailItem("Ngoc", "A beautiful village, right?", pic);
        mai.sendMailItem("Ngoc", "I send you our course syllabus.", txt);
        ngoc.sendMailItem("Mai", "This is the pdf file of chemistry 101.", pdf);
        ngoc.sendMailItem("Mai", "Let's use this!", unsupportedAttch);
        //retrieve mail with all four types of attachments using a MailClient and preview them.
        System.out.println("Expect: retrieve mails with all four types of attachments and preview attachments.");
        ngoc.printNextMailItem();
        ngoc.printNextMailItem();       
        mai.printNextMailItem();
        mai.printNextMailItem();
        
        mai.sendMailItem("Ngoc", "A beautiful village, right?", pic);
        mai.sendMailItem("Ngoc", "I send you our course syllabus.", txt);
        ngoc.sendMailItem("Mai", "This is the pdf file of chemistry 101.", pdf);
        ngoc.sendMailItem("Mai", "Let's use this!", unsupportedAttch);
        //retrieve mail and open attachments with the OperatingSystem instance.
        System.out.println("Expect: succeed to open 3 first attachments using the OperatingSystem instance, fail to open the last one.");
        opSystem.openAttachment(ngoc.getNextMailItem().getAttachment());
        opSystem.openAttachment(ngoc.getNextMailItem().getAttachment());
        opSystem.openAttachment(mai.getNextMailItem().getAttachment());
        opSystem.openAttachment(mai.getNextMailItem().getAttachment());
        
        //attempt to open a Picture with the PDFReader
        System.out.println("Expect: fail to open a Picture with the PDFReader.");
        mai.sendMailItem("Ngoc", "A beautiful village, right?", pic);
        pdfreader.open(ngoc.getNextMailItem().getAttachment());
        
        
        

        
    }

}
