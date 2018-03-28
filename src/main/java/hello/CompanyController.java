package hello;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @RequestMapping(value = "/getCompany", method = RequestMethod.POST)
    public Company getCompany(@RequestBody Company company){

        System.out.println(company.getCompanyName());

        return company;
    }

}
