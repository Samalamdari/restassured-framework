package tests.account;

import api.account.GetUserAccountPractice;
import base.BaseTest;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetUserAccountPracticeTest extends BaseTest {

    @Test
    public void getUserUnauthorized(){

        String userId = "befce4ac-a8fb-4c41-8da4-c9276cd4ad1e";

        Response response = GetUserAccountPractice.getUserAccountPracticeForGetUser(userId);

        assertEquals(401, response.statusCode(), "Request failed.");


    }
}
