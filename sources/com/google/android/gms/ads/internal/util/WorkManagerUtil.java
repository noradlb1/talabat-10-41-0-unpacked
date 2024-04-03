package com.google.android.gms.ads.internal.util;

import android.content.Context;
import androidx.annotation.RecentlyNonNull;
import androidx.work.Configuration;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import com.google.android.gms.ads.internal.offline.buffering.OfflineNotificationPoster;
import com.google.android.gms.ads.internal.offline.buffering.OfflinePingSender;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzciz;

@KeepForSdk
public class WorkManagerUtil extends zzbu {
    private static void zzb(Context context) {
        try {
            WorkManager.initialize(context.getApplicationContext(), new Configuration.Builder().build());
        } catch (IllegalStateException unused) {
        }
    }

    public final void zze(@RecentlyNonNull IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        try {
            WorkManager instance = WorkManager.getInstance(context);
            instance.cancelAllWorkByTag("offline_ping_sender_work");
            instance.enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflinePingSender.class).setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build())).addTag("offline_ping_sender_work")).build());
        } catch (IllegalStateException e11) {
            zzciz.zzk("Failed to instantiate WorkManager.", e11);
        }
    }

    public final boolean zzf(@RecentlyNonNull IObjectWrapper iObjectWrapper, @RecentlyNonNull String str, @RecentlyNonNull String str2) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzb(context);
        Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
        try {
            WorkManager.getInstance(context).enqueue((WorkRequest) (OneTimeWorkRequest) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) new OneTimeWorkRequest.Builder(OfflineNotificationPoster.class).setConstraints(build)).setInputData(new Data.Builder().putString("uri", str).putString("gws_query_id", str2).build())).addTag("offline_notification_work")).build());
            return true;
        } catch (IllegalStateException e11) {
            zzciz.zzk("Failed to instantiate WorkManager.", e11);
            return false;
        }
    }
}
