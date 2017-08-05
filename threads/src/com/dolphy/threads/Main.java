package com.dolphy.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static ThreadLocal<Connection> connectionHolder = new ThreadLocal<Connection>() {
        public Connection initialValue() {
            return new Connection();
        }
    };

    public static void main(String[] args) {
        Connection myConn = connectionHolder.get();
        System.out.printf("Connection ID = %d", myConn.getId());

        List<Widget> widgetList = new Collections.synchronizedList(new ArrayList<Widget>());

    }
}
