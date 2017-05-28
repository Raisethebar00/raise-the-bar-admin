package raise.the.bar.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by Sujeet on 2/4/17.
 */


@Entity
@Table(name="special")
public class SpecialModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "specialSeq")
    @SequenceGenerator(name = "specialSeq", sequenceName = "special_special_id_seq", allocationSize = 1)
    private @Column(name="special_id") Integer itemId;

    private @Column(name="bar_id") Integer barId;
    private @Column(name="name") String name;
    private @Column(name="price") BigDecimal price;
    private @Column(name="quantity") String quantity;
    private @Column(name="day_of_week") Integer dayOfWeek;
    private @Column(name="till") Time tillTime;
    private @Column(name="valid_from") Time validFrom;

    public Time getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Time validFrom) {
        this.validFrom = validFrom;
    }

    public Time getTillTime() {
        return tillTime;
    }

    public void setTillTime(Time tillTime) {
        this.tillTime = tillTime;
    }

    public Integer getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(Integer dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public Integer getBarId() {
        return barId;
    }

    public void setBarId(Integer barId) {
        this.barId = barId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

}