package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zzcm;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.instabug.library.model.NetworkLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint({"ViewConstructor"})
@Instrumented
@ParametersAreNonnullByDefault
@VisibleForTesting
final class zzcpi extends WebView implements DownloadListener, ViewTreeObserver.OnGlobalLayoutListener, zzcop {
    public static final /* synthetic */ int zza = 0;
    @GuardedBy("this")
    private boolean zzA;
    @GuardedBy("this")
    private boolean zzB;
    @GuardedBy("this")
    private zzbnv zzC;
    @GuardedBy("this")
    private zzbnt zzD;
    @GuardedBy("this")
    private zzazn zzE;
    @GuardedBy("this")
    private int zzF;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzG;
    private zzblv zzH;
    private final zzblv zzI;
    private zzblv zzJ;
    private final zzblw zzK;
    private int zzL;
    private int zzM;
    private int zzN;
    @GuardedBy("this")
    private zzl zzO;
    @GuardedBy("this")
    private boolean zzP;
    private final zzcm zzQ;
    private int zzR = -1;
    private int zzS = -1;
    private int zzT = -1;
    private int zzU = -1;
    private Map<String, zzcnf> zzV;
    private final WindowManager zzW;
    private final zzbay zzX;
    private final zzcqd zzb;
    private final zzalt zzc;
    private final zzbmi zzd;
    private final zzcjf zze;
    private com.google.android.gms.ads.internal.zzl zzf;
    private final zza zzg;
    private final DisplayMetrics zzh;
    private final float zzi;
    private zzfdn zzj;
    private zzfdq zzk;
    private boolean zzl = false;
    private boolean zzm = false;
    private zzcow zzn;
    @GuardedBy("this")
    private zzl zzo;
    @GuardedBy("this")
    private IObjectWrapper zzp;
    @GuardedBy("this")
    private zzcqe zzq;
    @GuardedBy("this")
    private final String zzr;
    @GuardedBy("this")
    private boolean zzs;
    @GuardedBy("this")
    private boolean zzt;
    @GuardedBy("this")
    private boolean zzu;
    @GuardedBy("this")
    private boolean zzv;
    @GuardedBy("this")
    private Boolean zzw;
    @GuardedBy("this")
    private boolean zzx = true;
    @GuardedBy("this")
    private final String zzy = "";
    @GuardedBy("this")
    private zzcpl zzz;

    @VisibleForTesting
    public zzcpi(zzcqd zzcqd, zzcqe zzcqe, String str, boolean z11, boolean z12, zzalt zzalt, zzbmi zzbmi, zzcjf zzcjf, zzbly zzbly, com.google.android.gms.ads.internal.zzl zzl2, zza zza2, zzbay zzbay, zzfdn zzfdn, zzfdq zzfdq) {
        super(zzcqd);
        zzfdq zzfdq2;
        this.zzb = zzcqd;
        this.zzq = zzcqe;
        this.zzr = str;
        this.zzu = z11;
        this.zzc = zzalt;
        this.zzd = zzbmi;
        this.zze = zzcjf;
        this.zzf = zzl2;
        this.zzg = zza2;
        WindowManager windowManager = (WindowManager) getContext().getSystemService("window");
        this.zzW = windowManager;
        zzt.zzp();
        DisplayMetrics zzy2 = com.google.android.gms.ads.internal.util.zzt.zzy(windowManager);
        this.zzh = zzy2;
        this.zzi = zzy2.density;
        this.zzX = zzbay;
        this.zzj = zzfdn;
        this.zzk = zzfdq;
        this.zzQ = new zzcm(zzcqd.zza(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e11) {
            zzciz.zzh("Unable to enable Javascript.", e11);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setMixedContentMode(2);
        settings.setUserAgentString(zzt.zzp().zzd(zzcqd, zzcjf.zza));
        zzt.zzq().zzf(getContext(), settings);
        setDownloadListener(this);
        zzaU();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(new zzcpp(this, new zzcpn(this), (zzcpn) null), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        zzbc();
        zzblw zzblw = new zzblw(new zzbly(true, "make_wv", this.zzr));
        this.zzK = zzblw;
        zzblw.zza().zzc((zzbly) null);
        if (!(!((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() || (zzfdq2 = this.zzk) == null || zzfdq2.zzb == null)) {
            zzblw.zza().zzd("gqi", this.zzk.zzb);
        }
        zzblw.zza();
        zzblv zzf2 = zzbly.zzf();
        this.zzI = zzf2;
        zzblw.zzb("native:view_create", zzf2);
        this.zzJ = null;
        this.zzH = null;
        zzt.zzq().zze(zzcqd);
        zzt.zzo().zzp();
    }

    private final synchronized void zzaU() {
        zzfdn zzfdn = this.zzj;
        if (zzfdn != null) {
            if (zzfdn.zzak) {
                zzciz.zze("Disabling hardware acceleration on an overlay.");
                zzaW();
                return;
            }
        }
        if (!this.zzu) {
            if (!this.zzq.zzi()) {
                zzciz.zze("Enabling hardware acceleration on an AdView.");
                zzaY();
                return;
            }
        }
        zzciz.zze("Enabling hardware acceleration on an overlay.");
        zzaY();
    }

    private final synchronized void zzaV() {
        if (!this.zzP) {
            this.zzP = true;
            zzt.zzo().zzo();
        }
    }

    private final synchronized void zzaW() {
        if (!this.zzv) {
            setLayerType(1, (Paint) null);
        }
        this.zzv = true;
    }

    private final void zzaX(boolean z11) {
        String str;
        HashMap hashMap = new HashMap();
        if (true != z11) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("isVisible", str);
        zzd("onAdVisibilityChanged", hashMap);
    }

    private final synchronized void zzaY() {
        if (this.zzv) {
            setLayerType(0, (Paint) null);
        }
        this.zzv = false;
    }

    private final synchronized void zzaZ(String str) {
        try {
            super.loadUrl("about:blank");
        } catch (Throwable th2) {
            zzt.zzo().zzs(th2, "AdWebViewImpl.loadUrlUnsafe");
            zzciz.zzk("Could not call loadUrl in destroy(). ", th2);
        }
    }

    private final void zzba() {
        zzblq.zza(this.zzK.zza(), this.zzI, "aeh2");
    }

    private final synchronized void zzbb() {
        Map<String, zzcnf> map = this.zzV;
        if (map != null) {
            for (zzcnf release : map.values()) {
                release.release();
            }
        }
        this.zzV = null;
    }

    private final void zzbc() {
        zzblw zzblw = this.zzK;
        if (zzblw != null) {
            zzbly zza2 = zzblw.zza();
            zzblo zzf2 = zzt.zzo().zzf();
            if (zzf2 != null) {
                zzf2.zzf(zza2);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:9|10|11|12) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzaS(java.lang.Boolean.FALSE);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0020, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final synchronized void zzbd() {
        /*
            r2 = this;
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzcik r0 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ all -> 0x0023 }
            java.lang.Boolean r0 = r0.zzk()     // Catch:{ all -> 0x0023 }
            r2.zzw = r0     // Catch:{ all -> 0x0023 }
            if (r0 != 0) goto L_0x0021
            java.lang.String r0 = "(function(){})()"
            r1 = 0
            r2.evaluateJavascript(r0, r1)     // Catch:{ IllegalStateException -> 0x001a }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ IllegalStateException -> 0x001a }
            r2.zzaS(r0)     // Catch:{ IllegalStateException -> 0x001a }
            monitor-exit(r2)
            return
        L_0x001a:
            java.lang.Boolean r0 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0023 }
            r2.zzaS(r0)     // Catch:{ all -> 0x0023 }
            monitor-exit(r2)
            return
        L_0x0021:
            monitor-exit(r2)
            return
        L_0x0023:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpi.zzbd():void");
    }

    public final synchronized void destroy() {
        zzbc();
        this.zzQ.zza();
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzb();
            this.zzo.zzl();
            this.zzo = null;
        }
        this.zzp = null;
        this.zzn.zzy();
        this.zzE = null;
        this.zzf = null;
        setOnClickListener((View.OnClickListener) null);
        setOnTouchListener((View.OnTouchListener) null);
        if (!this.zzt) {
            zzt.zzy().zzd(this);
            zzbb();
            this.zzt = true;
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzhn)).booleanValue()) {
                zze.zza("Initiating WebView self destruct sequence in 3...");
                zze.zza("Loading blank page in WebView, 2...");
                zzaZ("about:blank");
                return;
            }
            zze.zza("Destroying the WebView immediately...");
            zzW();
        }
    }

    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (zzaB()) {
            zzciz.zzl("#004 The webview is destroyed. Ignoring action.", (Throwable) null);
            if (valueCallback != null) {
                valueCallback.onReceiveValue((Object) null);
                return;
            }
            return;
        }
        super.evaluateJavascript(str, valueCallback);
    }

    public final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzt) {
                    this.zzn.zzy();
                    zzt.zzy().zzd(this);
                    zzbb();
                    zzaV();
                }
            }
            super.finalize();
        } catch (Throwable th2) {
            super.finalize();
            throw th2;
        }
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!zzaB()) {
            super.loadData(str, str2, str3);
        } else {
            zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!zzaB()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!zzaB()) {
            try {
                super.loadUrl(str);
            } catch (Throwable th2) {
                zzt.zzo().zzs(th2, "AdWebViewImpl.loadUrl");
                zzciz.zzk("Could not call loadUrl. ", th2);
            }
        } else {
            zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzcow zzcow = this.zzn;
        if (zzcow != null) {
            zzcow.onAdClicked();
        }
    }

    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!zzaB()) {
            this.zzQ.zzc();
        }
        boolean z11 = this.zzA;
        zzcow zzcow = this.zzn;
        if (zzcow != null && zzcow.zzK()) {
            if (!this.zzB) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = true;
            }
            zzaT();
            z11 = true;
        }
        zzaX(z11);
    }

    public final void onDetachedFromWindow() {
        zzcow zzcow;
        synchronized (this) {
            if (!zzaB()) {
                this.zzQ.zzd();
            }
            super.onDetachedFromWindow();
            if (this.zzB && (zzcow = this.zzn) != null && zzcow.zzK() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzn.zza();
                this.zzn.zzb();
                this.zzB = false;
            }
        }
        zzaX(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzt.zzp();
            com.google.android.gms.ads.internal.util.zzt.zzQ(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb2.append("Couldn't find an Activity to view url/mimetype: ");
            sb2.append(str);
            sb2.append(" / ");
            sb2.append(str4);
            zzciz.zze(sb2.toString());
        }
    }

    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!zzaB()) {
            super.onDraw(canvas);
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzaT = zzaT();
        zzl zzN2 = zzN();
        if (zzN2 != null && zzaT) {
            zzN2.zzm();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x01c2 A[SYNTHETIC, Splitter:B:116:0x01c2] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0120  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x013a  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:126:0x01e3=Splitter:B:126:0x01e3, B:66:0x00dd=Splitter:B:66:0x00dd} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r9, int r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            boolean r0 = r8.zzaB()     // Catch:{ all -> 0x01e8 }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x000d:
            boolean r0 = r8.isInEditMode()     // Catch:{ all -> 0x01e8 }
            if (r0 != 0) goto L_0x01e3
            boolean r0 = r8.zzu     // Catch:{ all -> 0x01e8 }
            if (r0 != 0) goto L_0x01e3
            com.google.android.gms.internal.ads.zzcqe r0 = r8.zzq     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.zzf()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x0021
            goto L_0x01e3
        L_0x0021:
            com.google.android.gms.internal.ads.zzcqe r0 = r8.zzq     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.zzh()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzcqe r0 = r8.zzq     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.zzj()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x0093
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzcv     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzblh r2 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x01e8 }
            java.lang.Object r0 = r2.zzb(r0)     // Catch:{ all -> 0x01e8 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzcpl r0 = r8.zzs()     // Catch:{ all -> 0x01e8 }
            r2 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.zze()     // Catch:{ all -> 0x01e8 }
            goto L_0x005a
        L_0x0059:
            r0 = r2
        L_0x005a:
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0063
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x0063:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e8 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e8 }
            float r2 = (float) r10     // Catch:{ all -> 0x01e8 }
            float r2 = r2 * r0
            int r2 = (int) r2     // Catch:{ all -> 0x01e8 }
            float r3 = (float) r9     // Catch:{ all -> 0x01e8 }
            float r3 = r3 / r0
            int r3 = (int) r3     // Catch:{ all -> 0x01e8 }
            if (r10 != 0) goto L_0x007c
            if (r3 == 0) goto L_0x007b
            float r10 = (float) r3     // Catch:{ all -> 0x01e8 }
            float r10 = r10 * r0
            int r2 = (int) r10     // Catch:{ all -> 0x01e8 }
            r1 = r9
            r10 = r3
            goto L_0x0086
        L_0x007b:
            r10 = r1
        L_0x007c:
            if (r9 != 0) goto L_0x0085
            if (r2 == 0) goto L_0x0086
            float r9 = (float) r2     // Catch:{ all -> 0x01e8 }
            float r9 = r9 / r0
            int r3 = (int) r9     // Catch:{ all -> 0x01e8 }
            r1 = r2
            goto L_0x0086
        L_0x0085:
            r1 = r9
        L_0x0086:
            int r9 = java.lang.Math.min(r2, r1)     // Catch:{ all -> 0x01e8 }
            int r10 = java.lang.Math.min(r3, r10)     // Catch:{ all -> 0x01e8 }
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x0093:
            com.google.android.gms.internal.ads.zzcqe r0 = r8.zzq     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.zzg()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x00e2
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzcz     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x01e8 }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x01e8 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01e8 }
            if (r0 != 0) goto L_0x00dd
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01e8 }
            if (r0 != 0) goto L_0x00b4
            goto L_0x00dd
        L_0x00b4:
            com.google.android.gms.internal.ads.zzcpg r0 = new com.google.android.gms.internal.ads.zzcpg     // Catch:{ all -> 0x01e8 }
            r0.<init>(r8)     // Catch:{ all -> 0x01e8 }
            java.lang.String r1 = "/contentHeight"
            r8.zzaf(r1, r0)     // Catch:{ all -> 0x01e8 }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r8.zzaQ(r0)     // Catch:{ all -> 0x01e8 }
            android.util.DisplayMetrics r0 = r8.zzh     // Catch:{ all -> 0x01e8 }
            float r0 = r0.density     // Catch:{ all -> 0x01e8 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e8 }
            int r1 = r8.zzG     // Catch:{ all -> 0x01e8 }
            r2 = -1
            if (r1 == r2) goto L_0x00d4
            float r10 = (float) r1     // Catch:{ all -> 0x01e8 }
            float r10 = r10 * r0
            int r10 = (int) r10     // Catch:{ all -> 0x01e8 }
            goto L_0x00d8
        L_0x00d4:
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e8 }
        L_0x00d8:
            r8.setMeasuredDimension(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x00dd:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x00e2:
            com.google.android.gms.internal.ads.zzcqe r0 = r8.zzq     // Catch:{ all -> 0x01e8 }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x01e8 }
            if (r0 == 0) goto L_0x00f5
            android.util.DisplayMetrics r9 = r8.zzh     // Catch:{ all -> 0x01e8 }
            int r10 = r9.widthPixels     // Catch:{ all -> 0x01e8 }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01e8 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x00f5:
            int r0 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01e8 }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01e8 }
            int r2 = android.view.View.MeasureSpec.getMode(r10)     // Catch:{ all -> 0x01e8 }
            int r10 = android.view.View.MeasureSpec.getSize(r10)     // Catch:{ all -> 0x01e8 }
            r3 = 2147483647(0x7fffffff, float:NaN)
            r4 = 1073741824(0x40000000, float:2.0)
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r0 == r5) goto L_0x0113
            if (r0 != r4) goto L_0x0111
            goto L_0x0113
        L_0x0111:
            r0 = r3
            goto L_0x0114
        L_0x0113:
            r0 = r9
        L_0x0114:
            if (r2 == r5) goto L_0x0118
            if (r2 != r4) goto L_0x0119
        L_0x0118:
            r3 = r10
        L_0x0119:
            com.google.android.gms.internal.ads.zzcqe r2 = r8.zzq     // Catch:{ all -> 0x01e8 }
            int r4 = r2.zzb     // Catch:{ all -> 0x01e8 }
            r5 = 1
            if (r4 > r0) goto L_0x0127
            int r2 = r2.zza     // Catch:{ all -> 0x01e8 }
            if (r2 <= r3) goto L_0x0125
            goto L_0x0127
        L_0x0125:
            r2 = r1
            goto L_0x0128
        L_0x0127:
            r2 = r5
        L_0x0128:
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzblj.zzdR     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzblh r6 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x01e8 }
            java.lang.Object r4 = r6.zzb(r4)     // Catch:{ all -> 0x01e8 }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01e8 }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01e8 }
            if (r4 == 0) goto L_0x0159
            com.google.android.gms.internal.ads.zzcqe r4 = r8.zzq     // Catch:{ all -> 0x01e8 }
            int r6 = r4.zzb     // Catch:{ all -> 0x01e8 }
            float r7 = r8.zzi     // Catch:{ all -> 0x01e8 }
            float r6 = (float) r6     // Catch:{ all -> 0x01e8 }
            float r6 = r6 / r7
            float r0 = (float) r0     // Catch:{ all -> 0x01e8 }
            float r0 = r0 / r7
            int r0 = (r6 > r0 ? 1 : (r6 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0154
            int r0 = r4.zza     // Catch:{ all -> 0x01e8 }
            float r0 = (float) r0     // Catch:{ all -> 0x01e8 }
            float r0 = r0 / r7
            float r3 = (float) r3     // Catch:{ all -> 0x01e8 }
            float r3 = r3 / r7
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 > 0) goto L_0x0154
            r0 = r5
            goto L_0x0155
        L_0x0154:
            r0 = r1
        L_0x0155:
            if (r5 == r2) goto L_0x0158
            goto L_0x0159
        L_0x0158:
            r2 = r0
        L_0x0159:
            r0 = 8
            if (r2 == 0) goto L_0x01c2
            com.google.android.gms.internal.ads.zzcqe r2 = r8.zzq     // Catch:{ all -> 0x01e8 }
            int r3 = r2.zzb     // Catch:{ all -> 0x01e8 }
            float r4 = r8.zzi     // Catch:{ all -> 0x01e8 }
            int r2 = r2.zza     // Catch:{ all -> 0x01e8 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01e8 }
            r7 = 103(0x67, float:1.44E-43)
            r6.<init>(r7)     // Catch:{ all -> 0x01e8 }
            java.lang.String r7 = "Not enough space to show ad. Needs "
            r6.append(r7)     // Catch:{ all -> 0x01e8 }
            float r3 = (float) r3     // Catch:{ all -> 0x01e8 }
            float r3 = r3 / r4
            int r3 = (int) r3     // Catch:{ all -> 0x01e8 }
            r6.append(r3)     // Catch:{ all -> 0x01e8 }
            java.lang.String r3 = "x"
            r6.append(r3)     // Catch:{ all -> 0x01e8 }
            float r2 = (float) r2     // Catch:{ all -> 0x01e8 }
            float r2 = r2 / r4
            int r2 = (int) r2     // Catch:{ all -> 0x01e8 }
            r6.append(r2)     // Catch:{ all -> 0x01e8 }
            java.lang.String r2 = " dp, but only has "
            r6.append(r2)     // Catch:{ all -> 0x01e8 }
            float r9 = (float) r9     // Catch:{ all -> 0x01e8 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01e8 }
            r6.append(r9)     // Catch:{ all -> 0x01e8 }
            java.lang.String r9 = "x"
            r6.append(r9)     // Catch:{ all -> 0x01e8 }
            float r9 = (float) r10     // Catch:{ all -> 0x01e8 }
            float r9 = r9 / r4
            int r9 = (int) r9     // Catch:{ all -> 0x01e8 }
            r6.append(r9)     // Catch:{ all -> 0x01e8 }
            java.lang.String r9 = " dp."
            r6.append(r9)     // Catch:{ all -> 0x01e8 }
            java.lang.String r9 = r6.toString()     // Catch:{ all -> 0x01e8 }
            com.google.android.gms.internal.ads.zzciz.zzj(r9)     // Catch:{ all -> 0x01e8 }
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e8 }
            if (r9 == r0) goto L_0x01ae
            r9 = 4
            r8.setVisibility(r9)     // Catch:{ all -> 0x01e8 }
        L_0x01ae:
            r8.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01e8 }
            boolean r9 = r8.zzl     // Catch:{ all -> 0x01e8 }
            if (r9 != 0) goto L_0x01c0
            com.google.android.gms.internal.ads.zzbay r9 = r8.zzX     // Catch:{ all -> 0x01e8 }
            r10 = 10001(0x2711, float:1.4014E-41)
            r9.zzc(r10)     // Catch:{ all -> 0x01e8 }
            r8.zzl = r5     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x01c0:
            monitor-exit(r8)
            return
        L_0x01c2:
            int r9 = r8.getVisibility()     // Catch:{ all -> 0x01e8 }
            if (r9 == r0) goto L_0x01cb
            r8.setVisibility(r1)     // Catch:{ all -> 0x01e8 }
        L_0x01cb:
            boolean r9 = r8.zzm     // Catch:{ all -> 0x01e8 }
            if (r9 != 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzbay r9 = r8.zzX     // Catch:{ all -> 0x01e8 }
            r10 = 10002(0x2712, float:1.4016E-41)
            r9.zzc(r10)     // Catch:{ all -> 0x01e8 }
            r8.zzm = r5     // Catch:{ all -> 0x01e8 }
        L_0x01d8:
            com.google.android.gms.internal.ads.zzcqe r9 = r8.zzq     // Catch:{ all -> 0x01e8 }
            int r10 = r9.zzb     // Catch:{ all -> 0x01e8 }
            int r9 = r9.zza     // Catch:{ all -> 0x01e8 }
            r8.setMeasuredDimension(r10, r9)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x01e3:
            super.onMeasure(r9, r10)     // Catch:{ all -> 0x01e8 }
            monitor-exit(r8)
            return
        L_0x01e8:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpi.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!zzaB()) {
            try {
                super.onPause();
            } catch (Exception e11) {
                zzciz.zzh("Could not pause webview.", e11);
            }
        }
    }

    public final void onResume() {
        if (!zzaB()) {
            try {
                super.onResume();
            } catch (Exception e11) {
                zzciz.zzh("Could not resume webview.", e11);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzn.zzK() || this.zzn.zzI()) {
            zzalt zzalt = this.zzc;
            if (zzalt != null) {
                zzalt.zzd(motionEvent);
            }
            zzbmi zzbmi = this.zzd;
            if (zzbmi != null) {
                zzbmi.zzb(motionEvent);
            }
        } else {
            synchronized (this) {
                zzbnv zzbnv = this.zzC;
                if (zzbnv != null) {
                    zzbnv.zzd(motionEvent);
                }
            }
        }
        if (zzaB()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzcow) {
            this.zzn = (zzcow) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!zzaB()) {
            try {
                super.stopLoading();
            } catch (Exception e11) {
                zzciz.zzh("Could not stop loading webview.", e11);
            }
        }
    }

    public final void zzA(int i11) {
        this.zzM = i11;
    }

    public final void zzB(boolean z11) {
        this.zzn.zzB(false);
    }

    public final synchronized void zzC(int i11) {
        this.zzL = i11;
    }

    public final void zzD(int i11) {
    }

    public final synchronized void zzE(zzcpl zzcpl) {
        if (this.zzz != null) {
            zzciz.zzg("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzz = zzcpl;
        }
    }

    public final zzfdn zzF() {
        return this.zzj;
    }

    public final Context zzG() {
        return this.zzb.zzb();
    }

    public final View zzH() {
        return this;
    }

    public final WebView zzI() {
        return this;
    }

    public final WebViewClient zzJ() {
        return this.zzn;
    }

    public final zzalt zzK() {
        return this.zzc;
    }

    public final synchronized zzazn zzL() {
        return this.zzE;
    }

    public final synchronized zzbnv zzM() {
        return this.zzC;
    }

    public final synchronized zzl zzN() {
        return this.zzo;
    }

    public final synchronized zzl zzO() {
        return this.zzO;
    }

    public final /* synthetic */ zzcqc zzP() {
        return this.zzn;
    }

    public final synchronized zzcqe zzQ() {
        return this.zzq;
    }

    public final zzfdq zzR() {
        return this.zzk;
    }

    public final synchronized IObjectWrapper zzS() {
        return this.zzp;
    }

    public final zzfxa<String> zzT() {
        zzbmi zzbmi = this.zzd;
        if (zzbmi == null) {
            return zzfwq.zzi(null);
        }
        return zzbmi.zza();
    }

    public final synchronized String zzU() {
        return this.zzr;
    }

    public final void zzV(zzfdn zzfdn, zzfdq zzfdq) {
        this.zzj = zzfdn;
        this.zzk = zzfdq;
    }

    public final synchronized void zzW() {
        zze.zza("Destroying WebView!");
        zzaV();
        com.google.android.gms.ads.internal.util.zzt.zza.post(new zzcph(this));
    }

    public final void zzX() {
        zzba();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zzd("onhide", hashMap);
    }

    public final void zzY(int i11) {
        if (i11 == 0) {
            zzblq.zza(this.zzK.zza(), this.zzI, "aebb2");
        }
        zzba();
        this.zzK.zza();
        this.zzK.zza().zzd("close_type", String.valueOf(i11));
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i11));
        hashMap.put("version", this.zze.zza);
        zzd("onhide", hashMap);
    }

    public final void zzZ() {
        if (this.zzH == null) {
            zzblq.zza(this.zzK.zza(), this.zzI, "aes2");
            this.zzK.zza();
            zzblv zzf2 = zzbly.zzf();
            this.zzH = zzf2;
            this.zzK.zzb("native:view_show", zzf2);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zze.zza);
        zzd("onshow", hashMap);
    }

    public final void zza(String str) {
        throw null;
    }

    public final boolean zzaA(boolean z11, int i11) {
        destroy();
        this.zzX.zzb(new zzcpf(z11, i11));
        this.zzX.zzc(10003);
        return true;
    }

    public final synchronized boolean zzaB() {
        return this.zzt;
    }

    public final synchronized boolean zzaC() {
        return this.zzu;
    }

    public final boolean zzaD() {
        return false;
    }

    public final synchronized boolean zzaE() {
        return this.zzx;
    }

    public final void zzaF(zzc zzc2, boolean z11) {
        this.zzn.zzr(zzc2, z11);
    }

    public final void zzaG(zzbv zzbv, zzehh zzehh, zzdyz zzdyz, zzfio zzfio, String str, String str2, int i11) {
        this.zzn.zzs(zzbv, zzehh, zzdyz, zzfio, str, str2, i11);
    }

    public final void zzaH(boolean z11, int i11, boolean z12) {
        this.zzn.zzt(z11, i11, z12);
    }

    public final void zzaI(boolean z11, int i11, String str, boolean z12) {
        this.zzn.zzv(z11, i11, str, z12);
    }

    public final void zzaJ(boolean z11, int i11, String str, String str2, boolean z12) {
        this.zzn.zzw(z11, i11, str, str2, z12);
    }

    public final zzcow zzaL() {
        return this.zzn;
    }

    @VisibleForTesting
    public final synchronized Boolean zzaM() {
        return this.zzw;
    }

    @TargetApi(19)
    public final synchronized void zzaP(String str, ValueCallback<String> valueCallback) {
        if (!zzaB()) {
            evaluateJavascript(str, (ValueCallback<String>) null);
        } else {
            zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void zzaQ(String str) {
        String str2;
        String str3;
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzaM() == null) {
                zzbd();
            }
            if (zzaM().booleanValue()) {
                zzaP(str, (ValueCallback<String>) null);
                return;
            }
            if (str.length() != 0) {
                str3 = InAppMessageWebViewClient.JAVASCRIPT_PREFIX.concat(str);
            } else {
                str3 = new String(InAppMessageWebViewClient.JAVASCRIPT_PREFIX);
            }
            zzaR(str3);
            return;
        }
        if (str.length() != 0) {
            str2 = InAppMessageWebViewClient.JAVASCRIPT_PREFIX.concat(str);
        } else {
            str2 = new String(InAppMessageWebViewClient.JAVASCRIPT_PREFIX);
        }
        zzaR(str2);
    }

    public final synchronized void zzaR(String str) {
        if (!zzaB()) {
            loadUrl(str);
        } else {
            zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @VisibleForTesting
    public final void zzaS(Boolean bool) {
        synchronized (this) {
            this.zzw = bool;
        }
        zzt.zzo().zzt(bool);
    }

    public final boolean zzaT() {
        int i11;
        int i12;
        boolean z11 = false;
        if (!this.zzn.zzJ() && !this.zzn.zzK()) {
            return false;
        }
        zzbgo.zzb();
        DisplayMetrics displayMetrics = this.zzh;
        int zzq2 = zzcis.zzq(displayMetrics, displayMetrics.widthPixels);
        zzbgo.zzb();
        DisplayMetrics displayMetrics2 = this.zzh;
        int zzq3 = zzcis.zzq(displayMetrics2, displayMetrics2.heightPixels);
        Activity zza2 = this.zzb.zza();
        if (zza2 == null || zza2.getWindow() == null) {
            i12 = zzq2;
            i11 = zzq3;
        } else {
            zzt.zzp();
            int[] zzU2 = com.google.android.gms.ads.internal.util.zzt.zzU(zza2);
            zzbgo.zzb();
            int zzq4 = zzcis.zzq(this.zzh, zzU2[0]);
            zzbgo.zzb();
            i11 = zzcis.zzq(this.zzh, zzU2[1]);
            i12 = zzq4;
        }
        int i13 = this.zzS;
        if (i13 == zzq2 && this.zzR == zzq3 && this.zzT == i12 && this.zzU == i11) {
            return false;
        }
        if (!(i13 == zzq2 && this.zzR == zzq3)) {
            z11 = true;
        }
        this.zzS = zzq2;
        this.zzR = zzq3;
        this.zzT = i12;
        this.zzU = i11;
        new zzcaq(this, "").zzi(zzq2, zzq3, i12, i11, this.zzh.density, this.zzW.getDefaultDisplay().getRotation());
        return z11;
    }

    public final void zzaa() {
        throw null;
    }

    public final void zzab(boolean z11) {
        this.zzn.zzh(z11);
    }

    public final void zzac() {
        this.zzQ.zzb();
    }

    public final synchronized void zzad(String str, String str2, String str3) {
        String str4;
        if (!zzaB()) {
            String[] strArr = new String[1];
            String str5 = (String) zzbgq.zzc().zzb(zzblj.zzK);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("version", (Object) str5);
                jSONObject.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, (Object) "Google Mobile Ads");
                jSONObject.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, (Object) "12.4.51-000");
                str4 = "<script>Object.defineProperty(window,'MRAID_ENV',{get:function(){return " + JSONObjectInstrumentation.toString(jSONObject) + "}});</script>";
            } catch (JSONException e11) {
                zzciz.zzk("Unable to build MRAID_ENV", e11);
                str4 = null;
            }
            strArr[0] = str4;
            super.loadDataWithBaseURL(str, zzcpv.zza(str2, strArr), NetworkLog.HTML, "UTF-8", (String) null);
            return;
        }
        zzciz.zzj("#004 The webview is destroyed. Ignoring action.");
    }

    public final void zzae() {
        if (this.zzJ == null) {
            this.zzK.zza();
            zzblv zzf2 = zzbly.zzf();
            this.zzJ = zzf2;
            this.zzK.zzb("native:view_load", zzf2);
        }
    }

    public final void zzaf(String str, zzbrt<? super zzcop> zzbrt) {
        zzcow zzcow = this.zzn;
        if (zzcow != null) {
            zzcow.zzx(str, zzbrt);
        }
    }

    public final void zzag() {
        throw null;
    }

    public final synchronized void zzah(zzl zzl2) {
        this.zzo = zzl2;
    }

    public final synchronized void zzai(zzcqe zzcqe) {
        this.zzq = zzcqe;
        requestLayout();
    }

    public final synchronized void zzaj(zzazn zzazn) {
        this.zzE = zzazn;
    }

    public final synchronized void zzak(boolean z11) {
        this.zzx = z11;
    }

    public final void zzal() {
        setBackgroundColor(0);
    }

    public final void zzam(Context context) {
        this.zzb.setBaseContext(context);
        this.zzQ.zze(this.zzb.zza());
    }

    public final synchronized void zzan(boolean z11) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzw(this.zzn.zzJ(), z11);
        } else {
            this.zzs = z11;
        }
    }

    public final synchronized void zzao(zzbnt zzbnt) {
        this.zzD = zzbnt;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0039, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzap(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzu     // Catch:{ all -> 0x003a }
            r2.zzu = r3     // Catch:{ all -> 0x003a }
            r2.zzaU()     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0038
            com.google.android.gms.internal.ads.zzblb<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzblj.zzL     // Catch:{ all -> 0x003a }
            com.google.android.gms.internal.ads.zzblh r1 = com.google.android.gms.internal.ads.zzbgq.zzc()     // Catch:{ all -> 0x003a }
            java.lang.Object r0 = r1.zzb(r0)     // Catch:{ all -> 0x003a }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x003a }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x003a }
            if (r0 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzcqe r0 = r2.zzq     // Catch:{ all -> 0x003a }
            boolean r0 = r0.zzi()     // Catch:{ all -> 0x003a }
            if (r0 != 0) goto L_0x0038
        L_0x0024:
            com.google.android.gms.internal.ads.zzcaq r0 = new com.google.android.gms.internal.ads.zzcaq     // Catch:{ all -> 0x003a }
            java.lang.String r1 = ""
            r0.<init>(r2, r1)     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r1 == r3) goto L_0x0031
            java.lang.String r3 = "default"
            goto L_0x0033
        L_0x0031:
            java.lang.String r3 = "expanded"
        L_0x0033:
            r0.zzk(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return
        L_0x0038:
            monitor-exit(r2)
            return
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpi.zzap(boolean):void");
    }

    public final synchronized void zzaq(zzbnv zzbnv) {
        this.zzC = zzbnv;
    }

    public final synchronized void zzar(IObjectWrapper iObjectWrapper) {
        this.zzp = iObjectWrapper;
    }

    public final synchronized void zzas(int i11) {
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzy(i11);
        }
    }

    public final synchronized void zzat(zzl zzl2) {
        this.zzO = zzl2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzau(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            int r0 = r2.zzF     // Catch:{ all -> 0x0017 }
            r1 = 1
            if (r1 == r3) goto L_0x0007
            r1 = -1
        L_0x0007:
            int r0 = r0 + r1
            r2.zzF = r0     // Catch:{ all -> 0x0017 }
            if (r0 > 0) goto L_0x0015
            com.google.android.gms.ads.internal.overlay.zzl r3 = r2.zzo     // Catch:{ all -> 0x0017 }
            if (r3 == 0) goto L_0x0015
            r3.zzC()     // Catch:{ all -> 0x0017 }
            monitor-exit(r2)
            return
        L_0x0015:
            monitor-exit(r2)
            return
        L_0x0017:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcpi.zzau(boolean):void");
    }

    public final synchronized void zzav(boolean z11) {
        if (z11) {
            setBackgroundColor(0);
        }
        zzl zzl2 = this.zzo;
        if (zzl2 != null) {
            zzl2.zzz(z11);
        }
    }

    public final void zzaw(String str, zzbrt<? super zzcop> zzbrt) {
        zzcow zzcow = this.zzn;
        if (zzcow != null) {
            zzcow.zzG(str, zzbrt);
        }
    }

    public final void zzax(String str, Predicate<zzbrt<? super zzcop>> predicate) {
        zzcow zzcow = this.zzn;
        if (zzcow != null) {
            zzcow.zzH(str, predicate);
        }
    }

    public final synchronized boolean zzay() {
        return this.zzs;
    }

    public final synchronized boolean zzaz() {
        return this.zzF > 0;
    }

    public final void zzb(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str.length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append("(");
        sb2.append(str2);
        sb2.append(");");
        zzaQ(sb2.toString());
    }

    public final synchronized void zzbv() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbv();
        }
    }

    public final synchronized void zzbw() {
        com.google.android.gms.ads.internal.zzl zzl2 = this.zzf;
        if (zzl2 != null) {
            zzl2.zzbw();
        }
    }

    public final zzckw zzbx() {
        return null;
    }

    public final void zzc(zzaxz zzaxz) {
        boolean z11;
        synchronized (this) {
            z11 = zzaxz.zzj;
            this.zzA = z11;
        }
        zzaX(z11);
    }

    public final void zzd(String str, Map<String, ?> map) {
        try {
            zze(str, zzt.zzp().zzf(map));
        } catch (JSONException unused) {
            zzciz.zzj("Could not convert parameters to JSON.");
        }
    }

    public final void zze(String str, JSONObject jSONObject) {
        String str2;
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObjectInstrumentation = JSONObjectInstrumentation.toString(jSONObject);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb2.append(str);
        sb2.append("',");
        sb2.append(jSONObjectInstrumentation);
        sb2.append(");");
        String sb3 = sb2.toString();
        if (sb3.length() != 0) {
            str2 = "Dispatching AFMA event: ".concat(sb3);
        } else {
            str2 = new String("Dispatching AFMA event: ");
        }
        zzciz.zze(str2);
        zzaQ(sb2.toString());
    }

    public final int zzf() {
        return this.zzN;
    }

    public final int zzg() {
        return this.zzM;
    }

    public final synchronized int zzh() {
        return this.zzL;
    }

    public final int zzi() {
        return getMeasuredHeight();
    }

    public final int zzj() {
        return getMeasuredWidth();
    }

    public final Activity zzk() {
        return this.zzb.zza();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        String str2;
        if (!(jSONObject instanceof JSONObject)) {
            str2 = jSONObject.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject);
        }
        zzb(str, str2);
    }

    public final zza zzm() {
        return this.zzg;
    }

    public final zzblv zzn() {
        return this.zzI;
    }

    public final zzblw zzo() {
        return this.zzK;
    }

    public final zzcjf zzp() {
        return this.zze;
    }

    public final void zzq() {
        zzcow zzcow = this.zzn;
        if (zzcow != null) {
            zzcow.zzq();
        }
    }

    public final synchronized zzcnf zzr(String str) {
        Map<String, zzcnf> map = this.zzV;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    public final synchronized zzcpl zzs() {
        return this.zzz;
    }

    public final synchronized String zzt() {
        zzfdq zzfdq = this.zzk;
        if (zzfdq == null) {
            return null;
        }
        return zzfdq.zzb;
    }

    public final synchronized String zzu() {
        return this.zzy;
    }

    public final synchronized void zzv(String str, zzcnf zzcnf) {
        if (this.zzV == null) {
            this.zzV = new HashMap();
        }
        this.zzV.put(str, zzcnf);
    }

    public final void zzw() {
        zzl zzN2 = zzN();
        if (zzN2 != null) {
            zzN2.zzd();
        }
    }

    public final void zzx(boolean z11, long j11) {
        String str;
        HashMap hashMap = new HashMap(2);
        if (true != z11) {
            str = "0";
        } else {
            str = "1";
        }
        hashMap.put("success", str);
        hashMap.put("duration", Long.toString(j11));
        zzd("onCacheAccessComplete", hashMap);
    }

    public final synchronized void zzy() {
        zzbnt zzbnt = this.zzD;
        if (zzbnt != null) {
            com.google.android.gms.ads.internal.util.zzt.zza.post(new zzdtw((zzdty) zzbnt));
        }
    }

    public final void zzz(int i11) {
        this.zzN = i11;
    }
}
