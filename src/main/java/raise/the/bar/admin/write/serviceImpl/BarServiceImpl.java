package raise.the.bar.admin.write.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raise.the.bar.admin.model.BarModel;
import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;
import raise.the.bar.admin.write.repository.BarRepository;
import raise.the.bar.admin.write.repository.OwnerRepository;
import raise.the.bar.admin.write.service.BarService;
import raise.the.bar.admin.write.service.OwnerService;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Service
public class BarServiceImpl implements BarService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BarRepository barRepository;

    @Override
    public List<BarModel> findBarByOwnerId(Integer ownerId) {

        logger.info("Searching list of bar with owner Id as {} ",ownerId);

        return barRepository.findBarByOwnerId(ownerId);
    }

    @Override
    public BarModel saveOne(BarModel barModel) {

        logger.info("Saving a new bar with bar name as {} , latitude as {} and longitude as {}",barModel.getName(), barModel.getLatitude(), barModel.getLongitude());
        return barRepository.save(barModel);
    }

    @Override
    public BarModel findOne(Integer barId) {

        logger.info("Searching bar with barId as {} ",barId);

        return barRepository.findOne(barId);
    }

    @Override
    public Integer updateAllExceptMedia(BarModel barModel) {

        logger.info("Updating everything except media field for barId {} ",barModel.getBarId());
        return barRepository.updateAllExceptMedia(barModel.getName(),barModel.getAddress(),barModel.getLatitude(),barModel.getLongitude(),barModel.getPhoneNumber(),
                barModel.getAmCloseTime(),barModel.getPmCloseTime(),barModel.getBarId());
    }

    @Override
    public Integer updateBarLogoAndBarPicture(Integer barId, String logo, String picture) {
        return barRepository.updateBarLogoAndBarPicture(barId,logo,picture);
    }

    @Override
    public Integer updateBarPicture(Integer barId, String picture) {
        return barRepository.updateBarPicture(barId, picture);
    }

    @Override
    public Integer updateBarLogo(Integer barId, String logo) {
        return barRepository.updateBarLogo(barId, logo);
    }

}
