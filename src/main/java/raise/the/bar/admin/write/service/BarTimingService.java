package raise.the.bar.admin.write.service;

import raise.the.bar.admin.model.BarTimingModel;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

public interface BarTimingService {

    public List<BarTimingModel> findAllByBarId(Integer barId);
    public List<BarTimingModel> reinsertAll(List<BarTimingModel> barTimingModelList,Integer barId);

}
