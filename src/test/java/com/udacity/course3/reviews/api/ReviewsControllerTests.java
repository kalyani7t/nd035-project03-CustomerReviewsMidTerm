package com.udacity.course3.reviews.api;

import com.udacity.course3.reviews.enitty.Product;
import com.udacity.course3.reviews.enitty.Review;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReviewsControllerTests {

    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private ProductRepository productRepository;

    @Test
    public void givenProductAndReviewRepository_whenSaveAndRetrieveEntity_thenOK(){
        productRepository.save(getProduct());
        Optional<Product> optionalProduct = productRepository.findById(1);
        Review review = getReview();
        Product product = optionalProduct.get();
        assertNotNull(product);
        review.setProduct(product);
        reviewRepository.save(review);
        assertEquals("Prestige Cooker", product.getName());
        assertEquals(2, reviewRepository.findAllByProduct(new Product(1)).size());

    }

    private Review getReview(){
        Review review = new Review();
        review.setTitle("Wonderful Kitchen Tool");
        review.setReviewText("Prestige cooker is really a must have for faster and healthier cooking.");
        return review;
    }

    private Product getProduct(){
        Product product = new Product();
        product.setName("Prestige Cooker");
        product.setDescription("Jo biwi se kare pyaar, wo Prestige se kaise kare inkaar?!");
        return product;
    }

}
