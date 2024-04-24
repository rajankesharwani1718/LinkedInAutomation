package in.devlover.LinkedInAutomation.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LinkedInAutomationServiceTest {

    @Autowired
    LinkedInAutomationService linkedInAutomationService;

    @Test
    public void test1() {
        linkedInAutomationService.login("kd","ke");
    }

}