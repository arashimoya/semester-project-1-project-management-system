package Model;

public class TeamMember {
  private int id;
  private String name;

  public TeamMember(int id, String name){
    this.id=id;
    this.name=name;
  }
  public int getId(){
    return id;
  }
  public String getName(){
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
}
