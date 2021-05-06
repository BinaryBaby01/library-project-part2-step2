import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
/**
 * Class that store book item information
 * methods for accessing fields stored - isbn & author
 * and mutators
 * @author (Simone Bamber)
 * @version (28/04/21)
 */
public class Book extends LibraryItem
{
    // isbn, author, noOfPages, publisher 
    //title , itemCode , cost , timesBorrowed ,  onLoan
    private long isbn;
    private String author;  
    private LibraryItem libraryItem ;
    private static final int NUMBER_OF_FIELDS = 2;
    private static final int AUTHOR=0,ISBN=1;
    /**
     * Constructor for objects of class Book
     */
    public Book(String author,long isbn,int noOfPages,String publisher,String title ,String itemCode ,int cost ,int timesBorrowed ,boolean onLoan) 
    {
        super();
        // set parameters to variables
        this.author = author;
        this.isbn = isbn;
        super.setNoOfPages(noOfPages);
        super.setPublisher(publisher);
        super.setTitle(title);
        super.setItemCode(itemCode);
        super.setCost(cost);
        super.setTimesBorrowed(timesBorrowed);
        super.setOnLoan(onLoan);
    }
    
    /**
     * Constructor for objects of class Book
     */
    public Book(String author,long isbn, LibraryItem libraryItem) 
    {
        super();
        // set parameters to variables
        this.author = author;
        this.isbn = isbn;
        this.libraryItem = libraryItem;
    }

    // public Book() 
    // {
    // set parameters to variables
    // author = "";
    // isbn = 0;
    // }
    // read method in subclasses

    /**
     * Returns the international isbn number for the book item
     * @return  the isbn of the book item
     */
    private long getIsbn()
    {
        return isbn;
    }

    /**
     * Returns the name of the author of the book
     * @return  the author of the book item
     */
    private String getAuthor()
    {
        return author;
    }

    /**
     * Changes the name of the author of the book
     * @param  the author of the book item
     */
    public void setAuthor(String author)
    {
        this.author = author;
    }

    /**
     * Changes the isbn of the book
     * @param the isbn of the book item
     */
    public void setIsbn(long isbn)
    {
        this.isbn = isbn;
    }

    /**
     * print details about the book 
     * @Override
     */
    public void printDetails()
    {
        //author and isbn
        //@override
        super.printDetails();
        System.out.println("Author:"+author+"/n ISBN:"+isbn);
    }

    /**
     * returns true if there is a book, false if not
     */
    public boolean hasBook()
    {
        return (this != null);
    }

    /**
     * returns this object
     */
    public Book getBook()
    {
        return this;
    }

    /**
     *reads book data 
     *@param scanner
     **/
    public void readData(Scanner line) 
    {
        //second scanner with useDelimiter() for processing lineOfText
        line.useDelimiter(",");
        //read unique fields author and isbn
        author = line.next();
        isbn = line.nextLong(); 
        //read the data in the superclass
        super.readData(line);
        //get libraryItem from SuperClass
        libraryItem = getLibraryItem();
        //Book book = new Book(author,isbn,libraryItem);
        //superclass method in Library
        storeLibraryItem(this);
        line.close();
    }

    /**
     * checks whether the LibraryItem obj is equal to Book or Periodical
     * if periodical access fields
     * @Override Object method equals()
     */
    public boolean equals(Book book)
    {
        if (this == book)
        {return true; //reference equality
        }
        if(!(book instanceof Book)) //not book
        {return false;
        }
        Book other = (Book) book;
        return other.equals(book) && other.getAuthor() == author &&
        other.getIsbn() == isbn;
    }
    
    public int hashCode()
    {
        int prime = 7;
        int result = 24 * prime + author.hashCode();
        return result;
    }

    /**
     * toString method of Book
     * 
     * @Override object method toString()
     */
    public String toString()
    {
        String text = "Author: "+author +"ISBN: "+ isbn;
        return text + super.toString();
    }
    

}
