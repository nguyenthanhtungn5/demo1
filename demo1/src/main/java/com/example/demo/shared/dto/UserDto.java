package com.example.demo.shared.dto;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto implements Serializable{
	private static final long serialVersionUID =3L;
	private long id;
	private String userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String encytedPassword;
	private String emailVerificationToken;
	private Boolean emailVerificationStatus=false;
}
