package com.instabug.library.firstseen;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f34364a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f34365b;

    public a(b bVar, Context context) {
        this.f34365b = bVar;
        this.f34364a = context;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            boolean unused = this.f34365b.f34367a = false;
            InstabugSDKLogger.e("IBG-Core", "first_seen response is null");
        } else if (jSONObject.has("first_seen")) {
            try {
                long j11 = jSONObject.getLong("first_seen");
                if (j11 != -1) {
                    SettingsManager.getInstance().setFirstSeen(j11);
                    SettingsManager.getInstance().setLastAppVersion(DeviceStateProvider.getAppVersion(this.f34364a));
                }
            } catch (Exception unused2) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while parsing first_seen response");
            }
        } else {
            boolean unused3 = this.f34365b.f34367a = false;
            InstabugSDKLogger.v("IBG-Core", "first_seen response doesn't has a key first_seen");
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        boolean unused = this.f34365b.f34367a = false;
        InstabugSDKLogger.e("IBG-Core", "Fetching first seen response ");
    }
}
