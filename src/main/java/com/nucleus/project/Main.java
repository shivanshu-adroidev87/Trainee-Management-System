package com.nucleus.project;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Main {
    public static void main(String[] args)
    {
        String rawPassword = "$2a$10$958MpHZVRZG34O42Zi2nguYZS7FttZslPPMJvUDGEHdPwlPVyl.bG";

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(rawPassword);

        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);
    }
}
