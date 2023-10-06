package com.technical.excercise.impl;

import com.technical.excercise.library.Algo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;

@Service
@Slf4j
@AllArgsConstructor
public class AlgoImpl {

    private static final String LOG_MESSAGE = "Processing Signal {0} inside method {1}";
    private static final String END_MESSAGE = "Processing Completed for Signal {0}. Exiting {1} method";

    public void signalOneProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    public void signalTwoProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    public void signalThreeProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    public void signalDefaultProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.cancelTrades();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }
}
