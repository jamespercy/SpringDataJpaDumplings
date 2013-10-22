package springjpaexample.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import springjpaexample.domain.Dumpling;
import springjpaexample.domain.FillingType;

import java.util.Collection;

@Repository
@Transactional
public interface DumplingQueryDao extends JpaRepository<Dumpling, Integer> {

    //uses named query based on type and the name of the method
    Collection<Dumpling> findByTimeDevouredIn(int seconds);

    //using a query specified
    @Query("select d from Dumpling d where d.filling = :paramFilling")
    Collection<Dumpling> findDumplingsWithFilling(@Param("paramFilling") FillingType filling);

    @Modifying
    @Query("update Dumpling d set d.filling = :newFilling where d.filling = :oldFilling")
    int updateFilling(@Param("newFilling") FillingType filling, @Param("oldFilling") FillingType oldFilling);
}
