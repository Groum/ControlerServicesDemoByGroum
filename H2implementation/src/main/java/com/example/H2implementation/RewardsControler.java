package com.example.H2implementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(tags = "Rewards Controller")
public class RewardsControler {
    @Autowired
    private TechWishDataServices transactionService;

    @GetMapping("/")
    @ApiOperation("Home endpoint")
    public String home() {
        return "<h1>Welcome to TekWish Rewards Page</h1>";
    }


    @GetMapping("/rewardPoints/{userId}/{month}")
    @ApiOperation("Get a Reward for Specific Months")
    public String  getAmountPaidForMonth(@PathVariable Long userId, @PathVariable int month) {


       ResponseEntity<Integer> Reward = transactionService.getRewardFortheMonth(userId, month);


       return Reward.getBody().toString();



    }
}
