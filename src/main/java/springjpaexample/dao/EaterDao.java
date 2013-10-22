package springjpaexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springjpaexample.domain.Eater;

@Repository
@Transactional
public interface EaterDao extends JpaRepository<Eater, Integer> {
}
