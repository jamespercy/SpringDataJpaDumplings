package springjpaexample.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.dao.DumplingQueryDao;
import springjpaexample.dao.UberDumplingDao;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.FillingType;

import java.util.Collection;

public class QueryExamples extends SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());
    private DumplingQueryDao queryDumplingDao;

    public static void main(String[] args) {
        new QueryExamples().run();
    }

    private void run() {
        //creates context, db and some initial test data
        initialise();

        Collection<Dumpling> dumplings = queryDumplingDao.findByTimeDevouredIn(3);
        logDumplings(dumplings);

        dumplings = queryDumplingDao.findDumplingsWithFilling(FillingType.TOFU);
        logDumplings(dumplings);

        int updated = queryDumplingDao.updateFilling(FillingType.CHICKEN_AND_PRAWN, FillingType.PORK);
        log.info(updated + "dumplings where updated");
        dumplings = queryDumplingDao.findDumplingsWithFilling(FillingType.PORK);
        log.info("There are " + dumplings.size() + " pork dumplings left");

    }

    public void initialise() {
        super.initialise();
        queryDumplingDao = context.getBean(DumplingQueryDao.class);
    }
}
