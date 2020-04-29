package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
@Entity(name="users")
@Getter
@Setter
public class UserEntity implements Serializable{

	private static final long serialVersionUID = 999861692305194974L;
	@Id
	@GeneratedValue
	private long id;
	@Column(nullable=false)
	private String userId;
	@Column(nullable=false, length=50)
	private String firstName;
	@Column(nullable=false,length=50)
	private String lastName;
	@Column(nullable=false,length=120,unique=true)
	private String email;
	private String encytedPassword;
	private String emailVerificationToken;
	@Column(nullable=false)
	private Boolean emailVerificationStatus=false;
}
