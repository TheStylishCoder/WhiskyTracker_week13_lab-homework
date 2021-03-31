package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void canGetAllWhiskiesByYear(){
		List<Whisky> found = whiskyRepository.findWhiskiesByYear(2018);
		assertEquals(6, found.size());
	}

	@Test
	public void canGetAllDistilleriesForParticularRegion(){
		List<Distillery> found = distilleryRepository.findDistilleriesByRegion("Speyside");
		assertEquals(3, found.size());
	}


	@Test
	public void canGetAllWhiskyFromParticularRegion(){
		List<Whisky> found = whiskyRepository.findWhiskiesByDistilleryRegion("Highland");
		assertEquals(7, found.size());
	}

	@Test
	public void canGetDistilleriesThatHaveWhiskiesThatAre12YearsOld(){
		List<Distillery> found = distilleryRepository.findDistilleriesByWhiskiesAge(12);
		assertEquals(6, found.size());
	}

}
