package springjpaexample.dao;

import springjpaexample.domain.Dumpling;
import java.util.Collection;

public interface DumplingDaoCustom {
    Collection<Dumpling> fetchDumplingsWithEvenIds();
}
