package com.instabug.library.core.eventbus;

import com.instabug.library.internal.video.ScreenRecordingEvent;

public class ScreenRecordingEventBus extends EventBus<ScreenRecordingEvent> {
    private static ScreenRecordingEventBus instance;

    public static ScreenRecordingEventBus getInstance() {
        if (instance == null) {
            instance = new ScreenRecordingEventBus();
        }
        return instance;
    }
}
