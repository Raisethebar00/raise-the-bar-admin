package raise.the.bar.admin.service.write.serviceImpl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import raise.the.bar.admin.model.BarTimingModel;
import raise.the.bar.admin.write.serviceImpl.BarTimingServiceImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sujeet on 3/16/17.
 */


@RunWith(SpringRunner.class)
@SpringBootTest
public class BarTimingServiceImplTest {

    @Autowired
    private BarTimingServiceImpl barTimingService;

    private List<BarTimingModel> barTimingModelList;
    private Integer barId;
    @Before
    public void setUp(){

        Time defaultTime = new Time(00,00,00);
        barId = 5;
        BarTimingModel barTimingModel = new BarTimingModel(barId,1,"Monday",defaultTime,defaultTime,defaultTime,defaultTime);
        barTimingModelList = new ArrayList<BarTimingModel>();
        barTimingModelList.add(barTimingModel);
    }

    @Test
    public void reinsertAll_OK() throws IOException {


        barTimingService.reinsertAll(barTimingModelList,5);
    }
}
