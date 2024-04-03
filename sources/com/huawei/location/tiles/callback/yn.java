package com.huawei.location.tiles.callback;

import com.huawei.location.tiles.cache.Vw;
import com.huawei.riemann.common.api.location.CityTileCallback;

public class yn implements CityTileCallback {
    private int FB;
    private int Vw;

    /* renamed from: yn  reason: collision with root package name */
    private Vw f50243yn;

    public yn(int i11, int i12) {
        this.Vw = i11;
        this.FB = i12;
        this.f50243yn = new Vw(i11, i12);
    }

    public byte[] get(long j11) {
        if (this.f50243yn == null) {
            this.f50243yn = new Vw(this.Vw, this.FB);
        }
        return this.f50243yn.yn(j11);
    }
}
