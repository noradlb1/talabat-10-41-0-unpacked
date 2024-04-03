package com.newrelic.mobile.fbs.ios;

public final class Arch {
    public static final byte arm64 = 1;
    public static final byte armv7 = 0;
    public static final String[] names = {"armv7", "arm64"};

    private Arch() {
    }

    public static String name(int i11) {
        return names[i11];
    }
}
