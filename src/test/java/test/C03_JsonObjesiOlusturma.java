package test;

import org.json.JSONObject;
import org.junit.Test;

public class C03_JsonObjesiOlusturma {

     /*
    Asagidaki JSON Objesini olusturup konsolda yazdirin.
    {
        "title":"Ahmet",
        "body":"Merhaba",
        "userId":1
    }
*/

    @Test
    public void jsonObje01(){
        JSONObject ilkJsonObject=new JSONObject();
        ilkJsonObject.put("title","Deli");
        ilkJsonObject.put("body","Veli");
        ilkJsonObject.put("userId",9);

        System.out.println(ilkJsonObject);
    }
    /*
                {
                 "firstname":"Jim",
                 "additionalneeds":"Breakfast",
                 "bookingdates":{
                         "checkin":"2018-01-01",
                         "checkout":"2019-01-01"
                    },
                  "totalprice":111,
                  "depositpaid":true,
                  "lastname":"Brown"
                  }
         */

    @Test
    public void jsonObje02(){
JSONObject innerJsonObje=new JSONObject();

innerJsonObje.put("checkin","2018-01-01");
innerJsonObje.put("checkout","2019-01-01");
JSONObject body=new JSONObject();
body.put("firstname","Cori");
body.put("additionalneeds","Breakfast");
body.put("bookingdates",innerJsonObje);
body.put("totalprice",111);
body.put("depositpaid",true);
body.put("lastname","Gori");

        System.out.println(body);

    }

}










