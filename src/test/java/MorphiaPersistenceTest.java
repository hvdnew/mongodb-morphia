import data.service.MorphiaService;
import data.service.MorphiaServiceImpl;
import entities.*;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

import java.util.ArrayList;
import java.util.List;

public class MorphiaPersistenceTest {

    private static final String DB_NAME = "morphia-example";
    private MorphiaService morphiaService;
    private PersonDAO personDao;
    private AddressDAO addressDAO;
    private StateDAO stateDAO;
    private BlogDAO blogDAO;
    private CommentsDAO commentsDAO;


    @Before
    public void setup() {

        morphiaService = new MorphiaServiceImpl(DB_NAME);

        personDao = new PersonDAO(morphiaService.getDatastore());
        addressDAO = new AddressDAO(morphiaService.getDatastore());
        stateDAO = new StateDAO(morphiaService.getDatastore());
        blogDAO = new BlogDAO(morphiaService.getDatastore());
        commentsDAO = new CommentsDAO(morphiaService.getDatastore());


    }


    @Test
    public void testPersist() {
        Person harsh = new Person("Harshvardhan", "Dadhich");

        State rajasthan = new State("Rajasthan");
        rajasthan.getAttractions().add("Jaipur");
        rajasthan.getAttractions().add("Jodhpur");

        Address address = new Address("addLine1", "addLine2", "122004");
        address.setState(rajasthan);

        harsh.setAddress(address);

        List<Blog> blogs = new ArrayList<>(0);
        Blog blog = new Blog("Let us brew Java with MongoDB", "45 mins content");
        blog.setAuthor(harsh);


        Person attendee1 = new Person("Mr", "Bean");
        Person attendee2 = new Person("Tony", "Stark");

        List<Comment> comments = new ArrayList<>(0);

        comments.add(new Comment("What is OGM?", attendee1));
        comments.add(new Comment("Let's wait till end, he will take questions", attendee2));

        blog.setComments(comments);
        blogs.add(blog);
        //harsh.setBlogs(blogs);


        personDao.save(attendee1);
        personDao.save(attendee2);
        commentsDAO.save(comments.get(0));
        commentsDAO.save(comments.get(1));


        stateDAO.save(rajasthan);
        addressDAO.save(address);

        personDao.save(harsh);

        blogDAO.save(blog);
    }


}


class PersonDAO extends BasicDAO<Person, ObjectId> {
    public PersonDAO(Datastore ds) {
        super(Person.class, ds);
    }
}

class AddressDAO extends BasicDAO<Address, ObjectId> {
    public AddressDAO(Datastore ds) {
        super(Address.class, ds);
    }
}

class StateDAO extends BasicDAO<State, ObjectId> {
    public StateDAO(Datastore ds) {
        super(State.class, ds);
    }
}

class BlogDAO extends BasicDAO<Blog, ObjectId> {
    public BlogDAO(Datastore ds) {
        super(Blog.class, ds);
    }
}

class CommentsDAO extends BasicDAO<Comment, ObjectId> {
    public CommentsDAO(Datastore ds) {
        super(Comment.class, ds);
    }
}

