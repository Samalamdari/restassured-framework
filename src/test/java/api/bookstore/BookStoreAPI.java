package api.bookstore;

import api.common.EndPoints;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BookStoreAPI {

    public static Response getAllBooks() {
        return RestAssured
                .given()
                .get(EndPoints.GET_ALL_BOOKS);
    }

    public static Response getBookByISBN(String isbn) {
        return RestAssured
                .given()
                .header("accept", "application/json")
                .when()
                .get(EndPoints.GET_BOOK_BY_ISBN + isbn);
    }

//    public static Response postAllBooks() {
//        return RestAssured
//                .given()
//                .get(EndPoints.POST_ALL_BOOKS);
//    }
}
