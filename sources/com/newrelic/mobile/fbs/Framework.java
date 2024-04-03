package com.newrelic.mobile.fbs;

public final class Framework {
    public static final byte Native = 0;
    public static final byte ReactNative = 1;
    public static final String[] names = {"Native", "ReactNative"};

    private Framework() {
    }

    public static String name(int i11) {
        return names[i11];
    }
}
