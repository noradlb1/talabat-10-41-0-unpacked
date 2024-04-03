package com.instabug.library;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.model.f;
import com.instabug.library.model.g;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import java.lang.ref.WeakReference;

class l0 {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private WeakReference f50578a;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public l0(@Nullable Context context) {
        this.f50578a = new WeakReference(context);
    }

    public g a() {
        try {
            f a11 = new f().c(e()).b(d()).a(c());
            String b11 = b();
            if (b11 != null) {
                a11.a(b11);
            }
            return a11.a();
        } finally {
            this.f50578a = null;
        }
    }

    @VisibleForTesting
    @Nullable
    public String b() {
        return SettingsManager.getInstance().getAppToken();
    }

    @VisibleForTesting
    public long c() {
        Context context;
        WeakReference weakReference = this.f50578a;
        if (weakReference == null || (context = (Context) weakReference.get()) == null) {
            return -1;
        }
        return DeviceStateProvider.getFreeMemory(context);
    }

    @VisibleForTesting
    public String d() {
        return DeviceStateProvider.getOS();
    }

    @VisibleForTesting
    public String e() {
        return DeviceStateProvider.getSdkVersion();
    }
}
