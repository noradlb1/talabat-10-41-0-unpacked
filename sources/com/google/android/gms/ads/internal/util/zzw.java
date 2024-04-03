package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.os.Environment;
import android.os.StatFs;
import android.view.View;

@TargetApi(18)
public class zzw extends zzv {
    public final int zzg() {
        return 14;
    }

    public final long zzh() {
        return new StatFs(Environment.getDataDirectory().getAbsolutePath()).getAvailableBytes() / 1024;
    }

    public boolean zzi(View view) {
        return super.zzi(view) || view.getWindowId() != null;
    }
}
