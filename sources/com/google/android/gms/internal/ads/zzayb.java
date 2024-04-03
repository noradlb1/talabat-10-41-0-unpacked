package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.zzcd;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.HashSet;

@TargetApi(14)
public final class zzayb implements View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, Application.ActivityLifecycleCallbacks {
    private static final long zzc = ((Long) zzbgq.zzc().zzb(zzblj.zzaX)).longValue();
    @Nullable
    @VisibleForTesting
    BroadcastReceiver zza;
    final WeakReference<View> zzb;
    private final Context zzd;
    private Application zze;
    private final WindowManager zzf;
    private final PowerManager zzg;
    private final KeyguardManager zzh;
    private WeakReference<ViewTreeObserver> zzi;
    private zzayn zzj;
    private final zzcd zzk = new zzcd(zzc);
    private boolean zzl = false;
    private int zzm = -1;
    private final HashSet<zzaya> zzn = new HashSet<>();
    private final DisplayMetrics zzo;
    private final Rect zzp;

    public zzayb(Context context, View view) {
        View view2;
        Context applicationContext = context.getApplicationContext();
        this.zzd = applicationContext;
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        this.zzf = windowManager;
        this.zzg = (PowerManager) applicationContext.getSystemService("power");
        this.zzh = (KeyguardManager) context.getSystemService("keyguard");
        if (applicationContext instanceof Application) {
            Application application = (Application) applicationContext;
            this.zze = application;
            this.zzj = new zzayn(application, this);
        }
        this.zzo = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzp = rect;
        rect.right = windowManager.getDefaultDisplay().getWidth();
        rect.bottom = windowManager.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzb;
        if (weakReference != null) {
            view2 = weakReference.get();
        } else {
            view2 = null;
        }
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzm(view2);
        }
        this.zzb = new WeakReference<>(view);
        if (view != null) {
            if (zzt.zzq().zzi(view)) {
                zzl(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final int zzh(int i11) {
        return (int) (((float) i11) / this.zzo.density);
    }

    private final void zzi(Activity activity, int i11) {
        Window window;
        if (this.zzb != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = this.zzb.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzm = i11;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0114, code lost:
        if (r11 == 0) goto L_0x012c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012a, code lost:
        if (r11 == 0) goto L_0x012c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0197 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0198  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzj(int r33) {
        /*
            r32 = this;
            r1 = r32
            r2 = r33
            java.util.HashSet<com.google.android.gms.internal.ads.zzaya> r0 = r1.zzn
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.zzb
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            android.graphics.Rect r5 = new android.graphics.Rect
            r5.<init>()
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r0 = 2
            int[] r8 = new int[r0]
            int[] r0 = new int[r0]
            r9 = 0
            r10 = 1
            r11 = 0
            if (r3 == 0) goto L_0x0069
            boolean r12 = r3.getGlobalVisibleRect(r5)
            boolean r13 = r3.getLocalVisibleRect(r6)
            r3.getHitRect(r7)
            r3.getLocationOnScreen(r8)     // Catch:{ Exception -> 0x0049 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0049 }
            goto L_0x004f
        L_0x0049:
            r0 = move-exception
            java.lang.String r14 = "Failure getting view location."
            com.google.android.gms.internal.ads.zzciz.zzh(r14, r0)
        L_0x004f:
            r0 = r8[r11]
            r4.left = r0
            r8 = r8[r10]
            r4.top = r8
            int r8 = r3.getWidth()
            int r0 = r0 + r8
            r4.right = r0
            int r0 = r4.top
            int r8 = r3.getHeight()
            int r0 = r0 + r8
            r4.bottom = r0
            r8 = r3
            goto L_0x006c
        L_0x0069:
            r8 = r9
            r12 = r11
            r13 = r12
        L_0x006c:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzba
            com.google.android.gms.internal.ads.zzblh r14 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r0 = r14.zzb(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x00bd
            if (r8 == 0) goto L_0x00bd
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x00ae }
            r0.<init>()     // Catch:{ Exception -> 0x00ae }
            android.view.ViewParent r14 = r8.getParent()     // Catch:{ Exception -> 0x00ae }
        L_0x0089:
            boolean r15 = r14 instanceof android.view.View     // Catch:{ Exception -> 0x00ae }
            if (r15 == 0) goto L_0x00c1
            r15 = r14
            android.view.View r15 = (android.view.View) r15     // Catch:{ Exception -> 0x00ae }
            android.graphics.Rect r11 = new android.graphics.Rect     // Catch:{ Exception -> 0x00ae }
            r11.<init>()     // Catch:{ Exception -> 0x00ae }
            boolean r17 = r15.isScrollContainer()     // Catch:{ Exception -> 0x00ae }
            if (r17 == 0) goto L_0x00a8
            boolean r15 = r15.getGlobalVisibleRect(r11)     // Catch:{ Exception -> 0x00ae }
            if (r15 == 0) goto L_0x00a8
            android.graphics.Rect r11 = r1.zza(r11)     // Catch:{ Exception -> 0x00ae }
            r0.add(r11)     // Catch:{ Exception -> 0x00ae }
        L_0x00a8:
            android.view.ViewParent r14 = r14.getParent()     // Catch:{ Exception -> 0x00ae }
            r11 = 0
            goto L_0x0089
        L_0x00ae:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcik r11 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r14 = "PositionWatcher.getParentScrollViewRects"
            r11.zzs(r0, r14)
            java.util.List r0 = java.util.Collections.emptyList()
            goto L_0x00c1
        L_0x00bd:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x00c1:
            r31 = r0
            r0 = 8
            if (r8 == 0) goto L_0x00cc
            int r11 = r8.getWindowVisibility()
            goto L_0x00cd
        L_0x00cc:
            r11 = r0
        L_0x00cd:
            int r14 = r1.zzm
            r15 = -1
            if (r14 == r15) goto L_0x00d3
            r11 = r14
        L_0x00d3:
            com.google.android.gms.ads.internal.zzt.zzp()
            long r26 = com.google.android.gms.ads.internal.util.zzt.zzA(r8)
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zzblj.zzhb
            com.google.android.gms.internal.ads.zzblh r15 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0117
            if (r3 == 0) goto L_0x012f
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzt.zzX(r8, r3, r14)
            if (r3 == 0) goto L_0x012f
            if (r12 == 0) goto L_0x012f
            if (r13 == 0) goto L_0x012f
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r3 = com.google.android.gms.internal.ads.zzblj.zzhe
            com.google.android.gms.internal.ads.zzblh r14 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r3 = r14.zzb(r3)
            java.lang.Integer r3 = (java.lang.Integer) r3
            int r3 = r3.intValue()
            long r14 = (long) r3
            int r3 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r3 < 0) goto L_0x012f
            if (r11 != 0) goto L_0x012f
            goto L_0x012c
        L_0x0117:
            if (r3 == 0) goto L_0x012f
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r3 = r1.zzg
            android.app.KeyguardManager r14 = r1.zzh
            boolean r3 = com.google.android.gms.ads.internal.util.zzt.zzX(r8, r3, r14)
            if (r3 == 0) goto L_0x012f
            if (r12 == 0) goto L_0x012f
            if (r13 == 0) goto L_0x012f
            if (r11 != 0) goto L_0x012f
        L_0x012c:
            r3 = r10
            r11 = 0
            goto L_0x0130
        L_0x012f:
            r3 = 0
        L_0x0130:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r14 = com.google.android.gms.internal.ads.zzblj.zzhg
            com.google.android.gms.internal.ads.zzblh r15 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Boolean r14 = (java.lang.Boolean) r14
            boolean r14 = r14.booleanValue()
            if (r14 == 0) goto L_0x0188
            com.google.android.gms.ads.internal.zzt.zzp()
            android.os.PowerManager r14 = r1.zzg
            android.app.KeyguardManager r15 = r1.zzh
            boolean r14 = com.google.android.gms.ads.internal.util.zzt.zzX(r8, r14, r15)
            if (r10 == r14) goto L_0x0151
            r14 = 0
            goto L_0x0153
        L_0x0151:
            r14 = 64
        L_0x0153:
            if (r10 == r12) goto L_0x0157
            r15 = 0
            goto L_0x0158
        L_0x0157:
            r15 = r0
        L_0x0158:
            r14 = r14 | r15
            if (r10 == r13) goto L_0x015d
            r15 = 0
            goto L_0x015f
        L_0x015d:
            r15 = 16
        L_0x015f:
            r14 = r14 | r15
            if (r11 != 0) goto L_0x0165
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x0166
        L_0x0165:
            r11 = 0
        L_0x0166:
            r11 = r11 | r14
            com.google.android.gms.internal.ads.zzblb<java.lang.Integer> r14 = com.google.android.gms.internal.ads.zzblj.zzhe
            com.google.android.gms.internal.ads.zzblh r15 = com.google.android.gms.internal.ads.zzbgq.zzc()
            java.lang.Object r14 = r15.zzb(r14)
            java.lang.Integer r14 = (java.lang.Integer) r14
            int r14 = r14.intValue()
            long r14 = (long) r14
            int r14 = (r26 > r14 ? 1 : (r26 == r14 ? 0 : -1))
            if (r14 < 0) goto L_0x017f
            r14 = 32
            goto L_0x0180
        L_0x017f:
            r14 = 0
        L_0x0180:
            com.google.android.gms.ads.internal.zzt.zzp()
            r11 = r11 | r14
            r11 = r11 | r3
            com.google.android.gms.ads.internal.util.zzt.zzN(r8, r11, r9)
        L_0x0188:
            if (r2 != r10) goto L_0x0198
            com.google.android.gms.ads.internal.util.zzcd r9 = r1.zzk
            boolean r9 = r9.zzb()
            if (r9 != 0) goto L_0x0198
            boolean r9 = r1.zzl
            if (r3 == r9) goto L_0x0197
            goto L_0x0198
        L_0x0197:
            return
        L_0x0198:
            if (r3 != 0) goto L_0x01a2
            boolean r9 = r1.zzl
            if (r9 != 0) goto L_0x01a2
            if (r2 == r10) goto L_0x01a1
            goto L_0x01a2
        L_0x01a1:
            return
        L_0x01a2:
            com.google.android.gms.internal.ads.zzaxz r2 = new com.google.android.gms.internal.ads.zzaxz
            com.google.android.gms.common.util.Clock r9 = com.google.android.gms.ads.internal.zzt.zzA()
            long r17 = r9.elapsedRealtime()
            android.os.PowerManager r9 = r1.zzg
            boolean r9 = r9.isScreenOn()
            if (r8 == 0) goto L_0x01bf
            com.google.android.gms.ads.internal.util.zzae r11 = com.google.android.gms.ads.internal.zzt.zzq()
            boolean r11 = r11.zzi(r8)
            if (r11 == 0) goto L_0x01bf
            goto L_0x01c0
        L_0x01bf:
            r10 = 0
        L_0x01c0:
            if (r8 == 0) goto L_0x01c6
            int r0 = r8.getWindowVisibility()
        L_0x01c6:
            r19 = r0
            android.graphics.Rect r0 = r1.zzp
            android.graphics.Rect r20 = r1.zza(r0)
            android.graphics.Rect r21 = r1.zza(r4)
            android.graphics.Rect r22 = r1.zza(r5)
            android.graphics.Rect r24 = r1.zza(r6)
            android.graphics.Rect r28 = r1.zza(r7)
            android.util.DisplayMetrics r0 = r1.zzo
            float r0 = r0.density
            r29 = r0
            r14 = r2
            r15 = r17
            r17 = r9
            r18 = r10
            r23 = r12
            r25 = r13
            r30 = r3
            r14.<init>(r15, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r29, r30, r31)
            java.util.HashSet<com.google.android.gms.internal.ads.zzaya> r0 = r1.zzn
            java.util.Iterator r0 = r0.iterator()
        L_0x01fa:
            boolean r4 = r0.hasNext()
            if (r4 == 0) goto L_0x020a
            java.lang.Object r4 = r0.next()
            com.google.android.gms.internal.ads.zzaya r4 = (com.google.android.gms.internal.ads.zzaya) r4
            r4.zzc(r2)
            goto L_0x01fa
        L_0x020a:
            r1.zzl = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayb.zzj(int):void");
    }

    private final void zzk() {
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzaxx(this));
    }

    private final void zzl(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzi = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zza == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zza = new zzaxy(this);
            zzt.zzv().zzc(this.zzd, this.zza, intentFilter);
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e11) {
                zzciz.zzh("Error registering activity lifecycle callbacks.", e11);
            }
        }
    }

    private final void zzm(View view) {
        try {
            WeakReference<ViewTreeObserver> weakReference = this.zzi;
            if (weakReference != null) {
                ViewTreeObserver viewTreeObserver = weakReference.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzi = null;
            }
        } catch (Exception e11) {
            zzciz.zzh("Error while unregistering listeners from the last ViewTreeObserver.", e11);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e12) {
            zzciz.zzh("Error while unregistering listeners from the ViewTreeObserver.", e12);
        }
        if (this.zza != null) {
            try {
                zzt.zzv().zzd(this.zzd, this.zza);
            } catch (IllegalStateException e13) {
                zzciz.zzh("Failed trying to unregister the receiver", e13);
            } catch (Exception e14) {
                zzt.zzo().zzs(e14, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zza = null;
        }
        Application application = this.zze;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzj);
            } catch (Exception e15) {
                zzciz.zzh("Error registering activity lifecycle callbacks.", e15);
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onActivityPaused(Activity activity) {
        zzi(activity, 4);
        zzj(3);
        zzk();
    }

    public final void onActivityResumed(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzj(3);
        zzk();
    }

    public final void onActivityStarted(Activity activity) {
        zzi(activity, 0);
        zzj(3);
        zzk();
    }

    public final void onActivityStopped(Activity activity) {
        zzj(3);
        zzk();
    }

    public final void onGlobalLayout() {
        zzj(2);
        zzk();
    }

    public final void onScrollChanged() {
        zzj(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzm = -1;
        zzl(view);
        zzj(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzm = -1;
        zzj(3);
        zzk();
        zzm(view);
    }

    public final Rect zza(Rect rect) {
        return new Rect(zzh(rect.left), zzh(rect.top), zzh(rect.right), zzh(rect.bottom));
    }

    public final void zzc(zzaya zzaya) {
        this.zzn.add(zzaya);
        zzj(3);
    }

    public final /* synthetic */ void zzd() {
        zzj(3);
    }

    public final void zze(zzaya zzaya) {
        this.zzn.remove(zzaya);
    }

    public final void zzf() {
        this.zzk.zza(zzc);
    }

    public final void zzg(long j11) {
        this.zzk.zza(j11);
    }
}
