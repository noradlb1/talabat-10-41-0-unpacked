package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import org.json.JSONArray;
import org.json.JSONException;

public final class zzkm extends zzhb {
    private final int type;
    private final zzfl zzaow;

    public zzkm(int i11, zzfl zzfl) {
        this.type = i11;
        this.zzaow = zzfl;
    }

    public final zzoa<?> zza(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11 = true;
        Preconditions.checkArgument(true);
        if (zzoaArr.length != 1) {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        Preconditions.checkArgument(zzoaArr[0] instanceof zzom);
        try {
            zzgy zzo = zzmm.zzo(new JSONArray((String) zzoaArr[0].value()).getJSONArray(0));
            zzo.zza(this.zzaow);
            zzoa<?> zzb = zzo.zzb(zzfl, new zzoa[0]);
            if (this.type == 0) {
                return zzog.zzaum;
            }
            return zzb;
        } catch (JSONException e11) {
            zzev.zza("Unable to convert Custom Pixie to instruction", e11);
            return zzog.zzaum;
        }
    }
}
