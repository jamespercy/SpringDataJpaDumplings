package springjpaexample.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.domain.Dumpling;

public class PaginationExamples extends SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        new PaginationExamples().run();
    }

    private void run() {
        //creates context, db and some initial test data
        initialise();
        log.info("\n\n\n\n");
        Pageable simpleDumplingPageSpec = new PageRequest(1, 2, new Sort(Sort.Direction.DESC, "id"));
        Page<Dumpling> dumplingPage = dumplingDao.findAll(simpleDumplingPageSpec);
        log.info("Page number = " + dumplingPage.getNumber() + ", items = " + dumplingPage.getNumberOfElements()
                + ", total elements = " + dumplingPage.getTotalElements()
                + ", total pages = " + dumplingPage.getTotalPages());
        logDumplings(dumplingPage.getContent());

        log.info("\n");
        simpleDumplingPageSpec = new PageRequest(2, 2, new Sort(Sort.Direction.DESC, "id"));
        dumplingPage = dumplingDao.findAll(simpleDumplingPageSpec);
        log.info("Page number = " + dumplingPage.getNumber() + ", items = " + dumplingPage.getNumberOfElements()
                + ", total elements = " + dumplingPage.getTotalElements()
                + ", total pages = " + dumplingPage.getTotalPages());
        logDumplings(dumplingPage.getContent());
    }
}
