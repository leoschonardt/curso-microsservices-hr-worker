package com.hrapplication.hrworker.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hrapplication.hrworker.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long>{

}
