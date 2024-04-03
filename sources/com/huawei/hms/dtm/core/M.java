package com.huawei.hms.dtm.core;

import android.content.Context;
import com.huawei.hms.dtm.core.util.Logger;
import java.util.List;

public class M {

    /* renamed from: a  reason: collision with root package name */
    private static volatile M f48344a;

    /* renamed from: b  reason: collision with root package name */
    private N f48345b;

    private M(Context context) {
        this.f48345b = new N(context);
    }

    public static M b() {
        if (f48344a == null) {
            synchronized (M.class) {
                if (f48344a == null) {
                    f48344a = new M(J.a());
                }
            }
        }
        return f48344a;
    }

    public final long a() {
        return S.c(this.f48345b.getWritableDatabase());
    }

    public List<Q> a(int i11, int i12) {
        return S.a(this.f48345b.getWritableDatabase(), i11, i12);
    }

    public boolean a(int i11) {
        return S.a(this.f48345b.getWritableDatabase(), i11);
    }

    public boolean a(long j11) {
        return S.a(this.f48345b.getWritableDatabase(), j11);
    }

    public boolean a(Q q11) {
        return S.a(this.f48345b.getWritableDatabase(), q11);
    }

    public boolean b(int i11) {
        Logger.info("DTM-Report", "MalformedURL url, delete it");
        return a(i11);
    }

    public boolean b(long j11) {
        return S.b(this.f48345b.getWritableDatabase(), j11);
    }

    public boolean b(Q q11) {
        long c11 = q11.c();
        if (c11 == 0) {
            q11.b(System.currentTimeMillis());
            return S.b(this.f48345b.getWritableDatabase(), q11);
        } else if (c11 + 14400000 >= System.currentTimeMillis()) {
            return true;
        } else {
            Logger.error("DTM-Report", "Delete event out of time");
            return a(q11.e());
        }
    }

    public List<Q> c(int i11) {
        return S.b(this.f48345b.getWritableDatabase(), i11);
    }
}
