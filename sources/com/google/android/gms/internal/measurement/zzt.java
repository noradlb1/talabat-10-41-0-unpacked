package com.google.android.gms.internal.measurement;

import androidx.core.app.NotificationCompat;
import com.huawei.location.lite.common.log.logwrite.LogWriteConstants;
import java.util.List;

public final class zzt extends zzai {
    /* access modifiers changed from: private */
    public final zzr zza;

    public zzt(zzr zzr) {
        super("internal.logger");
        this.zza = zzr;
        this.zze.put(LogWriteConstants.LOG_TYPE, new zzs(this, false, true));
        this.zze.put(NotificationCompat.GROUP_KEY_SILENT, new zzp(this, NotificationCompat.GROUP_KEY_SILENT));
        ((zzai) this.zze.get(NotificationCompat.GROUP_KEY_SILENT)).zzr(LogWriteConstants.LOG_TYPE, new zzs(this, true, true));
        this.zze.put("unmonitored", new zzq(this, "unmonitored"));
        ((zzai) this.zze.get("unmonitored")).zzr(LogWriteConstants.LOG_TYPE, new zzs(this, false, false));
    }

    public final zzap zza(zzg zzg, List list) {
        return zzap.zzf;
    }
}
