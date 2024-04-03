package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

public final /* synthetic */ class zzeqz implements zzevm {
    public final /* synthetic */ ArrayList zza;

    public /* synthetic */ zzeqz(ArrayList arrayList) {
        this.zza = arrayList;
    }

    public final void zza(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zza);
    }
}
