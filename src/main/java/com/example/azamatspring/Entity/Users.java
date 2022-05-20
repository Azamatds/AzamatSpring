//package com.example.azamatspring.Entity;
//
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity(name = "user")
//@Table
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class Users {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
//    private Long id;
//
//    @Column(name = "username")
//    private String username;
//
//    @Column(name = "phone")
//    private String phone;
//
//    @Column(name = "password")
//    private String password;
//
//    @ManyToMany(fetch = FetchType.EAGER)
//    private List<Role> roles;
//}
//
