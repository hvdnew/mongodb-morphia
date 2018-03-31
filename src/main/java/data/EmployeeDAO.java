package data;

import entities.Employee;
import org.bson.types.ObjectId;
import org.mongodb.morphia.dao.DAO;

public interface EmployeeDAO extends DAO<Employee, ObjectId> {


}
