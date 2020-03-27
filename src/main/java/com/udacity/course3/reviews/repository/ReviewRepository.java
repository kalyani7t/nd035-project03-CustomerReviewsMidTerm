package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.enitty.Product;
import com.udacity.course3.reviews.enitty.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

    List<Review> findAllByProduct(Product product);


}
