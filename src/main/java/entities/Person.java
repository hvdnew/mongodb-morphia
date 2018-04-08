package entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

import java.util.List;

@Entity("person")
@Indexes(
        @Index(value = "firstName", fields = @Field("firstName"))
)
public class Person {

    @Id
    private ObjectId id;
    private String firstName;
    private String lastName;

    @Reference
    private Address address;

    @Reference
    private List<Blog> blogs;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
