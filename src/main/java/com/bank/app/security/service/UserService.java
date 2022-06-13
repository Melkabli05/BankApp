package com.bank.app.security.service;

import com.bank.app.model.User;
import com.bank.app.security.dto.AuthenticatedUserDto;
import com.bank.app.security.dto.RegistrationRequest;
import com.bank.app.security.dto.RegistrationResponse;


public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
