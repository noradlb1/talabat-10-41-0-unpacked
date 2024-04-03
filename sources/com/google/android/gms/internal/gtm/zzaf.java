package com.google.android.gms.internal.gtm;

final class zzaf implements Runnable {
    private final /* synthetic */ int zzvv;
    private final /* synthetic */ zzae zzvw;

    public zzaf(zzae zzae, int i11) {
        this.zzvw = zzae;
        this.zzvv = i11;
    }

    public final void run() {
        this.zzvw.zzvu.zzg(((long) this.zzvv) * 1000);
    }
}
