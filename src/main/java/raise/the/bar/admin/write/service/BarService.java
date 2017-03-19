package raise.the.bar.admin.write.service;

import org.springframework.data.repository.query.Param;
import raise.the.bar.admin.model.BarModel;
import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

public interface BarService {

    public List<BarModel> findBarByOwnerId(Integer ownerId);
    public BarModel saveOne(BarModel barModel);
    public BarModel findOne(Integer barId);
    public Integer updateAllExceptMedia(BarModel barModel);
    public Integer updateBarLogoAndBarPicture(Integer barId,String logo, String picture);
    public Integer updateBarPicture(Integer barId, String picture);
    public Integer updateBarLogo(Integer barId, String logo);

}
