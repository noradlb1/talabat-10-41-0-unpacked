package com.google.android.gms.vision.clearcut;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.clearcut.ClearcutLogger;
import com.google.android.gms.internal.vision.zzds;
import com.google.android.gms.internal.vision.zzea;
import com.google.android.gms.internal.vision.zzgd;
import com.google.android.gms.vision.L;

@Keep
public class VisionClearcutLogger {
    private final ClearcutLogger zzbv;
    private boolean zzbw = true;

    public VisionClearcutLogger(Context context) {
        this.zzbv = new ClearcutLogger(context, "VISION", (String) null);
    }

    public final void zzb(int i11, zzea.zzo zzo) {
        byte[] byteArray = zzo.toByteArray();
        if (i11 < 0 || i11 > 3) {
            L.i("Illegal event code: %d", Integer.valueOf(i11));
            return;
        }
        try {
            if (this.zzbw) {
                this.zzbv.newEvent(byteArray).setEventCode(i11).log();
                return;
            }
            zzea.zzo.zza zzdi = zzea.zzo.zzdi();
            try {
                zzdi.zza(byteArray, 0, byteArray.length, zzgd.zzfm());
                L.e("Would have logged:\n%s", zzdi.toString());
            } catch (Exception e11) {
                L.e(e11, "Parsing error", new Object[0]);
            }
        } catch (Exception e12) {
            zzds.zza(e12);
            L.e(e12, "Failed to log", new Object[0]);
        }
    }
}
