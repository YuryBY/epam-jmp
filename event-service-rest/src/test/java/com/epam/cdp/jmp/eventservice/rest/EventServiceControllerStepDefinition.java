package com.epam.cdp.jmp.eventservice.rest;

import com.epam.cdp.jmp.eventservice.dto.Event;
import com.epam.cdp.jmp.eventservice.dto.EventType;
import com.epam.cdp.jmp.eventservice.impl.repository.EventRepository;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(classes = {Application.class})
public class EventServiceControllerStepDefinition {
    private RestTemplate restTemplate = new RestTemplate();

    @LocalServerPort
    protected int port;

    @Autowired
    private EventRepository eventRepository;

    private String getEventServiceHost() {
        return "http://localhost:" + port;
    }

    private ResponseEntity<Event> responseEntity;

    @Given("^there are no events in a database$")
    public void there_are_no_events_in_a_database() throws Throwable {
        Iterable<Event> events = eventRepository.findAll();
        System.out.println("is there any events in repo: " + events.iterator().hasNext());
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the client calls POST /l(\\d+)/v(\\d+)\\.(\\d+)/event-service and Body contains Event with title: \"([^\"]*)\", place: \"([^\"]*)\", speaker: \"([^\"]*)\", eventType: \"([^\"]*)\", dateTime: \"([^\"]*)\"\\.$")
    public void the_client_calls_POST_l_v_event_service_and_Body_contains_Event_with_title_place_speaker_eventType_dateTime(int arg1, int arg2, int arg3, String arg4, String arg5, String arg6, String arg7, String arg8) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^the client receives status code of (\\d+) and response body containes eventId: \"([^\"]*)\"\\.$")
    public void the_client_receives_status_code_of_and_response_body_containes_eventId(int arg1, String arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^the client calls POST '(.+)' and Body contains Event with title: '(.+)', place: '(.+)', speaker: '(.+)', eventType: '(.+)', dateTime: '(.+)'")
    public void createEvent(String url,
                            String title,
                            String place,
                            String speaker,
                            EventType eventType,
                            LocalDateTime dateTime) {
        Event event = new Event(title, place, speaker, eventType, dateTime);
        HttpEntity<Event> request = new HttpEntity<>(event);
        responseEntity = restTemplate.exchange(getEventServiceHost() + url, HttpMethod.POST, request, Event.class);
    }

    @Then("^the client receives status code of (\\d{3})$")
    public void validateStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, responseEntity.getStatusCodeValue());
    }

    @And("response body containes eventId: '(.+)'")
    public void validateResponseBody(long id) {
        Assert.assertEquals(1L, responseEntity.getBody().getEventId());
    }
}
