package entities;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

import java.util.ArrayList;
import java.util.List;

@Entity("state")
public class State {

    @Id
    private ObjectId id;
    private String name;
    private List<String> attractions;

    public State(String name) {
        this.name = name;
        this.attractions = new ArrayList<>(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAttractions() {
        return attractions;
    }

    public void setAttractions(List<String> attractions) {
        this.attractions = attractions;
    }
}
