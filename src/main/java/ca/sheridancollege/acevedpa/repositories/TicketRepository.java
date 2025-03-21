package ca.sheridancollege.acevedpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.acevedpa.domain.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
