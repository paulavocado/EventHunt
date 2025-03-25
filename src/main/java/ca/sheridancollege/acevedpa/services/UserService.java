package ca.sheridancollege.acevedpa.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.sheridancollege.acevedpa.domain.User;

@Service
public interface UserService {
	
	//must haves for all services
	public Optional<User> findById(Long id);
	public List<User> findAll();
	public User save(User user);

}
