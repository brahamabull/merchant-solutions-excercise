package com.technical.excercise.impl;

import com.technical.excercise.library.SignalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Service
@Slf4j
public class Application implements SignalHandler {

    @Autowired
    private AlgoImpl algo;
    private Map<Integer, Consumer<Integer>> processSignals = new HashMap<>();

    @PostConstruct
    public void initProcessSignals() {
        processSignals.put(1, algo::signalOneProcess);
        processSignals.put(2, algo::signalTwoProcess);
        processSignals.put(3, algo::signalThreeProcess);
    }

    @Override
    public void handleSignal(int signal) {
        if (processSignals.containsKey(signal)) {
           processSignals.get(signal).accept(signal);
        } else {
            log.info(MessageFormat.format("Signal {0} Configuration is not found. Cancelling trade", signal));
            algo.signalDefaultProcess(signal);
        }
    }
}
