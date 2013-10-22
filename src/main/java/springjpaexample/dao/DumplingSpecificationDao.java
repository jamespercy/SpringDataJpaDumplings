package springjpaexample.dao;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import springjpaexample.domain.Dumpling;

@Repository
public interface DumplingSpecificationDao extends CrudRepository<Dumpling, Integer>, JpaSpecificationExecutor {
}
