package Model;
import java.util.GregorianCalendar;

public class MyDate{
  private int day;
  private int month;
  private int year;

  public void setDay(int day)  throws IllegalDateException {
    if (day >= 1 && day <= 31)
      this.day = day;
    else throw new IllegalDateException();
  }

  public void setMonth(int month)  throws IllegalDateException {
    if (month >= 1 && month <= 12)
      this.month = month;
    else throw new IllegalDateException();
  }

  public void setYear(int year)  throws IllegalDateException {
    if (year >= 1 && year <= 9999)
      this.year = year;
    else throw new IllegalDateException();
  }

  public int getDay(){
    return day;
  }

  public int getMonth(){
    return month;
  }

  public int getYear(){
    return year;
  }

  public MyDate(){
    GregorianCalendar currentDateConstructor = new GregorianCalendar();
    this.day = currentDateConstructor.get(GregorianCalendar.DATE);
    this.month = currentDateConstructor.get(GregorianCalendar.MONTH) + 1;
    this.year = currentDateConstructor.get(GregorianCalendar.YEAR);
  }

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

  public MyDate(MyDate obj){
    this.day = obj.getDay();
    this.month = obj.getMonth();
    this.year = obj.getYear();
  }

  public String toString(){
    return day + "/" + month + "/" + year;
  }

  public boolean isLeapYear(){
    if (this.year > 0 & this.year < 10000) {
      if ((this.year % 4 == 0 && this.year % 100 != 0) || (this.year % 400 == 0))
        return true;
      else
        return false;
    }else
      return false;
  }

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

  public MyDate copy(){
    MyDate date = new MyDate(this);
    return date;
  }

  public static MyDate today() throws IllegalDateException{
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentDay = currentDate.get(GregorianCalendar.DATE);
    int currentMonth = currentDate.get(GregorianCalendar.MONTH) + 1;
    int currentYear = currentDate.get(GregorianCalendar.YEAR);
    MyDate currentDateObj = new MyDate(currentDay, currentMonth, currentYear);
    return currentDateObj;
  }

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