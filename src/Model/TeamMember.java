package Model;

import java.io.Serializable;
import java.util.Objects;

/**
 * A class representing a team member
 * @author Dan
 * @version 1.0
 */
public class TeamMember implements Serializable {
    private int id;
    private String name;

    /**
     * A two-argument constructor
     * @param id id of the team member
     * @param name name of the team member
     */
    public TeamMember(int id, String name) {
        this.name = name;
        this.id = id;
    }

    /**
     * Gets the ID of the team member
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the name of the team member
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the team member
     * @param name name of the team member
     */
    public void setName(String name) {
        this.name = name;

    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamMember that = (TeamMember) o;

        if (getId() != that.getId()) return false;
        return getName() != null ? getName().equals(that.getName()) : that.getName() == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TeamMember{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
