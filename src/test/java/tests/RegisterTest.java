package tests;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constant;
import common.helpers.Common;
import common.helpers.DataHelper;
import common.helpers.Log;
import models.RegisterData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.RegisterPage;
import java.io.IOException;
import java.util.List;

public class RegisterTest extends BaseTest {
    RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        registerPage.gotoRegisterPage();
    }

    @Test(description = "User can register an account")
    public void TC001() {
        String email = DataHelper.getRandomEmail();
        String password = DataHelper.getRandomText();
        String confirmPassword = password;
        String pid = DataHelper.getRandomPID();

        registerPage.register(email, password, confirmPassword, pid);

        String actualSuccessMsg = registerPage.getRegisterSuccessfullyMsg();
        String expectSuccessMsg = "Registration Confirmed! You can now log in to the site.";

        Assert.assertEquals(actualSuccessMsg, expectSuccessMsg, "Success message is incorrect");
    }

    @Test(description = "Error message is displayed when register with invalid data", dataProvider = "invalidRegisterData")
    public void TC002(RegisterData registerData) {
        Log.info("Register with data: " + registerData.getEmail() + "-" + registerData.getPassword()
                + "-" + registerData.getConfirmPassword() + "-" + registerData.getPid());

        registerPage.register(registerData.getEmail(), registerData.getPassword(),
                registerData.getConfirmPassword(), registerData.getPid());

        String actualGeneralErrorMsg = registerPage.getGeneralErrorMsg();
        String expectGeneralErrorMsg = "There're errors in the form. Please correct the errors and try again.";

        String actualSpecificErrorMsg = registerPage.getSpecificErrorMsg();
        String expectSpecificErrorMsg = registerData.getMessage();

        Assert.assertEquals(actualGeneralErrorMsg, expectGeneralErrorMsg, "General error message is incorrect");
        Assert.assertEquals(actualSpecificErrorMsg, expectSpecificErrorMsg, "Specific error message is incorrect");
    }

    @DataProvider(name = "invalidRegisterData")
    public Object[] getInvalidLoginData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<RegisterData> listData = objectMapper.readValue(Common.readFile(Constant.JSON_PATH
                + "invalidRegisterData.json"), new TypeReference<List<RegisterData>>() {});
        return listData.toArray();
    }
}
