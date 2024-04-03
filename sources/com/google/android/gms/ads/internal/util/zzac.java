package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import java.util.Locale;
import javax.annotation.ParametersAreNonnullByDefault;

@TargetApi(28)
@ParametersAreNonnullByDefault
public final class zzac extends zzaa {
    public static final /* synthetic */ WindowInsets zzs(Activity activity, View view, WindowInsets windowInsets) {
        if (zzt.zzo().zzh().zzl() == null) {
            DisplayCutout a11 = windowInsets.getDisplayCutout();
            String str = "";
            if (a11 != null) {
                zzg zzh = zzt.zzo().zzh();
                for (Rect rect : a11.getBoundingRects()) {
                    String format = String.format(Locale.US, "%d,%d,%d,%d", new Object[]{Integer.valueOf(rect.left), Integer.valueOf(rect.top), Integer.valueOf(rect.right), Integer.valueOf(rect.bottom)});
                    if (!TextUtils.isEmpty(str)) {
                        str = String.valueOf(str).concat("|");
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(format);
                    if (valueOf2.length() != 0) {
                        str = valueOf.concat(valueOf2);
                    } else {
                        str = new String(valueOf);
                    }
                }
                zzh.zzA(str);
            } else {
                zzt.zzo().zzh().zzA(str);
            }
        }
        zzv(false, activity);
        return view.onApplyWindowInsets(windowInsets);
    }

    private static final void zzv(boolean z11, Activity activity) {
        Window window = activity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        int a11 = attributes.layoutInDisplayCutoutMode;
        int i11 = 1;
        if (true != z11) {
            i11 = 2;
        }
        if (i11 != a11) {
            attributes.layoutInDisplayCutoutMode = i11;
            window.setAttributes(attributes);
        }
    }

    public final void zzr(Activity activity) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaT)).booleanValue() && zzt.zzo().zzh().zzl() == null && !activity.isInMultiWindowMode()) {
            zzv(true, activity);
            activity.getWindow().getDecorView().setOnApplyWindowInsetsListener(new zzab(this, activity));
        }
    }
}
