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
import ca.sheridancollege.acevedpa.domain.Organizer;
import ca.sheridancollege.acevedpa.domain.Roles;
import ca.sheridancollege.acevedpa.domain.User;
import ca.sheridancollege.acevedpa.repositories.AddressRepository;
import ca.sheridancollege.acevedpa.repositories.EventRepository;
import ca.sheridancollege.acevedpa.repositories.OrganizerRepository;
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
	
	@Override
	public void run(String... args) throws Exception {
		
		//create address
		Address eventAddress1 = Address.builder()
				.addressLine1("Apple Line 1")
				.addressLine2("Apt. 5")
				.city("Toronto")
				.province("ON")
				.country("Canada")
				.postalCode("123JND")
				.build();
		eventAddress1 = addressRepository.save(eventAddress1);
		
		//create organizer
		Organizer organizer1 = Organizer.builder()
				.orgName("Monsters Inc.")
				.orgAddress("monster@gmail.com")
				.build();
		organizer1 = organizerRepository.save(organizer1);
		
		
		//set time and date of event
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Date eventDate = sdf.parse("2025-03-30");
	    
	    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
	    Date parsedTime = timeFormat.parse("18:30");  // Parse the time string to Date
	    Time eventTime = new Time(parsedTime.getTime()); 
		
		//create event
		Event event1 = Event.builder()
				.eventName("Meet A Monster")
				.description("Get to know a fellow monster!")
				.eventAddress(eventAddress1)
				.date(eventDate)
				.time(eventTime)
				.category(Categories.NETWORKING)
				.maxAttendees(30)
				.ticketPrice(new BigDecimal("20.00"))
				.build();
		event1 = eventRepository.save(event1);
		
		//set time and date of registration
	    Date userRegistrationDate = sdf.parse("2025-03-01");
		
		//create user
		User user1 = User.builder()
				.username("user123")
				.userEmail("user123@gmail.com")
				.role(Roles.EVENTHUNT_USER)
				.registrationDate(userRegistrationDate)
				.build();
		user1 = userRepository.save(user1);
		
		//create ticket
		
		//create feedback

	}

}
