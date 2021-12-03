package com.item.controller;

import com.item.domain.Item;
import com.item.repository.ItemRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringJUnitWebConfig
@WebMvcTest(ItemController.class)
public class ItemControllerTestSuite {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    private static void prepare() {
        ItemRepository itemRepository = ItemRepository.INSTANCE;

        for (int i = 0; i < 2000; i++) {
            itemRepository.add(new Item((long) i, "test"));
        }
    }

    @Test
    void shouldFetchItem() throws Exception {
        //Given
        ItemRepository itemRepository = ItemRepository.INSTANCE;

        //When&Then
        int count = 0;
        double second = 0;

        for (int i = 0; i < itemRepository.size(); i++) {

            double start = System.currentTimeMillis();
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v1/item/" + i)
                    .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(MockMvcResultMatchers.status().is(200));
            double end = System.currentTimeMillis();

            second += (end-start)/1000;
            count++;

            if (second >= 1 && second < 1.001) {
                System.out.println("In: " + second + "s. executed: " + count + " queries.");
            }
        }
    }
}
