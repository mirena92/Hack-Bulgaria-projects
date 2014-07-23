package com.hackbulgaria.corejava;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.*;

public class SendEmail {

    public static void main(String args[]) throws MalformedURLException, EmailException {

        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif"));

        MultiPartEmail email = new MultiPartEmail();

        email.setHostName("smtp.googlemail.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("kermilska", "******"));
        email.setSSLOnConnect(true);
        email.setFrom("kermilska@gmail.com", "Reni");
        email.setSubject("Suarez-Chiellini");
        email.setMsg("Suarez is crazy!");
        email.addTo("kermilska@gmail.com");
        email.attach(attachment);
        email.send();
    }
}
