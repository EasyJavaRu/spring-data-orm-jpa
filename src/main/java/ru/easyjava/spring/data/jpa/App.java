package ru.easyjava.spring.data.jpa;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.easyjava.spring.data.jpa.dao.GreeterDao;
import ru.easyjava.spring.data.jpa.entity.Greeter;
import ru.easyjava.spring.data.jpa.service.GreeterService;

/**
 * Simple example of JDBC usage.
 */
public final class App {
    /**
     * Do not construct me.
     */
    private App() {
    }

    /**
     * Entry point.
     *
     * @param args Command line args. Not used.
     */
    public static void main(final String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("/applicationContext.xml");
        GreeterService greeterService = context.getBean(GreeterService.class);
        GreeterDao dao = context.getBean(GreeterDao.class);

        Greeter greeter = new Greeter();
        greeter.setGreeting("Hello");
        greeter.setTarget("World");

        dao.addGreet(greeter);

        System.out.println(greeterService.greet());

        System.exit(0);
    }
}
