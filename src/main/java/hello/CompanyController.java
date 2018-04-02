package hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @RequestMapping(value = "/getCompany", method = RequestMethod.POST)
    public Company getCompany(@RequestBody Company company) {

        System.out.println(company.getCompanyName());

        return company;
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.POST)
    public Employee getEmployee(@RequestBody Company company) {

        List<Employee> employeeList = company.getEmployeeList();

        Employee shekar = null;

        for (Employee emp : employeeList) {

            if (emp.getEmployeeName().equals("Shekar")) {

                shekar = emp;
            }
        }

        return shekar;
    }

    @RequestMapping(value = "/getEmployeeByAge", method = RequestMethod.POST)
    public List<Employee> getEmployeeBasedOnAge(@RequestBody Company company) {

        List<Employee> employeeList = company.getEmployeeList();
        List<Employee> empAgeList = new ArrayList<Employee>();

        for (Employee employee : employeeList) {

            if (employee.getAge() > 22) {

                empAgeList.add(employee);

            }
        }
        return empAgeList;
    }

    @RequestMapping(value = "/uniqueNames", method = RequestMethod.POST)
    public List<Employee> getUniqueNames(@RequestBody Company company) {
        Set<String> employeeSet = new HashSet<String>();
        List<Employee> employeeList = company.getEmployeeList();

        for (Employee employee : employeeList) {
            employeeSet.add(employee.getEmployeeName());
        }
        for (String uniqueNameSet : employeeSet) {

            System.out.println(uniqueNameSet);
        }

        return employeeList;
    }


    @RequestMapping(value="/sumOfEmployeesSalary", method = RequestMethod.POST)
    public int sumOfEmployeesSalary(@RequestBody Employee employee){


                List<Employee> empAgeList = new ArrayList<Employee>();

        int sumOfEmployeesSalary = 0;

        int a = employee.getSalary();

        sumOfEmployeesSalary = a + sumOfEmployeesSalary;

        return sumOfEmployeesSalary;
    }



// find the avg age of all employees
    @RequestMapping(value="/sumOfEmployeesSalary", method = RequestMethod.POST)
    public int avgAgeOfEmployees(@RequestBody Employee employee){

        int avgAgeOfEmployees = 0;

        int employeeAge[] = employee.getAge();

        int a = employee.getSalary();

        sumOfEmployeesSalary = a + sumOfEmployeesSalary;

        return sumOfEmployeesSalary;
    }


}