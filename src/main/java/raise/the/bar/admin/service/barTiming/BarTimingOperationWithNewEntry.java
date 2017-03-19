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
public class BarTimingOperationWithNewEntry {



    public BarTimingForWeek generateEmptyList(BarTimingForWeek barTimingForWeek){

        for (BarTimingModel barTimingModel: barTimingForWeek.getWeekTiming()) {

            if (barTimingModel.getPmOpenTime().after(barTimingModel.getPmCloseTime())) {

                barTimingModel.setAmCloseTime(barTimingModel.getPmCloseTime());
                barTimingModel.setPmCloseTime(new Time(00, 00, 00));
                barTimingModel.setAmOpenTime(new Time(00, 00, 00));
            }
        }

        return barTimingForWeek;
    }
}
