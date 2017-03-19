package raise.the.bar.admin.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Time;

/**
 * Created by Sujeet on 2/4/17.
 */


@Entity
@Table(name="items")
public class ItemModel {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itemSeq")
    @SequenceGenerator(name = "itemSeq", sequenceName = "items_items_id_seq", allocationSize = 1)
    private @Column(name="items_id") Integer itemId;
    private @Column(name="bar_id") Integer barId;
    private @Column(name="name") String name;
    private @Column(name="price") BigDecimal price;
    private @Column(name="quantity") String quantity;


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