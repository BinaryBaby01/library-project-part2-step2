import java.io.*;
/**
 * Class Test is used to test functionality of other classes.
 *
 * @author (Simone Bamber)
 * @version (08/04/21)
 */
public class Test
{
    // instance variables 
    //a Library class object
    Library library;

    /**
     * Constructor for objects of class Test
     */
    public Test() throws FileNotFoundException
    {
        //initialise University Library
        //test step 1 - FNFException is being caught by the constructor for Library 
        library = new Library();
        //test 2 populate itemList collection in class Library
        //library.populate();
        //test 2.2 instead of populate we use FileDialog to select
        //we automate it by calling to set fileName methods
        //first test data to be attempted to be read from
        //library.setFileName("item_data_1_v2.txt");
        //setFile("textv1.txt")
        library.readLibraryData();
        //test 3 show all Library Item objects held in the Library class' collection
        library.showAllLibraryItems();
    }
}
