package com.technical.excercise.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.technical.excercise.config.SignalConfig;
import com.technical.excercise.library.Algo;
import com.technical.excercise.library.SignalHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Class ; ApplictionV2
 * Description : Another efficient way of Managing the large number of signals with simple configurations
 */
@Slf4j
@Service
public class ApplicationV2 implements SignalHandler {

    private Map<String, SignalConfig> signalConfigMap;

    @PostConstruct
    public void init() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            signalConfigMap = objectMapper.readValue(new ClassPathResource("signals.json").getFile(),
                    new TypeReference<>(){});
        } catch (IOException e) {
            log.error("Cannot parse the JSON File signals.json. Error : " + e.getMessage());
        }
    }

    /**
     * Method : handleSignal
     * Description : This method will process the signals from the configMap created during the init() process
     * @param signal
     */
    @Override
    public void handleSignal(int signal) {
        Algo algo = new Algo();
        SignalConfig signalConfig = signalConfigMap.getOrDefault(Integer.toString(signal), signalConfigMap.get("default"));
        if (Objects.nonNull(signalConfig)) {
            signalConfig.executeAction(algo);
        }
        algo.doAlgo();
    }
}
