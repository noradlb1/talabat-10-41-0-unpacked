package com.instabug.library.model.v3Session;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

public final class IBGSessionData {
    @NotNull
    private final JSONObject featureData;
    @NotNull
    private final String featureKey;

    public IBGSessionData(@NotNull String str, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str, "featureKey");
        Intrinsics.checkNotNullParameter(jSONObject, "featureData");
        this.featureKey = str;
        this.featureData = jSONObject;
    }

    @NotNull
    public final JSONObject getFeatureData() {
        return this.featureData;
    }

    @NotNull
    public final String getFeatureKey() {
        return this.featureKey;
    }
}
