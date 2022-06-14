package com.pidgeonsmssender.sdk;

public class PidgeonSMSSender
{
    public void send(final String num, final String txt) {
        System.out.println("{SMSSender} " + num + ": " + txt);
    }
}