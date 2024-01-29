package com.sucre.datastructures.datastructure;

import com.sucre.datastructures.datastructure.tasks.Complex;
import com.sucre.datastructures.datastructure.tasks.Medium;
import com.sucre.datastructures.datastructure.tasks.Simple;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DatastructureApplication {

    public static void main(String[] args) {


        int[] intArray = new int[]{1,2,3,4,5};
        int[] intArraym = new int[]{3,4,5,1,2};

//        int numServers = 43;
//        List<Integer> serverFrom = List.of(1, 2,2);
//        List<Integer> serverTo = List.of(1,3,5);
//        List<Integer> serverWeight = List.of(2,4,3);
//        int signalSpeed = 5;
//
//        List<Integer> pairsCount = Complex.getNumPairs(numServers, serverFrom, serverTo, serverWeight, signalSpeed);
//
//        for (int i = 0; i < pairsCount.size(); i++) {
//            System.out.println("Server " + i + ": " + pairsCount.get(i) + " pairs");
//        }
//
////		Simple.merge(intArray,3,intArraym,3);
////		Simple.romanToInt("MCMXCIV");

//		Medium.prod?uctExceptSelfv2(intArray);

        int rst=Simple.strStr("hello","ll");

        SpringApplication.run(DatastructureApplication.class, args);
    }

}
