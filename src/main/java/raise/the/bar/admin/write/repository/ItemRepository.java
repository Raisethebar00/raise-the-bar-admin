package raise.the.bar.admin.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import raise.the.bar.admin.model.ItemModel;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Repository
public interface ItemRepository extends JpaRepository<ItemModel,Integer>{

    @Query("select i from ItemModel i where i.barId = :barId")
    List<ItemModel> findAllByBarId(@Param("barId") Integer barId);


    @Modifying
    @Transactional
    @Query("update ItemModel b set b.name = :name , b.price = :price , b.quantity = :quantity where b.itemId = :itemId")
    int editOne(@Param("name") String name, @Param("price") BigDecimal price, @Param("quantity") String quantity,
                @Param("itemId") Integer itemId);
}
