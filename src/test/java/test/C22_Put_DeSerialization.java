package test;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testData.TestDataJsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class C22_Put_DeSerialization extends JsonPlaceHolderBaseUrl {
    /*
    https://jsonplaceholder.typicode.com/posts/70 url'ine asagidaki
    body’e sahip bir PUT request yolladigimizda donen response’in
    response body’sinin asagida verilen ile ayni oldugunu test ediniz
    Request Body
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
    Expected Data :
        {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":10,
        "id":70
        }
     */
    @Test
    public void put01(){
        // 1- url  ve body hazirla
        specJsonPlace.pathParams("pp1","posts","pp2",70);

        TestDataJsonPlaceHolder testDataJsonPlaceHolder= new TestDataJsonPlaceHolder();

        HashMap<String,Object> reqBody = testDataJsonPlaceHolder.requestBodyOlusturMap();

        System.out.println("req Body Map = "+reqBody);
        // 2- Expected Data hazirla

        HashMap<String,Object> expData = testDataJsonPlaceHolder.requestBodyOlusturMap();

        // 3 - Response  kaydet

        Response response= given().spec(specJsonPlace).
                                   contentType(ContentType.JSON).
                           when().
                                   body(reqBody).put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        // Not : Bizim hazirlamis oldugumuz Expected Data Map formatinda.
        // Bize response'dan donen Response Body ise Json formatinda
        // Ikisini Assert methodlari icerisinde kiyaslayabilmemiz icin oncelikle
        // response'i map formatina parse etmemiz gerekiyor.

        HashMap<String,Object> resMap = response.as(HashMap.class);

        Assert.assertEquals(testDataJsonPlaceHolder.basariliStatusCode,response.getStatusCode());
        Assert.assertEquals(expData.get("title"),resMap.get("title"));
        Assert.assertEquals(expData.get("body"),resMap.get("body"));
        Assert.assertEquals(expData.get("userId"),resMap.get("userId"));
        Assert.assertEquals(expData.get("id"),resMap.get("id"));

    }

}
