package com.instabug.library.firstseen;

import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;

public class b {

    /* renamed from: b  reason: collision with root package name */
    private static b f34366b;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f34367a;

    private b() {
    }

    public void a() {
        try {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null) {
                a(applicationContext);
            }
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "json exception while fetching first_seen request" + e11.getMessage());
        }
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            if (f34366b == null) {
                f34366b = new b();
            }
            bVar = f34366b;
        }
        return bVar;
    }

    public synchronized void a(Context context) throws JSONException {
        if (b(context)) {
            this.f34367a = true;
            d.a().a(context, (Request.Callbacks) new a(this, context));
        }
    }

    @VisibleForTesting
    public boolean b(Context context) {
        if (this.f34367a) {
            return false;
        }
        if (SettingsManager.getInstance().getLastAppVersion() != null && DeviceStateProvider.getAppVersion(context).equals(SettingsManager.getInstance().getLastAppVersion())) {
            return false;
        }
        SettingsManager.getInstance().setLastAppVersion((String) null);
        return true;
    }
}
