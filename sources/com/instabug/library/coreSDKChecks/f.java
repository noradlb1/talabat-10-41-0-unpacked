package com.instabug.library.coreSDKChecks;

import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.settings.SettingsManager;
import org.jetbrains.annotations.Nullable;

public final class f {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final SettingsManager f34213a;

    public f(@Nullable SettingsManager settingsManager) {
        this.f34213a = settingsManager;
    }

    private final void a(int i11) {
        SettingsManager settingsManager = this.f34213a;
        if (settingsManager != null) {
            settingsManager.setOSVersion(i11);
        }
        SDKCoreEventPublisher.post(new SDKCoreEvent(UserPropertyKeys.OS_VERSION, "os_version_changed"));
    }

    public final void b(int i11) {
        SettingsManager settingsManager = this.f34213a;
        if (settingsManager != null) {
            if (!settingsManager.isOSVersionSet()) {
                settingsManager.setOSVersion(i11);
            } else if (settingsManager.getOSVersion() != i11) {
                a(i11);
            }
        }
    }
}
