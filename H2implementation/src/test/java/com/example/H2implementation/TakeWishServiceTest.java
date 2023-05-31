package com.example.H2implementation;
import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@AutoConfigureTestEntityManager
@Transactional
public class    TakeWishServiceTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TechWishDataServices takeWishService;

    @Test
    public void testGetAmountPaidForMonth() {

        TekWishEntity transaction = new TekWishEntity(1L, 120.0, 5);


        entityManager.persist(transaction);
        entityManager.flush();


        ResponseEntity<Integer> amountPaid = takeWishService.getRewardFortheMonth(1L, 5);

        // Verify the result
        assertEquals(HttpStatus.OK, amountPaid.getStatusCode());
        assertEquals(90, amountPaid.getBody());
    }
}
