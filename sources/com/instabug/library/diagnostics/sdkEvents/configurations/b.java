package com.instabug.library.diagnostics.sdkEvents.configurations;

import android.content.SharedPreferences;
import com.instabug.library.settings.SettingsManager;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class b implements a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SettingsManager f34332a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private final SharedPreferences f34333b;

    public b(@NotNull SettingsManager settingsManager, @Nullable SharedPreferences sharedPreferences) {
        Intrinsics.checkNotNullParameter(settingsManager, "settingsManager");
        this.f34332a = settingsManager;
        this.f34333b = sharedPreferences;
    }

    @Nullable
    public Set a() {
        SharedPreferences sharedPreferences = this.f34333b;
        if (sharedPreferences == null) {
            return null;
        }
        return sharedPreferences.getStringSet("allow_list", (Set) null);
    }

    public boolean isEnabled() {
        return this.f34332a.getFeatureState("SDK_EVENTS", false);
    }
}
