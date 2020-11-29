package Model;

public class MyDate {

  private int day;
  private int month;
  private int year;

  public MyDate()
  {
    this.day = 0;
    this.month = 0;
    this.year = 0;
  }

  public MyDate(int day, int month, int year)
  {
    this.day = day;
    this.month = month;
    this.year = year;
  }

  public MyDate(MyDate obj) {
    this.day = obj.day;
    this.month = obj.month;
    this.year = obj.year;
  }

  public int getDay()
  {
    return day;
  }

  public int getMonth()
  {
    return month;
  }

  public int getYear()
  {
    return year;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public MyDate copy() {
    return new MyDate(day, month, year);
  }

  public String toString()
  {
    return "Day: " + day + ", Month: " + month
        + ", Year: " + year;
  }

  public boolean equals(Object o) {
    if(!(o instanceof MyDate)) {
      return false;
    }

    MyDate other = (MyDate) o;

    return day == other.day
        && month == other.month
        && year == other.year;
  }

  /* To be edited
  public int timeToDeadline()
  {
    if ();

    return ;
  }
*/

    public boolean isLeapYear(int year)
    {
      if (year % 400 == 0 || year % 4 == 0 && year % 100 != 0)
      {
        return true;
      }
      else
      {
        return false;
      }
    }

  public int getDaysInMonth(int month)
    {
      switch (month)
      {
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
          return 31;

        case 4:
        case 6:
        case 9:
        case 11:
          return 30;
        case 2:
          if (!isLeapYear(year))
          {
            return 28;
          }
          else
          {
            return 29;
          }
        default:
          return 0;
      }
    }

  public String getMonthName(int month)
  {
    switch (month)
    {
      case 1:
      case 12:
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
        return "November";

      case 11:
        return "December";

      default:
        return "Error in converting the month number to string";

    }
  }

  public boolean isBefore(MyDate obj)
    {
      if (obj.getYear() < year)
      {
        return false;
      }
      else if (obj.getYear() == year && obj.getMonth() < month)
      {
        return false;
      }
      else if (obj.getYear() == year && obj.getMonth() == month
          && obj.getDay() < day)
      {
        return false;
      }
      return true;
    }



}
