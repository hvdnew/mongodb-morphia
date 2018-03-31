package data;

import entities.JobProfile;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class JobProfileDAOImpl extends BasicDAO<JobProfile, ObjectId> implements JobProfileDAO {

    public JobProfileDAOImpl(Datastore ds) {
        super(JobProfile.class, ds);
    }

}
