package com.example.demo.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user")
    @Builder.Default
    private List<Address> addresses = new ArrayList<>();

    public void addAddress(Address address)
    {
        addresses.add(address);
        address.setUser(this);
    }

    public void removeAddress(Address address)
    {
        addresses.remove(address);
        address.setUser(null);
    }

    @ManyToMany
    @JoinTable
            (
                    name = "user_tags",
                    joinColumns = @JoinColumn(name = "user_id"),
                    inverseJoinColumns = @JoinColumn(name = "tag_id")
            )
    @Builder.Default
    private Set<Tag> tags = new HashSet<>();

    public void addTag(String name)
    {
        var tag = new Tag(name);
        this.tags.add(tag);
        tag.getUsers().add(this);
    }

    public void removeTag(String name)
    {
        var tag = new Tag(name);
        this.tags.remove(tag);
        tag.getUsers().remove(this);
    }

    @OneToOne(mappedBy = "user")
    private Profile profile;
}
