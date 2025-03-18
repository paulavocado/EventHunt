package ca.sheridancollege.acevedpa.domain;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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
@Table(name = "_user") 
public class User {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long userID;
	
	@NonNull
	private String username;
	private String userEmail;
	@NonNull
	private String userPassword;
	
	@Enumerated(EnumType.STRING)
	private Roles role;
	
	private Date registrationDate;
	 
	//TODO- double check this! user HAS tickets not the other way around
	//they may have multiple tickets
	//this is because every ticket should have a unique id
	//@OneToMany
	//private List<Ticket> tickets;
}
