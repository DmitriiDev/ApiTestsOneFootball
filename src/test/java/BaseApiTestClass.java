import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static io.restassured.RestAssured.requestSpecification;

public class BaseApiTestClass {

    @BeforeClass
    public static void createRequestSpecification() {
        requestSpecification = new RequestSpecBuilder().
                setBaseUri("http://localhost:3030").
                build();
    }

    @BeforeClass
    public static ResponseSpecification createPesponseSpecCode200TypeJson() {

        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                expectHeader("Connection", "keep-alive").
                build();
        return responseSpec;
    }


}
