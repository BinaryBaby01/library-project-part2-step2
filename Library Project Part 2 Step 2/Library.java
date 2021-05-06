import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.awt.FileDialog;
import java.awt.Frame;
/**
 * Stores LibraryItem objects in Collection itemList
 * accessors for itemData and mutators for adding
 * items and manipulating , removing items from itemList 
 * in a specified position or all
 *
 * @author (Simone Bamber)
 * @version (29/04/21)
 */
public class Library
{
    //polymorphic collection storing declared type and sub-types
    private ArrayList<LibraryItem> itemList;
    //file name for file being accessed
    private String fileName, fileDirectory;
    /**
     * Constructor for objects of class Library
     */
    public Library()
    {
        // initialise new ArrayList itemList to store LibraryItem objects
        itemList = new ArrayList<>();
    }

    /**
     * Adds a library item to the collection list.
     * @param a <code>LibraryItem</code> object to be added
     */
    public void storeLibraryItem(LibraryItem libraryItem)
    {
        itemList.add(libraryItem);
    }

    /**
     * Shows an animal by printing it's details.  This includes
     * it's position in the collection.
     *
     * @param  <code>listPosition</code> the position of the libraryItem in the list
     */
    public void showLibraryItem(int listPosition)
    {
        LibraryItem libraryItem;
        if( listPosition < itemList.size() )
        {
            //initialise the LibraryItem object var as the one in the list 
            // at the specified position
            libraryItem = itemList.get(listPosition);
            System.out.println("Position " + listPosition  + ": " );
            libraryItem.printDetails();
        }
    }

    /**
     * Returns how many libraryItems are stored in the collection
     *
     * @return   the number of libraryItems in the collection
     */
    public int numberOfLibraryItems()                                                                                                  
    {
        return itemList.size();
    }

    /**
     * Print all details for all items inside of ArrayList itemList
     * @param no param
     * @return String details of all items in the collection itemList
     */
    public void showAllLibraryItems()
    {
        //collection list position pointer
        int listPosition = 0;
        System.out.println("University Library");
        System.out.println("===");
        while( listPosition < itemList.size() )
        {
            showLibraryItem(listPosition);
            listPosition++;
        }
        System.out.println(listPosition + " Library items shown" );    // display number of animals shown
    }

    /**
     * Remove a library item from the collection
     * collection is a zero-based index 1st entry is at 0 and so on
     * @param  <code>listPosition</code> the position of the item in the list
     */
    public void removeLibraryItem(int listPosition)
    {
        if( listPosition>=0 && listPosition<itemList.size() )
        {
            //deletes the item at specified position begining at 0
            itemList.remove(listPosition);
        }
        else
        {
            System.out.println("Invalid position");
        }
    }

    /**
     * Reads animal data from a file and adds corresponding animals to the zoo
     *
     * @param   <code>fileName</code> a <code>String</code>, the name of the 
     *          text file in which the data is stored.
     * 
     * @throws  FileNotFoundException
     */   
    public void readLibraryData() throws FileNotFoundException
    {
        try{
            // one line of code for accessing the fileDialog
            //need to comment out if using automated testing
            openFile();
            if (fileName != null) //then file was selected
            {
                File dataFile = new File(fileName);
                Scanner scanner = new Scanner(dataFile);

                while( scanner.hasNextLine() )
                {
                    //storing each line of text as a string
                    String lineOfText = scanner.nextLine();
                    if (lineOfText.startsWith("//") || lineOfText.isEmpty() || lineOfText.startsWith("["))
                    {
                        lineOfText = "";
                        //erase line of text if it is empty or the line starts with double backslash//
                    }
                    else{
                        //removes leading and trailing spaces
                        lineOfText = lineOfText.trim();

                        System.out.println("Position:" + lineOfText );
                        // //call readData in superclass and subclasses
                        //libraryItem cannot be instantiated 
                        //because its abstract  
                        //test for book or periodical


                        //if true its a book if false periodical
                        Boolean isBook = checkLineOfText(lineOfText);
                        System.out.println("Is it a book? "+isBook);
                        // need to know whether the first line is a Book or Periodical
                        // a test needs to be done with the first line of text
                        String[] str =  lineOfText.split(",");
                        for (String string : str)
                        {
                            System.out.println(string);
                        }
                        
                        Scanner scanner2 = new Scanner(lineOfText);
                        // LibraryItem libraryItem =  new LibraryItem();
                        // libraryItem.readData(scanner2);
                        // System.out.println(libraryItem.toString());
                        //
                        // if (isBook = true)
                        // {
                        // Book book1 = (Book) new LibraryItem();
                        // book1.readData(scanner2);
                        // // Periodical periodical = (Periodical) new LibraryItem();}
                        // }
                        // else
                        // {
                        // Periodical periodical1 = (Periodical) new LibraryItem();
                        // periodical1.readData(scanner2);
                        // }
                        // LibraryItem libraryItem = new LibraryItem();
                        // libraryItem.readData(scanner2);

                        // Book book = (Book) new LibraryItem();
                        // Periodical periodical = (Periodical) new LibraryItem();

                        // if(isBook == true)
                        // {
                        // Book book1 = (Book)  libraryItem;
                        // book1 = book.readData(lineOfText);
                        // }
                        // else
                        // {
                        // Periodical periodical1 = (Periodical) libraryItem;
                        // periodical1 = periodical.readData(lineOfText);
                        // }
                        //readData(scanner);
                    }
                }
                scanner.close();
            }
        }
        catch(FileNotFoundException e)
        {
            System.out.println("File was not found.");
            System.out.println("Please try again.");
        }
        catch(IOException e){
            System.out.println("Input / Output Error.");
            System.out.println("Please try again.");
        }
        catch(NullPointerException e){
            //This catch block catches all the exceptions that aren't specified
            System.out.println("No Pointer Exception.");
            System.out.println("Please try again.");
        }
        catch(ArrayIndexOutOfBoundsException e){
            //This catch block catches all the exceptions that aren't specified
            System.out.println("Array out of bounds Exception.");
            System.out.println("Please try again.");
        }
        catch(Exception e){
            //This catch block catches all the exceptions that aren't specified
            System.out.println("Unexpected Error.");
            System.out.println("Please try again.");
        }

        //end of catch
        finally{
            System.out.println("finally finished!");
        }
    }

    /**
     * check the line of text for author String or publicationDate int
     * boolean true for String and false for Int
     */
    private boolean checkLineOfText(String textline)
    {
        Scanner scanner2 = new Scanner(textline);
        scanner2.useDelimiter(",|-");
        String firstWords = "";
        int firstNum = 0;
        boolean isBook = false;
        //if periodical firstNum and firstWord become the first num it is outputted as String
        if(scanner2.hasNextInt() == true){
            //firstNum = scanner.nextInt() = true
            firstNum = scanner2.nextInt();
            firstWords += firstNum;
        }
        else
        { 
            //its a book - author is in this field
            firstWords = scanner2.next();
            isBook = true;
        }
        return isBook;
    }

    /**
     * tests whether the libraryItem is an instance of Book or Periodical
     * @param LibraryItem obj
     * @return boolean true for book false for periodical
     */
    public boolean checkLibraryItem(LibraryItem testLibraryItem)
    {
        if (testLibraryItem instanceof Book)//book obj
        {
            return true;
        }
        else //periodical obj
            return false;
    }

    /**
     * opens a fileDialog and sets the selected file to be the 
     * file and file path
     */
    private void openFile()
    {
        Frame myFrame = new Frame();
        FileDialog fileBox = new FileDialog (myFrame , "Open", FileDialog.LOAD);
        fileBox.setVisible(true);
        //assigns fileName the selected file directory path from fileDialog
        //assuming the file is in the same directory as the project
        fileName = fileBox.getFile();
        fileDirectory = fileBox.getDirectory();
    }

    /**
     * set a new file name
     * requires a string
     * this may replace an already existing value
     */
    public void setFileName(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * get fileName currently being stored
     * @return String 
     */
    public String getFileName()
    {
        return fileName;
    }

    /**
     * return Library object
     */
    public Library getLibrary()
    {
        return this;
    }

    /**
     * returns true if there is a Library object, false if otherwise
     */
    public boolean hasLibrary()
    {
        return (this != null);
    }

    /**
     * checks whether the Library obj is equal to Library
     * 
     * @Override Object method equals()
     */
    public boolean equals(Library library)
    {
        if (this == library)
        {return true; //reference equality
        }
        if(!(library instanceof Library)) //not Library
        {return false;
        }
        System.out.println(library);
        return this.equals(library);
    }

    public int hashCode()
    {
        int prime = 9;
        int result = 35 * prime + ((fileName == null) ? 0 : fileName.hashCode());
        return result;
    }

    // /**
    // * toString method of Library class
    // * @Override toString Object
    // */
    // public String toString()
    // {
    // String str = "Library System";
    // String emptyList = "";
    // return str + fileName + fileDirectory;
    // boolean empty = itemList.isEmpty();
    // if( empty = true )
    // {
    // return emptyList += "No items in the list.\n";
    // }
    // else
    // {
    // return emptyList += "There are " + itemList.size() + "items in the list.";
    // }
    // }

}
