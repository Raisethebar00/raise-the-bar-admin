package raise.the.bar.admin.write.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;
import raise.the.bar.admin.write.repository.OwnerRepository;
import raise.the.bar.admin.write.service.OwnerService;

/**
 * Created by Sujeet on 2/4/17.
 */

@Service
public class OwnerServiceImpl implements OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public OwnerModel findOneOwner(LoginModel loginModel) {

        return ownerRepository.findByEmailIdAndPassword(loginModel.getEmailId(),loginModel.getPassword());
    }
}
