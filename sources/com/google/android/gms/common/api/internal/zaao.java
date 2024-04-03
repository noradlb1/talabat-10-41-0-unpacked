package com.google.android.gms.common.api.internal;

import android.app.PendingIntent;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;

final class zaao extends zaav {
    final /* synthetic */ zaaw zaa;
    private final Map zac;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zaao(zaaw zaaw, Map map) {
        super(zaaw, (zaau) null);
        this.zaa = zaaw;
        this.zac = map;
    }

    @GuardedBy("mLock")
    @WorkerThread
    public final void zaa() {
        zal zal = new zal(this.zaa.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Api.Client client : this.zac.keySet()) {
            if (!client.requiresGooglePlayServices() || ((zaal) this.zac.get(client)).zac) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i11 = 0;
        int i12 = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i11 < size) {
                i12 = zal.zab(this.zaa.zac, (Api.Client) arrayList.get(i11));
                i11++;
                if (i12 != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i11 < size2) {
                i12 = zal.zab(this.zaa.zac, (Api.Client) arrayList2.get(i11));
                i11++;
                if (i12 == 0) {
                    break;
                }
            }
        }
        if (i12 != 0) {
            ConnectionResult connectionResult = new ConnectionResult(i12, (PendingIntent) null);
            zaaw zaaw = this.zaa;
            zaaw.zaa.zal(new zaam(this, zaaw, connectionResult));
            return;
        }
        zaaw zaaw2 = this.zaa;
        if (zaaw2.zam && zaaw2.zak != null) {
            zaaw2.zak.zab();
        }
        for (Api.Client client2 : this.zac.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) this.zac.get(client2);
            if (!client2.requiresGooglePlayServices() || zal.zab(this.zaa.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaaw zaaw3 = this.zaa;
                zaaw3.zaa.zal(new zaan(this, zaaw3, connectionProgressReportCallbacks));
            }
        }
    }
}
