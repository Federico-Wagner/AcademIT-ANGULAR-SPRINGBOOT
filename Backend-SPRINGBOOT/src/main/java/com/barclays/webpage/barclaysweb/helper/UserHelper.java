package com.barclays.webpage.barclaysweb.helper;

import java.util.Random;


public class UserHelper {

    public static String generate_alias(){
        Random rand = new Random(); //instance of random class
        int upperbound = 25000000;
        //generate random values from 0- 25000000
        return String.valueOf(rand.nextInt(upperbound));
    }

    public static String generate_cbu(){
        Random rand = new Random(); //instance of random class
        int upperbound = 25000000;
        //generate random values from 0- 25000000
        return String.valueOf(rand.nextInt(upperbound));
    }
}
