package application;

import data.EmployeeDAO;
import data.EmployeeDAOImpl;
import data.JobProfileDAO;
import data.JobProfileDAOImpl;
import data.service.MorphiaService;
import data.service.MorphiaServiceImpl;
import entities.Employee;
import entities.JobProfile;

public class Application {

    private static final String DB_NAME = "morphia-example";
    private final EmployeeDAO employeeDAO;
    private final JobProfileDAO jobProfileDAO;

    public Application() {

        MorphiaService morphiaService = new MorphiaServiceImpl(DB_NAME);
        employeeDAO = new EmployeeDAOImpl(morphiaService.getDatastore());
        jobProfileDAO = new JobProfileDAOImpl(morphiaService.getDatastore());

    }

    void insertData() {

        JobProfile devProfile = new JobProfile("Developer");
        JobProfile mgrProfile = new JobProfile("Manager");

        Employee emp1 = new Employee("Harsh", 250.0D);
        emp1.setJobProfile(devProfile);

        Employee manager = new Employee("Harman", 3200000.0D);
        manager.setJobProfile(mgrProfile);

        emp1.setManager(manager);

        jobProfileDAO.save(devProfile);
        jobProfileDAO.save(mgrProfile);

        employeeDAO.save(emp1);
        employeeDAO.save(manager);

    }

    void updateData() {

        // had to disable validation
        employeeDAO.createQuery().forEach(employee -> {
            employee.setCompany("sapient");
            employeeDAO.save(employee);
        });
    }

    void readWithJoin() {
        employeeDAO.createQuery().field("name").equalIgnoreCase("harsh").forEach(harsh -> {
            System.out.println(harsh.getManager().getName() + " guides harsh");
        });
    }


}
