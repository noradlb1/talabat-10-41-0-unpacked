package com.instabug.library.networkv2.service.userattributes;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Feature;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.internal.utils.PreferencesUtils;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.user.f;
import com.instabug.library.util.InstabugSDKLogger;

public class h {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private g f51708a;

    public h(@Nullable g gVar) {
        this.f51708a = gVar;
    }

    public static h a(Context context) {
        return new h(new g(new e(new NetworkManager(), new PreferencesUtils(context, SettingsManager.INSTABUG_SHARED_PREF_NAME)), new b()));
    }

    public void b() {
        if (!c()) {
            InstabugSDKLogger.e("IBG-Core", "Couldn't sync attributes current user is not identified");
        } else if (!d()) {
            InstabugSDKLogger.e("IBG-Core", "Couldn't sync attributes sync feature is not available");
        } else {
            String k11 = f.k();
            String h11 = f.h();
            g gVar = this.f51708a;
            if (gVar != null) {
                gVar.c(k11, h11);
            }
        }
    }

    @VisibleForTesting
    public boolean c() {
        return f.p();
    }

    @VisibleForTesting
    public boolean d() {
        return InstabugCore.isExperimentalFeatureAvailable(Feature.BE_USER_ATTRIBUTES);
    }
}
