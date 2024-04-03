package com.google.android.gms.common.api.internal;

import androidx.annotation.WorkerThread;
import com.google.android.gms.common.api.Api;
import java.util.ArrayList;

final class zaap extends zaav {
    final /* synthetic */ zaaw zaa;
    private final ArrayList zac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaap(zaaw zaaw, ArrayList arrayList) {
        super(zaaw, (zaau) null);
        this.zaa = zaaw;
        this.zac = arrayList;
    }

    @WorkerThread
    public final void zaa() {
        zaaw zaaw = this.zaa;
        zaaw.zaa.zag.zad = zaaw.zao(zaaw);
        ArrayList arrayList = this.zac;
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            zaaw zaaw2 = this.zaa;
            ((Api.Client) arrayList.get(i11)).getRemoteService(zaaw2.zao, zaaw2.zaa.zag.zad);
        }
    }
}
