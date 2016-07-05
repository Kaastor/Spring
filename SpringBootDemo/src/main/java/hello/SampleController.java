package hello;

/**
 * Created by Przemek on 2016-07-05.
 */
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller //HTTP requests are handled by a controller
@EnableAutoConfiguration
public class SampleController {

    @RequestMapping("/") //any HTTP request with the path “/” should be mapped to the home method
    @ResponseBody
    String home() {
        return "Hello World!";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
}
