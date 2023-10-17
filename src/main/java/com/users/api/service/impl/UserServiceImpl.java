package com.users.api.service.impl;

import org.springframework.stereotype.Service;

import com.users.api.model.DocumentType;
import com.users.api.model.User;
import com.users.api.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User findUserById(String documentType, String documentNumber) {
        User userMock = new User(1,
                "Daniel",
                "Florez",
                "3206194814",
                "Cra 17 # 11-11",
                "Manizales",
                "23445322",
                DocumentType.ID_CARD);
        if (documentType.equals(DocumentType.ID_CARD.getDocumentType()) &&
                documentNumber.equals(userMock.getDocumentNumber())) {
            return userMock;
        } else {
            return null;
        }
    }
}
