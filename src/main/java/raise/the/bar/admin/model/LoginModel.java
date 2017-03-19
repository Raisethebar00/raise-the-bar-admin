package raise.the.bar.admin.model;

import org.springframework.stereotype.Component;

/**
 * Created by Sujeet on 2/4/17.
 */
@Component
public class LoginModel {

    private String emailId;
    private String password;

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
