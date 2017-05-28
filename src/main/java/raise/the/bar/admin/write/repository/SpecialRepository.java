package raise.the.bar.admin.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import raise.the.bar.admin.model.SpecialModel;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Repository
public interface SpecialRepository extends JpaRepository<SpecialModel,Integer>{

    @Query("select i from SpecialModel i where i.barId = :barId")
    List<SpecialModel> findAllSpecialByBarId(@Param("barId") Integer barId);

    @Modifying
    @Transactional
    @Query("update SpecialModel b set b.name = :name , b.price = :price , b.quantity = :quantity , b.tillTime = :tillTime ," +
            "b.validFrom = :validFrom , b.dayOfWeek = :dayOfWeek where b.itemId = :itemId")
    int editOne(@Param("name") String name, @Param("price") BigDecimal price, @Param("quantity") String quantity,@Param("validFrom") Time validFrom,
                @Param("tillTime") Time tillTime, @Param("dayOfWeek") Integer dayOfWeek, @Param("itemId") Integer itemId);

}
