package Model;

import java.io.Serializable;

public class Customer implements Serializable {
  private int id;
  private String name;

  public Customer(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName()
  {
    return name;
  }

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
