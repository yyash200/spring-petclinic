package org.springframework.samples.petclinic.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.model.AboutUs;
import org.springframework.samples.petclinic.model.AboutUsEntity;
import org.springframework.samples.petclinic.model.AboutUsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutController {

	@Autowired
	AboutUsRepository aboutUsRepository;

	@GetMapping(value = "/aboutUs", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AboutUs> about() {

		AboutUsEntity aboutUsEntity = aboutUsRepository.findById(1);
		// aboutUs.setText(
		// "As a registered charity our promise is to act as a resource for young people
		// from the age of 5 up to the age of 18 living in underprivileged and/or
		// disadvantaged areas of Newham, London and the surrounding area by providing
		// advice and assistance.");

		AboutUs aboutUs = new AboutUs();
		aboutUs.setText(aboutUsEntity.getText());
		return ResponseEntity.status(HttpStatus.OK).body(aboutUs);
	}

}
