package web.portal.permits.infra.Notification;

import web.portal.permits.entities.Permit;
import web.portal.permits.entities.User;

import java.io.IOException;
import java.util.List;

public interface NotificationContract {
    void NotifyExpiration(List<Permit> lstPermits, User user) throws IOException;
}
