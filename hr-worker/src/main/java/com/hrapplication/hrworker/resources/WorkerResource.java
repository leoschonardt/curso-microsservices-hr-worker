package com.hrapplication.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrapplication.hrworker.entities.Worker;
import com.hrapplication.hrworker.services.WorkerService;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private final WorkerService workerService;

	public WorkerResource(WorkerService workerService) {
		this.workerService = workerService;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(workerService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok(workerService.findById(id));
	}
	
}
