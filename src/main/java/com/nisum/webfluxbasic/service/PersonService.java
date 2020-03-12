package com.nisum.webfluxbasic.service;

import com.nisum.webfluxbasic.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nisum.webfluxbasic.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;

	public Mono<Person> savePerson(Person Person) {
		return personRepository.save(Person).map(p->{
			System.out.println("---------"+p.getName());
			return p;
		});
	}

	public Flux<Person> getAllPersonsData() {
		return personRepository.findAll();
	}

	public Mono<Person> getPersonById(Integer id) {
		return personRepository.findById(id);
	}

	public Flux<Person> getPersonByName(String name) {
		return personRepository.findPersonByName(name);
	}

	public Mono<Void> deletePersonById(Integer id) {
		return personRepository.deleteById(id);
	}
}
