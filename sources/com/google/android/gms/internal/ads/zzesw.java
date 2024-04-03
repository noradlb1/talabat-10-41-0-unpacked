package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.Nullable;
import com.facebook.internal.AnalyticsEvents;
import java.util.Set;

public final class zzesw implements zzevn<zzesx> {
    private final zzfxb zza;
    @Nullable
    private final ViewGroup zzb;
    private final Context zzc;
    private final Set<String> zzd;

    public zzesw(zzfxb zzfxb, @Nullable ViewGroup viewGroup, Context context, Set<String> set) {
        this.zza = zzfxb;
        this.zzd = set;
        this.zzb = viewGroup;
        this.zzc = context;
    }

    public final /* synthetic */ zzesx zza() throws Exception {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzep)).booleanValue() && this.zzb != null && this.zzd.contains("banner")) {
            return new zzesx(Boolean.valueOf(this.zzb.isHardwareAccelerated()));
        }
        Boolean bool = null;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzeq)).booleanValue() && this.zzd.contains(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE)) {
            Context context = this.zzc;
            if (context instanceof Activity) {
                Activity activity = (Activity) context;
                Window window = activity.getWindow();
                if (window == null || (window.getAttributes().flags & 16777216) == 0) {
                    try {
                        boolean z11 = false;
                        if ((activity.getPackageManager().getActivityInfo(activity.getComponentName(), 0).flags & 512) != 0) {
                            z11 = true;
                        }
                        bool = Boolean.valueOf(z11);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                } else {
                    bool = Boolean.TRUE;
                }
                return new zzesx(bool);
            }
        }
        return new zzesx((Boolean) null);
    }

    public final zzfxa<zzesx> zzb() {
        return this.zza.zzb(new zzesv(this));
    }
}
