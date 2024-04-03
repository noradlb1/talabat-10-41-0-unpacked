package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public final class zzals extends zzalr {
    public zzals(Context context, String str, boolean z11) {
        super(context, str, z11);
    }

    public static zzals zzs(String str, Context context, boolean z11) {
        zzalr.zzq(context, false);
        return new zzals(context, str, false);
    }

    @Deprecated
    public static zzals zzt(String str, Context context, boolean z11, int i11) {
        zzalr.zzq(context, z11);
        return new zzals(context, str, z11);
    }

    public final List<Callable<Void>> zzo(zzams zzams, Context context, zzaiz zzaiz, zzais zzais) {
        if (zzams.zzk() == null || !this.zzt) {
            return super.zzo(zzams, context, zzaiz, (zzais) null);
        }
        int zza = zzams.zza();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(super.zzo(zzams, context, zzaiz, (zzais) null));
        arrayList.add(new zzanh(zzams, "pzhIFr8jSwvyB8FXK2qfBOfw0jXHNl6+dmbReaTm1jquB51r9sbZLlTA4zaBxZEm", "RbRyr5uGUYOSrOuNnmzV0kl42YeLvs7OFWbwh2MFm18=", zzaiz, zza, 24));
        return arrayList;
    }
}
