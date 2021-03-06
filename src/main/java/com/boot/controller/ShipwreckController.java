package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.model.Shipwreck;
import com.boot.repository.ShipwreckRepository;

@RestController
@RequestMapping("/api/v1/")
public class ShipwreckController {

	@Autowired
	private ShipwreckRepository sr;

	@GetMapping("shipwrecks")
	public List<Shipwreck> list() {
		return sr.findAll();
	}

	@PostMapping("shipwrecks")
	public Shipwreck create(@RequestBody Shipwreck shipwreck) {
		return sr.saveAndFlush(shipwreck);
	}

	@GetMapping("shipwrecks/{id}")
	public Optional<Shipwreck> get(@PathVariable Long id) {
		return sr.findById(id);
	}

	@PutMapping("shipwrecks/{id}")
	public Shipwreck get(@PathVariable Long id, @RequestBody Shipwreck shipwreck) {

		Optional<Shipwreck> existing = sr.findById(id);
		
		existing.get().setCondition(shipwreck.getCondition());
		existing.get().setDepth(shipwreck.getDepth());
		existing.get().setDescription(shipwreck.getDescription());
		existing.get().setLatitude(shipwreck.getLatitude());
		existing.get().setLongitude(shipwreck.getLongitude());
		existing.get().setName(shipwreck.getName());
		existing.get().setYearDiscovered(shipwreck.getYearDiscovered());
		
		return sr.saveAndFlush(existing.get());
	}

	@DeleteMapping("shipwrecks/{id}")
	public Optional<Shipwreck> delete(@PathVariable Long id) {
		Optional<Shipwreck> existing = sr.findById(id);
		sr.deleteById(existing.get().getId());
		return existing;
	}

}

/* Google - Spring boot common application properties. */
