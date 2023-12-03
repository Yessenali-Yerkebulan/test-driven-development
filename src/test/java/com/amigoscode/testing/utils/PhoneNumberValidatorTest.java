package com.amigoscode.testing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

class PhoneNumberValidatorTest {
    private PhoneNumberValidator underTest;

    @BeforeEach
    void setup(){
        underTest = new PhoneNumberValidator();
    }

   @ParameterizedTest
   @CsvSource({"+3828382889789,true"})
    void itShouldValidatePhoneNumber(String input, String expected){
        //When
        boolean isValid = underTest.test(input);
        //Then
        assertThat(isValid).isEqualTo(Boolean.valueOf(expected));
    }

    @Test
    @DisplayName("Bigger than 14 should fail")
    void itShouldValidatePhoneNumberWhenIncorrect (){
        //given
        String phoneNumber = "+38283828897894568";
        //When
        boolean isValid = underTest.test(phoneNumber);
        //Then
        assertThat(isValid).isFalse();
    }
}
