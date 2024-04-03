package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.concurrent.GuardedBy;

public final class zzcbl implements zzcbm {
    @GuardedBy("lock")
    @VisibleForTesting
    static boolean zza = false;
    @GuardedBy("lock")
    @VisibleForTesting
    static boolean zzb = false;
    private static final Object zzd = new Object();
    @VisibleForTesting
    zzfjw zzc;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        com.google.android.gms.internal.ads.zzciz.zzl("#007 Could not call remote method.", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:10:0x0023, B:15:0x0045] */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.dynamic.IObjectWrapper zza(java.lang.String r14, android.webkit.WebView r15, java.lang.String r16, java.lang.String r17, @androidx.annotation.Nullable java.lang.String r18, com.google.android.gms.internal.ads.zzcbo r19, com.google.android.gms.internal.ads.zzcbn r20, @androidx.annotation.Nullable java.lang.String r21) {
        /*
            r13 = this;
            java.lang.String r4 = ""
            java.lang.String r5 = "javascript"
            java.lang.String r7 = "Google"
            java.lang.Object r1 = zzd
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzdB     // Catch:{ all -> 0x0047 }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x0047 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x0047 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x0047 }
            r11 = 0
            if (r0 == 0) goto L_0x0044
            boolean r0 = zza     // Catch:{ all -> 0x0047 }
            if (r0 != 0) goto L_0x0021
            goto L_0x0044
        L_0x0021:
            monitor-exit(r1)     // Catch:{ all -> 0x0047 }
            r12 = r13
            com.google.android.gms.internal.ads.zzfjw r1 = r12.zzc     // Catch:{ RemoteException -> 0x003d, NullPointerException -> 0x003b }
            com.google.android.gms.dynamic.IObjectWrapper r3 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x003d, NullPointerException -> 0x003b }
            java.lang.String r8 = r19.toString()     // Catch:{ RemoteException -> 0x003d, NullPointerException -> 0x003b }
            java.lang.String r9 = r20.toString()     // Catch:{ RemoteException -> 0x003d, NullPointerException -> 0x003b }
            r2 = r14
            r6 = r18
            r10 = r21
            com.google.android.gms.dynamic.IObjectWrapper r11 = r1.zze(r2, r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ RemoteException -> 0x003d, NullPointerException -> 0x003b }
            goto L_0x0046
        L_0x003b:
            r0 = move-exception
            goto L_0x003e
        L_0x003d:
            r0 = move-exception
        L_0x003e:
            java.lang.String r1 = "#007 Could not call remote method."
            com.google.android.gms.internal.ads.zzciz.zzl(r1, r0)
            goto L_0x0046
        L_0x0044:
            r12 = r13
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
        L_0x0046:
            return r11
        L_0x0047:
            r0 = move-exception
            r12 = r13
        L_0x0049:
            monitor-exit(r1)     // Catch:{ all -> 0x004b }
            throw r0
        L_0x004b:
            r0 = move-exception
            goto L_0x0049
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbl.zza(java.lang.String, android.webkit.WebView, java.lang.String, java.lang.String, java.lang.String, com.google.android.gms.internal.ads.zzcbo, com.google.android.gms.internal.ads.zzcbn, java.lang.String):com.google.android.gms.dynamic.IObjectWrapper");
    }

    @Nullable
    public final IObjectWrapper zzb(String str, WebView webView, String str2, String str3, @Nullable String str4, String str5, zzcbo zzcbo, zzcbn zzcbn, @Nullable String str6) {
        synchronized (zzd) {
            try {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                    if (zza) {
                        try {
                            return this.zzc.zzf(str, ObjectWrapper.wrap(webView), "", "javascript", str4, str5, zzcbo.toString(), zzcbn.toString(), str6);
                        } catch (RemoteException | NullPointerException e11) {
                            zzciz.zzl("#007 Could not call remote method.", e11);
                            return null;
                        }
                    }
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        }
    }

    @Nullable
    public final String zzc(Context context) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
            return null;
        }
        try {
            zzf(context);
            String valueOf = String.valueOf(this.zzc.zzg());
            if (valueOf.length() != 0) {
                return "a.".concat(valueOf);
            }
            return new String("a.");
        } catch (RemoteException | NullPointerException e11) {
            zzciz.zzl("#007 Could not call remote method.", e11);
            return null;
        }
    }

    public final void zzd(IObjectWrapper iObjectWrapper, View view) {
        synchronized (zzd) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzh(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e11) {
                        zzciz.zzl("#007 Could not call remote method.", e11);
                    }
                }
            }
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper) {
        synchronized (zzd) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzi(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e11) {
                        zzciz.zzl("#007 Could not call remote method.", e11);
                    }
                }
            }
        }
    }

    @VisibleForTesting
    public final void zzf(Context context) {
        synchronized (zzd) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue() && !zzb) {
                try {
                    zzb = true;
                    this.zzc = (zzfjw) zzcjd.zzb(context, "com.google.android.gms.ads.omid.DynamiteOmid", zzcbk.zza);
                } catch (zzcjc e11) {
                    zzciz.zzl("#007 Could not call remote method.", e11);
                }
            }
        }
    }

    public final void zzg(IObjectWrapper iObjectWrapper, View view) {
        synchronized (zzd) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzj(iObjectWrapper, ObjectWrapper.wrap(view));
                    } catch (RemoteException | NullPointerException e11) {
                        zzciz.zzl("#007 Could not call remote method.", e11);
                    }
                }
            }
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        synchronized (zzd) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                if (zza) {
                    try {
                        this.zzc.zzk(iObjectWrapper);
                    } catch (RemoteException | NullPointerException e11) {
                        zzciz.zzl("#007 Could not call remote method.", e11);
                    }
                }
            }
        }
    }

    public final boolean zzi(Context context) {
        synchronized (zzd) {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzdB)).booleanValue()) {
                return false;
            }
            if (zza) {
                return true;
            }
            try {
                zzf(context);
                boolean zzl = this.zzc.zzl(ObjectWrapper.wrap(context));
                zza = zzl;
                return zzl;
            } catch (RemoteException e11) {
                e = e11;
                zzciz.zzl("#007 Could not call remote method.", e);
                return false;
            } catch (NullPointerException e12) {
                e = e12;
                zzciz.zzl("#007 Could not call remote method.", e);
                return false;
            }
        }
    }
}
