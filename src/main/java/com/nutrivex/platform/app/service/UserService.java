package com.nutrivex.platform.app.service;

import com.nutrivex.platform.app.models.User;

public interface UserService {
	public abstract User findUser(String email);
	public abstract User findUser(Long id);

}
