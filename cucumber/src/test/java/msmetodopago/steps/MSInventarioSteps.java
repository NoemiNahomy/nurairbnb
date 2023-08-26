package msmetodopago.steps;

import context.World;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.Transpose;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import util.RequestSpecificationFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import static util.Util.jsonTemplate;

public class MSInventarioSteps {
    private final World world;
    private final Properties envConfig;
    private RequestSpecification request;

    public MSInventarioSteps(World world) {
        this.world = world;
        this.envConfig = World.envConfig;
        this.world.featureContext = World.threadLocal.get();
    }

    @Before
    public void setUp() {
        request = RequestSpecificationFactory.getInstance();
    }

    @Given("an item with valid details")
    public void getItemValidData(@Transpose DataTable dataTable) throws IOException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String id = data.get(0).get("id");
        String detalle = data.get(0).get("detalle");
        String tipo = data.get(0).get("tipo");

        Map<String, Object> valuesToTemplate = new HashMap<>();
        valuesToTemplate.put("id", id);
        valuesToTemplate.put("detalle", detalle);
        valuesToTemplate.put("tipo", tipo);



        String jsonAsString = jsonTemplate(envConfig.getProperty("msmetodopago-item_request"), valuesToTemplate);

        world.scenarioContext.put("requestStr", jsonAsString);
    }
    @Given("an item with invalid details")
    public void getItemInvalidData(@Transpose DataTable dataTable) throws IOException {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        String id = data.get(0).get("id");

        Map<String, Object> valuesToTemplate = new HashMap<>();
        valuesToTemplate.put("id", id);
        valuesToTemplate.put("detalle", "");
        valuesToTemplate.put("tipo", "");

        String jsonAsString = jsonTemplate(envConfig.getProperty("msmetodopago-item_request"), valuesToTemplate);

        world.scenarioContext.put("requestStr", jsonAsString);
    }

    @When("request is submitted for item creation")
    public void submitItemCreation() {
        String payload = world.scenarioContext.get("requestStr").toString();
        Response response = request
                .accept(ContentType.JSON)
                .body(payload)
                .contentType(ContentType.JSON)
                .when().post(envConfig.getProperty("msmetodopago-service_url")
                        + envConfig.getProperty("msmetodopago-item_api"));

        world.scenarioContext.put("response", response);
    }

    @Then("verify that the Item HTTP response is {int}")
    public void verifyHTTPResponseCode(Integer status) {
        Response response = (Response) world.scenarioContext.get("response");
        Integer actualStatusCode = response.then()
                .extract()
                .statusCode();
        Assert.assertEquals(status, actualStatusCode);
    }

    @Then("a item id is returned")
    public void checkItemId() {
        Response response = (Response) world.scenarioContext.get("response");
        String responseString = response.then().extract().asString();
        Assert.assertNotNull(responseString);
        Assert.assertNotEquals("", responseString);
        //Assert.assertTrue(responseString.matches("\"[a-f0-9]{8}(-[a-f0-9]{4}){4}[a-f0-9]{8}\""));
    }
}
