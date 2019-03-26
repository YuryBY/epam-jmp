Feature: event_service_controller_queries
  Event's create delete functionality testing

  Scenario: a client calls create event method
  client call POST /l0/v1.0/event-service
#    Given there are no events in a database
#"2019-03-25T14:27:35.007Z".
    When the client calls POST "/l0/v1.0/event-service" and Body contains Event with title: "the_title_1", place: "the_place_1", speaker: "the_speaker_1", eventType: "TECHTALK", dateTime: "2019-03-25T14:27:35".
    Then the client receives status code of "201" and response body containes eventId: "1".