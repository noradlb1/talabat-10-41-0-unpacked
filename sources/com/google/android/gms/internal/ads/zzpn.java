package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.SparseArray;

public final class zzpn implements zzqk {
    private final zzdh zza;
    private final SparseArray<zzqk> zzb;
    private final int[] zzc;

    public zzpn(Context context, zzww zzww) {
        Class<zzdh> cls = zzdh.class;
        Class<zzqk> cls2 = zzqk.class;
        zzto zzto = new zzto(context);
        this.zza = zzto;
        SparseArray<zzqk> sparseArray = new SparseArray<>();
        try {
            sparseArray.put(0, (zzqk) Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzto}));
        } catch (Exception unused) {
        }
        try {
            sparseArray.put(1, (zzqk) Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzto}));
        } catch (Exception unused2) {
        }
        try {
            sparseArray.put(2, (zzqk) Class.forName("androidx.media3.exoplayer.hls.HlsMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[]{cls}).newInstance(new Object[]{zzto}));
        } catch (Exception unused3) {
        }
        try {
            sparseArray.put(3, (zzqk) Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(cls2).getConstructor(new Class[0]).newInstance(new Object[0]));
        } catch (Exception unused4) {
        }
        sparseArray.put(4, new zzrc(zzto, zzww));
        this.zzb = sparseArray;
        this.zzc = new int[sparseArray.size()];
        for (int i11 = 0; i11 < this.zzb.size(); i11++) {
            this.zzc[i11] = this.zzb.keyAt(i11);
        }
    }
}
