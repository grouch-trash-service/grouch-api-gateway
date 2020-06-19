package net.mporter.cucumber;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openapitools.api.MessageApiClient;
import org.openapitools.model.Message;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.Assert.assertThat;

public class StepDefinitions extends SpringCucumberContext {

    private Message message;

    @Autowired
    MessageApiClient messageApiClient;

    @When("^a user requests a message$")
    public void requestMessage() {
        message = messageApiClient.getMessage().getBody();
    }

    @Then("a valid message about when trash pickup is returned")
    public void validateMessage() {
        assertThat(message.getText(),
                containsString("Trash"));
    }
}
