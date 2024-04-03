package com.newrelic.agent.android.unity;

import java.lang.Thread;

public class NewRelicUnity {
    public static void handleUnityCrash(UnityException unityException) {
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler != null) {
            defaultUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), unityException);
        }
    }
}
