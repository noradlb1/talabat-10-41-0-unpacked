package com.google.android.gms.tagmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Keep;
import android.support.annotation.WorkerThread;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public class TagManagerService extends Service {

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int f44510b = 0;

    @Keep
    @WorkerThread
    @KeepName
    public static void initialize(Context context) {
        zzbf.zzi(context);
    }

    public IBinder onBind(Intent intent) {
        return zzbf.zzh(this);
    }
}
