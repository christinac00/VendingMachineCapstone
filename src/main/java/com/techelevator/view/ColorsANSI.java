package com.techelevator.view;

public class ColorsANSI {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";



    public static void main(String[] args) {
        System.out.println(ANSI_PURPLE + "is this red" + ANSI_RESET);
    }

}



