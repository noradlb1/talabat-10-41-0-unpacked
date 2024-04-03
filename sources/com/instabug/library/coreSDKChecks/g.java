package com.instabug.library.coreSDKChecks;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.settings.SettingsManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class g {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final SettingsManager f34214a;

    public g(@Nullable SettingsManager settingsManager) {
        this.f34214a = settingsManager;
    }

    public final void a(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "inputSdkVersion");
        SettingsManager settingsManager = this.f34214a;
        if (settingsManager != null) {
            if (settingsManager.getLastSDKVersion() != null && !Intrinsics.areEqual((Object) settingsManager.getLastSDKVersion(), (Object) str)) {
                SDKCoreEventPublisher.post(new SDKCoreEvent("sdk_version", "sdk_version_changed"));
            }
            settingsManager.setCurrentSDKVersion("11.7.0");
        }
    }
}
