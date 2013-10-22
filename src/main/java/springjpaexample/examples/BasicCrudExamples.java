package springjpaexample.examples;

import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.domain.Dumpling;

import java.util.List;

public class BasicCrudExamples extends SpringDataExampleUtils {

    private Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        new BasicCrudExamples().run();
    }

    private void run() {
        //creates context, db and some initial test data
        initialise();
        log.info(" we have initialised " + dumplingDao.count() + " dumplings");

        //OUT OF THE BOX
        //1. get an entity by ID
        getByIdExample();

        //2. find a sorted list
        findSortedListExample();

        //3. find all in a list of IDS
        findAllInListExample();

        //4. exists
        existsExample();

        //5. delete example
        deleteExample();

    }

    private void getByIdExample() {
        Dumpling dumplingOne = dumplingDao.findOne(1);
        log.info("\n\tFOUND DUMPLING BY ID 1 \n" + dumplingOne);
    }

    private void findSortedListExample() {
        List<Dumpling> sortedDumplings = dumplingDao.findAll(
                new Sort(
                        new Sort.Order(Sort.Direction.ASC, "filling"),
                        new Sort.Order(Sort.Direction.ASC, "timeDevouredIn")));
        log.info("\nDumplings sorted by filling and time devoured in");
        for (Dumpling dumpling : sortedDumplings) {
            log.info(dumpling.getFilling() + " - " + dumpling.getTimeDevouredIn());
        }
    }

    private void findAllInListExample() {
        List<Integer> idsToFind = Lists.newArrayList(1, 3, 8, 22);
        List<Dumpling> foundByIds = dumplingDao.findAll(idsToFind);
        log.info("\nDumplings found by ids");
        for (Dumpling dumpling : foundByIds) {
            log.info(dumpling.toString());
        }
    }

    private void existsExample() {
        log.info("Does a dumpling with ID 1 exist? " + dumplingDao.exists(1));
        log.info("Does a dumpling with ID 666 exist? " + dumplingDao.exists(666));
    }

    private void deleteExample() {
        log.info(" we have " + dumplingDao.count() + " dumplings in the DB");
        dumplingDao.delete(3);
        log.info(" after deleting dumpling ID=3 we only have " + dumplingDao.count() + " dumplings");
        List<Dumpling> all = dumplingDao.findAll();
    }

}
