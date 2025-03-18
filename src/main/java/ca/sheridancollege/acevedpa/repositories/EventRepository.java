package ca.sheridancollege.acevedpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.acevedpa.domain.Event;

public interface EventRepository extends JpaRepository<Event, Long> {

}
