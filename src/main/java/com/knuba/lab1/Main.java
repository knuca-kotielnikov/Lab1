package com.knuba.lab1;

import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) {

        String string = "We have the java learning course!";

        List<String> subStrings = Arrays.asList(string.split(" "));

        subStrings.forEach(Main::printWithMinuteInterrupt);
    }

    private static void printWithMinuteInterrupt(String word) {
        System.out.println(word);
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
