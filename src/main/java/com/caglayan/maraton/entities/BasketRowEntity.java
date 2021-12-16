package com.caglayan.maraton.entities;

import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@ToString
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "basket_row")
public class BasketRowEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long basketRowId;

    @Column(name = "number")
    private int number;

    @Column(name = "price")
    private double price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "basket_id", referencedColumnName = "id")
    private BasketEntity basket;
}
