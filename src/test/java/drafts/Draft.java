package drafts;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import common.Constant;
import common.helpers.Common;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.LoginPage;
import tests.BaseTest;

import java.io.File;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Draft extends BaseTest {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @BeforeMethod
    public void beforeMethod() {
        homePage.gotoLoginPage();
    }

    @AfterMethod
    public void afterMethod() {
        if (homePage.doesTabLogoutExist()) {
            homePage.logout();
        }
    }

    @Test(dataProvider = "jsonjson")
    public void TC001(String username, String password) {
        System.out.println("TC001: User can login with valid account");
        loginPage.login(username, password);
        String expectedWelcomeMsg = "Welcome " + Constant.USERNAME;
        String actualWelcomeMsg = homePage.getWelcomeMessage();
        Assert.assertEquals(actualWelcomeMsg, expectedWelcomeMsg, "Welcome message is incorrect.");
    }

    @DataProvider(name = "jsonjson")
    public static Object[][] credentials() {
            JSONParser parser = new JSONParser();
            Map<String, JSONObject> dataMap = new HashMap<String, JSONObject>();
            Iterator entriesIterator = null;
            try
            {
                JSONObject contentObj = (JSONObject)parser.parse(new FileReader(new File(System.getProperty("user.dir") + "/src/test/resources/json/data.json")));
                JSONObject dataObj = (JSONObject)contentObj.get("SuperParent");


                dataObj.keySet().forEach(key -> {
                    dataMap.put(String.valueOf(key), (JSONObject) dataObj.get(key));
                });

                Set entries = dataObj.entrySet();
                entriesIterator = entries.iterator();
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (ParseException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }


            Object[][] arr = new Object[dataMap.size()][2];
            int i = 0;
            while(entriesIterator.hasNext()){

                Map.Entry mapping = (Map.Entry) entriesIterator.next();

                arr[i][0] = mapping.getKey();
                arr[i][1] = mapping.getValue();

                i++;

            }

            return arr;
        }
}