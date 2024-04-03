package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.TuplesKt;
import kotlin.UInt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

public final class zzay implements zzas {
    @NotNull
    public static final zzat zza = new zzat((DefaultConstructorMarker) null);
    @NotNull
    private final zzbb zzb;
    @NotNull
    private final CoroutineScope zzc;
    @NotNull
    private final zzbj zzd;
    @NotNull
    private final Map zze;
    @NotNull
    private final Map zzf = MapsKt__MapsKt.mapOf(TuplesKt.to(39, zzbs.zza), TuplesKt.to(34, zzck.zza), TuplesKt.to(35, zzcw.zza), TuplesKt.to(25, zzcb.zza), TuplesKt.to(37, zzcu.zza), TuplesKt.to(21, zzbk.zza), TuplesKt.to(22, zzct.zza), TuplesKt.to(23, zzcl.zza), TuplesKt.to(24, zzby.zza), TuplesKt.to(1, zzco.zza), TuplesKt.to(2, zzbr.zza), TuplesKt.to(38, zzcs.zza), TuplesKt.to(3, zzcc.zza), TuplesKt.to(4, zzcd.zza), TuplesKt.to(17, zzbx.zza), TuplesKt.to(32, zzbl.zza), TuplesKt.to(5, zzcf.zza), TuplesKt.to(31, zzbm.zza), TuplesKt.to(36, zzbn.zza), TuplesKt.to(16, zzbt.zza), TuplesKt.to(26, zzcp.zza), TuplesKt.to(6, zzce.zza), TuplesKt.to(27, zzcn.zza), TuplesKt.to(8, zzci.zza), TuplesKt.to(9, zzcj.zza), TuplesKt.to(10, zzcg.zza), TuplesKt.to(11, zzch.zza), TuplesKt.to(12, zzcq.zza), TuplesKt.to(13, zzcr.zza), TuplesKt.to(30, zzbo.zza), TuplesKt.to(15, zzbp.zza), TuplesKt.to(20, zzbq.zza), TuplesKt.to(7, zzcm.zza), TuplesKt.to(18, zzbv.zza), TuplesKt.to(19, zzbw.zza), TuplesKt.to(40, zzcv.zza));
    @NotNull
    private final zzcz zzg;

    public zzay(@NotNull zzbb zzbb, @NotNull CoroutineScope coroutineScope, @NotNull Context context, @NotNull zzn zzn) {
        zzbb zzbb2 = zzbb;
        this.zzb = zzbb2;
        this.zzc = coroutineScope;
        zzbj zzbj = new zzbj(zzbb2, zzn);
        this.zzd = zzbj;
        this.zze = zzbj.zzd().zzc();
        zzcz zzcz = new zzcz();
        this.zzg = zzcz;
        zzbj.zzg(3, context);
        zzbj.zzg(4, zzcz);
    }

    /* access modifiers changed from: private */
    public final zzna zzg(String str, List list) throws zzs {
        if (str.length() != 0) {
            try {
                zzcy zzcy = new zzcy((short) this.zzg.zza(CollectionsKt___CollectionsKt.toIntArray(list)), 255);
                StringBuilder sb2 = new StringBuilder(str.length());
                for (int i11 = 0; i11 < str.length(); i11++) {
                    sb2.append((char) UInt.m6423constructorimpl(UInt.m6423constructorimpl(str.charAt(i11)) ^ UInt.m6423constructorimpl(zzcy.zza())));
                }
                return zzna.zzg(zzek.zzh().zzj(sb2.toString()));
            } catch (Exception e11) {
                throw new zzs(3, 18, e11);
            }
        } else {
            throw new zzs(3, 17, (Throwable) null);
        }
    }

    /* access modifiers changed from: private */
    public final Object zzh(List list, zzbh zzbh, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzav(zzbh, list, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final Object zzi(Exception exc, zzbh zzbh, Continuation continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new zzaw(exc, zzbh, this, (Continuation) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public final void zzj(zznm zznm, zzbh zzbh) throws zzs {
        zzdt zzb2 = zzdt.zzb();
        int zzb3 = zzbh.zzb();
        zzca zzca = (zzca) this.zzf.get(Integer.valueOf(zznm.zzf()));
        if (zzca != null) {
            int zzg2 = zznm.zzg();
            zznl[] zznlArr = (zznl[]) zznm.zzj().toArray(new zznl[0]);
            zzca.zza(zzg2, zzbh, (zznl[]) Arrays.copyOf(zznlArr, zznlArr.length));
            if (zzb3 == zzbh.zzb()) {
                zzbh.zzi(zzbh.zzb() + 1);
            }
            zzb2.zzf();
            long zza2 = zzb2.zza(TimeUnit.MICROSECONDS);
            zzj zzj = zzj.zza;
            int zzk = zznm.zzk();
            if (zzk != 1) {
                zzj.zza(zzk - 2, zza2);
                zznm.zzk();
                zznm.zzg();
                String unused = CollectionsKt___CollectionsKt.joinToString$default(zznm.zzj(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new zzau(this), 31, (Object) null);
                return;
            }
            throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
        }
        throw new zzs(5, 2, (Throwable) null);
    }

    public final void zza(@NotNull String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzc, (CoroutineContext) null, (CoroutineStart) null, new zzax(new zzbh(this.zzd), this, str, (Continuation) null), 3, (Object) null);
    }
}
