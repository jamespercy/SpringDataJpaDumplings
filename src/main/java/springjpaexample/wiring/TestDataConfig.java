package springjpaexample.wiring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springjpaexample.DataGenerator;
import springjpaexample.dao.DumplingDao;
import springjpaexample.dao.EaterDao;

@Configuration
@Import(RepoConfig.class)
public class TestDataConfig {

    @Autowired
    private DumplingDao dumplingDao;

    @Autowired
    private EaterDao eaterDao;


    @Bean
    public DataGenerator dataGenerator() {
        return new DataGenerator(dumplingDao, eaterDao);
    }

}
