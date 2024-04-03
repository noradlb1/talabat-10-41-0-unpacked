package com.uxcam.internals;

import java.util.Arrays;

public enum ao {
    MP4("isom", 512, new String[]{"isom", "iso2", "avc1", "mp41"});
    

    /* renamed from: a  reason: collision with root package name */
    public final bz f13005a;

    /* access modifiers changed from: public */
    ao(String str, int i11, String[] strArr) {
        this.f13005a = new bz(str, i11, Arrays.asList(strArr));
    }

    public bz a() {
        return this.f13005a;
    }
}
