package com.huawei.location.ephemeris;

import com.huawei.hms.push.constant.RemoteMessageConst;
import java.util.Locale;

public class Vw {
    private int FB;
    private long LW;
    private int Vw;

    /* renamed from: yn  reason: collision with root package name */
    private int f50090yn;

    public Vw(long j11) {
        yn(j11);
    }

    private void yn(long j11) {
        long j12 = ((j11 / 1000) - 315964800) + ((long) 18);
        this.LW = j12;
        this.FB = (int) (j12 % 604800);
        int i11 = (int) (j12 / 604800);
        this.Vw = i11;
        this.f50090yn = i11 / 1024;
        this.Vw = i11 % 1024;
    }

    public int FB() {
        return this.Vw;
    }

    public int LW() {
        return this.f50090yn;
    }

    public long Vw() {
        return this.LW;
    }

    public int dC() {
        return this.FB;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "weekRound: %d weekNumber = %d weekSecond: %d", new Object[]{Integer.valueOf(this.f50090yn), Integer.valueOf(this.Vw), Integer.valueOf(this.FB)});
    }

    public int yn() {
        return (this.FB / RemoteMessageConst.DEFAULT_TTL) * RemoteMessageConst.DEFAULT_TTL;
    }
}
