package Model;

import java.io.Serializable;

/**
 * A class representing a customer
 * @author eminem
 * @version ?
 */
public class Customer implements Serializable {
  private int id;
  private String name;

  /**
   * 2-argument constructor letting user to enter parameters below:
   * @param id    id of the customer
   * @param name  name of the customer
   */
  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  /**
   * Getter for id variable
   * @return id
   */
  public int getId() {
    return id;
  }

  /**
   * Getter for name variable
   * @return name
   */
  public String getName()
  {
    return name;
  }

  /**
   * Setter for name variable
   * @param name name of customer
   */
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Customer customer = (Customer) o;

    if (getId() != customer.getId()) return false;
    return getName() != null ? getName().equals(customer.getName()) : customer.getName() == null;
  }


  @Override public String toString()
  {
    return "Customer{" + "id=" + id + ", name='" + name + '\'' + '}';
  }

}
