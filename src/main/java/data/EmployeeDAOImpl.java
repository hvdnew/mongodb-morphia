package data;

import entities.Employee;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;

public class EmployeeDAOImpl extends BasicDAO<Employee, ObjectId> implements EmployeeDAO {

    public EmployeeDAOImpl(Datastore ds) {
        super(Employee.class, ds);

    }
}
