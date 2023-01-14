package pages;

import core.BasePage;

public class LoginPage extends BasePage {

    public void typeUsername(String username){
        write("#user-name", username);
    }

    public void typePassword(String password){
        write("#password", password);
    }

    public void submitLoginForm(){
        click("#login-button");
    }

    public String getErrorMessageText(){
        return getElementText(".error-message-container.error");
    }
}
