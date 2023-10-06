package com.technical.excercise.config;

import com.technical.excercise.library.Algo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

/**
 * Class : SignalConfig
 * Description : This is a Configuration Class for execution of signals based upon the configurations from signals.json
 */
@Slf4j
public class SignalConfig {
    private String initialProcess;
    private List<Integer> inputs;
    private List<String> additionalProcess;

    public String getInitialProcess() {
        return initialProcess;
    }

    public void setInitialProcess(String initialProcess) {
        this.initialProcess = initialProcess;
    }

    public List<Integer> getInputs() {
        return inputs;
    }

    public void setInputs(List<Integer> inputs) {
        this.inputs = inputs;
    }

    public List<String> getAdditionalProcess() {
        return additionalProcess;
    }

    public void setAdditionalProcess(List<String> additionalProcess) {
        this.additionalProcess = additionalProcess;
    }

    /**
     * Method : executeAction
     * Description :  This method will execute the desired methods based upon the config given in signals.json
     * @param algo
     *
     */
    public void executeAction(Algo algo) {
        log.info(MessageFormat.format("Received call in executeAction Method with InitialProcess : {0}, Inputs : {1}, additionalProcess : {2}",
                initialProcess, inputs.toString(), additionalProcess.toString()));
        if (Objects.nonNull(initialProcess)) {
            switch (initialProcess) {
                case "setup":
                    algo.setUp();
                    break;
                case "reverse":
                    algo.reverse();
                    break;
                case "cancelTrades":
                    algo.cancelTrades();
                    break;
                // More methods can be added in case required
            }
        }

        if (Objects.nonNull(inputs) && !CollectionUtils.isEmpty(inputs)) {
            for (int i = 0; i < inputs.size(); i += 2) {
                algo.setAlgoParam(inputs.get(i), inputs.get(i + 1));
            }
        }

        if (Objects.nonNull(additionalProcess) && !CollectionUtils.isEmpty(additionalProcess)) {
            additionalProcess.forEach(s -> {
                switch (s) {
                    case "performCalc":
                        algo.performCalc();
                        break;
                    case "submitToMarket":
                        algo.submitToMarket();
                        break;
                    //Add additional methods as required
                }
            });
        }
    }
}
