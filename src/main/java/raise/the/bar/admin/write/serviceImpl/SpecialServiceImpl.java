package raise.the.bar.admin.write.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raise.the.bar.admin.model.SpecialModel;
import raise.the.bar.admin.write.repository.SpecialRepository;
import raise.the.bar.admin.write.service.SpecialService;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Service
public class SpecialServiceImpl implements SpecialService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private SpecialRepository specialRepository;

    @Override
    public SpecialModel saveOne(SpecialModel specialModel) {

        logger.info("Adding a new special for a bar with bar ID as {} ",specialModel.getBarId());

        return specialRepository.save(specialModel);
    }

    @Override
    public List<SpecialModel> findAll(Integer barId) {

        logger.info("Searching for all services from a bar with barId {} ",barId);
        return specialRepository.findAllSpecialByBarId(barId);
    }

    @Override
    public Integer editOne(SpecialModel specialModel) {

        logger.info(" Updating Special Item information with Item ID as {}",specialModel.getItemId());
        return specialRepository.editOne(specialModel.getName(),specialModel.getPrice(),specialModel.getQuantity(),specialModel.getValidFrom(),
                                          specialModel.getTillTime(),specialModel.getDayOfWeek(), specialModel.getItemId());
    }

}
