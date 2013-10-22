package springjpaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springjpaexample.dao.DumplingDao;
import springjpaexample.dao.EaterDao;
import springjpaexample.domain.Dumpling;
import springjpaexample.wiring.TestDataConfig;

import java.util.Collection;

public abstract class SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());
    protected DumplingDao dumplingDao;
    protected EaterDao eaterDao;
    protected ApplicationContext context = new AnnotationConfigApplicationContext(TestDataConfig.class);

    protected void initialise() {
        log.info(" ***************************** BEANS ****************************");
        for (String beanName : context.getBeanDefinitionNames()) {
            log.info(beanName);
        }
        log.info(" ***************************** END BEANS ****************************");

        dumplingDao = context.getBean(DumplingDao.class);
        eaterDao = context.getBean(EaterDao.class);

        context.getBean(DataGenerator.class).createDumplings();

    }


    protected void logDumplings(Collection<Dumpling> dumplings) {
        for (Dumpling dumpling : dumplings) {
            log.info(dumpling +"");
        }
    }

}
