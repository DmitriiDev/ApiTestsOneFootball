import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class ApiServices extends BaseApiTestClass {

    public static String servicesApiPath = "services";

    @BeforeClass
    public static ResponseSpecification createPesponseSpecCode200TypeJson() {

        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                expectHeader("Connection", "keep-alive").
                build();
        return responseSpec;
    }

    @BeforeClass
    public static ResponseSpecification createPesponseSpecCode404TypeJson() {

        ResponseSpecification responseSpec = new ResponseSpecBuilder().
                expectStatusCode(404).
                expectContentType(ContentType.JSON).
                expectHeader("Connection", "keep-alive").
                build();
        return responseSpec;
    }
}
