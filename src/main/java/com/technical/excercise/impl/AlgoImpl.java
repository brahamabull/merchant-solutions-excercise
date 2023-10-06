package com.technical.excercise.impl;

import com.technical.excercise.library.Algo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Class : AlgoImpl
 * Descriptions : An Implantation class with methods to process the signal received.
 */
@Service
@Slf4j
@AllArgsConstructor
public class AlgoImpl {

    private static final String LOG_MESSAGE = "Processing Signal {0} inside method {1}";
    private static final String END_MESSAGE = "Processing Completed for Signal {0}. Exiting {1} method";

    /**
     * Method : SignalOneProcess
     * Description : Method executes the underlying methods from the Algo Library when Signal is 1
     * @param signal
     */
    public void signalOneProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.setUp();
        algo.setAlgoParam(1, 60);
        algo.performCalc();
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    /**
     * Method : signalTwoProcess
     * Description : Method executes the underlying methods from the Algo Library when Signal is 2
     * @param signal
     */
    public void signalTwoProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.reverse();
        algo.setAlgoParam(1, 80);
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    /**
     * Method : signalThreeProcess
     * Description : Method executes the underlying methods from the Algo Library when Signal is 3
     * @param signal
     */
    public void signalThreeProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.setAlgoParam(1, 90);
        algo.setAlgoParam(2, 15);
        algo.performCalc();
        algo.submitToMarket();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    /**
     * Method : signalDefaultProcess
     * Description : Method executes the underlying methods from the Algo Library when no signal config is present
     * @param signal
     */
    public void signalDefaultProcess(Integer signal) {
        log.info(MessageFormat.format(LOG_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
        Algo algo = new Algo();
        algo.cancelTrades();
        log.info(MessageFormat.format(END_MESSAGE, signal, new Object() {}.getClass().getEnclosingMethod().getName()));
    }

    /**
     * Method : signalDoAlgo
     * Description : Method will always be called
     */
    public void signalDoAlgo() {
        Algo algo = new Algo();
        algo.doAlgo();
    }
}
