package com.hrapplication.hrworker.resources;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrapplication.hrworker.entities.Worker;
import com.hrapplication.hrworker.repositories.WorkerRepository;

@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {

	private final WorkerRepository workerRepository;

	public WorkerResource(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(workerRepository.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable(value = "id") long id) {
		return ResponseEntity.ok(workerRepository.findById(id).get());
	}
	
}
