package com.hackbulgaria.corejava;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class DownloadFile {
    
    public static void download(URL url) throws URISyntaxException, IOException {
        BufferedInputStream input = new BufferedInputStream(url.openStream());
        String filename = url.toString().substring(url.toString().lastIndexOf("/")+1);
        FileOutputStream output = new FileOutputStream(new File(filename));
        int i = input.read();
        
        while(i!=-1) {
            output.write(i);
            i = input.read();
        }
        input.close();
        output.close();
    }

    public static void main(String[] args) {
        try {
            URL url = new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/aozrdx0_700b.jpg");
            DownloadFile.download(url);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (URISyntaxException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
