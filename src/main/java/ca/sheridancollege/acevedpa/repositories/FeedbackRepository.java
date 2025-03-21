package ca.sheridancollege.acevedpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.acevedpa.domain.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
