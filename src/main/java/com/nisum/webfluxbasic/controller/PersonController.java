package com.nisum.webfluxbasic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.webfluxbasic.model.Person;
import com.nisum.webfluxbasic.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/Person")
public class PersonController {

	@Autowired
	private PersonService PersonService;

	@RequestMapping(value = "/save", method = RequestMethod.POST, consumes = "application/json")
	@ResponseStatus(code = HttpStatus.CREATED)
	public Mono<Person> save(@RequestBody Person Person) {
		return PersonService.savePerson(Person);
	}

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public Flux<Person> getData() {
		return PersonService.getAllPersonsData();
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Mono<Person>> getPersonByName(@PathVariable("id") Integer id) {

		Mono<Person> e = PersonService.getPersonById(id);
		HttpStatus status = e != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		return new ResponseEntity<Mono<Person>>(e, status);

	}

	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public Flux<Person> getPersonByName(@PathVariable("name") String name) {
		return PersonService.getPersonByName(name);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(value = HttpStatus.OK)
	public Mono<Void> deletePerson(@PathVariable("id") Integer id) {
		return PersonService.deletePersonById(id);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, consumes = "application/json")
	@ResponseStatus(code = HttpStatus.OK)
	public Mono<Person> update(@PathVariable("id") Integer id, @RequestBody Person Person) {
		return PersonService.getPersonById(id).flatMap(stale -> {
			stale.setName(Person.getName());
			return PersonService.savePerson(stale);
		});

	}
}
