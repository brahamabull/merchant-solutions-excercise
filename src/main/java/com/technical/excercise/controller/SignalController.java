package com.technical.excercise.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.MessageFormat;

/**
 * Class : SignalController
 * Description : API(s) for Accessing the Signal Interfaces and executions
 */
@RestController
@RequestMapping("/api/v1")
public class SignalController {

    @GetMapping("/input/{signal}")
    public ResponseEntity<String> getSignals(@PathVariable String signal) {
        return ResponseEntity.ok(MessageFormat.format("Signal {0} Processed Successfully", signal));
    }
}
