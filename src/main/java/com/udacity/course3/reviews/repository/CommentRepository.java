package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.enitty.Comment;
import com.udacity.course3.reviews.enitty.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
    List<Comment> findAllByReview(Review review);
}
