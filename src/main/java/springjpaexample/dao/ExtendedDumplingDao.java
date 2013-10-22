package springjpaexample.dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.Eater;
import springjpaexample.domain.FillingType;

import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface ExtendedDumplingDao extends JpaRepository<Dumpling, Integer> {

    List<Dumpling> findByEater(Eater eater);

    //find by a sub property  i.e. all dumplings eaten by someone called ....
    Set<Dumpling> findByEaterName(String name);

    List<Dumpling> findByEaterName(String name, Sort sort);
}
