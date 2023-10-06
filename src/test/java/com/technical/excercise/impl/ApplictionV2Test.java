package com.technical.excercise.impl;

import com.technical.excercise.config.SignalConfig;
import com.technical.excercise.library.Algo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

@ExtendWith(MockitoExtension.class)
public class ApplictionV2Test {

    @Autowired
    @InjectMocks
    private ApplicationV2 applicationV2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        this.applicationV2.init();
    }

    @Test
    public void handleSignalOne() {
        applicationV2.handleSignal(1);
    }
}
