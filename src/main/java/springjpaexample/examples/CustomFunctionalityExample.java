package springjpaexample.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.dao.UberDumplingDao;
import springjpaexample.domain.Dumpling;

import java.util.Collection;

public class CustomFunctionalityExample extends SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());

    private UberDumplingDao uberDumplingDao;

    public static void main(String[] args) {
        new CustomFunctionalityExample().run();
    }

    private void run() {
        initialise();

        //calls a custom implementation
        Collection<Dumpling> evenDumplings = uberDumplingDao.fetchDumplingsWithEvenIds();
        logDumplings(evenDumplings);
    }


    public void initialise() {
        super.initialise();
        uberDumplingDao = context.getBean(UberDumplingDao.class);

    }
}
