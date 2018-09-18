/*
 * Khoá học Java căn bản + nâng cao, Techmaster Vietnam
 * https://techmaster.vn
 * Biểu thức chính quy trong Java
 * Author: Mr Nguyen Duc Hoang
 * */
package com.JavaTechmaster.app;

import java.io.FileInputStream;
import java.io.IOException;
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
    RegexExample(String fileName){
        this.fileName = fileName;
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
}
