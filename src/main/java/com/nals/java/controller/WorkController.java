package com.nals.java.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nals.java.exception.ResourceNotFoundException;
import com.nals.java.model.Work;
import com.nals.java.repository.WorkRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class WorkController {
	@Autowired
	private WorkRepository workRepository;

	@GetMapping("/work")
	public List<Work> getAllWork() {
		return workRepository.findAll();
	}

	@GetMapping("/work/{id}")
	public ResponseEntity<Work> getWorkById(@PathVariable(value = "id") Long workId) throws ResourceNotFoundException {
		Work work = workRepository.findById(workId)
				.orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + workId));
		return ResponseEntity.ok().body(work);
	}

	@PostMapping("/work")
	public Work createWork(@Valid @RequestBody Work work) {
		return workRepository.save(work);
	}

	@PutMapping("/work/{id}")
	public ResponseEntity<Work> updateWork(@PathVariable(value = "id") Long workId,
			@Valid @RequestBody Work workDetails) throws ResourceNotFoundException {
		Work work = workRepository.findById(workId)
				.orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + workId));

		work.setWorkName(workDetails.getWorkName());
		work.setStartingDate(workDetails.getStartingDate());
		work.setEndingDate(workDetails.getEndingDate());
		work.setStatus(workDetails.getStatus());
		final Work updatedWork = workRepository.save(work);
		return ResponseEntity.ok(updatedWork);

	}

	@DeleteMapping("/work/{id}")
	public Map<String, Boolean> deleteWork(@PathVariable(value = "id") Long workId) throws ResourceNotFoundException {
		Work work = workRepository.findById(workId)
				.orElseThrow(() -> new ResourceNotFoundException("Work not found for this id :: " + workId));

		workRepository.delete(work);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
