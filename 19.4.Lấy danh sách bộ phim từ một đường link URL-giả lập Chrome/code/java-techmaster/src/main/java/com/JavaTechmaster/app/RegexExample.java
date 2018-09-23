/*
 * Khoá học Java căn bản + nâng cao, Techmaster Vietnam
 * https://techmaster.vn
 * Biểu thức chính quy trong Java
 * Author: Mr Nguyen Duc Hoang
 * */
package com.JavaTechmaster.app;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    private String fileName;
    private String requestURL;

    RegexExample(String fileName, String requestURL) {
        this.fileName = fileName;
        this.requestURL = requestURL;
    }
    public String readStringFromURL(){
        try {
            System.setProperty("http.agent", "Chrome");
            URL url = new URL(requestURL);
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
            String inputLine;
            String content = "";
            while ((inputLine = in.readLine()) != null) {
                content += inputLine;
            }
            in.close();
            return content;
        } catch (Exception e) {
            System.out.println("Cannot read from url : "+requestURL);
            return  "";
        }
    }
    public List<String> findFilmNamesFromURL() {
        //<span class="movie-title-1">(.*?)</span>
        final List<String> matches = new ArrayList<>();
        try {
            Pattern pattern = Pattern.compile(
                    "(<span class=\"movie-title-1\">)(.*?)(</span>)",
                    Pattern.CASE_INSENSITIVE);
            CharSequence fileContent = readStringFromURL();
            Matcher matcher = pattern.matcher(fileContent);
            while (matcher.find()) {
                //String x0 = matcher.group(0);
                //String x1 = matcher.group(1);
                // x2 = matcher.group(2);
                //String x3 = matcher.group(3);
                matches.add(matcher.group(2));
                //System.out.println("aa");
            }
            return matches;
        } catch (NullPointerException e) {

        }
        return matches;
    }

    public CharSequence readFromFile() {
        CharBuffer cbuf = null;
        try {
            FileInputStream input = new FileInputStream(fileName);
            FileChannel channel = input.getChannel();
            ByteBuffer bbuf = channel.map(FileChannel.MapMode.READ_ONLY,
                    0, (int)channel.size());
            cbuf = Charset.forName(StandardCharsets.UTF_8.name()).newDecoder().decode(bbuf);
        } catch (IOException e) {
            return cbuf;
        }
        return cbuf;
    }
    public List<String> findEmails(){
        //Email regex : [A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,6}
        final List<String> matches = new ArrayList<>();
        Pattern pattern = Pattern.compile(
                "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}",
                Pattern.CASE_INSENSITIVE);
        CharSequence fileContent = readFromFile();
        Matcher matcher = pattern.matcher(fileContent);
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }
    public List<String> findFilmNames() {
        //<span class="movie-title-1">(.*?)</span>
        final List<String> matches = new ArrayList<>();
        try {
            Pattern pattern = Pattern.compile(
                    "(<span class=\"movie-title-1\">)(.*?)(</span>)",
                    Pattern.CASE_INSENSITIVE);
            CharSequence fileContent = readFromFile();
            Matcher matcher = pattern.matcher(fileContent);
            while (matcher.find()) {
                //String x0 = matcher.group(0);
                //String x1 = matcher.group(1);
                // x2 = matcher.group(2);
                //String x3 = matcher.group(3);
                matches.add(matcher.group(2));
                //System.out.println("aa");
            }
            return matches;
        } catch (NullPointerException e) {

        }
        return matches;
    }
}
