package com.botland.backrabbit;

import com.botland.backrabbit.view.View;

/**
 * Author: Vladimir Batygin
 * Date: 06.01.2010
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, I am Back Rabbit!");
        View view = new View();
        view.setVisible(true);
        view.createBufferStrategy(3

        );
    }
}
