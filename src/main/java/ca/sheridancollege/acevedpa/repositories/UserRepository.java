package ca.sheridancollege.acevedpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.acevedpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
