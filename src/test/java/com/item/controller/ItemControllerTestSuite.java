package com.item.controller;

import com.item.cqrs.ItemCommand;
import com.item.cqrs.ItemQuery;
import com.item.domain.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@SpringJUnitWebConfig
@WebMvcTest(ItemController.class)
public class ItemControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ItemQuery itemQuery;

    @Test
    void shouldFetchItem() throws Exception {
        //Given
        Map<Long, Item> items = prepareData();

        //When&Then
        int count = 0;
        double second = 0;

        for (int i = 0; i < items.size(); i++) {
            when(itemQuery.get((long) i)).thenReturn(items.get((long) i));

            double start = System.currentTimeMillis();
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v1/item/" + i)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200));
            double end = System.currentTimeMillis();

            second += (end-start)/1000;
            count++;

            if (second >= 1 && second < 1.001){
                System.out.println("In: " + second + "s. executed: " + count + " queries.");
            }
        }
    }

    private Map<Long, Item> prepareData(){
        Map<Long, Item> items = new HashMap<>();

        for (int i = 0; i < 2000; i++) {
            items.put((long) i, new Item((long) i, "test"));
        }

        return items;
    };
}
