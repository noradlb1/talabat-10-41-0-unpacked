package com.huawei.hms.dtm;

import android.os.Bundle;
import android.os.Parcelable;

public class E {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f48246a;

    public E(Bundle bundle) {
        this.f48246a = bundle == null ? new Bundle() : bundle;
    }

    public int a(String str, int i11) {
        try {
            return this.f48246a.getInt(str, i11);
        } catch (Throwable th2) {
            B.b("SafeBundle", "getInt throwable: " + th2.getMessage());
            return i11;
        }
    }

    public boolean a(String str) {
        try {
            return this.f48246a.containsKey(str);
        } catch (Throwable unused) {
            B.b("SafeBundle", "containsKey throwable. key:");
            return false;
        }
    }

    public int b(String str) {
        return a(str, 0);
    }

    public <T extends Parcelable> T c(String str) {
        try {
            return this.f48246a.getParcelable(str);
        } catch (Throwable th2) {
            B.b("SafeBundle", "getParcelable throwable: " + th2.getMessage());
            return null;
        }
    }
}
