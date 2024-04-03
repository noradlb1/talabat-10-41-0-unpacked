package com.huawei.location.crowdsourcing;

import android.net.wifi.ScanResult;
import com.huawei.location.crowdsourcing.common.util.Vw;

public final /* synthetic */ class b implements Vw {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f50043a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f50044b;

    public /* synthetic */ b(long j11, long j12) {
        this.f50043a = j11;
        this.f50044b = j12;
    }

    public final boolean yn(Object obj) {
        return dC.yn(this.f50043a, this.f50044b, (ScanResult) obj);
    }
}
