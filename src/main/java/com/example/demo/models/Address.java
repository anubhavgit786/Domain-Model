package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Table(name = "addresses")
public class Address
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "street", nullable = false)
    private String street;

    @Column(name = "city", nullable = false)
    private String city;

    @Column(name = "zip", nullable = false)
    private String zip;

    @Column(name = "state", nullable = false)
    private String state;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @ToString.Exclude
    private User user;
}