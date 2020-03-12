package com.nisum.webfluxbasic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Tetst
{

    public static void main(String[] arr){

        List<String> lines = Arrays.asList("spring", "node", "mkyong");

        List<String> result = lines.stream()                // convert list to stream
                .filter(line -> !"mkyong".equals(line))     // we dont like mkyong
                .collect(Collectors.toList());              // collect the output and convert streams to a List

        //result.forEach(System.out::println);

        List<Person> persons = Arrays.asList(
                new Person("mkyong", 30),
                new Person("jack", 20),
                new Person("lawrence", 40)
        );


        List<String> memberNames = new ArrayList<>();
        memberNames.add("Amitabh");
        memberNames.add("Shekhar");
        memberNames.add("Aman");
        memberNames.add("Rahul");
        memberNames.add("Shahrukh");
        memberNames.add("Salman");
        memberNames.add("Yana");
        memberNames.add("Lokesh");

        Optional<Person> result2=persons.stream().filter(p->p.getName().equals("jack")&&(p.getAge()==20)).findFirst();
        System.out.println(result2);

        List list = persons.stream().filter(p->p.getName().startsWith("j")).collect(Collectors.toList());

        list.forEach(System.out::println);

        Optional<String> reduced = memberNames.parallelStream() //Amitabh#Shekhar#Aman#Rahul#Shahrukh#Salman#Yana#Lokesh
                .reduce((s1,s2) -> s1 + "#" + s2);

        reduced.ifPresent(System.out::println);
    }
}
