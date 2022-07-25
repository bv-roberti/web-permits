package web.portal.permits.infra.mail;

import java.io.IOException;

public interface EmailServiceInterface {
    void sendHTML(String to, String subject, String body) throws IOException;

}
