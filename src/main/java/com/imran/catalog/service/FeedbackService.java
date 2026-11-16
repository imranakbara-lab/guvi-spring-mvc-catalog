package com.imran.catalog.service;

import com.imran.catalog.model.Feedback;
import com.imran.catalog.repository.FeedbackRepository;
import org.springframework.stereotype.Service;

@Service
public class FeedbackService {

    private final FeedbackRepository repository;

    public FeedbackService(FeedbackRepository repository) {
        this.repository = repository;
    }

    public Feedback save(Feedback feedback) {
        return repository.save(feedback);
    }
}
