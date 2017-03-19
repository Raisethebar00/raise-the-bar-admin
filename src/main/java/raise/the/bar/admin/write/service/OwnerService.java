package raise.the.bar.admin.write.service;

import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;

/**
 * Created by Sujeet on 2/4/17.
 */

public interface OwnerService {

    public OwnerModel findOneOwner(LoginModel loginModel);

}
