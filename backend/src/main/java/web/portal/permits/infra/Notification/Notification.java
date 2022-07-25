package web.portal.permits.infra.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.portal.permits.entities.Permit;
import web.portal.permits.entities.User;
import web.portal.permits.infra.mail.EmailImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class Notification implements NotificationContract {

    @Autowired
    private EmailImpl mail;

    @Override
    public void NotifyExpiration(List<Permit> lstPermits, User user) throws IOException {
        var subject = "Aviso de vencimento";

        mail.sendHTML(user.getEmail(), subject, pepareContent(lstPermits, user));
    }

    private String readFromInputStream(InputStream inputStream)
            throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br
                     = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    private String pepareContent(List<Permit> lstPermits, User user) throws IOException {
        var mailTemplate = "./Mail/Templates/itemExpired.html";

        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(mailTemplate);
        String content = readFromInputStream(inputStream);


        content = content.replace("[CONTATO]", user.getName());

        StringBuilder output = new StringBuilder();

        output.append("<table class=\"<table table-striped\" border=\"1\">");
        output.append("<thead class=\"thead-dark\">");
        output.append("<tr>");

        output.append("<td>");
        output.append("<h4><strong>Item</strong></h4>");
        output.append("</td>");
        output.append("<td>");
        output.append("<h4><strong> Regional </strong></h4>");
        output.append("</td>");
        output.append("<td>");
        output.append("<h4><strong> Unidade </strong></h4>");
        output.append("</td>");
        output.append("<td>");
        output.append("<h4><strong> Tipo </strong></h4>");
        output.append("</td>");
        output.append("<td>");
        output.append("<h4><strong> Vencimento </strong></h4>");
        output.append("</td>");

        output.append("<td>");
        output.append("<h4><strong> Data de renovacao </strong></h4>");
        output.append("</td>");

        output.append("<td>");
        output.append("<h4><strong> Status </strong></h4>");
        output.append("</td>");

        output.append("</tr>");
        output.append("</thead>");
        output.append("<tbody>");

        int coun = 0;

        for (Permit item : lstPermits)
        {
            coun += 1;
            output.append("<tr>");
            output.append("<td>" + coun + "</td>");
            output.append("<td>" + item.getCompany().getRegion() + "</td>");
            output.append("<td>" + item.getCompany().getName() + "</td>");
            output.append("<td>" + item.getName() + "</td>");
            output.append("<td>" + item.getExpirationDate().toString()  + "</td>");
            output.append("<td>" + item.getDeadLineDate().toString() + "</td>");
            output.append("<td>" + item.getStatus() + "</td>");

            output.append("</tr>");
        }

        output.append("</tbody>");
        output.append("</table>");

        content = content.replace("[TABLE]", output.toString());

        return content;
    }

}
