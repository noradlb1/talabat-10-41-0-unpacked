package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzcis;

@TargetApi(24)
public class zzz extends zzy {
    @VisibleForTesting
    public static final boolean zzp(int i11, int i12, int i13) {
        return Math.abs(i11 - i12) <= i13;
    }

    public final boolean zzo(Activity activity, Configuration configuration) {
        int i11;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdr)).booleanValue()) {
            return false;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdt)).booleanValue()) {
            return activity.isInMultiWindowMode();
        }
        zzbgo.zzb();
        int zzs = zzcis.zzs(activity, configuration.screenHeightDp);
        int zzs2 = zzcis.zzs(activity, configuration.screenWidthDp);
        zzt.zzp();
        DisplayMetrics zzy = zzt.zzy((WindowManager) activity.getApplicationContext().getSystemService("window"));
        int i12 = zzy.heightPixels;
        int i13 = zzy.widthPixels;
        int identifier = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            i11 = activity.getResources().getDimensionPixelSize(identifier);
        } else {
            i11 = 0;
        }
        int round = ((int) Math.round(((double) activity.getResources().getDisplayMetrics().density) + 0.5d)) * ((Integer) zzbgq.zzc().zzb(zzblj.zzdp)).intValue();
        if (!zzp(i12, zzs + i11, round)) {
            return true;
        }
        if (zzp(i13, zzs2, round)) {
            return false;
        }
        return true;
    }
}
