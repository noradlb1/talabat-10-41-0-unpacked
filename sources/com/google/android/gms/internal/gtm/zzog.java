package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;

public final class zzog extends zzoa<zzoa<?>> {
    public static final zzog zzauj = new zzog("BREAK");
    public static final zzog zzauk = new zzog("CONTINUE");
    public static final zzog zzaul = new zzog("NULL");
    public static final zzog zzaum = new zzog("UNDEFINED");

    /* renamed from: name  reason: collision with root package name */
    private final String f35100name;
    private final boolean zzaun;
    private final zzoa<?> zzauo;

    private zzog(String str) {
        this.f35100name = str;
        this.zzaun = false;
        this.zzauo = null;
    }

    public final String toString() {
        return this.f35100name;
    }

    public final /* synthetic */ Object value() {
        return this.zzauo;
    }

    public final boolean zzmh() {
        return this.zzaun;
    }

    public zzog(zzoa<?> zzoa) {
        Preconditions.checkNotNull(zzoa);
        this.f35100name = "RETURN";
        this.zzaun = true;
        this.zzauo = zzoa;
    }
}
