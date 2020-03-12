package com.nisum.webfluxbasic.repository;

import com.nisum.webfluxbasic.model.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveCrudRepository<Person, Integer> {

	@Query("{'name':?0}")
	Flux<Person> findPersonByName(final String name);

}
