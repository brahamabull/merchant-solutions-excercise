package com.technical.excercise.controller;

import com.technical.excercise.exception.ErrorResponse;
import com.technical.excercise.impl.Application;
import com.technical.excercise.impl.ApplicationV2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.text.MessageFormat;
import java.util.Objects;

/**
 * Class : SignalController
 * Description : API(s) for Accessing the Signal Interfaces and executions
 */
@RestController
@RequestMapping("/api")
public class SignalController {

    @Autowired
    private Application application;

    @Autowired
    private ApplicationV2 applicationV2;

    /**
     * Method : getSignals()
     * Description : An API Call Method when provided the signal in Integer format will process
     * and returns the successfully or bad request when null
     * @param signal
     * @return ResponseEntity Ok or Bad Request
     */
    @GetMapping("/v1/input/{signal}")
    public ResponseEntity<String> getSignals(@PathVariable Integer signal) {
        if (Objects.nonNull(signal)) {
            application.handleSignal(signal);
            return ResponseEntity.ok(MessageFormat.format("Signal {0} Processed Successfully", signal));
        } else {
            return ResponseEntity.badRequest().body("No Signal Passed to the API. Kindly check and Try Again");
        }
    }

    /**
     * Method : getSignalsForV2()
     * Description : An API Call Method when provided the signal in Integer format will process
     * and returns the successfully or bad request when null
     * @param signal
     * @return ResponseEntity Ok or Bad Request
     */
    @GetMapping("/v2/input/{signal}")
    public ResponseEntity<String> getSignalsForV2(@PathVariable Integer signal) {
        if (Objects.nonNull(signal)) {
            applicationV2.handleSignal(signal);
            return ResponseEntity.ok(MessageFormat.format("Signal {0} Processed Successfully", signal));
        } else {
            return ResponseEntity.badRequest().body("No Signal Passed to the API. Kindly check and Try Again");
        }
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(
           Exception exception
    ) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "Something Went Wrong. Please Check the Inputs"
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
