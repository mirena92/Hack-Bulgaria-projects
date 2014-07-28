package com.hackbulgaria.corejava;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL(args[0]);
            DownloadFile.download(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
