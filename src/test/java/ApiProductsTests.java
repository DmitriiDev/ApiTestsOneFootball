import io.qameta.allure.Attachment;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

@Listeners(LogListener.class)
public class ApiProductsTests extends ApiProducts {

    @DataProvider(name = "Products")
    public static Object[][]parametres() {
        return new Object[][] {
                {productApiPathLessOrEqualsCustomPrice, 1},
                {productApiPathLessOrEqualsCustomPrice, 5},
                {productApiPathLessOrEqualsCustomPrice, 10}
        };
    }
    @Epic("Products")
    @Feature("Price Range")
    @Story("Items with price less than")
    @Test(dataProvider = "Products")
    public void productsPriceLessThanCustomPrice(String path, Integer priceParam) {

        Response response =  given().spec(requestSpecification).pathParam("path", path).pathParam("price", priceParam)
                .urlEncodingEnabled(false)
                .when().get("/{path}={price}")
                .then()
                .and().extract().response();
        List<Object> data = response.jsonPath().getList("data");

        for (Object price : data) {
            Object priceValue = ((LinkedHashMap)price).get("price");
            float convertToFloatPriceValue = (float)priceValue;
            Assert.assertFalse(convertToFloatPriceValue > priceParam);
        }
    }

    @Epic("Products")
    @Feature("Price Range")
    @Story("Items with price less than")
    @Test
    public void productsShipCostLessThanCustomPrice() {

        Response response =  given().spec(requestSpecification).pathParam("path", productApiPathShippingCostMoreThan).pathParam("price", 10)
                .urlEncodingEnabled(false)
                .when().get("/{path}={price}")
                .then()
                .and().extract().response();
        List<Object> data = response.jsonPath().getList("data");

        for (Object price : data) {
            Object priceValue = ((LinkedHashMap)price).get("shipping");
            float convertToFloatPriceValue = (float)priceValue;
            Assert.assertFalse(convertToFloatPriceValue > 8);
        }
    }

}
