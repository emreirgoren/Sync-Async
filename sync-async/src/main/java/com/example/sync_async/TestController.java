package com.example.sync_async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@Slf4j
@RestController
@RequestMapping("/api/v1")
public class TestController {

    private final TestService testService;

    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/sync")
    public String syncMethod(){
        return testService.syncMethod();
    }

    @GetMapping("/async")
    public String asyncMethod(){
        log.info("ASYNC: Controller call method");
        testService.asyncMethod();
        log.info("ASYNC: Controller method done ");
        return "Request in progress...";
    }

}
