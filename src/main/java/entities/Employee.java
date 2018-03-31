package entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

@Entity("employees") // by default uses class-name
@Indexes(
        @Index(value = "salary", fields = @Field("salary"))
)
public class Employee {
    @Id
    private ObjectId id;

    private String name;

    private String company;

    @Reference
    private Employee manager;

    @Property("wage") // similar to JPA's @Column
    private Double salary;

    @Reference
    private JobProfile jobProfile;

    public Employee(){}

    public Employee(String name, Double salary) {
        this.id = new ObjectId();
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee getManager() {
        return manager;
    }

    public void setManager(Employee manager) {
        this.manager = manager;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public JobProfile getJobProfile() {
        return jobProfile;
    }

    public void setJobProfile(JobProfile jobProfile) {
        this.jobProfile = jobProfile;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
