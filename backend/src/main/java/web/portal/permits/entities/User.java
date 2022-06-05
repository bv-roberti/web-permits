package web.portal.permits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_usser")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
