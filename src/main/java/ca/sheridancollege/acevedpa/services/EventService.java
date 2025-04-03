package ca.sheridancollege.acevedpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.acevedpa.domain.Event;

@Service
public interface EventService {

	//must haves for all services
	public Optional<Event> findById(Long id);
	public List<Event> findAll();
	public Event save(Event event);
}
