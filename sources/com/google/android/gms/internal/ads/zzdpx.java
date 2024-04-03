package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.AnyThread;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzdpx extends zzdav {
    private final Executor zzc;
    private final zzdqc zzd;
    private final zzdqk zze;
    private final zzdrb zzf;
    private final zzdqh zzg;
    private final zzdqn zzh;
    private final zzgpl<zzduc> zzi;
    private final zzgpl<zzdua> zzj;
    private final zzgpl<zzduh> zzk;
    private final zzgpl<zzdty> zzl;
    private final zzgpl<zzduf> zzm;
    /* access modifiers changed from: private */
    public zzdrw zzn;
    private boolean zzo;
    private boolean zzp;
    private boolean zzq;
    private final zzcgq zzr;
    private final zzalt zzs;
    private final zzcjf zzt;
    private final Context zzu;
    private final zzdpz zzv;
    private final zzepa zzw;
    /* access modifiers changed from: private */
    public final Map<String, Boolean> zzx = new HashMap();
    private final List<zzayb> zzy = new ArrayList();
    private final zzayc zzz;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzdpx(zzdau zzdau, Executor executor, zzdqc zzdqc, zzdqk zzdqk, zzdrb zzdrb, zzdqh zzdqh, zzdqn zzdqn, zzgpl<zzduc> zzgpl, zzgpl<zzdua> zzgpl2, zzgpl<zzduh> zzgpl3, zzgpl<zzdty> zzgpl4, zzgpl<zzduf> zzgpl5, zzcgq zzcgq, zzalt zzalt, zzcjf zzcjf, Context context, zzdpz zzdpz, zzepa zzepa, zzayc zzayc) {
        super(zzdau);
        this.zzc = executor;
        this.zzd = zzdqc;
        this.zze = zzdqk;
        this.zzf = zzdrb;
        this.zzg = zzdqh;
        this.zzh = zzdqn;
        this.zzi = zzgpl;
        this.zzj = zzgpl2;
        this.zzk = zzgpl3;
        this.zzl = zzgpl4;
        this.zzm = zzgpl5;
        this.zzr = zzcgq;
        this.zzs = zzalt;
        this.zzt = zzcjf;
        this.zzu = context;
        this.zzv = zzdpz;
        this.zzw = zzepa;
        this.zzz = zzayc;
    }

    public static boolean zzP(View view) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhd)).booleanValue()) {
            zzt.zzp();
            long zzA = com.google.android.gms.ads.internal.util.zzt.zzA(view);
            if (view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null)) {
                if (zzA >= ((long) ((Integer) zzbgq.zzc().zzb(zzblj.zzhe)).intValue())) {
                    return true;
                }
            }
            return false;
        } else if (!view.isShown() || !view.getGlobalVisibleRect(new Rect(), (Point) null)) {
            return false;
        } else {
            return true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzR */
    public final synchronized void zzt(zzdrw zzdrw) {
        View view;
        zzalp zzc2;
        if (!this.zzo) {
            this.zzn = zzdrw;
            this.zzf.zze(zzdrw);
            this.zze.zzx(zzdrw.zzf(), zzdrw.zzm(), zzdrw.zzn(), zzdrw, zzdrw);
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbQ)).booleanValue() && (zzc2 = this.zzs.zzc()) != null) {
                zzc2.zzn(zzdrw.zzf());
            }
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbm)).booleanValue()) {
                zzfdn zzfdn = this.zzb;
                if (zzfdn.zzai) {
                    Iterator<String> keys = zzfdn.zzah.keys();
                    if (keys != null) {
                        while (keys.hasNext()) {
                            String next = keys.next();
                            WeakReference weakReference = this.zzn.zzl().get(next);
                            this.zzx.put(next, Boolean.FALSE);
                            if (!(weakReference == null || (view = (View) weakReference.get()) == null)) {
                                zzayb zzayb = new zzayb(this.zzu, view);
                                this.zzy.add(zzayb);
                                zzayb.zzc(new zzdpw(this, next));
                            }
                        }
                    }
                }
            }
            if (zzdrw.zzi() != null) {
                zzdrw.zzi().zzc(this.zzr);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzS */
    public final void zzu(zzdrw zzdrw) {
        this.zze.zzy(zzdrw.zzf(), zzdrw.zzl());
        if (zzdrw.zzh() != null) {
            zzdrw.zzh().setClickable(false);
            zzdrw.zzh().removeAllViews();
        }
        if (zzdrw.zzi() != null) {
            zzdrw.zzi().zze(this.zzr);
        }
        this.zzn = null;
    }

    public static /* synthetic */ void zzh(zzdpx zzdpx) {
        try {
            int zzc2 = zzdpx.zzd.zzc();
            if (zzc2 != 1) {
                if (zzc2 != 2) {
                    if (zzc2 != 3) {
                        if (zzc2 != 6) {
                            if (zzc2 != 7) {
                                zzciz.zzg("Wrong native template id!");
                            } else if (zzdpx.zzh.zzg() != null) {
                                zzdpx.zzh.zzg().zzg(zzdpx.zzl.zzb());
                            }
                        } else if (zzdpx.zzh.zzf() != null) {
                            zzdpx.zzq("Google", true);
                            zzdpx.zzh.zzf().zze(zzdpx.zzk.zzb());
                        }
                    } else if (zzdpx.zzh.zzd(zzdpx.zzd.zzy()) != null) {
                        if (zzdpx.zzd.zzr() != null) {
                            zzdpx.zzq("Google", true);
                        }
                        zzdpx.zzh.zzd(zzdpx.zzd.zzy()).zze(zzdpx.zzm.zzb());
                    }
                } else if (zzdpx.zzh.zza() != null) {
                    zzdpx.zzq("Google", true);
                    zzdpx.zzh.zza().zze(zzdpx.zzj.zzb());
                }
            } else if (zzdpx.zzh.zzb() != null) {
                zzdpx.zzq("Google", true);
                zzdpx.zzh.zzb().zze(zzdpx.zzi.zzb());
            }
        } catch (RemoteException e11) {
            zzciz.zzh("RemoteException when notifyAdLoad is called", e11);
        }
    }

    public final synchronized void zzA() {
        zzdrw zzdrw = this.zzn;
        if (zzdrw == null) {
            zzciz.zze("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzc.execute(new zzdpu(this, zzdrw instanceof zzdqv));
        }
    }

    public final synchronized void zzB() {
        if (!this.zzp) {
            this.zze.zzq();
        }
    }

    public final void zzC(View view) {
        IObjectWrapper zzu2 = this.zzd.zzu();
        zzcop zzq2 = this.zzd.zzq();
        if (this.zzg.zzc() && zzu2 != null && zzq2 != null && view != null) {
            zzt.zzh().zzg(zzu2, view);
        }
    }

    public final synchronized void zzD(View view, MotionEvent motionEvent, View view2) {
        this.zze.zzr(view, motionEvent, view2);
    }

    public final synchronized void zzE(Bundle bundle) {
        this.zze.zzs(bundle);
    }

    public final synchronized void zzF(View view) {
        this.zze.zzt(view);
    }

    public final synchronized void zzG() {
        this.zze.zzu();
    }

    public final synchronized void zzH(zzbif zzbif) {
        this.zze.zzv(zzbif);
    }

    public final synchronized void zzI(zzbit zzbit) {
        this.zzw.zza(zzbit);
    }

    public final synchronized void zzJ(zzbqc zzbqc) {
        this.zze.zzw(zzbqc);
    }

    public final synchronized void zzK(zzdrw zzdrw) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbk)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzdps(this, zzdrw));
        } else {
            zzt(zzdrw);
        }
    }

    public final synchronized void zzL(zzdrw zzdrw) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbk)).booleanValue()) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzdpt(this, zzdrw));
        } else {
            zzu(zzdrw);
        }
    }

    public final boolean zzM() {
        return this.zzg.zzd();
    }

    public final synchronized boolean zzN() {
        return this.zze.zzz();
    }

    public final boolean zzO() {
        return this.zzg.zzc();
    }

    public final synchronized boolean zzQ(Bundle bundle) {
        if (this.zzp) {
            return true;
        }
        boolean zzA = this.zze.zzA(bundle);
        this.zzp = zzA;
        return zzA;
    }

    public final synchronized void zzT() {
        this.zzo = true;
        this.zzc.execute(new zzdpq(this));
        super.zzT();
    }

    @AnyThread
    public final void zzU() {
        this.zzc.execute(new zzdpr(this));
        if (this.zzd.zzc() != 7) {
            Executor executor = this.zzc;
            zzdqk zzdqk = this.zze;
            zzdqk.getClass();
            executor.execute(new zzdpv(zzdqk));
        }
        super.zzU();
    }

    public final zzdpz zza() {
        return this.zzv;
    }

    public final String zzd() {
        return this.zzg.zza();
    }

    public final synchronized JSONObject zzf(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zze.zzd(view, map, map2);
    }

    public final synchronized JSONObject zzg(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zze.zze(view, map, map2);
    }

    public final void zzi(View view) {
        IObjectWrapper zzu2 = this.zzd.zzu();
        if (this.zzg.zzc() && zzu2 != null && view != null) {
            zzt.zzh().zzd(zzu2, view);
        }
    }

    public final synchronized void zzk() {
        this.zze.zzg();
    }

    public final void zzq(String str, boolean z11) {
        String str2;
        zzcbn zzcbn;
        zzcbo zzcbo;
        if (this.zzg.zzc() && !TextUtils.isEmpty(str)) {
            zzcop zzq2 = this.zzd.zzq();
            zzcop zzr2 = this.zzd.zzr();
            if (zzq2 != null || zzr2 != null) {
                if (zzq2 != null) {
                    str2 = null;
                } else {
                    str2 = "javascript";
                    zzq2 = zzr2;
                }
                String str3 = str2;
                if (!zzt.zzh().zzi(this.zzu)) {
                    zzciz.zzj("Failed to initialize omid in InternalNativeAd");
                    return;
                }
                zzcjf zzcjf = this.zzt;
                int i11 = zzcjf.zzb;
                int i12 = zzcjf.zzc;
                StringBuilder sb2 = new StringBuilder(23);
                sb2.append(i11);
                sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
                sb2.append(i12);
                String sb3 = sb2.toString();
                if (zzr2 != null) {
                    zzcbn = zzcbn.zzc;
                    zzcbo = zzcbo.DEFINED_BY_JAVASCRIPT;
                } else {
                    zzcbn = zzcbn.NATIVE_DISPLAY;
                    if (this.zzd.zzc() == 3) {
                        zzcbo = zzcbo.UNSPECIFIED;
                    } else {
                        zzcbo = zzcbo.ONE_PIXEL;
                    }
                }
                zzcbn zzcbn2 = zzcbn;
                zzcbo zzcbo2 = zzcbo;
                IObjectWrapper zzb = zzt.zzh().zzb(sb3, zzq2.zzI(), "", "javascript", str3, str, zzcbo2, zzcbn2, this.zzb.zzaj);
                if (zzb == null) {
                    zzciz.zzj("Failed to create omid session in InternalNativeAd");
                    return;
                }
                this.zzd.zzaa(zzb);
                zzq2.zzar(zzb);
                if (zzr2 != null) {
                    zzt.zzh().zzg(zzb, zzr2.zzH());
                    this.zzq = true;
                }
                if (z11) {
                    zzt.zzh().zzh(zzb);
                    zzq2.zzd("onSdkLoaded", new ArrayMap());
                }
            }
        }
    }

    public final /* synthetic */ void zzr() {
        this.zze.zzh();
        this.zzd.zzG();
    }

    public final /* synthetic */ void zzs(boolean z11) {
        this.zze.zzn(this.zzn.zzf(), this.zzn.zzl(), this.zzn.zzm(), z11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00a5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzv(android.view.View r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r6, boolean r7) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzp     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)
            return
        L_0x0007:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzbm     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            com.google.android.gms.internal.ads.zzfdn r0 = r3.zzb     // Catch:{ all -> 0x00a6 }
            boolean r0 = r0.zzai     // Catch:{ all -> 0x00a6 }
            if (r0 == 0) goto L_0x0045
            java.util.Map<java.lang.String, java.lang.Boolean> r0 = r3.zzx     // Catch:{ all -> 0x00a6 }
            java.util.Set r0 = r0.keySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0029:
            boolean r1 = r0.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0045
            java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x00a6 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ all -> 0x00a6 }
            java.util.Map<java.lang.String, java.lang.Boolean> r2 = r3.zzx     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r2.get(r1)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ all -> 0x00a6 }
            boolean r1 = r1.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r1 != 0) goto L_0x0029
            monitor-exit(r3)
            return
        L_0x0045:
            r0 = 1
            if (r7 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzdrb r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdrw r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzd(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdqk r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzp(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzp = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x0058:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzblj.zzcx     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x00a6 }
            java.lang.Object r7 = r1.zzb(r7)     // Catch:{ all -> 0x00a6 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x00a6 }
            boolean r7 = r7.booleanValue()     // Catch:{ all -> 0x00a6 }
            if (r7 == 0) goto L_0x00a4
            if (r5 == 0) goto L_0x00a4
            java.util.Set r7 = r5.entrySet()     // Catch:{ all -> 0x00a6 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00a6 }
        L_0x0074:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x00a4
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00a6 }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x00a6 }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x00a6 }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x00a6 }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            boolean r1 = zzP(r1)     // Catch:{ all -> 0x00a6 }
            if (r1 == 0) goto L_0x0074
            com.google.android.gms.internal.ads.zzdrb r7 = r3.zzf     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdrw r1 = r3.zzn     // Catch:{ all -> 0x00a6 }
            r7.zzd(r1)     // Catch:{ all -> 0x00a6 }
            com.google.android.gms.internal.ads.zzdqk r7 = r3.zze     // Catch:{ all -> 0x00a6 }
            r7.zzp(r4, r5, r6)     // Catch:{ all -> 0x00a6 }
            r3.zzp = r0     // Catch:{ all -> 0x00a6 }
            monitor-exit(r3)
            return
        L_0x00a4:
            monitor-exit(r3)
            return
        L_0x00a6:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpx.zzv(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzw(@Nullable zzbij zzbij) {
        this.zze.zzi(zzbij);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzx(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzdrb r0 = r8.zzf     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdrw r1 = r8.zzn     // Catch:{ all -> 0x0033 }
            r0.zzc(r1)     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzdqk r2 = r8.zze     // Catch:{ all -> 0x0033 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zzj(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0033 }
            boolean r9 = r8.zzq     // Catch:{ all -> 0x0033 }
            if (r9 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzdqc r9 = r8.zzd     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzcop r9 = r9.zzr()     // Catch:{ all -> 0x0033 }
            if (r9 != 0) goto L_0x001f
            goto L_0x0031
        L_0x001f:
            com.google.android.gms.internal.ads.zzdqc r9 = r8.zzd     // Catch:{ all -> 0x0033 }
            com.google.android.gms.internal.ads.zzcop r9 = r9.zzr()     // Catch:{ all -> 0x0033 }
            androidx.collection.ArrayMap r10 = new androidx.collection.ArrayMap     // Catch:{ all -> 0x0033 }
            r10.<init>()     // Catch:{ all -> 0x0033 }
            java.lang.String r11 = "onSdkAdUserInteractionClick"
            r9.zzd(r11, r10)     // Catch:{ all -> 0x0033 }
            monitor-exit(r8)
            return
        L_0x0031:
            monitor-exit(r8)
            return
        L_0x0033:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpx.zzx(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzy(String str) {
        this.zze.zzk(str);
    }

    public final synchronized void zzz(Bundle bundle) {
        this.zze.zzl(bundle);
    }
}
