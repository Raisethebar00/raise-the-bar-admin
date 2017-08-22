package raise.the.bar.admin.write.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ItemRepository itemRepository;


    @Override
    public ItemModel saveOne(ItemModel itemModel) {

        logger.info("Adding new Item to bar with bar Id as {} ",itemModel.getBarId());

        return itemRepository.save(itemModel);
    }

    @Override
    public List<ItemModel> findAll(Integer barId) {

        logger.info("Searching for all item from a bar with barId {} ",barId);
        return itemRepository.findAllByBarId(barId);
    }

    @Override
    public int edit(ItemModel itemModel) {

        logger.info("Updating Item information with ItemId as {} ", itemModel.getItemId());
        return itemRepository.editOne(itemModel.getName(),itemModel.getPrice(),itemModel.getQuantity(),itemModel.getItemId());
    }
}
