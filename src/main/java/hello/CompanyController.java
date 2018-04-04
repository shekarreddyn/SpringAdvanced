package hello;

import org.springframework.web.bind.annotation.*;

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
    public int sumOfEmployeesSalary(@RequestBody Company company) {

        List<Employee> employeeList = company.getEmployeeList();
        int sumOfSalary =0;

        for(Employee employeeDetails : employeeList){

            sumOfSalary = sumOfSalary + employeeDetails.getSalary();
        }
        return sumOfSalary;

    }




// find the avg age of all employees
    @RequestMapping(value="/avgAgeOfEmployees", method = RequestMethod.POST)
    public int avgAgeOfEmployees(@RequestBody Company company){

        int ageOfEmployees = 0;
        int avgAgeOfEmployees = 0;

        List<Employee> employeeList = company.getEmployeeList();

        if(employeeList.size() > 0) {

            for (Employee employeeDetails : employeeList) {

                ageOfEmployees = ageOfEmployees + employeeDetails.getAge();
            }

            avgAgeOfEmployees = ageOfEmployees / employeeList.size();
            return avgAgeOfEmployees;
        }

        else {
            return 0;
        }
    }

    @RequestMapping(value = "/getEmployeeByName", method = RequestMethod.POST)
    public  Employee getEmployeeByName(@RequestBody Company company, @RequestParam("employeeName") String employeeName){

        Employee resultEmployee = null;
        List<Employee> employeeList = company.getEmployeeList();

        for (Employee employeeDetails : employeeList) {

            if(employeeDetails.getEmployeeName().equals(employeeName)){

                resultEmployee = employeeDetails;
                break;
            }
        }

        return resultEmployee;

    }

    @RequestMapping(value = "/getEmployees", method = RequestMethod.POST)
    public List<Employee> getEmployees(@RequestBody Company company , @RequestParam("employeeName") String employeeName) {

        Employee resultEmployee = null;
        List<Employee> employeeList = company.getEmployeeList();
         List<Employee> sameEmployeeList = new ArrayList<Employee>();

        for (Employee employeeDetails : employeeList) {

            if(employeeDetails.getEmployeeName().equalsIgnoreCase(employeeName)){

                sameEmployeeList.add(employeeDetails);

            }
        }
        return sameEmployeeList;

    }


    @RequestMapping(value = "/getEmployeesBySalRange", method = RequestMethod.POST)
    public List<Employee> getEmployeesBySalRange(@RequestBody Company company , @RequestParam("employeeName") String employeeName, @RequestParam("maxSalary") Integer maxSalary, @RequestParam("minSalary") Integer minSalary, @RequestHeader("authenticationToken") String authenticationToken) {

        if (authenticationToken.equals("*#06#")) {
            Employee resultEmployee = null;
            List<Employee> employeeList = company.getEmployeeList();
            List<Employee> sameEmployeeList = new ArrayList<Employee>();

            for (Employee employeeDetails : employeeList) {

                if (employeeDetails.getEmployeeName().equalsIgnoreCase(employeeName) && employeeDetails.getSalary() > minSalary && employeeDetails.getSalary() < maxSalary) {

                    sameEmployeeList.add(employeeDetails);

                }
            }
            return sameEmployeeList;

        }
        else {
            return null;
        }
    }
}