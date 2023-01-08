package com.ngo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ngo.dto.FeedbackDto;
import com.ngo.service.FeedbackService;

@RestController
@RequestMapping("/feedbackApi")
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService ;
	@PostMapping("/savefeedback")
	public ResponseEntity<FeedbackDto>postFeedback(@RequestBody FeedbackDto feedbackDto ){
		FeedbackDto postFeedback = this.feedbackService.postFeedback(feedbackDto);
		return new ResponseEntity<FeedbackDto>(postFeedback,HttpStatus.CREATED);
		}

}
