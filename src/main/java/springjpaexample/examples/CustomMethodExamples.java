package springjpaexample.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import springjpaexample.SpringDataExampleUtils;
import springjpaexample.dao.ExtendedDumplingDao;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.Eater;

import java.util.List;
import java.util.Set;

public class CustomMethodExamples extends SpringDataExampleUtils {
    private Logger log = LoggerFactory.getLogger(getClass());

    private ExtendedDumplingDao extendedDumplingDao;

    public static void main(String[] args) {
        new CustomMethodExamples().run();
    }

    private void run() {
        initialise();
        Eater bez = eaterDao.findOne(1);
        List<Dumpling> dumplingsEatenByBez = extendedDumplingDao.findByEater(bez);

        log.info("Found " + dumplingsEatenByBez.size() + " eaten by " + bez.getName());


        Set<Dumpling> dumplingsEatenByBernie = extendedDumplingDao.findByEaterName("Bernie");
        log.info("Found " + dumplingsEatenByBernie.size() + " eaten by Bernie");


        List<Dumpling> dumplingsEatenByBinSorted = extendedDumplingDao.findByEaterName("Bin",
                new Sort(new Sort.Order(Sort.Direction.ASC, "timeDevouredIn")));
        log.info("Found " + dumplingsEatenByBinSorted.size() + " eaten by Bin sorted by time eaten in");
        logDumplings(dumplingsEatenByBinSorted);
    }


    public void initialise() {
        super.initialise();
        extendedDumplingDao = context.getBean(ExtendedDumplingDao.class);
    }
}
