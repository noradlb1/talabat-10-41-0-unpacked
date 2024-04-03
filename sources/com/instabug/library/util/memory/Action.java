package com.instabug.library.util.memory;

public interface Action {
    void onAffirmed() throws Throwable;

    void onDenied() throws Throwable;
}
