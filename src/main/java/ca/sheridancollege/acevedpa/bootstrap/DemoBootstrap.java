package ca.sheridancollege.acevedpa.bootstrap;

import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.sheridancollege.acevedpa.domain.Address;
import ca.sheridancollege.acevedpa.domain.Categories;
import ca.sheridancollege.acevedpa.domain.Event;
import ca.sheridancollege.acevedpa.domain.Feedback;
import ca.sheridancollege.acevedpa.domain.Organizer;
import ca.sheridancollege.acevedpa.domain.Roles;
import ca.sheridancollege.acevedpa.domain.Ticket;
import ca.sheridancollege.acevedpa.domain.User;
import ca.sheridancollege.acevedpa.repositories.AddressRepository;
import ca.sheridancollege.acevedpa.repositories.EventRepository;
import ca.sheridancollege.acevedpa.repositories.FeedbackRepository;
import ca.sheridancollege.acevedpa.repositories.OrganizerRepository;
import ca.sheridancollege.acevedpa.repositories.TicketRepository;
import ca.sheridancollege.acevedpa.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DemoBootstrap implements CommandLineRunner {
	
	//repositories
	private AddressRepository addressRepository;
	private OrganizerRepository organizerRepository;
	private EventRepository eventRepository;
	private UserRepository userRepository;
	private TicketRepository ticketRepository;
	private FeedbackRepository feedbackRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		//create address (1)
		Address eventAddress1 = Address.builder()
				.addressLine1("Apple Line 1")
				.addressLine2("Apt. 5")
				.city("Toronto")
				.province("ON")
				.country("Canada")
				.postalCode("123JND")
				.build();
		eventAddress1 = addressRepository.save(eventAddress1);
		//create address (2)
		Address eventAddress2 = Address.builder()
				.addressLine1("Orange Line 2")
				.addressLine2("Suite 101")
				.city("Ottawa")
				.province("ON")
				.country("Canada")
				.postalCode("234KLM")
				.build();
		eventAddress2 = addressRepository.save(eventAddress2);
		
		//create organizer (1)
		Organizer organizer1 = Organizer.builder()
				.orgName("Monsters Inc.")
				.orgEmail("monster@gmail.com")
				.build();
		organizer1 = organizerRepository.save(organizer1);
		//create organizer (2)
		Organizer organizer2 = Organizer.builder()
				.orgName("SuperHeroes Inc.")
				.orgEmail("heroes@gmail.com")
				.build();
		organizer2 = organizerRepository.save(organizer2);
		
		//set time and date of event
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date eventDate = sdf.parse("2025-03-30");
	    Date eventDate2 = sdf.parse("2025-04-10");
	    
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    Date parsedTime = timeFormat.parse("18:30");  // Parse the time string to Date
	    Time eventTime = new Time(parsedTime.getTime()); 
	    Date parsedTime2 = timeFormat.parse("14:00");
	    Time eventTime2 = new Time(parsedTime2.getTime());
		
		//create event (1)
		Event event1 = Event.builder()
				.eventName("Meet A Monster")
				.description("Get to know a fellow monster!")
				.eventAddress(eventAddress1)
				.date(eventDate)
				.time(eventTime)
				.organizer(organizer1)
				.category(Categories.NETWORKING)
				.maxAttendees(30)
				.ticketPrice(new BigDecimal("20.00"))
				.build();
		event1 = eventRepository.save(event1);
		//create event (2)
		Event event2 = Event.builder()
				.eventName("Superhero Meetup")
				.description("Join us for a superhero gathering!")
				.eventAddress(eventAddress2)
				.date(eventDate2)
				.time(eventTime2)
				.organizer(organizer2)
				.category(Categories.NETWORKING)
				.maxAttendees(50)
				.ticketPrice(new BigDecimal("25.00"))
				.build();
		event2 = eventRepository.save(event2);
		
		//set time and date of registration
	    Date userRegistrationDate = sdf.parse("2025-03-01");
		
		//create user
		User user1 = User.builder()
				.username("user123")
				.userEmail("user123@gmail.com")
				.userPassword("1234") //needs to be encrypted**
				.role(Roles.EVENTHUNT_USER)
				.registrationDate(userRegistrationDate)
				.build();
		user1 = userRepository.save(user1);
		
		//create ticket
		Ticket ticket1 = Ticket.builder()
				.ticketPurchaseDate(eventDate)
				.user(user1)
				.event(event1)
				.build();
		ticket1 = ticketRepository.save(ticket1);
		//another ticket for the same user
		Ticket ticket2 = Ticket.builder()
				.ticketPurchaseDate(eventDate)
				.user(user1)
				.event(event1)
				.build();
		ticket2 = ticketRepository.save(ticket2);
		//ticket for the same user but joining the other event instead
		Ticket ticket3 = Ticket.builder()
				.ticketPurchaseDate(eventDate)
				.user(user1)
				.event(event2)
				.build();
		ticket3 = ticketRepository.save(ticket3);
		
		//create feedback
		Feedback feedback1 = Feedback.builder()
				.rating(5L)
				.comment("Great event!")
				.feedbackDate(new Date())
				.event(event1)
				.user(user1)
				.build();
		feedback1 = feedbackRepository.save(feedback1);

	}

}
