package raise.the.bar.admin.write.serviceImpl;

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

    @Autowired
    private SpecialRepository specialRepository;

    @Override
    public boolean saveOne(SpecialModel specialModel) {

        specialRepository.save(specialModel);
        return true;
    }

    @Override
    public List<SpecialModel> findAll(Integer barId) {
        return specialRepository.findAllSpecialByBarId(barId);
    }

    @Override
    public Integer editOne(SpecialModel specialModel) {

        System.out.println(" Going to Edit - Name "+specialModel.getName());
        System.out.println(" Going to Edit - Item Id "+specialModel.getItemId());
        System.out.println(" Going to Edit - DayOF week"+specialModel.getDayOfWeek());
        System.out.println(" Going to Edit - Bar Name"+specialModel.getName());


        return specialRepository.editOne(specialModel.getName(),specialModel.getPrice(),specialModel.getQuantity(),specialModel.getValidFrom(),
                                          specialModel.getTillTime(),specialModel.getDayOfWeek(), specialModel.getItemId());
    }

}
