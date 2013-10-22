package springjpaexample.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.dao.DumplingSpecificationDao;
import springjpaexample.domain.DumplingSpecs;

import java.util.List;

import static org.springframework.data.jpa.domain.Specifications.where;
import static springjpaexample.domain.DumplingSpecs.*;

public class SpecificationExample extends SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());
    private DumplingSpecificationDao dumplingSpecificationDao;

    public static void main(String[] args) {
        new SpecificationExample().run();
    }

    private void run() {

        initialise();
        dumplingSpecificationDao = context.getBean(DumplingSpecificationDao.class);

        List quicklyEatenDumplings = dumplingSpecificationDao.findAll(eatenQuickly());
        log.info("\n\n\n DUMPLINGS EATEN QUICKLY = " + dumplingSpecificationDao.count(eatenQuickly()) + "\n");
        logDumplings(quicklyEatenDumplings);

        List quickOrSlowlyEatenDumplings = dumplingSpecificationDao.findAll(where(eatenSlowly()).or(eatenQuickly()));
        log.info("\n\n\n DUMPLINGS EATEN QUICKLY OR SLOWLY = "
                + dumplingSpecificationDao.count(where(eatenSlowly()).or(eatenQuickly())) + "\n");
        logDumplings(quickOrSlowlyEatenDumplings);
    }
}
