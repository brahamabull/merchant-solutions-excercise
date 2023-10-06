package com.technical.excercise.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ApplicationTest {

    @Mock
    private AlgoImpl algo;

    @Autowired
    @InjectMocks
    private Application application;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.application.initProcessSignals();
    }

    @Test
    public void testHandleSignalsOne() {
        application.handleSignal(1);
        verify(algo).signalOneProcess(1);
    }

    @Test
    public void testHandleSignalsTwo() {
        application.handleSignal(2);
        verify(algo).signalTwoProcess(2);
    }

    @Test
    public void testHandleSignalsThree() {
        application.handleSignal(3);
        verify(algo).signalThreeProcess(3);
    }

    @Test
    public void testHandleSignalsDefault() {
        application.handleSignal(4);
        verify(algo).signalDefaultProcess(4);
    }
}
