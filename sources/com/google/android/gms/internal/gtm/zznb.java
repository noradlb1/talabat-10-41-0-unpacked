package com.google.android.gms.internal.gtm;

final class zznb implements Runnable {
    private final /* synthetic */ String zzatf;
    private final /* synthetic */ zzmn zzatg;
    private final /* synthetic */ zzmz zzath;

    public zznb(zzmz zzmz, String str, zzmn zzmn) {
        this.zzath = zzmz;
        this.zzatf = str;
        this.zzatg = zzmn;
    }

    public final void run() {
        this.zzath.zzb(this.zzatf, this.zzatg);
    }
}
