package data;

import entities.JobProfile;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface JobProfileDAO extends DAO<JobProfile, ObjectId> {
}
