package com.google.android.gms.common.api.internal;

final class zabn implements Runnable {
    final /* synthetic */ int zaa;
    final /* synthetic */ zabq zab;

    public zabn(zabq zabq, int i11) {
        this.zab = zabq;
        this.zaa = i11;
    }

    public final void run() {
        this.zab.zaH(this.zaa);
    }
}
