package com.users.api.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.users.api.model.User;
import com.users.api.service.UserService;
import com.users.api.util.Response;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    private static final Logger logger = Logger.getLogger(UserController.class.getName());


    @GetMapping(value = "user", params = { "documentType", "documentNumber" })
    public ResponseEntity<Response> getUser(
            @RequestParam String documentType,
            @RequestParam String documentNumber) {
        try {
            logger.info("Init UserController getUser " + documentNumber);
            User user = userService.findUserById(documentType, documentNumber);
            ObjectMapper objectMapper = new ObjectMapper();
            
            if (user == null) {
                return new ResponseEntity<>(
                        new Response(false, "User Not Found by number "+ documentNumber +" or type document " + documentType, ""),
                        HttpStatus.BAD_REQUEST);
            }            

            return new ResponseEntity<>(
                    new Response(true, "User Found " + documentNumber, objectMapper.writeValueAsString(user) ),
                    HttpStatus.OK);

        } catch (Exception e) {
            logger.warning("Error " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
