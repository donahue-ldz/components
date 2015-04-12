
import com.email.Email;
import com.jmsAndActive.EmailProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.Destination;

/**
 * Created by ldz on 11/04/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")

public class ProducerConsumerTest {

    @Autowired
    EmailProducerService emailProducerService;

    @Autowired
    @Qualifier("queueDestination")
    private Destination destination;

    @Test
    public void testSend(){
        /*Email email = new Email();
        email.setReciever("donahue");
        email.setSubject("just MessageConverter");
        Another another = new Another();
        another.setName("another name ");
        another.setContext("another context");

        for (int i=0; i<3; i++) {
            email.setContent("today is fine," +i);
            emailProducerService.sendMsg(destination, email);
           *//* try {
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
        }
        emailProducerService.sendMsg(destination,another);

        try {
            Thread.sleep(10000);  //避免容器关闭造成3干扰
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }







}
