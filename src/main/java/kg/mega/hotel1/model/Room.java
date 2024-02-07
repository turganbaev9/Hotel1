package kg.mega.hotel1.model;

import javax.persistence.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "tb_room")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor

@FieldDefaults(level = AccessLevel.PRIVATE)
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Integer rooms;
    Boolean isAvailable;
    @OneToOne
    Client client;
    Category category;
}

