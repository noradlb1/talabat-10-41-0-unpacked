package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import java.util.HashMap;
import java.util.Map;

public final class zzsk extends zzck {
    /* access modifiers changed from: private */
    public boolean zza;
    /* access modifiers changed from: private */
    public boolean zzb;
    /* access modifiers changed from: private */
    public boolean zzc;
    /* access modifiers changed from: private */
    public boolean zzd;
    /* access modifiers changed from: private */
    public boolean zze;
    /* access modifiers changed from: private */
    public final SparseArray<Map<zzch, zzsm>> zzf;
    /* access modifiers changed from: private */
    public final SparseBooleanArray zzg;

    @Deprecated
    public zzsk() {
        this.zzf = new SparseArray<>();
        this.zzg = new SparseBooleanArray();
        zzu();
    }

    private final void zzu() {
        this.zza = true;
        this.zzb = true;
        this.zzc = true;
        this.zzd = true;
        this.zze = true;
    }

    public final /* synthetic */ zzck zze(int i11, int i12, boolean z11) {
        super.zze(i11, i12, true);
        return this;
    }

    public final zzsk zzo(int i11, boolean z11) {
        if (this.zzg.get(i11) == z11) {
            return this;
        }
        if (z11) {
            this.zzg.put(i11, true);
        } else {
            this.zzg.delete(i11);
        }
        return this;
    }

    public zzsk(Context context) {
        super.zzd(context);
        Point zzx = zzfn.zzx(context);
        zze(zzx.x, zzx.y, true);
        this.zzf = new SparseArray<>();
        this.zzg = new SparseBooleanArray();
        zzu();
    }

    public /* synthetic */ zzsk(zzsi zzsi, zzsj zzsj) {
        super(zzsi);
        this.zza = zzsi.zzF;
        this.zzb = zzsi.zzH;
        this.zzc = zzsi.zzI;
        this.zzd = zzsi.zzM;
        this.zze = zzsi.zzO;
        SparseArray zza2 = zzsi.zzP;
        SparseArray<Map<zzch, zzsm>> sparseArray = new SparseArray<>();
        for (int i11 = 0; i11 < zza2.size(); i11++) {
            sparseArray.put(zza2.keyAt(i11), new HashMap((Map) zza2.valueAt(i11)));
        }
        this.zzf = sparseArray;
        this.zzg = zzsi.zzQ.clone();
    }
}
