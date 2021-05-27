package com.hrapplication.hrworker.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hrapplication.hrworker.entities.Worker;
import com.hrapplication.hrworker.repositories.WorkerRepository;

@Service
public class WorkerService {

	private final WorkerRepository workerRepository;

	public WorkerService(WorkerRepository workerRepository) {
		this.workerRepository = workerRepository;
	}

	public Worker findById(long id) {
		return workerRepository.findById(id).get();
	}

	public List<Worker> findAll() {
		return workerRepository.findAll();
	}
	
	
	
}
