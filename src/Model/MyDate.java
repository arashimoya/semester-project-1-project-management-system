package Model;
import java.io.Serializable;
import java.util.GregorianCalendar;

/**
 * A class representing date
 * @author Dan
 * @version 1
 */
public class MyDate  implements Serializable {
  private int day;
  private int month;
  private int year;

  /**
   * Sets the value of the day instance
   * @param day day of the month
   * @throws IllegalDateException if day instance is lesser than 1 and greater than
   * 31
   */
  public void setDay(int day)  throws IllegalDateException {
    if (day >= 1 && day <= 31)
      this.day = day;
    else throw new IllegalDateException();
  }

  /**
   * Sets the value of the month instance
   * @param month month
   * @throws IllegalDateException if month instance is lesser than 1 and greater
   * than 12
   */
  public void setMonth(int month)  throws IllegalDateException {
    if (month >= 1 && month <= 12)
      this.month = month;
    else throw new IllegalDateException();
  }

  /**
   * Sets the value the year instance
   * @param year year
   * @throws IllegalDateException if year instance is lesser than 1 and greater
   * than 9999
   */
  public void setYear(int year)  throws IllegalDateException {
    if (year >= 1 && year <= 9999)
      this.year = year;
    else throw new IllegalDateException();
  }

  /**
   * Gets the value of the day instance
   * @return day
   */
  public int getDay(){
    return day;
  }

  /**
   * Gets the value of the month instance
   * @return month
   */
  public int getMonth(){
    return month;
  }

  /**
   * Gets the value of the year instance
   * @return year
   */
  public int getYear(){
    return year;
  }

  /**
   * No-argument constructor initializing MyDate Object with current date
   */
  public MyDate(){
    GregorianCalendar currentDateConstructor = new GregorianCalendar();
    this.day = currentDateConstructor.get(GregorianCalendar.DATE);
    this.month = currentDateConstructor.get(GregorianCalendar.MONTH) + 1;
    this.year = currentDateConstructor.get(GregorianCalendar.YEAR);
  }

  /**
   * 3-argument constructor initializing MyDate object with parameters listed
   * below
   * @param day day of the month
   * @param month month
   * @param year year
   * @throws IllegalDateException if incorrect date is entered
   */
  public MyDate(int day, int month, int year) throws IllegalDateException {
    if (day >= 1 && day <= 31)
      this.day = day;
    else
      throw new IllegalDateException();
    if (month >= 1 && month <= 12)
      this.month = month;
    else
      throw new IllegalDateException();
    if (year >= 1 && year <= 9999)
      this.year = year;
    else
      throw new IllegalDateException();
  }

  public String toString(){
    return day + "/" + month + "/" + year;
  }

  /**
   * Checks if given year is a leap year
   * @return true or false
   */
  public boolean isLeapYear(){
    if (this.year > 0 & this.year < 10000) {
      if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
        return true;
      else
        return false;
    }else
      return false;
  }

  /**
   * Checks the number of days in inputted month
   * @param month month
   * @return number of days
   */
  public int daysInMonth(int month){

    switch (month) {
      case 1 :
        return 31;
      case 2 :
        return 28;
      case 3 :
        return 31;
      case 4 :
        return 30;
      case 5 :
        return 31;
      case 6 :
        return 30;
      case 7 :
        return 31;
      case 8 :
        return 31;
      case 9 :
        return 30;
      case 10 :
        return 31;
      case 11 :
        return 30;
      case 12 :
        return 31;
      default:
        return 0;
    }
  }

  /**
   * A method returning the name of inputted month
   * @param monthNum month to be checked
   * @return month name
   */
  public String getMonthName(int monthNum){
    switch(monthNum) {
      case 1:
        return "January";
      case 2:
        return "February";
      case 3:
        return "March";
      case 4:
        return "April";
      case 5:
        return "May";
      case 6:
        return "June";
      case 7:
        return "July";
      case 8:
        return "August";
      case 9:
        return "September";
      case 10:
        return "October";
      case 11:
        return "November";
      case 12:
        return "December";
      default:
        //probably change later
        return "Invalid month";
    }
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    MyDate myDate = (MyDate) o;

    if (getDay() != myDate.getDay()) return false;
    if (getMonth() != myDate.getMonth()) return false;
    return getYear() == myDate.getYear();
  }

  /**
   * Method copying a MyDate object
   * @return copy of MyDate object
   */
  public MyDate copy(){
    MyDate date;
    try
  {
    date = new MyDate(this.day, this.month, this.year);
  }
  catch (IllegalDateException e){
      return null;
  }
    return date;
  }

  /**
   * A method returning current date
   * @return currentDateObj
   * @throws IllegalDateException _______
   */
  public static MyDate today() throws IllegalDateException{
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    MyDate currentDateObj = new MyDate(currentDay, currentMonth, currentYear);
    return currentDateObj;
  }

  /**
   * A method checking if inputted date is before a date
   * @param obj inputted object
   * @return false/true
   */
  public boolean isBefore (MyDate obj){
    if (this.year > obj.getYear()){
      return false;
    }
    else if (this.year < obj.getYear()){
      return true;
    }
    else {
      if (this.month > obj.getMonth()){
        return false;
      }
      else if (this.month < obj.getMonth()){
        return true;
      }
      else {
        if (this.day > obj.getDay()){
          return false;
        }
        else if (this.day < obj.getMonth()){
          return true;
        }
        else {
          return false;
        }
      }
    }
  }


}