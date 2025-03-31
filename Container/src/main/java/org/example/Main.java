package org.example;

import org.example.Container.Container;

public class Main {
    public static void main(String[] args) {
        Container container = new Container();

        container.add(10);
        container.add(20);
        container.add(30);

        for (Integer num : container) {
            System.out.println(num);
        }

        container.remove(1);
        System.out.println("Size after removal: " + container.size());
    }
}