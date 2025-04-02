package com.example.sync_async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Service
public class TestService {

    public String syncMethod() {
      log.info("SYNC: Method start");
      try {
          Thread.sleep(3000);
      }catch (InterruptedException ie){
          Thread.currentThread().interrupt();
      }
      log.info("SYNC: Method done");
      return "SYNC: Method completed";
    }

    @Async
    public CompletableFuture<String> asyncMethod() {
        log.info("ASYNC: Method start");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException ie){
            Thread.currentThread().interrupt();
        }
        log.info("ASYNC: Method done");
        return CompletableFuture.completedFuture("ASYNC: Method completed");
    }
}
