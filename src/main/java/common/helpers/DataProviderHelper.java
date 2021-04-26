package common.helpers;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import common.Constant;
import models.LoginData;
import org.json.simple.parser.ParseException;
import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.List;

public class DataProviderHelper {
    @DataProvider(name = "invalidLoginData")
    public Object[] getInvalidLoginData() throws IOException, ParseException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = Common.getJsonData(Constant.JSON_PATH+ "loginData.json").toString();
        List<LoginData> listData = objectMapper.readValue(json, new TypeReference<List<LoginData>>() {});
        return listData.toArray();
    }


}
