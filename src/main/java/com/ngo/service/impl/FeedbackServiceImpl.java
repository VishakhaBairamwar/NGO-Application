package com.ngo.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

import com.ngo.dto.FeedbackDto;
import com.ngo.model.Feedback;
import com.ngo.repository.FeedbackRepository;
import com.ngo.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {
	
	@Autowired
	private FeedbackRepository feedbackRepository;
	
	@AutoConfigureOrder
	private ModelMapper modelMapper;

	@Override
	public FeedbackDto postFeedback(FeedbackDto feedbackDto) {
		Feedback feedback = this.modelMapper.map(feedbackDto, Feedback.class);
		Feedback saveFeedback = this.feedbackRepository.save(feedback);
		return this.modelMapper.map(saveFeedback, FeedbackDto.class);
	}

}
