package org.example;

public class Main {
    public static void main(String[] args) {
        StringListImp list= new StringListImp(2);
        list.add("new data one");
        System.out.println(list.size());
        System.out.println(list.get(0));
    }
}