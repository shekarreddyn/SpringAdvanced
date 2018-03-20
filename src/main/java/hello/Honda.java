package hello;


import org.springframework.web.bind.annotation.*;
import sun.misc.Request;

@RestController
@RequestMapping("/honda")
public class Honda {

    @RequestMapping(value = "/anyCar", method = RequestMethod.POST)
    public String index(@RequestParam("carName") String name, @RequestParam("makeYear") Integer makeYear) {

        return name+ " car Make year "+ makeYear+"!";
    }


    @RequestMapping(value = "/avalon")
    public String welcome(){
        return " Honda Civic  car make year 2013";
    }

    @RequestMapping(value = "/insertCar", method = RequestMethod.POST)
    public String insertCar(Car car){

        return "Car inserted";

    }
}
