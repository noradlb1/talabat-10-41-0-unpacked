package com.instabug.library.coreSDKChecks;

import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.settings.SettingsManager;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

public final class e {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final SettingsManager f34212a;

    public e(@Nullable SettingsManager settingsManager) {
        this.f34212a = settingsManager;
    }

    private final void a() {
        SettingsManager settingsManager = this.f34212a;
        if (settingsManager != null) {
            settingsManager.setSavedAppToken(settingsManager.getAppToken());
        }
        SDKCoreEventPublisher.post(new SDKCoreEvent(InstabugDbContract.SessionEntry.COLUMN_APP_TOKEN, "app_token_changed"));
    }

    public final void b() {
        boolean z11;
        SettingsManager settingsManager = this.f34212a;
        if (settingsManager != null) {
            String savedAppToken = settingsManager.getSavedAppToken();
            if (savedAppToken == null || StringsKt__StringsJVMKt.isBlank(savedAppToken)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                settingsManager.setSavedAppToken(settingsManager.getAppToken());
            } else if (!Intrinsics.areEqual((Object) settingsManager.getSavedAppToken(), (Object) settingsManager.getAppToken())) {
                a();
            }
        }
    }
}
