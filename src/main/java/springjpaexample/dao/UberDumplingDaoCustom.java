package springjpaexample.dao;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import springjpaexample.domain.Dumpling;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.Collection;
import java.util.List;

public class UberDumplingDaoCustom implements DumplingDaoCustom {
    private Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    private EntityManager entityManager;

    UberDumplingDaoCustom() {}

    public UberDumplingDaoCustom(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Collection<Dumpling> fetchDumplingsWithEvenIds() {
        Query q = entityManager.createQuery("select d from Dumpling d");
        List<Dumpling> allDumplings = q.getResultList();
        return Collections2.filter(allDumplings, new Predicate<Dumpling>() {
            @Override
            public boolean apply(Dumpling d) {
                return d.getId() % 2 == 0;
            }
        });
    }
}
