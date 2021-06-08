package steps;

public class StepsDefinition {
    public StepsDefinition() {
        Given("^перейти на https://www\\.udemy\\.com$", () -> {
        });
        When("^я проскроллил страницу до блока div с классом \"([^\"]*)\"$", (String arg0) -> {
        });
        And("^я проверил, что у блока есть фотография$", () -> {
        });
        Then("^я проверил, что у блока есть заголовок h(\\d+)$", (Integer arg0) -> {
        });
    }
}
