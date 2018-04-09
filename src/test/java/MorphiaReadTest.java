import data.service.MorphiaService;
import data.service.MorphiaServiceImpl;
import entities.MovieDetails;
import entities.Person;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class MorphiaReadTest {

    private static final String DB_NAME = "video";
    private MorphiaService morphiaService;
    private MovieDetailsDAO movieDetailsDAO;

    @Before
    public void setup() {

        morphiaService = new MorphiaServiceImpl(DB_NAME);
        movieDetailsDAO = new MovieDetailsDAO(morphiaService.getDatastore());

    }


    @Test
    public void readTest() {
        movieDetailsDAO.createQuery().field("year").equal(2014).field("rated").equalIgnoreCase("R").forEach(movie -> {
            System.out.println(movie);
            movie.setType("morphiaMovie");
            movieDetailsDAO.save(movie);
        });

    }


}

class MovieDetailsDAO extends BasicDAO<MovieDetails, ObjectId> {
    public MovieDetailsDAO(Datastore ds) {
        super(MovieDetails.class, ds);
    }
}