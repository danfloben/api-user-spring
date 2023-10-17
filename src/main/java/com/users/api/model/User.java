package com.users.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    
    @Id
    private Integer id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
    private String city;
    private String documentNumber;
    private DocumentType documentType; 
    
}
