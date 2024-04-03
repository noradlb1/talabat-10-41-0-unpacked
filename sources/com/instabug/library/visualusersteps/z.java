package com.instabug.library.visualusersteps;

import com.instabug.library.Feature;
import com.instabug.library.e0;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class z {
    public static void a(State state) {
        if (state == null) {
            InstabugSDKLogger.e("IBG-Core", "reproStepsState object passed to Instabug.setReproStepsState() is null");
            return;
        }
        if (state == State.ENABLED) {
            e0.c().a(Feature.REPRO_STEPS, Feature.State.ENABLED);
            SettingsManager.getInstance().setReproStepsScreenshotEnabled(true);
        } else if (state == State.ENABLED_WITH_NO_SCREENSHOTS) {
            e0.c().a(Feature.REPRO_STEPS, Feature.State.ENABLED);
            SettingsManager.getInstance().setReproStepsScreenshotEnabled(false);
        } else if (state == State.DISABLED) {
            e0.c().a(Feature.REPRO_STEPS, Feature.State.DISABLED);
        }
        InstabugSDKLogger.d("IBG-Core", "setReproStepsState: " + state.name());
    }
}
