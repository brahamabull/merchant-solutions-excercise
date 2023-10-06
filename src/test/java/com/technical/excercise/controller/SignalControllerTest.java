package com.technical.excercise.controller;

import com.technical.excercise.impl.Application;
import com.technical.excercise.impl.ApplicationV2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(SignalController.class)
public class SignalControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private Application application;

    @MockBean
    private ApplicationV2 applicationV2;


    @Test
    public void testApplicationSignalOne() throws Exception {
        mockMvc.perform(get("/api/v1/input/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testApplicationSignalTwo() throws Exception {
        mockMvc.perform(get("/api/v1/input/2"))
                .andExpect(status().isOk());
    }

    @Test
    public void testApplicationSignalFive() throws Exception {
        mockMvc.perform(get("/api/v1/input/5"))
                .andExpect(status().isOk());
    }

    @Test
    public void testApplicationV2SignalFive() throws Exception {
        mockMvc.perform(get("/api/v2/input/5"))
                .andExpect(status().isOk());
    }

    @Test
    public void testApplicationV2SignalOne() throws Exception {
        mockMvc.perform(get("/api/v2/input/1"))
                .andExpect(status().isOk());
    }
}
