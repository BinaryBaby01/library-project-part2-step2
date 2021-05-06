import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;
/**
 * Class used to create instances of libraryItems , or books some say
 * has accessors for all fields and mutators for changing values once 
 * the object has been instantiated 
 *
 * @author (Simone Bamber)
 * @version (28/04/21)
 */
public class LibraryItem extends Library
{
    // class variables - for library item , noOfPages and publisher
    protected int noOfPages;
    protected String publisher;   
    //title , itemcode , cost , timesBorrowed , onLoan
    protected String title; 
    protected String itemCode;
    protected int cost;
    protected int timesBorrowed;
    protected boolean onLoan;

    private static final int NUMBER_OF_FIELDS = 7;
    private static final int NOOFPAGES=0,PUBLISHER=1,TITLE=2,ITEMCODE=3,COST=4,TIMESBORROWED=5,ONLOAN=6;

    

    /**
     * Constructor for objects of class LibraryItem
     * noOfPages , publisher , title , itemCode , cost , timesBorrowed , onLoan 
     */
    public LibraryItem() 
    {
        //nothing for now
    }

    //abstract public void storeLibraryItem(LibraryItem libraryItem);

    /**
     * mutator - change the noOfPages of a library item
     * @param  new newNoOfPages
     * @return the NEW number of pages for library item object 
     */
    protected void setNoOfPages(int noOfPages)
    {
        System.out.println("you have successfully changed " + noOfPages); 
        this.noOfPages = noOfPages;
        System.out.println("to " + noOfPages);
    }

    /**
     * mutator - change the noOfPages of a library item
     * @param  new newNoOfPages
     * @return the NEW number of pages for library item object 
     */
    protected void setPublisher(String publisher)
    {
        System.out.println("you have successfully changed " + publisher); 
        this.publisher = publisher;
        System.out.println("to " + publisher);
    }

    /**
     * mutator - change the title of a library item
     * @param  new title
     * @return the NEW title of the library item object 
     */
    protected void setTitle(String newTitle)
    {
        System.out.println("you have successfully changed " + title); 
        this.title = title;
        System.out.println("to " + title);
    }

    /**
     * mutator - change the itemCode of a library item
     * @param  new itemCode
     * @return the NEW itemCode of the library item object 
     */
    protected void setItemCode(String itemCode)
    {
        System.out.println("you have successfully changed " + itemCode); 
        this.itemCode = itemCode;
        System.out.println("to " + itemCode);
    }

    /**
     * mutator - change the cost of a library item
     * @param  new Cost in pence
     * @return the NEW Cost of the library item object 
     */
    protected void setCost(int cost)
    {
        System.out.println("you have successfully changed " + cost); 
        this.cost = cost;
        System.out.println("to " + cost);
    }

    /**
     * mutator - change the amount of times borrowed for a library item
     * @param  new timesBorrowed
     * @return the NEW amount of timesBorrowed for the library item object 
     */
    protected void setTimesBorrowed(int timesBorrowed)
    {
        System.out.println("you have successfully changed " + timesBorrowed); 
        this.timesBorrowed = timesBorrowed;
        System.out.println("to " + timesBorrowed);
    }

    /**
     * mutator - change the loan status or availability of a library item
     * @return change the loan status of a library item object 
     */
    public void changeOnLoan()
    {
        if (onLoan == true)
            onLoan = false;
        else
            onLoan = true;
    }

    /**
     * mutator - change the loan status or availability of a library item
     * @param on loan status boolean
     * @return change the loan status of a library item object 
     */
    public void setOnLoan(boolean onLoan)
    {
        this.onLoan = onLoan;
    }

    /**
     * Return the number of pages of the Library Item 
     * Accessor
     * @param  n/a
     * @return the number of pages of the library item object 
     */
    public int getNoOfPages()
    {
        return noOfPages;
    }

    /**
     * Return the publisher of the Library Item 
     * Accessor
     * @param  n/a
     * @return the publisher of the library item object 
     */
    public String getPublisher()
    {
        return publisher;
    }

    /**
     * Return the title of the Library Item 
     * Accessor
     * @param  n/a
     * @return the title of the library item object 
     */
    public String getTitle()
    {
        return title;
    }

    /**
     * Return the item code of the Library Item 
     * Accessor
     * @param  n/a
     * @return the item code of the library item object 
     */
    public String getItemCode()
    {
        return itemCode;
    }

    /**
     * Return the cost of the Library Item in Pence (p)
     * Accessor
     * @param  n/a
     * @return the cost of the library item object 
     */
    public int getCost()
    {
        return cost;
    }

    /**
     * Return the cost of the Library Item
     * Accessor
     * @param  n/a
     * @return the amount of times the library item object, has been checked out of the library
     */
    public int getTimesBorrowed()
    {
        return timesBorrowed;
    }

    /**
     * Return the cost of the Library Item
     * Accessor
     * @param  n/a
     * @return the cost of the library item object 
     */
    public boolean checkOnLoan()
    {
        return onLoan;
    }

    /**
     * Return the cost of the Library Item
     * Accessor
     * @param  n/a
     * @return the string ver of boolean onLoan, property of the library item object 
     */
    protected String onLoanToString(boolean onLoan)
    {
        String loanString;
        if (onLoan == true)
            loanString = "on loan";
        else{
            loanString = "available in the library";
        }
        return loanString;
    }

    /**
     * Print details about the Library Item Object
     *  @param  n/a
     * @return a few lines containing all the fields declared in a library item object
     */
    public void printDetails()
    {
        System.out.println(title + " with item code " + itemCode + " has been borrowed " + timesBorrowed + ". This item is at present \n");
        System.out.println(onLoanToString(onLoan) + " and when new cost " + cost + " pence.");
    } 

    //public abstract void readData(Scanner textline);

    /**
     *reads libraryItem data 
     *@param textline Scanner
     **/
    public void readData(Scanner line) 
    {
        //second scanner with useDelimiter() for processing lineOfText
        line.useDelimiter(",");
        noOfPages = line.nextInt(); 
        publisher = line.next(); 
        title = line.next();
        itemCode = line.next();
        cost =line.nextInt();
        timesBorrowed = line.nextInt();
        onLoan = line.nextBoolean();
        //superclass method in Library
        storeLibraryItem(this);
        line.close();
    
    }

    /**
     * toString for LibraryItem 
     * @Overriding Object method toString()
     */
    public String toString()
    {
        String str1 = new String("Number of pages:"+noOfPages +" Publisher:"+publisher+" Title:"+title+"/n");
        String str2 = "Item Code:"+itemCode+" Cost:"+cost+"Times Borrowed:"+timesBorrowed+"On Loan:"+onLoan;;
        return str1 + str2; 
    }

    /**
     * returns true if there is a libraryItem false if not
     */
    public boolean hasLibraryItem()
    {
        return (this != null);
    }

    /**
     * returns this object
     */
    public LibraryItem getLibraryItem()
    {
        return this;
    }
    

    /**
     * checks whether the LibraryItem obj is equal to Book or Periodical
     * if periodical access fields
     * @Override Object method equals()
     */
    public boolean equals(LibraryItem libraryItem)
    {
        if (this == libraryItem)
        {return true; //reference equality
        }
        if(!(libraryItem instanceof LibraryItem)) //not LibraryItem
        {return false;
        }
        LibraryItem other = (LibraryItem) libraryItem;
        return other.equals(libraryItem) && other.getNoOfPages() == noOfPages &&
        other.getPublisher() == publisher && other.getItemCode() == itemCode && 
        other.getCost() == cost && other.getTimesBorrowed() == timesBorrowed
        && other.checkOnLoan() == onLoan;
    }
    
    public int hashCode()
    {
        int prime = 3;
        int result = 17 * prime + noOfPages + timesBorrowed + cost;
        return result;
    }

}
