package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.Nullable;
import java.util.ArrayList;

public final class zzepw implements zzevn<zzepx> {
    private final zzfxb zza;
    private final Context zzb;
    private final zzfef zzc;
    private final View zzd;

    public zzepw(zzfxb zzfxb, Context context, zzfef zzfef, @Nullable ViewGroup viewGroup) {
        this.zza = zzfxb;
        this.zzb = context;
        this.zzc = zzfef;
        this.zzd = viewGroup;
    }

    public final /* synthetic */ zzepx zza() throws Exception {
        int i11;
        Context context = this.zzb;
        zzbfi zzbfi = this.zzc.zze;
        ArrayList arrayList = new ArrayList();
        View view = this.zzd;
        while (view != null) {
            ViewParent parent = view.getParent();
            if (parent == null) {
                break;
            }
            if (parent instanceof ViewGroup) {
                i11 = ((ViewGroup) parent).indexOfChild(view);
            } else {
                i11 = -1;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", parent.getClass().getName());
            bundle.putInt("index_of_child", i11);
            arrayList.add(bundle);
            if (!(parent instanceof View)) {
                break;
            }
            view = (View) parent;
        }
        return new zzepx(context, zzbfi, arrayList);
    }

    public final zzfxa<zzepx> zzb() {
        return this.zza.zzb(new zzepv(this));
    }
}
