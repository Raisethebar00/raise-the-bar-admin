package raise.the.bar.admin.write.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raise.the.bar.admin.model.ItemModel;
import raise.the.bar.admin.model.LoginModel;
import raise.the.bar.admin.model.OwnerModel;
import raise.the.bar.admin.write.repository.ItemRepository;
import raise.the.bar.admin.write.repository.OwnerRepository;
import raise.the.bar.admin.write.service.ItemService;
import raise.the.bar.admin.write.service.OwnerService;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public boolean saveOne(ItemModel itemModel) {


         itemRepository.save(itemModel);
        return true;
    }

    @Override
    public List<ItemModel> findAll(Integer barId) {
        return itemRepository.findAllByBarId(barId);
    }

    @Override
    public int edit(ItemModel itemModel) {
        System.out.println("Editing ");
        return itemRepository.editOne(itemModel.getName(),itemModel.getPrice(),itemModel.getQuantity(),itemModel.getItemId());
    }
}
