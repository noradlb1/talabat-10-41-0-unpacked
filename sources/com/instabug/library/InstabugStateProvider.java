package com.instabug.library;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;

public class InstabugStateProvider {
    @Nullable
    private static InstabugStateProvider instance;
    @NonNull
    private InstabugState state = InstabugState.BUILDING;

    private InstabugStateProvider() {
    }

    public static synchronized InstabugStateProvider getInstance() {
        InstabugStateProvider instabugStateProvider;
        synchronized (InstabugStateProvider.class) {
            if (instance == null) {
                instance = new InstabugStateProvider();
            }
            instabugStateProvider = instance;
        }
        return instabugStateProvider;
    }

    @NonNull
    public InstabugState getState() {
        return this.state;
    }

    public void setState(@NonNull InstabugState instabugState) {
        InstabugSDKLogger.d("IBG-Core", "Setting Instabug SDK state to " + instabugState.name());
        this.state = instabugState;
    }
}
