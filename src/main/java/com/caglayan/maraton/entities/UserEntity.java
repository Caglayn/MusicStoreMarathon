package com.caglayan.maraton.entities;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long userId;

    @Column(name = "name")
    private String userName;

    @Column(name = "lastname")
    private String userLastname;

    @Column(name = "email")
    private String eMail;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "isadmin")
    private Boolean isAdmin = false;

    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<BasketEntity> baskets = new HashSet<>();

    public void addBasket(BasketEntity basket){
        if (this.baskets == null){
            this.baskets = new HashSet<>();
        }
        this.baskets.add(basket);
    }
}
