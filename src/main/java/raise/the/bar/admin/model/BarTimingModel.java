package raise.the.bar.admin.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by Sujeet on 2/4/17.
 */


@Entity
@Table(name="bar_timing")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BarTimingModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barTimingSeq")
    @SequenceGenerator(name = "barTimingSeq", sequenceName = "bar_timing_timing_id_seq", allocationSize = 1)
    private @Column(name="timing_id") Integer timingId;
    private @Column(name="bar_id") Integer barId;
    private @Column(name="day_of_week") Integer dayOFWeek;
    private @Column(name="day") String day;
    private @Column(name="am_open_time") Time amOpenTime;
    private @Column(name="am_close_time") Time amCloseTime;
    private @Column(name="pm_open_time") Time pmOpenTime;
    private @Column(name="pm_close_time") Time pmCloseTime;

    public BarTimingModel() {
    }

    public BarTimingModel(Integer barId, Integer dayOFWeek, String day, Time amOpenTime, Time amCloseTime, Time pmOpenTime, Time pmCloseTime) {
        this.barId = barId;
        this.dayOFWeek = dayOFWeek;
        this.day = day;
        this.amOpenTime = amOpenTime;
        this.amCloseTime = amCloseTime;
        this.pmOpenTime = pmOpenTime;
        this.pmCloseTime = pmCloseTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Integer getTimingId() {
        return timingId;
    }

    public void setTimingId(Integer timingId) {
        this.timingId = timingId;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Integer getDayOFWeek() {
        return dayOFWeek;
    }

    public void setDayOFWeek(Integer dayOFWeek) {
        this.dayOFWeek = dayOFWeek;
    }

    public Time getAmOpenTime() {
        return amOpenTime;
    }

    public void setAmOpenTime(Time amOpenTime) {
        this.amOpenTime = amOpenTime;
    }

    public Time getAmCloseTime() {
        return amCloseTime;
    }

    public void setAmCloseTime(Time amCloseTime) {
        this.amCloseTime = amCloseTime;
    }

    public Time getPmOpenTime() {
        return pmOpenTime;
    }

    public void setPmOpenTime(Time pmOpenTime) {
        this.pmOpenTime = pmOpenTime;
    }

    public Time getPmCloseTime() {
        return pmCloseTime;
    }

    public void setPmCloseTime(Time pmCloseTime) {
        this.pmCloseTime = pmCloseTime;
    }
}