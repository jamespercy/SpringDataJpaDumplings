package springjpaexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.FillingType;

import java.util.Collection;

@Repository
public interface UberDumplingDao extends JpaRepository<Dumpling, Integer>, DumplingDaoCustom {


    //using a query specified
    @Query("select d from Dumpling d where d.filling = :paramFilling")
    Collection<Dumpling> findDumplingsWithFilling(@Param("paramFilling") FillingType filling);
}
