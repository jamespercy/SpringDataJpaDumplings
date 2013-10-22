package springjpaexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import springjpaexample.dao.DumplingDao;
import springjpaexample.dao.EaterDao;
import springjpaexample.domain.CookingTechnique;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.Eater;
import springjpaexample.domain.FillingType;

@Transactional
public class DataGenerator {

    DataGenerator() { }

    private Logger log = LoggerFactory.getLogger(getClass());
    private DumplingDao dumplingDao;
    private EaterDao eaterDao;

    public DataGenerator(DumplingDao dumplingDao, EaterDao eaterDao) {
        this.dumplingDao = dumplingDao;
        this.eaterDao = eaterDao;
    }

    public void createDumplings() {
        log.info("creating dumplings");
        Eater bez = eaterDao.save(new Eater("Bez"));
        Eater tinh = eaterDao.save(new Eater("Tinh"));
        Eater bin = eaterDao.save(new Eater("Bin"));
        Eater mehdi = eaterDao.save(new Eater("Mehdi"));
        Eater andrew = eaterDao.save(new Eater("Andrew"));
        Eater dan = eaterDao.save(new Eater("Dan"));
        Eater bernie = eaterDao.save(new Eater("Bernie"));
        Eater james = eaterDao.save(new Eater("James"));

        eaterDao.flush();

        insertDumpling(new Dumpling(FillingType.PORK, CookingTechnique.BOILED, bez, 3));
        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.FRIED, bez, 1));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, bez, 4));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.FRIED, bez, 5));
        insertDumpling(new Dumpling(FillingType.PORK, CookingTechnique.BOILED, bez, 2));

        insertDumpling(new Dumpling(FillingType.PORK, CookingTechnique.BOILED, tinh, 8));
        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.FRIED, tinh, 9));

        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, bin, 7));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, bin, 6));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, bin, 8));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, bin, 5));

        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.BOILED, mehdi, 4));

        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.FRIED, andrew, 9));
        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.BOILED, andrew, 9));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.FRIED, andrew, 11));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, andrew, 8));

        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.BOILED, james, 5));
        insertDumpling(new Dumpling(FillingType.BEEF, CookingTechnique.FRIED, james, 2));
        insertDumpling(new Dumpling(FillingType.PORK, CookingTechnique.FRIED, james, 3));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.FRIED, james, 5));

        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.FRIED, dan, 6));
        insertDumpling(new Dumpling(FillingType.CHICKEN_AND_PRAWN, CookingTechnique.BOILED, dan, 5));

        insertDumpling(new Dumpling(FillingType.TOFU, CookingTechnique.FRIED, bernie, 8));
        insertDumpling(new Dumpling(FillingType.PUMPKIN_AND_CHIVES, CookingTechnique.BOILED, bernie, 7));


    }

    private void insertDumpling(Dumpling dumplingToBeSaved) {
        dumplingDao.save(dumplingToBeSaved);
        log.info("SAVED " + dumplingToBeSaved);
    }
}
