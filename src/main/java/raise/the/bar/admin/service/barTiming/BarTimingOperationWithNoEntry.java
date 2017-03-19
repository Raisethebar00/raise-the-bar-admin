package raise.the.bar.admin.service.barTiming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import raise.the.bar.admin.model.BarTimingForWeek;
import raise.the.bar.admin.model.BarTimingModel;

import java.sql.Time;
import java.util.List;

/**
 * Created by Sujeet on 3/11/17.
 */

@Service
public class BarTimingOperationWithNoEntry {

    @Autowired
    private BarTimingForWeek barTimingForWeek;

    public BarTimingForWeek generateEmptyList(Integer barId){

        List<BarTimingModel> barTimingModelList  = barTimingForWeek.getWeekTiming();
        String[] weekdays = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};

        Time defaultTime = new Time(00,00,00);

        for (int i =0; i < 7 ; i++){

            barTimingModelList.add(new BarTimingModel(barId,i+1,weekdays[i],defaultTime,defaultTime,defaultTime,defaultTime ));
            }

        return barTimingForWeek;
    }
}
