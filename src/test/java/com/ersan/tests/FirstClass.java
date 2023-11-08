package com.ersan.tests;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {
    public static void main(String[] args) {

        Faker faker = new Faker();

        System.out.println("Fake Name = " + faker.name().fullName());

        System.out.println("Harry Potter Character = " + faker.harryPotter().character());

        System.out.println("Fake MASTERCARD Number = " + faker.finance().creditCard(CreditCardType.MASTERCARD));


    }

}

