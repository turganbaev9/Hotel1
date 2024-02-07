package kg.mega.hotel1.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Getter
@Entity
@Table(name = "tb_order")
@Setter
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToMany
    List<Client> client;
    @OneToMany
    List<Discount> discount;
    @OneToMany List<Price> price;

    @ManyToOne Room room;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateTimeFrom;
    @JsonFormat(pattern = "dd-MM-yyyy")
    LocalDate dateTimeTo;
    Double priceBeforeDiscount;
    Double priceWithDiscount;
}

