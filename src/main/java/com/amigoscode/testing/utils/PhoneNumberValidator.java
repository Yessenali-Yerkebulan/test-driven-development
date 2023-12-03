package com.amigoscode.testing.utils;


import org.springframework.stereotype.Service;

import java.util.function.Predicate;

@Service
public class PhoneNumberValidator implements Predicate<String> {
    public boolean test(String phoneNumber) {
        return phoneNumber.startsWith("+") && phoneNumber.length() == 14;
    }
}
