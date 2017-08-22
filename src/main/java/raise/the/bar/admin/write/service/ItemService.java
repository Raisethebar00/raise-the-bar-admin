package raise.the.bar.admin.write.service;


import raise.the.bar.admin.model.ItemModel;

import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */

public interface ItemService {

    public ItemModel saveOne(ItemModel itemModel);
    public List<ItemModel> findAll(Integer barId);
    public int edit(ItemModel itemModel);
}
