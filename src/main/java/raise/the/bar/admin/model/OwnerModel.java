package raise.the.bar.admin.model;

import javax.persistence.*;

/**
 * Created by Sujeet on 2/4/17.
 */


@Entity
@Table(name="owners")
public class OwnerModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ownersSeq")
    @SequenceGenerator(name = "ownersSeq", sequenceName = "owners_owner_id_seq", allocationSize = 1)
    private @Column(name="owner_id") Integer ownerId;
    private @Column(name="first_name") String firstName;
    private @Column(name="middle_name") String middleName;
    private @Column(name="last_name") String lastName;
    private @Column(name="address") String adress;
    private @Column(name="emailid") String emailId;
    private @Column(name="pic") String pic;
    private @Column(name="password") String password;

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}