package ca.sheridancollege.acevedpa.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.acevedpa.domain.Roles;
import ca.sheridancollege.acevedpa.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
    //find user by username (single user)
    Optional<User> findByUsername(String username);

    //find user by email (single user)
    Optional<User> findByUserEmail(String userEmail);

    //find all users with a specific role
    List<User> findByRole(Roles role);
    
    //find all users who registered before specified date
    List<User> findByRegistrationDateBefore(Date date);
    
    //find all users who registered after specified date
    List<User> findByRegistrationDateAfter(Date date);

}
