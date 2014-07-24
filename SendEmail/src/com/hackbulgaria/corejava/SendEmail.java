package com.hackbulgaria.corejava;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.*;

public class SendEmail {

    public static final int PORT = 465;

    public static void main(String args[]) throws MalformedURLException, EmailException {

        MultiPartEmail email = new MultiPartEmail();

        email.addTo(args[0]);
        email.setSubject(args[1]);
        email.setMsg(args[2]);
        email.setHostName("smtp." + args[3].substring(args[3].lastIndexOf("@") + 1));
        email.setSmtpPort(PORT);
        email.setAuthenticator(new DefaultAuthenticator(args[5], args[6]));
        email.setSSLOnConnect(true);
        email.setFrom(args[3], args[4]);

        if (!args[7].isEmpty()) {
            EmailAttachment attachment = new EmailAttachment();
            attachment.setURL(new URL(args[7]));
            email.attach(attachment);
        }
        email.send();
    }
}
