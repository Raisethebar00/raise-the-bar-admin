//package raise.the.bar.admin.service.write.serviceImpl;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import raise.the.bar.admin.model.BarTimingModel;
//import raise.the.bar.admin.model.ItemModel;
//import raise.the.bar.admin.write.service.ItemService;
//import raise.the.bar.admin.write.serviceImpl.BarTimingServiceImpl;
//
//import java.io.IOException;
//import java.math.BigDecimal;
//import java.sql.Time;
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by Sujeet on 3/16/17.
// */
//
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class ItemServiceImpllTest {
//
//    @Autowired
//    private ItemService itemService;
//
//    private ItemModel itemModel;
//
//    @Before
//    public void setUp(){
//
//        itemModel = new ItemModel();
//        itemModel.setBarId(5);
//        itemModel.setName("new ");
//        itemModel.setPrice(new BigDecimal(89));
//        itemModel.setQuantity("67 ml");
//    }
//
//    @Test
//    public void edit_OK() throws IOException {
//
//
//        System.out.println(itemService.edit(itemModel));
//    }
//}
