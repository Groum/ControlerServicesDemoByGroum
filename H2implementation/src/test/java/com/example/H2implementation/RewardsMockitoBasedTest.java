package com.example.H2implementation;

import com.example.H2implementation.Services.TechWishDataServices;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RewardsMockitoBasedTest {

    @Mock
    private TechWishDataServices takeWishService;


    @Test
    public void testGetRewardsForMonth() {

        when(takeWishService.getRewardFortheMonth(1L, 5)).thenReturn(ResponseEntity.ok(90));

        ResponseEntity<Integer> points = takeWishService.getRewardFortheMonth(1L, 5);

        assertEquals(90, points.getBody());
    }
}
