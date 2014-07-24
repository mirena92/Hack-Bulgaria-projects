package com.hackbulgaria.corejava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebsiteCrawler {

    public static void crawler(URL url, String needle) throws IOException, URISyntaxException {

        String content = getContent(url);
        if (content.toLowerCase().contains(needle.toLowerCase())) {
            System.out.println(url.toString());
        } else
            searchInLinks(url, getAllLinks(content), needle);
    }

    private static List<String> getAllLinks(String content) {
        ArrayList<String> resultList = new ArrayList<>();
        String regex = "<a.*?href=\"((?!javascript).*?)\".*?>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            resultList.add(matcher.group(1));
        }
        return resultList;
    }

    public static String getContent(URL url) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(new String(inputLine.getBytes(), StandardCharsets.UTF_8)).append(System.lineSeparator());
        }
        in.close();
        return content.toString();
    }

    private static void searchInLinks(URL parent, List<String> allLinks, String needle) throws MalformedURLException,
            URISyntaxException {
        URI uri = null;
        for (String link : allLinks) {
            try {
                String newLink = link.replaceAll("..", "").replaceAll("/{2,}", "/");
                uri = new URI(link).normalize();

                if(!uri.isAbsolute()) {
                    uri = new URI (parent.toString() + "/" + newLink);
                }
                String content = getContent(uri.toURL());
                if (content.toLowerCase().contains(needle.toLowerCase())) {
                    System.out.println(uri.toString());
                } else {
                    searchInLinks(uri.toURL(), getAllLinks(link), needle);
                }
            } catch (IOException e) {
                System.out.println("—чупен линк: " + uri.toString());
                continue;
            }
        }
    }
}
