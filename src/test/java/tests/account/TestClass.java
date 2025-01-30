package tests.account;

import api.account.AccountAPI;
import auth.TokenGenerator;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.DataGenerator;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClass extends BaseTest {

    private String userName;
    private String password;
    private Response response;
    private String userUUID;
    private String userToken;
    private Response getUserInfo;


    @BeforeEach
    public void prepare(){
         userName = DataGenerator.generateRandomUserName();
         password = DataGenerator.generateRandomPassword();
         response = AccountAPI.createUser(userName, password);
         userUUID = response.jsonPath().getString("userID");
         userToken = TokenGenerator.getToken(userName, password);
         getUserInfo = AccountAPI.getUserByUUIDWithToken(userUUID, userToken);

   }

    @Test
    public void createUser() {
        assertEquals(201, response.statusCode(), "Request failed.");
    }

    @AfterEach
    public void tearDown() {
        Response deleteUser = AccountAPI.deleteUser(userUUID, userToken);
        System.out.println("user deleted!");
        System.out.println("Status Code: " + deleteUser.statusCode());
    }
}
