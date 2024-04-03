package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import android.os.Looper;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import java.util.Objects;

public class e0 extends b0 {

    /* renamed from: b  reason: collision with root package name */
    private LocationRequest f49166b;

    /* renamed from: c  reason: collision with root package name */
    private PendingIntent f49167c;

    /* renamed from: d  reason: collision with root package name */
    private LocationCallback f49168d;

    /* renamed from: e  reason: collision with root package name */
    private int f49169e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f49170f;

    /* renamed from: g  reason: collision with root package name */
    private Looper f49171g;

    /* renamed from: h  reason: collision with root package name */
    private String f49172h;

    public e0(LocationRequest locationRequest, PendingIntent pendingIntent, LocationCallback locationCallback, Looper looper, String str, String str2) {
        this.f49166b = locationRequest;
        this.f49167c = pendingIntent;
        if (locationRequest != null) {
            this.f49169e = locationRequest.getNumUpdates();
        }
        this.f49168d = locationCallback;
        this.f49171g = looper;
        if (locationCallback != null) {
            this.f49170f = str;
        } else {
            this.f49170f = null;
        }
        this.f49172h = str2;
        a(str);
    }

    public void a(int i11) {
        this.f49169e = i11;
    }

    public boolean a(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f49168d, ((e0) obj).f49168d);
    }

    public PendingIntent b() {
        return this.f49167c;
    }

    public boolean b(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || e0.class != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.f49167c, ((e0) obj).f49167c);
    }

    public LocationCallback c() {
        return this.f49168d;
    }

    public LocationRequest d() {
        return this.f49166b;
    }

    public Looper e() {
        return this.f49171g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && e0.class == obj.getClass()) {
            if (c() != null) {
                return a(obj);
            }
            if (b() != null) {
                return b(obj);
            }
        }
        return false;
    }

    public String f() {
        return this.f49172h;
    }

    public int g() {
        return this.f49169e;
    }

    public String h() {
        return this.f49170f;
    }

    public int hashCode() {
        return 0;
    }
}
