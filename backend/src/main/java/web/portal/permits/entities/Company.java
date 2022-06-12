package web.portal.permits.entities;

import java.time.Instant;
import javax.annotation.Nullable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_company")
public class Company {

  public Company() {}

  public Company(String name, String cnpj) {
    this.name = name;
    this.cnpj = cnpj;
    this.createdAt = Instant.now();
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Long id;

  @Column(name = "NAME")
  private String name;

  @Column(name = "created_at")
  private Instant createdAt;

  @Column(name = "CNPJ")
  private String cnpj;

  private boolean active;
  @Nullable
  private String region;
  @Nullable
  private String localization;

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }

  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public String getLocalization() {
    return localization;
  }

  public void setLocalization(String localization) {
    this.localization = localization;
  }


  @ManyToOne
  @JoinColumn(name = "uf_id", nullable = false)
  private UF uf;

  @OneToMany(mappedBy = "company", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Permit> permits = new HashSet<>();

  public UF getUf() {
    return uf;
  }

  public void setUf(UF uf) {
    this.uf = uf;
  }

  public Set<Permit> getPermits() {
    return permits;
  }

  public void setPermits(Set<Permit> permits) {
    this.permits = permits;
  }



  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCnpj() {
    return cnpj;
  }

  public void setCnpj(String cnpj) {
    this.cnpj = cnpj;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  @PrePersist
  public void prePersist() {
    createdAt = Instant.now();
    active = true;
  }
}
