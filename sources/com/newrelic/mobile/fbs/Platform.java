package com.newrelic.mobile.fbs;

public final class Platform {
    public static final byte Android = 0;
    public static final byte iOS = 1;
    public static final String[] names = {"Android", "iOS", "tvOS"};
    public static final byte tvOS = 2;

    private Platform() {
    }

    public static String name(int i11) {
        return names[i11];
    }
}
