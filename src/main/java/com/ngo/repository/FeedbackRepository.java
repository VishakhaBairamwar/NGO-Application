package com.ngo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngo.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
