package web.portal.permits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_permit")
public class Permit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
