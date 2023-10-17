package com.users.api.service;

import com.users.api.model.User;

public interface UserService {
    User findUserById(String documentType, String documentNumber);
}
