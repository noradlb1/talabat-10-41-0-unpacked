package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import java.util.Iterator;
import java.util.LinkedList;

public abstract class zzalq implements zzalp {
    protected static volatile zzams zza;
    protected MotionEvent zzb;
    protected final LinkedList<MotionEvent> zzc = new LinkedList<>();
    protected long zzd = 0;
    protected long zze = 0;
    protected long zzf = 0;
    protected long zzg = 0;
    protected long zzh = 0;
    protected long zzi = 0;
    protected long zzj = 0;
    protected double zzk;
    protected float zzl;
    protected float zzm;
    protected float zzn;
    protected float zzo;
    protected boolean zzp = false;
    protected DisplayMetrics zzq;
    private double zzr;
    private double zzs;
    private boolean zzt = false;

    public zzalq(Context context) {
        try {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbX)).booleanValue()) {
                zzaki.zzd();
            } else {
                zzamt.zza(zza);
            }
            this.zzq = context.getResources().getDisplayMetrics();
        } catch (Throwable unused) {
        }
    }

    private final void zzj() {
        this.zzh = 0;
        this.zzd = 0;
        this.zze = 0;
        this.zzf = 0;
        this.zzg = 0;
        this.zzi = 0;
        this.zzj = 0;
        if (this.zzc.size() > 0) {
            Iterator<MotionEvent> it = this.zzc.iterator();
            while (it.hasNext()) {
                it.next().recycle();
            }
            this.zzc.clear();
        } else {
            MotionEvent motionEvent = this.zzb;
            if (motionEvent != null) {
                motionEvent.recycle();
            }
        }
        this.zzb = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00b4 A[SYNTHETIC, Splitter:B:48:0x00b4] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String zzm(android.content.Context r20, java.lang.String r21, int r22, android.view.View r23, android.app.Activity r24, byte[] r25) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            r2 = r22
            r3 = r23
            r4 = r24
            long r5 = java.lang.System.currentTimeMillis()
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r7 = com.google.android.gms.internal.ads.zzblj.zzbM
            com.google.android.gms.internal.ads.zzblh r8 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r7 = r8.zzb(r7)
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            boolean r7 = r7.booleanValue()
            r8 = 1
            r9 = 0
            if (r7 == 0) goto L_0x0046
            com.google.android.gms.internal.ads.zzams r10 = zza
            if (r10 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzams r10 = zza
            com.google.android.gms.internal.ads.zzalo r10 = r10.zzd()
            goto L_0x002e
        L_0x002d:
            r10 = r9
        L_0x002e:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r11 = com.google.android.gms.internal.ads.zzblj.zzbX
            com.google.android.gms.internal.ads.zzblh r12 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r11 = r12.zzb(r11)
            java.lang.Boolean r11 = (java.lang.Boolean) r11
            boolean r11 = r11.booleanValue()
            if (r8 == r11) goto L_0x0043
            java.lang.String r11 = "te"
            goto L_0x0048
        L_0x0043:
            java.lang.String r11 = "be"
            goto L_0x0048
        L_0x0046:
            r10 = r9
            r11 = r10
        L_0x0048:
            r15 = 2
            r14 = 3
            if (r2 != r14) goto L_0x005e
            com.google.android.gms.internal.ads.zzaiz r9 = r1.zzb(r0, r3, r4)     // Catch:{ Exception -> 0x005b }
            r1.zzt = r8     // Catch:{ Exception -> 0x0056 }
            r0 = 1002(0x3ea, float:1.404E-42)
            r13 = r0
            goto L_0x006f
        L_0x0056:
            r0 = move-exception
            r18 = r0
            r8 = r14
            goto L_0x008c
        L_0x005b:
            r0 = move-exception
            r8 = r14
            goto L_0x008a
        L_0x005e:
            if (r2 != r15) goto L_0x0067
            com.google.android.gms.internal.ads.zzaiz r0 = r1.zzd(r0, r3, r4)     // Catch:{ Exception -> 0x005b }
            r3 = 1008(0x3f0, float:1.413E-42)
            goto L_0x006d
        L_0x0067:
            com.google.android.gms.internal.ads.zzaiz r0 = r1.zzc(r0, r9)     // Catch:{ Exception -> 0x005b }
            r3 = 1000(0x3e8, float:1.401E-42)
        L_0x006d:
            r9 = r0
            r13 = r3
        L_0x006f:
            if (r7 == 0) goto L_0x0087
            if (r10 == 0) goto L_0x0087
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x005b }
            long r3 = r3 - r5
            r0 = -1
            r18 = 0
            r12 = r10
            r8 = r14
            r14 = r0
            r15 = r3
            r17 = r11
            r12.zzc(r13, r14, r15, r17, r18)     // Catch:{ Exception -> 0x0085 }
            goto L_0x0088
        L_0x0085:
            r0 = move-exception
            goto L_0x008a
        L_0x0087:
            r8 = r14
        L_0x0088:
            r3 = 2
            goto L_0x00ae
        L_0x008a:
            r18 = r0
        L_0x008c:
            if (r7 == 0) goto L_0x0088
            if (r10 == 0) goto L_0x0088
            if (r2 != r8) goto L_0x0097
            r0 = 1003(0x3eb, float:1.406E-42)
            r13 = r0
            r3 = 2
            goto L_0x00a2
        L_0x0097:
            r3 = 2
            if (r2 != r3) goto L_0x009e
            r0 = 1009(0x3f1, float:1.414E-42)
            r13 = r0
            goto L_0x00a2
        L_0x009e:
            r0 = 1001(0x3e9, float:1.403E-42)
            r13 = r0
            r2 = 1
        L_0x00a2:
            r14 = -1
            long r15 = java.lang.System.currentTimeMillis()
            long r15 = r15 - r5
            r12 = r10
            r17 = r11
            r12.zzc(r13, r14, r15, r17, r18)
        L_0x00ae:
            long r4 = java.lang.System.currentTimeMillis()
            if (r9 == 0) goto L_0x00ef
            com.google.android.gms.internal.ads.zzgkl r0 = r9.zzah()     // Catch:{ Exception -> 0x00f5 }
            com.google.android.gms.internal.ads.zzajp r0 = (com.google.android.gms.internal.ads.zzajp) r0     // Catch:{ Exception -> 0x00f5 }
            int r0 = r0.zzas()     // Catch:{ Exception -> 0x00f5 }
            if (r0 != 0) goto L_0x00c1
            goto L_0x00ef
        L_0x00c1:
            com.google.android.gms.internal.ads.zzgkl r0 = r9.zzah()     // Catch:{ Exception -> 0x00f5 }
            com.google.android.gms.internal.ads.zzajp r0 = (com.google.android.gms.internal.ads.zzajp) r0     // Catch:{ Exception -> 0x00f5 }
            r6 = r21
            java.lang.String r0 = com.google.android.gms.internal.ads.zzaki.zza(r0, r6)     // Catch:{ Exception -> 0x00f5 }
            if (r7 == 0) goto L_0x011c
            if (r10 == 0) goto L_0x011c
            if (r2 != r8) goto L_0x00d7
            r6 = 1006(0x3ee, float:1.41E-42)
        L_0x00d5:
            r13 = r6
            goto L_0x00df
        L_0x00d7:
            if (r2 != r3) goto L_0x00dc
            r6 = 1010(0x3f2, float:1.415E-42)
            goto L_0x00d5
        L_0x00dc:
            r6 = 1004(0x3ec, float:1.407E-42)
            goto L_0x00d5
        L_0x00df:
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f5 }
            long r15 = r14 - r4
            r14 = -1
            r18 = 0
            r12 = r10
            r17 = r11
            r12.zzc(r13, r14, r15, r17, r18)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x011c
        L_0x00ef:
            r0 = 5
            java.lang.String r0 = java.lang.Integer.toString(r0)     // Catch:{ Exception -> 0x00f5 }
            goto L_0x011c
        L_0x00f5:
            r0 = move-exception
            r18 = r0
            r0 = 7
            java.lang.String r0 = java.lang.Integer.toString(r0)
            if (r7 == 0) goto L_0x011c
            if (r10 == 0) goto L_0x011c
            if (r2 != r8) goto L_0x0107
            r2 = 1007(0x3ef, float:1.411E-42)
        L_0x0105:
            r13 = r2
            goto L_0x010f
        L_0x0107:
            if (r2 != r3) goto L_0x010c
            r2 = 1011(0x3f3, float:1.417E-42)
            goto L_0x0105
        L_0x010c:
            r2 = 1005(0x3ed, float:1.408E-42)
            goto L_0x0105
        L_0x010f:
            r14 = -1
            long r2 = java.lang.System.currentTimeMillis()
            long r15 = r2 - r4
            r12 = r10
            r17 = r11
            r12.zzc(r13, r14, r15, r17, r18)
        L_0x011c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalq.zzm(android.content.Context, java.lang.String, int, android.view.View, android.app.Activity, byte[]):java.lang.String");
    }

    public abstract long zza(StackTraceElement[] stackTraceElementArr) throws zzamj;

    public abstract zzaiz zzb(Context context, View view, Activity activity);

    public abstract zzaiz zzc(Context context, zzais zzais);

    public abstract zzaiz zzd(Context context, View view, Activity activity);

    public final String zze(Context context, String str, View view) {
        return zzm(context, str, 3, view, (Activity) null, (byte[]) null);
    }

    public final String zzf(Context context, String str, View view, Activity activity) {
        return zzm(context, str, 3, view, activity, (byte[]) null);
    }

    public final String zzg(Context context) {
        if (!zzamv.zzf()) {
            return zzm(context, (String) null, 1, (View) null, (Activity) null, (byte[]) null);
        }
        throw new IllegalStateException("The caller must not be called from the UI thread.");
    }

    public final String zzh(Context context, View view, Activity activity) {
        return zzm(context, (String) null, 2, view, (Activity) null, (byte[]) null);
    }

    public abstract zzamu zzi(MotionEvent motionEvent) throws zzamj;

    public final synchronized void zzk(MotionEvent motionEvent) {
        Long l11;
        if (this.zzt) {
            zzj();
            this.zzt = false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.zzk = 0.0d;
            this.zzr = (double) motionEvent.getRawX();
            this.zzs = (double) motionEvent.getRawY();
        } else if (action == 1 || action == 2) {
            double rawX = (double) motionEvent.getRawX();
            double rawY = (double) motionEvent.getRawY();
            double d11 = rawX - this.zzr;
            double d12 = rawY - this.zzs;
            this.zzk += Math.sqrt((d11 * d11) + (d12 * d12));
            this.zzr = rawX;
            this.zzs = rawY;
        }
        int action2 = motionEvent.getAction();
        if (action2 == 0) {
            this.zzl = motionEvent.getX();
            this.zzm = motionEvent.getY();
            this.zzn = motionEvent.getRawX();
            this.zzo = motionEvent.getRawY();
            this.zzd++;
        } else if (action2 == 1) {
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            this.zzb = obtain;
            this.zzc.add(obtain);
            if (this.zzc.size() > 6) {
                this.zzc.remove().recycle();
            }
            this.zzf++;
            this.zzh = zza(new Throwable().getStackTrace());
        } else if (action2 == 2) {
            this.zze += (long) (motionEvent.getHistorySize() + 1);
            try {
                zzamu zzi2 = zzi(motionEvent);
                Long l12 = zzi2.zzd;
                if (!(l12 == null || zzi2.zzg == null)) {
                    this.zzi += l12.longValue() + zzi2.zzg.longValue();
                }
                if (!(this.zzq == null || (l11 = zzi2.zze) == null || zzi2.zzh == null)) {
                    this.zzj += l11.longValue() + zzi2.zzh.longValue();
                }
            } catch (zzamj unused) {
            }
        } else if (action2 == 3) {
            this.zzg++;
        }
        this.zzp = true;
    }

    public final synchronized void zzl(int i11, int i12, int i13) {
        synchronized (this) {
            if (this.zzb != null) {
                if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbK)).booleanValue()) {
                    zzj();
                } else {
                    this.zzb.recycle();
                }
            }
            DisplayMetrics displayMetrics = this.zzq;
            if (displayMetrics != null) {
                float f11 = displayMetrics.density;
                this.zzb = MotionEvent.obtain(0, (long) i13, 1, ((float) i11) * f11, ((float) i12) * f11, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
            } else {
                this.zzb = null;
            }
            this.zzp = false;
        }
    }

    public void zzn(View view) {
    }
}
