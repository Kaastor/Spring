package hello;

/**
 * Created by Przemek on 2016-07-05.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // the Class annotated with this annotation should have its creation handled by Spring.
public class MessagePrinter {
    //class MessagePrinter relies on a MessageService in order to provide the actual message that will be printed when
    // System.out.println(...) is invoked from inside <MessagePrinter>.printMessage().

    final private MessageService service;

    @Autowired //when given a Class annotated with @Component (MessagePrinter), and if this @AutoWired annotation is also found
    // then Spring should "look up" the implementation of the type of the thing annotated with @AutoWired (notice how MessageService is just an implementation)
    public MessagePrinter(MessageService service) {
        this.service = service;
    }

    public void printMessage() {
        System.out.println(this.service.getMessage());
    }
}

