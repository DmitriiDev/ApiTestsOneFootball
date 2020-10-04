import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

public class ApiProducts extends BaseApiTestClass {

    public static String productApiPath = "products";
    public static String productApiPathLessOrEqualsCustomPrice = "products?price[$lte]";
    public static String productApiPathShippingCostMoreThan = "products?shipping[$gt]";

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
