package web.portal.permits.entities;

import javax.persistence.*;

@Entity
@Table(name = "tb_attachment")
public class Attachment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
}
