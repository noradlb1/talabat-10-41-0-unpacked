package com.instabug.library.sessionV3.providers;

import org.jetbrains.annotations.NotNull;

public interface FeatureSessionDataControllerHost {
    @NotNull
    FeatureSessionDataController getSessionDataController();
}
