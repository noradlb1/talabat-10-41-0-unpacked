package com.instabug.library.networkv2.limitation;

import org.jetbrains.annotations.NotNull;

public enum RateLimitedFeature {
    V3_SESSION("v3_sessions");
    
    @NotNull
    private final String featureName;

    private RateLimitedFeature(String str) {
        this.featureName = str;
    }

    @NotNull
    public final String getFeatureName() {
        return this.featureName;
    }
}
