package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping("/greetings")
    public String index() {
        return "Greetings from Spring Boot!";
    }


    @RequestMapping("/welcome")
    public String welcome(){
        return "<html><head><title>welcome page</title></head><body><h1>Welcome to Spring !!</h1></body></html>";
    }

}
