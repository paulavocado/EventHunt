package ca.sheridancollege.acevedpa.domain;

import java.math.BigDecimal;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Event {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long eventID;
	
	@NonNull
	private String eventName;
	@NonNull
	private String description;
	@OneToOne
	private Address eventAddress;
	@NonNull
	private Date date;
	@NonNull
	private Time time;
	
	//to reference object
	//TODO - ensure that only one organizer can have an event...
	//sometimes multiple organizers host 1 event
	@ManyToOne
	private Organizer organizer;
	
	//TODO - consider making this a list of enums
	@Enumerated(EnumType.STRING)
	private Categories category;
	//private List<Categories> categories;

	private Integer maxAttendees;
	@NonNull
	private BigDecimal ticketPrice;
}
