package com.huawei.hms.dtm.core.safe;

import android.os.Bundle;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.Set;

public class SafeBundle {

    /* renamed from: a  reason: collision with root package name */
    private final Bundle f48586a;

    public SafeBundle() {
        this(new Bundle());
    }

    public SafeBundle(Bundle bundle) {
        this.f48586a = bundle == null ? new Bundle() : bundle;
    }

    public void clear() {
        try {
            this.f48586a.clear();
        } catch (Throwable unused) {
            Logger.error("SafeBundle", "clear throwable.");
        }
    }

    public Object get(String str) {
        try {
            return this.f48586a.get(str);
        } catch (Throwable th2) {
            Logger.error("SafeBundle", "get throwable: " + th2.getMessage());
            return null;
        }
    }

    public Bundle getBundle() {
        return this.f48586a;
    }

    public String getString(String str) {
        try {
            return this.f48586a.getString(str);
        } catch (Throwable th2) {
            Logger.error("SafeBundle", "getString throwable: " + th2.getMessage());
            return "";
        }
    }

    public boolean isEmpty() {
        try {
            return this.f48586a.isEmpty();
        } catch (Throwable unused) {
            Logger.error("SafeBundle", "isEmpty throwable");
            return true;
        }
    }

    public Set<String> keySet() {
        try {
            return this.f48586a.keySet();
        } catch (Throwable unused) {
            Logger.error("SafeBundle", "keySet throwable.");
            return null;
        }
    }

    public void remove(String str) {
        try {
            this.f48586a.remove(str);
        } catch (Throwable unused) {
            Logger.error("SafeBundle", "remove throwable. key:" + str);
        }
    }

    public int size() {
        try {
            return this.f48586a.size();
        } catch (Throwable unused) {
            Logger.error("SafeBundle", "size throwable");
            return 0;
        }
    }

    public String toString() {
        return this.f48586a.toString();
    }
}
