package Model;

import java.util.Objects;

/**
 *
 * @author alex
 * @version 1.0
 */
public class TeamMember {
  private int id;
  private String name;

  public TeamMember(String name){
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


  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    TeamMember that = (TeamMember) o;
    return id == that.id && Objects.equals(name, that.name);
  }

  @Override
  public String toString() {
    return "TeamMember{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
