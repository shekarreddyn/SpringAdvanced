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
    public List<Employee> getEmployeeBasedOnAge(@RequestBody Company company){

        List<Employee> employeeList = company.getEmployeeList();
        List<Employee> empAgeList = new ArrayList<Employee>();

        for(Employee employee:employeeList){

            if(employee.getAge()>22){

                empAgeList.add(employee);

            }
        }
        return empAgeList;
    }


}
