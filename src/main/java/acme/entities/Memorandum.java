package acme.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

public class Memorandum extends AbstractEntity {
	
	// Serialisation identifier -----------------------------------------------
	
	protected static final long serialVersionUID = 1L;
	
	// Attributes -------------------------------------------------------------
	
	@NotBlank
	@Column(unique = true)
	@Pattern(regexp = "^([A-Z]{2}:)?[A-Z]{3}-[0-9]{3}\\:[0-9]{4}$")
	protected String sequenceNumber;

	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date creationMoment;
	
	@NotBlank
	@Length(max = 255)
	protected String report;
	
	@URL
	protected String link;
	
	// Derived attributes -----------------------------------------------------
	
	// Relationships ----------------------------------------------------------
	
	@NotNull
	@Valid
	@ManyToOne(optional=false)
	protected FineDish fineDish;
}