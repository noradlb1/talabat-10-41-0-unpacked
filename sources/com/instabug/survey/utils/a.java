package com.instabug.survey.utils;

import java.util.concurrent.TimeUnit;

public abstract class a {
    public static int a(long j11) {
        return (int) TimeUnit.MILLISECONDS.toDays(System.currentTimeMillis() - j11);
    }

    public static int b(long j11) {
        return (int) TimeUnit.SECONDS.toDays((System.currentTimeMillis() / 1000) - j11);
    }
}
