package com.gacha.server.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * @author Namhoon
 */
@Data
@EqualsAndHashCode(of = { "latitude", "longitude" })
@Entity
@Table(name = "restaurants")
public class Restaurant {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@NaturalId
	@Column(unique = true, nullable = false)
	private double latitude;

	@NaturalId
	@Column(unique = true, nullable = false)
	private double longitude;

	@Column(nullable = false, length = 100)
	private String name;

	@Column(nullable = false)
	@Size(min = 0, max = 100)
	private int score;
}
