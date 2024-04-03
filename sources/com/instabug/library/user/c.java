package com.instabug.library.user;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f51994a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51995b;

    public c(d dVar, String str, String str2) {
        this.f51994a = str;
        this.f51995b = str2;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        InstabugSDKLogger.v("IBG-Core", "old uuid " + this.f51994a);
        InstabugSDKLogger.v("IBG-Core", "md5uuid " + this.f51995b);
        f.c();
        SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(false);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(true);
    }
}
