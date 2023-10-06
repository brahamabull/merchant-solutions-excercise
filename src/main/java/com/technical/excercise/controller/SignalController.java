package com.technical.excercise.controller;

import com.technical.excercise.impl.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Class : SignalController
 * Description : API(s) for Accessing the Signal Interfaces and executions
 */
@RestController
@RequestMapping("/api/v1")
public class SignalController {

    @Autowired
    private Application application;

    @GetMapping("/input/{signal}")
    public ResponseEntity<String> getSignals(@PathVariable Integer signal) {
        if (Objects.nonNull(signal)) {
            application.handleSignal(signal);
            return ResponseEntity.ok(MessageFormat.format("Signal {0} Processed Successfully", signal));
        } else {
            return ResponseEntity.badRequest().body("No Signal Passed to the API. Kindly check and Try Again");
        }
    }
}
