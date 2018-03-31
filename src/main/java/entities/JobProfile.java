package entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.ArrayList;
import java.util.List;

@Entity("profile")
@Indexes({
        @Index(value = "link", fields = @Field(""))
})
public class JobProfile {

    @Id
    private ObjectId id;

    @Property("name")
    private String profileName;

    @Reference
    private List<Employee> employees;

    public JobProfile() {
    }

    public JobProfile(String profileName) {
        this.id = new ObjectId();
        this.profileName = profileName;
        this.employees = new ArrayList<>(0);
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}
