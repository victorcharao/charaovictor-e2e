package pages;

import core.BasePage;

import static mappings.login.LoginMappings.*;

public class LoginPage extends BasePage {

    public void typeUsername(String username){
        write(USERNAME_TEXTFIELD, username);
    }

    public void typePassword(String password){
        write(PASSWORD_TEXTFIELD, password);
    }

    public void submitLoginForm(){
        click(SUBMIT_LOGIN_BUTTON);
    }

    public String getErrorMessageText(){
        return getElementText(ERROR_TEXTMESSAGE);
    }
}
