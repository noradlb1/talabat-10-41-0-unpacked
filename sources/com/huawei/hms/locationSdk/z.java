package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import java.util.Objects;

public class z extends b0 {

    /* renamed from: b  reason: collision with root package name */
    private PendingIntent f49219b;

    public void a(PendingIntent pendingIntent) {
        this.f49219b = pendingIntent;
    }

    public boolean equals(Object obj) {
        PendingIntent pendingIntent;
        if (this == obj) {
            return true;
        }
        if (obj == null || z.class != obj.getClass() || (pendingIntent = this.f49219b) == null) {
            return false;
        }
        return pendingIntent.equals(((z) obj).f49219b);
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.f49219b});
    }
}
