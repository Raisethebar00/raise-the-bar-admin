package raise.the.bar.admin.write.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import raise.the.bar.admin.model.BarTimingModel;
import raise.the.bar.admin.write.repository.BarTimingRepository;
import raise.the.bar.admin.write.service.BarTimingService;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Service
public class BarTimingServiceImpl implements BarTimingService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private BarTimingRepository barTimingRepository;

    @Override
    public List<BarTimingModel> findAllByBarId(Integer barId) {

        //ToDo to log the activity
        return barTimingRepository.findAllByBarId(barId);
    }

    @Modifying
    @Transactional
    @Override
    public List<BarTimingModel> reinsertAll(List<BarTimingModel> barTimingModelList , Integer barId) {

        logger.info("Re-Inserting BarTiming for BarID {} ",barId);
        barTimingRepository.deleteAllByBarId(barId);
        return barTimingRepository.save(barTimingModelList);
    }
}
