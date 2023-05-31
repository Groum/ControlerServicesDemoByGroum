package com.example.H2implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RewardsControler {
    @Autowired
    private TechWishDataServices transactionService;

    @GetMapping("/")
    public String home() {
        return "<h1>Welcome to TekWish Rewards Page</h1>";
    }


    @GetMapping("/rewardPoints/{userId}/{month}")
    public String  getAmountPaidForMonth(@PathVariable Long userId, @PathVariable int month) {


       ResponseEntity<Integer> Reward = transactionService.getRewardFortheMonth(userId, month);


       return Reward.getBody().toString();



    }
}
