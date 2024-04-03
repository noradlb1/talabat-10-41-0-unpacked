package com.instabug.library.diagnostics.nonfatals.networking;

public class a extends Exception {
    public a(String str) {
        super("NonFatal sync request error - " + str);
    }
}
