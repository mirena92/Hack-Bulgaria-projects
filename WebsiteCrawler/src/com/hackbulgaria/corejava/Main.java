package com.hackbulgaria.corejava;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws URISyntaxException {
        URL url;
        try {
            url = new URL(args[0]);
            WebsiteCrawler.crawler(url, args[1]);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}