package io.inorwa.springhib.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@ToString
@Table(name = "users")
public class User {
	@Id
	String login;

	@Column(name = "first_name")
	String firstName;

	@Column(name = "famioly_name")
	String familyName;

	public User(String login, String firstName, String familyName) {
		this.login = login;
		this.firstName = firstName;
		this.familyName = familyName;
	}

	public User() {
	}
}
