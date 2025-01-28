package api.account;

import api.common.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetUserAccountPractice {

    public static Response getUserAccountPracticeForGetUser(String uuid) {
        return RestAssured
                .given()
                .header("accept","application/json")
                .pathParam("UUID",uuid)
                .get(EndPoints.GET_USER_BY_UUID);
    }
}
