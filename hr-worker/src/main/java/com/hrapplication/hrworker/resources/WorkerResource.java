package com.hrapplication.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrapplication.hrworker.entities.Worker;
import com.hrapplication.hrworker.services.WorkerService;

@RefreshScope
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
	
	@Value("${test.config}")
	private String config;

	private static Logger log = LoggerFactory.getLogger(WorkerResource.class);
	private final WorkerService workerService;
	private final Environment env;

	public WorkerResource(WorkerService workerService, Environment env) {
		this.workerService = workerService;
		this.env = env;
	}

	@GetMapping(value = "/config")
	public void getConfig() {
		log.info("Config" + config);
	}
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll() {
		return ResponseEntity.ok(workerService.findAll());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Worker> findById(@PathVariable(value = "id") long id) {
		
		log.info("MS-WORKER RODANDO NA PORTA " + env.getProperty("local.server.port"));
		
		return ResponseEntity.ok(workerService.findById(id));
	}
	
}
