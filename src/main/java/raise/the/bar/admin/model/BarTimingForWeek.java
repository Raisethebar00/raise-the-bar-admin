package raise.the.bar.admin.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sujeet on 2/4/17.
 */


@Component
public class BarTimingForWeek {

    private List<BarTimingModel> weekTiming;

    public BarTimingForWeek() {
        this.weekTiming = new ArrayList<>(7);
    }

    public List<BarTimingModel> getWeekTiming() {
        return weekTiming;
    }

    public void setWeekTiming(List<BarTimingModel> weekTiming) {
        this.weekTiming = weekTiming;
    }
}