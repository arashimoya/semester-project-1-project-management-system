package Model;

public class Customer {
  private int id;
  private String name;

  public Customer(int id, String name) {
    this.id = id.copy();
    this.name = name.copy();
  }

  public getId() {
    return id.copy();
  }

  public String getName()
  {
    return name.copy();
  }

  public void setName(String name) {
    this.name = name.copy();
  }
}
