package com.instabug.library.core.eventbus;

import com.instabug.library.model.i;

public class ScreenCaptureEventBus extends EventBus<i> {
    private static ScreenCaptureEventBus INSTANCE;

    public static ScreenCaptureEventBus getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ScreenCaptureEventBus();
        }
        return INSTANCE;
    }
}
