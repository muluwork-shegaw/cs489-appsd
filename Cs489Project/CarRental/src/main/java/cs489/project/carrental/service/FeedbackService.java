package cs489.project.carrental.service;

import cs489.project.carrental.model.domain.Feedback;

public interface FeedbackService {
    Feedback saveFeedback(Feedback feedback);
    Feedback getFeedbackById(Long id);
    void deleteFeedback(Long id);
}
