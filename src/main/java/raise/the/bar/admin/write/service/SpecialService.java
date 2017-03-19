package raise.the.bar.admin.write.service;


import raise.the.bar.admin.model.SpecialModel;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

public interface SpecialService {

    public boolean saveOne(SpecialModel specialModel);
    public List<SpecialModel> findAll(Integer barId);
    public Integer editOne(SpecialModel specialModel);

}
