package hello;

/**
 * Created by Przemek on 2016-07-05.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.*;

/*The example above shows the basic concept of dependency injection, the
 MessagePrinter is decoupled from the MessageService implementation, with
 Spring Framework wiring everything together. */
@Configuration //class can be used by the Spring IoC container as a source of bean definitions
// Your configuration class can have declaration for more than one @Bean
@ComponentScan
public class Application {

    @Bean //method annotated with @Bean will return an object that should be registered as a bean in the Spring application context
    //w klasie Application jest definicja tworzenia klasy MessageService

    MessageService mockMessageService() { //implementation of MessageService
        return new MessageService() {
            public String getMessage() {
                return "Hello World!";
            }
        };
    }

    public static void main(String[] args) {
        //Once your configuration classes are defined, you can load & provide them to Spring container using AnnotationConfigApplicationContext
        //Some Spring code in AnnotationConfigApplicationContext discovers the mockMessageService annotated with @Bean
        ApplicationContext context =
                new AnnotationConfigApplicationContext(Application.class);
        MessagePrinter printer = context.getBean(MessagePrinter.class); //Spring goes and loads the MessagePrinter class
        //notices that it has an annotation @Component which means Spring is responsible for instantiating this class
        //and the objects it depends on (MessageService)
        //Spring goes and then looks for @AutoWired
        //It notices that @AutoWired takes an instance of MessageService... which it then realizes <-- BEAN INJECTION
        //it has available because mockMessageService was annotated with @Bean.
        //Spring "injects" mockMessageService into MessagePrinter and returns to the programmer an instance of MessagePrinter.
        printer.printMessage(); //hello world print
    }
}
