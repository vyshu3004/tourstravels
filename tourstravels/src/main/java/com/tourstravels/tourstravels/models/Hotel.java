package com.tourstravels.tourstravels.models;

import lombok.*;
import jakarta.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String hName;
	private int fare;
	private String city;
	private String state;
	private String country;
	private String date;
	private String mode;
	@Lob
	@Column(columnDefinition = "longtext")
	private String photo;

}
