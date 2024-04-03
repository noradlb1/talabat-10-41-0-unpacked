package com.instabug.library.util.threading;

import android.os.Handler;
import android.os.HandlerThread;
import io.reactivex.annotations.NonNull;

public class HandlerThreadProvider {
    public static void run(@NonNull String str, @NonNull Runnable runnable) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        new Handler(handlerThread.getLooper()).post(runnable);
    }
}
