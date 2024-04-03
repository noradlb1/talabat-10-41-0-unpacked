package com.google.android.gms.internal.ads;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.zzt;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import java.util.List;

public final class zzepx implements zzevm<Bundle> {
    public final Context zza;
    public final zzbfi zzb;
    public final List<Parcelable> zzc;

    public zzepx(Context context, zzbfi zzbfi, List<Parcelable> list) {
        this.zza = context;
        this.zzb = zzbfi;
        this.zzc = list;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj) {
        ActivityManager.RunningTaskInfo runningTaskInfo;
        Bundle bundle = (Bundle) obj;
        if (zzbna.zza.zze().booleanValue()) {
            Bundle bundle2 = new Bundle();
            zzt.zzp();
            String str = null;
            try {
                ActivityManager activityManager = (ActivityManager) this.zza.getSystemService("activity");
                if (activityManager != null) {
                    List<ActivityManager.RunningTaskInfo> runningTasks = activityManager.getRunningTasks(1);
                    if (!(runningTasks == null || runningTasks.isEmpty() || (runningTaskInfo = runningTasks.get(0)) == null || runningTaskInfo.topActivity == null)) {
                        str = runningTaskInfo.topActivity.getClassName();
                    }
                }
            } catch (Exception unused) {
            }
            bundle2.putString("activity", str);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("width", this.zzb.zze);
            bundle3.putInt("height", this.zzb.zzb);
            bundle2.putBundle(BindingAdaptersKt.QUERY_SIZE, bundle3);
            if (this.zzc.size() > 0) {
                List<Parcelable> list = this.zzc;
                bundle2.putParcelableArray("parents", (Parcelable[]) list.toArray(new Parcelable[list.size()]));
            }
            bundle.putBundle(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY, bundle2);
        }
    }
}
