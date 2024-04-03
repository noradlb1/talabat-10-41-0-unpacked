package com.instabug.library.visualusersteps;

import com.instabug.library.core.eventbus.eventpublisher.AbstractEventPublisher;
import org.jetbrains.annotations.NotNull;

public final class ReproStepsScreenshotEventBus extends AbstractEventPublisher<Integer> {
    @NotNull
    public static final ReproStepsScreenshotEventBus INSTANCE = new ReproStepsScreenshotEventBus();
    public static final int SCREENSHOT_CAPTURING_FINISHED = 2;
    public static final int SCREENSHOT_CAPTURING_STARTED = 1;

    private ReproStepsScreenshotEventBus() {
    }
}
