package com.epam.cdp.jmp.eventservice.rest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber_scenarios")
public class EventServiceControllerIT {
}
