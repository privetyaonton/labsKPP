package com.example.laba1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class Controller
{
    @Autowired
    WebApplicationContext webApplicationContext;
    MockMvc mockMvc;
    @BeforeEach
    public void before() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }
    @Test
    public void test1() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci")
                        .contentType(MediaType.APPLICATION_JSON).param ("num", "1" ))
                        .andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentLength());
    }
    @Test
    public void test2() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci")
                        .contentType(MediaType.APPLICATION_JSON).param ("num", "-1" ))
                .andExpect(MockMvcResultMatchers.status().isBadRequest()).andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentLength());
    }
    @Test
    public void test3() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/fibonacci")
                        .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isBadRequest())
                    .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentLength());
    }
    @Test
    public void test4() throws Exception {
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)).andExpect(MockMvcResultMatchers.status().isInternalServerError())
                .andDo(MockMvcResultHandlers.print()).andReturn();
        System.out.println(mvcResult.getResponse().getContentLength());
    }
}
