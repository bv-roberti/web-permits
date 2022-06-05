package web.portal.permits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
