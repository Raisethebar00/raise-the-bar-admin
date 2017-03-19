package raise.the.bar.admin.write.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import raise.the.bar.admin.model.OwnerModel;

/**
 * Created by Sujeet on 2/4/17.
 */

@Repository
public interface OwnerRepository extends JpaRepository<OwnerModel,String>{

    @Query("select o from OwnerModel o where o.emailId = :emailid and o.password = :password")
    OwnerModel findByEmailIdAndPassword(@Param("emailid") String emailId,@Param("password") String password);
}
