package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.util.zzcf;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.wrappers.Wrappers;
import com.huawei.location.lite.common.util.PermissionUtil;

public final class zzbkt {
    private final Context zza;

    public zzbkt(Context context) {
        Preconditions.checkNotNull(context, "Context can not be null");
        this.zza = context;
    }

    public final boolean zza(Intent intent) {
        Preconditions.checkNotNull(intent, "Intent can not be null");
        if (!this.zza.getPackageManager().queryIntentActivities(intent, 0).isEmpty()) {
            return true;
        }
        return false;
    }

    @TargetApi(14)
    public final boolean zzb() {
        if (zza(new Intent("android.intent.action.INSERT").setType("vnd.android.cursor.dir/event"))) {
            return true;
        }
        return false;
    }

    public final boolean zzc() {
        if (!((Boolean) zzcf.zza(this.zza, new zzbks())).booleanValue() || Wrappers.packageManager(this.zza).checkCallingOrSelfPermission(PermissionUtil.WRITE_EXTERNAL_PERMISSION) != 0) {
            return false;
        }
        return true;
    }
}
