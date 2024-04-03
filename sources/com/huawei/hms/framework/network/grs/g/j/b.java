package com.huawei.hms.framework.network.grs.g.j;

import android.os.SystemClock;
import com.huawei.hms.framework.network.grs.g.d;
import java.util.concurrent.Future;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final Future<d> f48932a;

    /* renamed from: b  reason: collision with root package name */
    private final long f48933b = SystemClock.elapsedRealtime();

    public b(Future<d> future) {
        this.f48932a = future;
    }

    public Future<d> a() {
        return this.f48932a;
    }

    public boolean b() {
        return SystemClock.elapsedRealtime() - this.f48933b <= 300000;
    }
}
