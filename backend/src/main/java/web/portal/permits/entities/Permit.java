package web.portal.permits.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "tb_permit")
public class Permit {

    public Permit() {
    }

    public Permit(Instant expirationDate, Instant issueDate, Instant deadLineDate, String number, String internalId, String name, String comments, boolean active, boolean hasExpiration) {
        this.expirationDate = expirationDate;
        this.issueDate = issueDate;
        this.deadLineDate = deadLineDate;
        this.number = number;
        this.internalId = internalId;
        this.name = name;
        this.comments = comments;
        this.active = active;
        this.hasExpiration = hasExpiration;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "expiration_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant expirationDate;
    @Column(name = "issue_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant issueDate;
    @Column(name = "deadline_date", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant deadLineDate;
    private String number;
    private String internalId;
    private String name;
    private String comments;
    private boolean active;
    private boolean hasExpiration;
    @Column(name = "created_at", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant createdAt;
    @Column(name = "UpdatedAt", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant UpdatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "company_id", nullable = false)
    @JsonBackReference
    private Company company;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "permit_status_id", nullable = false)
    private PermitStatus status;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "permit_type_id", nullable = false)
    private PermitType type;

    @OneToMany(mappedBy = "permit", fetch = FetchType.EAGER)
    private Set<Attachment> attachments;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public PermitStatus getStatus() {
        return status;
    }

    public void setStatus(PermitStatus status) {
        this.status = status;
    }

    public PermitType getType() {
        return type;
    }

    public void setType(PermitType type) {
        this.type = type;
    }

    public Set<Attachment> getAttachments() {
        return attachments;
    }

    public void setAttachments(Set<Attachment> attachments) {
        this.attachments = attachments;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Instant expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Instant getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Instant issueDate) {
        this.issueDate = issueDate;
    }

    public Instant getDeadLineDate() {
        return deadLineDate;
    }

    public void setDeadLineDate(Instant deadLineDate) {
        this.deadLineDate = deadLineDate;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getInternalId() {
        return internalId;
    }

    public void setInternalId(String internalId) {
        this.internalId = internalId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isHasExpiration() {
        return hasExpiration;
    }

    public void setHasExpiration(boolean hasExpiration) {
        this.hasExpiration = hasExpiration;
    }

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
}
