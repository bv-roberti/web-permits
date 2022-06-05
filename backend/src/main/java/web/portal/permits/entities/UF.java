package web.portal.permits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_uf")
public class UF {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
