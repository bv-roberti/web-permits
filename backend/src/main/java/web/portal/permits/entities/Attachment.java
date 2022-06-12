package web.portal.permits.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_attachment")
public class Attachment {

    public Attachment() {
    }

    public Attachment(String name, String description, String keyFile, Instant issuedDate) {
        this.name = name;
        this.description = description;
        this.keyFile = keyFile;
        this.issuedDate = issuedDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long Id;

    private String name;
    private String description;
    private String keyFile;
    private Instant issuedDate;
    private Instant createdAt;
    private Instant UpdatedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(Instant updateddAt) {
        UpdatedAt = updateddAt;
    }


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "permit_id", nullable = false)
    private Permit permit;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getKeyFile() {
        return keyFile;
    }

    public void setKeyFile(String keyFile) {
        this.keyFile = keyFile;
    }

    public Instant getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(Instant issuedDate) {
        this.issuedDate = issuedDate;
    }

    @PrePersist
    public void prePersist() {
        createdAt = Instant.now();
    }
}
