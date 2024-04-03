package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import java.util.Objects;

public class x extends b0 {

    /* renamed from: b  reason: collision with root package name */
    private PendingIntent f49215b;

    public void a(PendingIntent pendingIntent) {
        this.f49215b = pendingIntent;
    }

    public boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass() || (pendingIntent = this.f49215b) == null) {
            return false;
        }
        return pendingIntent.equals(((x) obj).f49215b);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f49215b});
    }
}
