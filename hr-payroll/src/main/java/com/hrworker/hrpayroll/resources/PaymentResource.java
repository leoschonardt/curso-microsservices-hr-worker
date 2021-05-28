package com.hrworker.hrpayroll.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hrworker.hrpayroll.entities.Payment;
import com.hrworker.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

	private final PaymentService paymentService;

	public PaymentResource(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@HystrixCommand(fallbackMethod = "getPaymentFallback")
	@GetMapping(value = "/{workerId}/days/{days}")
	public ResponseEntity<Payment> getPayment(@PathVariable(value = "workerId") long workerId, @PathVariable(value = "days") int days) {
		return ResponseEntity.ok(paymentService.getPayment(workerId, days));
	}
	
	public ResponseEntity<Payment> getPaymentFallback(long workerId, int days) {
		return ResponseEntity.ok(new Payment("Ana", 296.0, days));
	}
}
