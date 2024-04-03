package com.instabug.commons.snapshot;

public interface Captor {
    void force();

    int getId();

    boolean isShutdown();

    void shutdown();

    void start();
}
