
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
        Email email = new Email();
        String reciever = "ldz2012yn@gmail.com";
        email.setTo(reciever);

        for (int i=0; i<1; i++) {
            System.out.println("邮件尝试发送次数"+(i+1));
            emailProducerService.sendMsg(destination, email,true);
          /*  try {
                //Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
        }


        try {
            Thread.sleep(40000);  //防止spring容器关闭
        } catch (Exception e) {
            e.printStackTrace();
        }
    }







}
