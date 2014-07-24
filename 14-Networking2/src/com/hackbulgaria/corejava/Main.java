package com.hackbulgaria.corejava;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    
    public static void main(String[] args) throws URISyntaxException {
        URL url;
        try {
            url = new URL("http://www.fmi.uni-sofia.bg");
            WebsiteCrawler.crawler(url, "стипендии");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
