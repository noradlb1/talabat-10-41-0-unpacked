package com.google.android.gms.internal.ads;

import android.util.JsonWriter;
import java.util.Map;

public final /* synthetic */ class zzcit implements zzcix {
    public final /* synthetic */ int zza;
    public final /* synthetic */ Map zzb;

    public /* synthetic */ zzcit(int i11, Map map) {
        this.zza = i11;
        this.zzb = map;
    }

    public final void zza(JsonWriter jsonWriter) {
        zzciy.zzb(this.zza, this.zzb, jsonWriter);
    }
}
