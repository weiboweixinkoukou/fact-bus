import com.woter.fact.bus.test.MainConfig;
import com.woter.fact.bus.test.User;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

public class TestUser {
    @Test
    public void test1() {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        User user = ac.getBean(User.class);
        System.out.println(user);
        ac.registerShutdownHook();
    }

    @Test
    public void test2() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(MainConfig.class);
        applicationContext.close();
    }

}
