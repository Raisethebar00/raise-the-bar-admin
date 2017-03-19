package raise.the.bar.admin.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import raise.the.bar.admin.model.BarModel;

import javax.persistence.Column;
import javax.persistence.SequenceGenerator;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Repository
public interface BarRepository extends JpaRepository<BarModel,Integer>{

    @Query("select b from BarModel b , OwnerModel o where b.ownerId = o.ownerId and o.ownerId = :ownerId")
    List<BarModel> findBarByOwnerId(@Param("ownerId") Integer ownerId);

    @Modifying
    @Transactional
    @Query("update BarModel b set b.name = :name , b.address = :address, b.latitude = :latitude, b.longitude = :longitude , b.phoneNumber = :phoneNumber ," +
            "b.amOpenTime = :amOpenTime , b.pmCloseTime = :pmCloseTime where b.barId = :barId")
    Integer updateAllExceptMedia(@Param("name") String name, @Param("address") String address, @Param("latitude") BigDecimal latitude, @Param("longitude") BigDecimal longitude,
                            @Param("phoneNumber") String phoneNumber, @Param("amOpenTime") Time amOpenTime, @Param("pmCloseTime") Time pmCloseTime ,@Param("barId") Integer barId);

    @Modifying
    @Transactional
    @Query("update BarModel b set b.barLogo = :logo , b.barPicture = :picture where b.barId = :barId")
    Integer updateBarLogoAndBarPicture(@Param("barId") Integer barId, @Param("logo") String logo, @Param("picture") String picture);

    @Modifying
    @Transactional
    @Query("update BarModel b set b.barPicture = :picture where b.barId = :barId")
    Integer updateBarPicture(@Param("barId") Integer barId, @Param("picture") String picture);

    @Modifying
    @Transactional
    @Query("update BarModel b set b.barLogo = :logo where b.barId = :barId")
    Integer updateBarLogo(@Param("barId") Integer barId, @Param("logo") String picture);
}
