import java.util.Scanner;
import java.io.*;
/**
 *  class Periodical 
 *  has methods for accessing and changing publication date
 *
 * @author (Simone Bamber)
 * @version (28/04/20)
 */
public class Periodical extends LibraryItem
{
    // publicationDtae format xx-xx-xx
    private String  publicationDate;
    private int day;
    private int month;
    private int year;
    private LibraryItem libraryItem ;
    private static final int NUMBER_OF_FIELDS = 3;
    private static final int DAY=0,MONTH=1,YEAR=2;
    // /**
     // * Constructor for objects of class Periodical
     // * keep to 2 digits per int answer
     // * format xx-xx-xx e.g 01-01-01 (hyphens will be added automatically)
     // * @Param first three param are int - day, month, year
     // */
    // public Periodical(int day,int month,int year,int noOfPages,String publisher,String title ,String itemCode ,int cost ,int timesBorrowed ,boolean onLoan)
    // {
        // super();
        // this.day = day;
        // this.month = month;
        // this.year = year;
        // publicationDate = (day + "-" + month + "-" + year);
        // //create new libraryItem to store periodical data
        // super.setNoOfPages(noOfPages);
        // super.setPublisher(publisher);
        // super.setTitle(title);
        // super.setItemCode(itemCode);
        // super.setCost(cost);
        // super.setTimesBorrowed(timesBorrowed);
        // super.setOnLoan(onLoan);
    // }

    // /**
     // * Constructor for objects of class Periodical
     // * keep to 2 digits per int answer 
     // * format xx-xx-xx e.g 01-01-01 (include hyphenation in String publicationDate)
     // * @param first param String - publicationDate
     // */
    // public Periodical(String publicationDate,int noOfPages,String publisher,String title ,String itemCode ,int cost ,int timesBorrowed ,boolean onLoan) 
    // {
        // super();
        // this.publicationDate = publicationDate;
        // //create new libraryItem to store periodical data
        // super.setNoOfPages(noOfPages);
        // super.setPublisher(publisher);
        // super.setTitle(title);
        // super.setItemCode(itemCode);
        // super.setCost(cost);
        // super.setTimesBorrowed(timesBorrowed);
        // super.setOnLoan(onLoan);
    // }
    
    /**
     * Constructor for objects of class Periodical
     * keep to 2 digits per int answer 
     * format xx-xx-xx e.g 01-01-01 (include hyphenation in String publicationDate)
     * @param first param String - publicationDate
     */
    public Periodical(String publicationDate,LibraryItem libraryItem) 
    {
        super();
        this.publicationDate = publicationDate;
        //create new libraryItem to store periodical data
        this.libraryItem = libraryItem;
    }

    /**
     * Constructor for objects of class Periodical
     * keep to 2 digits per int answer 
     * format xx-xx-xx e.g 01-01-01 (include hyphenation in String publicationDate)
     * @param first param String - publicationDate
     */
    public Periodical(int day,int month,int year,LibraryItem libraryItem) 
    {
        super();
        this.publicationDate = publicationDate;
        this.day = day;
        this.month = month;
        this.year = year;
        publicationDate = (day + "-" + month + "-" + year);
        //create new libraryItem to store periodical data
        this.libraryItem = libraryItem;
    }
    
    // public void Periodical() 
    // {
    // day = 00;
    // month = 00;
    // year = 00;
    // }

    /**
     * shows the publication date
     * @return   publicationDate
     */
    public String getPublicationDate()
    {
        return publicationDate;
    }

    /**
     * set / change the publication date day
     * @param  publicationDate day 
     */
    public void setPublicationDateDay(int day)
    {
        this.day = day;
    }

    /**
     * set / change the publication date month 
     * @param  publicationDate month
     */
    public void setPublicationDateMonth(int month)
    {
        this.month = month;
    }

    /**
     * set / change the publication date year 
     * @param  publicationDate year
     */
    public void setPublicationDateYear(int year)
    {
        this.year = year;
    }

    public void setPublicationDate()
    {
        publicationDate = (day+"-"+month+"-"+year);
    }

    public void setPublicationDate(String publicationDate)
    {
        this.publicationDate = publicationDate;
    }

    /**
     * set / change publication date manually enter 2 digit numbers
     * for day , month and year
     * format xx-xx-xx e.g 01-01-01
     */
    public void setPublicationDate(int day, int month, int year)
    {
        this.day=day;
        this.month=month;
        this.year=year;
        publicationDate = (day+"-"+month+"-"+year);
    }

    /**
     * return the publication date day
     * @return int publication date day 
     */
    public int getPublicationDateDay()
    {
        return day;
    }

    /**
     * return the publication date day
     * @return int publication date day 
     */
    public int getPublicationDateMonth()
    {
        return month;
    }

    /**
     * return the publication date day
     * @return int publication date day 
     */
    public int getPublicationDateYear()
    {
        return year;
    }

    /**
     * print details about periodicals to the terminal
     */
    public void printDetails()
    {
        //publicationDate and 
        super.printDetails();
        System.out.println("Date of Publication:"+publicationDate);
    }

    /**
     * return unique fields 
     * publicationDate to String
     * param String publicationDate
     * return ints day, month and year
     */
    public void publicationDateToInt(String publicationDate)
    {
        Scanner toInt = new Scanner(publicationDate); 
        //Seperate at the hyphen
        toInt.useDelimiter("-");
        while (toInt.hasNext())
        {
            day = toInt.nextInt();
            month = toInt.nextInt();
            year = toInt.nextInt();
        }
    }

    /**
     *reads periodical data 
     *@param scanner
     **/
    public void readData(Scanner line) 
    {
        //second scanner with useDelimiter() for processing lineOfText
        line.useDelimiter("-");
        
        //read unique fields 
        day = line.nextInt();
        month = line.nextInt();
        year = line.nextInt();
        //read the data in the superclass
        super.readData(line);
        libraryItem = getLibraryItem(); 
        //create object to store in arraylist
        //Periodical periodical = new Periodical(day,month,year,libraryItem);
        //superclass method in Library
        storeLibraryItem(this);
        line.close();
}
    
    /**
     * returns true if there is a periodical, false if not
     */
    public boolean hasPeriodical()
    {
        return (this != null);
    }

    /**
     * returns this object
     */
    public Periodical getPeriodical()
    {
        return this;
    }

    /**
     * checks whether the LibraryItem obj is equal to Book or Periodical
     * if periodical access fields
     * @Override Object method equals()
     */
    public boolean equals(Periodical periodical)
    {
        if (this == periodical)
        {return true; //reference equality
        }
        if(!(periodical instanceof Periodical)) //not Periodical
        {return false;
        }
        Periodical other = (Periodical) periodical;
        return other.equals(periodical) && other.getPublicationDateDay() == day &&
        other.getPublicationDateMonth() == month && other.getPublicationDateYear() == year;
    }
    
    public int hashCode()
    {
        int prime = 3;
        int result = 31 * prime + day +  month + year;
        return result;
    }

    /**
     * toString method of Book
     * 
     * @Override object method toString()
     */
    public String toString()
    {
        String text = getPublicationDate();
        return text + super.toString();
    }
}
