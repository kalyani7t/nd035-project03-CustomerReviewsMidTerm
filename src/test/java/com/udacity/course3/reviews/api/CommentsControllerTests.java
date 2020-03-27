package com.udacity.course3.reviews.api;

import com.udacity.course3.reviews.enitty.Comment;
import com.udacity.course3.reviews.enitty.Product;
import com.udacity.course3.reviews.enitty.Review;
import com.udacity.course3.reviews.repository.CommentRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentsControllerTests {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    CommentRepository commentRepository;

    @Test
    public void givenProductAndReviewAndCommentRepositories_whenSaveAndRetrieveEntities_thenOK(){
        productRepository.save(getProduct());
        Optional<Product> optionalProduct = productRepository.findById(1);
        Product product = optionalProduct.get();

        Review review = getReview();
        assertNotNull(product);
        review.setProduct(product);
        reviewRepository.save(review);

        Optional<Review> optionalReview = reviewRepository.findById(1);
        Review foundReview = optionalReview.get();

        Comment comment = getComment();
        assertNotNull(foundReview);
        comment.setReview(foundReview);
        commentRepository.save(comment);

        assertEquals("Wonderful Kitchen Tool", foundReview.getTitle());
        assertEquals(1, commentRepository.findAllByReview(new Review(1)).size());


    }

    private Comment getComment(){
        Comment comment = new Comment();
        comment.setTitle("Is it heavy?");
        comment.setCommentText("Is it Aluminium body or Steel body? Heavy or light?");

        return comment;
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
