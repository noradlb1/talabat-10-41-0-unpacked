package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

public final /* synthetic */ class zzeqk implements zzevm {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzeqk(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zza(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zza);
    }
}
