package com.antra.singleton.usecase;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexExample {
    public static void main(String[] args) {
        String userdata = "dawei000021231231230tom10charlie220arthur300";
        System.out.println(Arrays.toString(userdata.split("\\d+")));

        String ssn = "123-14-1234";
        System.out.println(ssn.matches("\\d{3}-\\d{2}-\\d{4}"));

        String email = "aa@yahoo.com";
        System.out.println(email.matches("[a-z]+@\\w+\\.com"));

        String json = "[{\"id\":1,\"name\":\"milk\"},{\"id\":2,\"name\":\"water\"},{\"id\":3,\"name\":\"pea\"},{\"id\":4,\"name\":\"tomato\"},{\"id\":5,\"name\":\"cheese\"},{\"id\":6,\"name\":\"butter\"},{\"id\":7,\"name\":\"corn\"},{\"id\":8,\"name\":\"shrimp\"},{\"id\":9,\"name\":\"steak\"},{\"id\":10,\"name\":\"chicken\"},{\"id\":11,\"name\":\"carrot\"},{\"id\":12,\"name\":\"bacon\"},{\"id\":14,\"name\":\"apple\"}]";
        Pattern p = Pattern.compile("\"name\":\"(\\w+)\"");
        Matcher m = p.matcher(json);
        while (m.find()) {
            System.out.println(m.group(1));
        }
    }
}
