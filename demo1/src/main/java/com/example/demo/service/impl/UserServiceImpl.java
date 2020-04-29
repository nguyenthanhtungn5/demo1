package com.example.demo.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.UserRepository;
import com.example.demo.entity.UserEntity;
import com.example.demo.service.UserService;
import com.example.demo.shared.Utils;
import com.example.demo.shared.dto.UserDto;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	Utils utils;
	@Override
	public UserDto createUser(UserDto user) {
				
		if(userRepository.findByEmail(user.getEmail()) !=null) throw new RuntimeException("Record already exits") ;
		UserEntity userEntity=new UserEntity();
		BeanUtils.copyProperties(user, userEntity);
		
		String publicUserId=utils.generateUserId(30);
		
		
		userEntity.setEncytedPassword("test");
		userEntity.setUserId(publicUserId);
		UserEntity storedUserDetails=userRepository.save(userEntity);
		
		UserDto returnValue= new UserDto();
		BeanUtils.copyProperties(storedUserDetails, returnValue);
		return returnValue;
	}
}
