package raise.the.bar.admin.model;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by Sujeet on 2/4/17.
 */


@Entity
@Table(name="bar")
@JsonIgnoreProperties(ignoreUnknown = true)
public class BarModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "barSeq")
    @SequenceGenerator(name = "barSeq", sequenceName = "bar_bar_id_seq", allocationSize = 1)
    private @Column(name="bar_id") Integer barId;
    private @Column(name="owner_id") Integer ownerId;
    private @Column(name="description") String description;
    private @Column(name="day_of_week") Integer dayOFWeek;
    private @Column(name="name") String name;
    private @Column(name="address") String address;
    private @Column(name="latitude") BigDecimal latitude;
    private @Column(name="longitude") BigDecimal longitude;
    private @Column(name="phone_number") String phoneNumber;
    private @Column(name="picture") String barPicture;
    private @Column(name="am_open_time") Time amOpenTime;
    private @Column(name="am_close_time") Time amCloseTime;
    private @Column(name="pm_open_time") Time pmOpenTime;
    private @Column(name="pm_close_time") Time pmCloseTime;
    private @Column(name="logo") String barLogo;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Integer getDayOFWeek() {
        return dayOFWeek;
    }

    public void setDayOFWeek(Integer dayOFWeek) {
        this.dayOFWeek = dayOFWeek;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getBarPicture() {
        return barPicture;
    }

    public void setBarPicture(String barPicture) {
        this.barPicture = barPicture;
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

    public String getBarLogo() {
        return barLogo;
    }

    public void setBarLogo(String barLogo) {
        this.barLogo = barLogo;
    }

}