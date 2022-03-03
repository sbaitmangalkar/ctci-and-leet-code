package com.sbaitman.ctci;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        boolean v = Boolean.parseBoolean("FalSe");
        System.out.println(v);
        List<Boolean> list = new ArrayList<>();
        list.add(true);
        list.add(Boolean.parseBoolean("FalSe"));
        list.add(Boolean.TRUE);
        System.out.println(list.size());
        System.out.println(list.get(1) instanceof Boolean);
    }
}
