package web.portal.permits.entities;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_audit")
public class Audit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    private String user;
    private String eventLog;
    private String action;
    private String entity;
    private Instant timeStamp;

    public Audit() {
    }

    public Audit(String user, String eventLog, String action, String entity) {
        this.user = user;
        this.eventLog = eventLog;
        this.action = action;
        this.entity = entity;
    }

    public Long getId() {
        return id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEventLog() {
        return eventLog;
    }

    public void setEventLog(String eventLog) {
        this.eventLog = eventLog;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

    public Instant getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Instant timeStamp) {
        this.timeStamp = timeStamp;
    }
}
