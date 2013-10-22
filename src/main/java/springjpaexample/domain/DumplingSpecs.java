package springjpaexample.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class DumplingSpecs {
    private Logger log = LoggerFactory.getLogger(getClass());

    public static Specification<Dumpling> eatenQuickly() {
        return new Specification<Dumpling>() {
            @Override
            public Predicate toPredicate(Root<Dumpling> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.lessThan(root.<Integer>get("timeDevouredIn"), 5);
            }
        };
    }

    public static Specification<Dumpling> eatenSlowly() {
        return new Specification<Dumpling>() {
            @Override
            public Predicate toPredicate(Root<Dumpling> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                return cb.greaterThan(root.<Integer>get("timeDevouredIn"), 8);
            }
        };
    }
}
