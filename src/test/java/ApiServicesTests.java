
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

@Listeners(LogListener.class)
public class ApiServicesTests extends ApiServices {


    @DataProvider(name = "ServicesItems")
    public static Object[][]parametres() {
        return new Object[][] {
                {servicesApiPath, 1, "Geek Squad Services"},
                {servicesApiPath, 5, "Hablamos Español"},
                {servicesApiPath, 10, "Windows Store"}
        };
    }

    @Epic("Services")
    @Feature("Items ")
    @Story("Name of Items")
    @Test(dataProvider = "ServicesItems")
    public void checkTheNameOfTheServiceProduct(String service, Integer id, String nameOfProduct) {

        String nameOfServiceItem =  given().spec(requestSpecification).pathParam("service", service).pathParam("id", id)
                .when().get("/{service}/{id}")
                .then().
                    spec(createPesponseSpecCode200TypeJson())
                .and().extract().path("name");
        Assert.assertEquals(nameOfServiceItem,nameOfProduct);
    }
}
