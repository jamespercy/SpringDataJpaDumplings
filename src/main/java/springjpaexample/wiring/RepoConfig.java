package springjpaexample.wiring;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "springjpaexample.dao", repositoryImplementationPostfix = "Custom")
@EnableTransactionManagement
@Import(EntityManagerConfig.class)
public class RepoConfig {



}
