package com.google.android.gms.internal.ads;

import android.app.PendingIntent;
import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import javax.annotation.Nullable;

public final class zzfpl {
    public static final int zza = 67108864;
    public static final ClipData zzb = ClipData.newIntent("", new Intent());

    @Nullable
    public static PendingIntent zza(Context context, int i11, Intent intent, int i12, int i13) {
        boolean z11;
        boolean z12;
        if ((i12 & 95) == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzfqg.zze(z11, "Cannot set any dangerous parts of intent to be mutable.");
        if (intent.getComponent() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        zzfqg.zze(z12, "Must set component on Intent.");
        if (zzb(0, 1)) {
            zzfqg.zze(!zzb(i12, 67108864), "Cannot set mutability flags if PendingIntent.FLAG_IMMUTABLE is set.");
        } else {
            zzfqg.zze(zzb(i12, 67108864), "Must set PendingIntent.FLAG_IMMUTABLE for SDK >= 23 if no parts of intent are mutable.");
        }
        Intent intent2 = new Intent(intent);
        if (!zzb(i12, 67108864)) {
            if (intent2.getPackage() == null) {
                intent2.setPackage(intent2.getComponent().getPackageName());
            }
            if (!zzb(0, 3) && intent2.getAction() == null) {
                intent2.setAction("");
            }
            if (!zzb(0, 9) && intent2.getCategories() == null) {
                intent2.addCategory("");
            }
            if (!zzb(0, 5) && intent2.getData() == null) {
                intent2.setDataAndType(Uri.EMPTY, "*/*");
            }
            if (!zzb(0, 17) && intent2.getClipData() == null) {
                intent2.setClipData(zzb);
            }
        }
        return PendingIntent.getService(context, 0, intent2, i12);
    }

    private static boolean zzb(int i11, int i12) {
        return (i11 & i12) == i12;
    }
}
