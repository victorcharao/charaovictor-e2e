package core;

import io.cucumber.java.After;

import static core.DriverFactory.killDriver;

public class BaseSteps {

    @After
    public void quitBrowser(){
        if (Properties.QUIT_BROWSER){
            killDriver();
        }
    }
}
