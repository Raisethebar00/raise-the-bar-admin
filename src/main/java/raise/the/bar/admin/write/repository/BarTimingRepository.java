package raise.the.bar.admin.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import raise.the.bar.admin.model.BarTimingModel;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Repository
public interface BarTimingRepository extends JpaRepository<BarTimingModel,Integer>{

    @Query("select b from BarTimingModel b where b.barId = :barId")
    List<BarTimingModel> findAllByBarId(@Param("barId") Integer barId);

    @Modifying
    @Query("delete from BarTimingModel b where b.barId = :barId")
    void deleteAllByBarId(@Param("barId") Integer barId);

}
