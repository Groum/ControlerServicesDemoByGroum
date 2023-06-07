package com.example.H2implementation.Services;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.example.H2implementation.Model.TekWishEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Service
public class TechWishDataServices {
    @PersistenceContext
    private EntityManager entityManager;

    private int rewardPoint;

    @Transactional
    public ResponseEntity<Integer> getRewardFortheMonth(Long userId, int month) {
        populateData();
        String jpql = "SELECT t.amountPaid FROM TekWishEntity t WHERE t.userId = :userId AND t.months = :month";
        TypedQuery<Double> query = entityManager.createQuery(jpql, Double.class);
        query.setParameter("userId", userId);
        query.setParameter("month", month);
        query.setMaxResults(1);
        query.setFirstResult(0);

        Double amountPaid;
        try {
            amountPaid = query.getSingleResult();
        } catch (NoResultException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(0);
        }


        rewardPoint = calculateReward(amountPaid);

        return ResponseEntity.ok(rewardPoint);


    }
      void populateData()
        {
            Random random = new Random();

            IntStream.rangeClosed(1, 3)
                    .forEach(userId ->
                            IntStream.rangeClosed(1, 12)
                                    .forEach(month -> {
                                        double amount = 30 + random.nextDouble() * (500 - 30);
                                        TekWishEntity transaction = new TekWishEntity((long) userId, amount, month);
                                        entityManager.persist(transaction);
                                    })
                    );

            entityManager.flush();
        }



         int calculateReward( Double amountPaid)
         {
             return Stream.of(amountPaid)
                     .mapToInt(d -> d.intValue())
                     .map(a -> a > 100 ? (a - 100) * 2 + 50 : a > 50 ? a - 50 : 0)
                     .findFirst()
                     .orElse(0);

         }

    
}
