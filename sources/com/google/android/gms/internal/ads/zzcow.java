package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.TrafficStats;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.webkit.ProxyConfig;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzm;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.overlay.zzw;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.location.lite.common.util.filedownload.DownloadConstants;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.URLConnectionInstrumentation;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@Instrumented
@ParametersAreNonnullByDefault
@VisibleForTesting
public class zzcow extends WebViewClient implements zzcqc {
    public static final /* synthetic */ int zzb = 0;
    private boolean zzA;
    private final HashSet<String> zzB;
    private View.OnAttachStateChangeListener zzC;
    @Nullable
    protected zzcgf zza;
    private final zzcop zzc;
    @Nullable
    private final zzbay zzd;
    private final HashMap<String, List<zzbrt<? super zzcop>>> zze = new HashMap<>();
    private final Object zzf = new Object();
    private zzbes zzg;
    private zzo zzh;
    private zzcqa zzi;
    private zzcqb zzj;
    private zzbqt zzk;
    private zzbqv zzl;
    private zzdmd zzm;
    private boolean zzn;
    private boolean zzo;
    @GuardedBy("lock")
    private boolean zzp;
    @GuardedBy("lock")
    private boolean zzq;
    @GuardedBy("lock")
    private boolean zzr;
    private zzw zzs;
    @Nullable
    private zzcap zzt;
    private zzb zzu;
    private zzcak zzv;
    @Nullable
    private zzfjs zzw;
    private boolean zzx;
    private boolean zzy;
    private int zzz;

    public zzcow(zzcop zzcop, @Nullable zzbay zzbay, boolean z11) {
        zzcap zzcap = new zzcap(zzcop, zzcop.zzG(), new zzbkt(zzcop.getContext()));
        this.zzd = zzbay;
        this.zzc = zzcop;
        this.zzp = z11;
        this.zzt = zzcap;
        this.zzv = null;
        this.zzB = new HashSet<>(Arrays.asList(((String) zzbgq.zzc().zzb(zzblj.zzeb)).split(",")));
    }

    private static WebResourceResponse zzM() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzay)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zzN(String str, Map<String, String> map) throws IOException {
        HttpURLConnection httpURLConnection;
        String str2;
        String str3;
        URL url = new URL(str);
        try {
            TrafficStats.setThreadStatsTag(264);
            int i11 = 0;
            while (true) {
                i11++;
                if (i11 <= 20) {
                    URLConnection openConnection = URLConnectionInstrumentation.openConnection(url.openConnection());
                    openConnection.setConnectTimeout(10000);
                    openConnection.setReadTimeout(10000);
                    for (Map.Entry next : map.entrySet()) {
                        openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                    }
                    if (openConnection instanceof HttpURLConnection) {
                        httpURLConnection = (HttpURLConnection) openConnection;
                        zzt.zzp().zzk(this.zzc.getContext(), this.zzc.zzp().zza, false, httpURLConnection, false, 60000);
                        zzciy zzciy = new zzciy((String) null);
                        zzciy.zzc(httpURLConnection, (byte[]) null);
                        int responseCode = httpURLConnection.getResponseCode();
                        zzciy.zze(httpURLConnection, responseCode);
                        if (responseCode < 300 || responseCode >= 400) {
                            zzt.zzp();
                            WebResourceResponse zzT = com.google.android.gms.ads.internal.util.zzt.zzT(httpURLConnection);
                        } else {
                            String headerField = httpURLConnection.getHeaderField("Location");
                            if (headerField == null) {
                                throw new IOException("Missing Location header in redirect");
                            } else if (headerField.startsWith("tel:")) {
                                TrafficStats.clearThreadStatsTag();
                                return null;
                            } else {
                                URL url2 = new URL(url, headerField);
                                String protocol = url2.getProtocol();
                                if (protocol == null) {
                                    zzciz.zzj("Protocol is null");
                                    WebResourceResponse zzM = zzM();
                                    TrafficStats.clearThreadStatsTag();
                                    return zzM;
                                } else if (protocol.equals(ProxyConfig.MATCH_HTTP) || protocol.equals("https")) {
                                    if (headerField.length() != 0) {
                                        str2 = "Redirecting to ".concat(headerField);
                                    } else {
                                        str2 = new String("Redirecting to ");
                                    }
                                    zzciz.zze(str2);
                                    httpURLConnection.disconnect();
                                    url = url2;
                                } else {
                                    if (protocol.length() != 0) {
                                        str3 = "Unsupported scheme: ".concat(protocol);
                                    } else {
                                        str3 = new String("Unsupported scheme: ");
                                    }
                                    zzciz.zzj(str3);
                                    return zzM();
                                }
                            }
                        }
                    } else {
                        throw new IOException("Invalid protocol.");
                    }
                } else {
                    TrafficStats.clearThreadStatsTag();
                    throw new IOException("Too many redirects (20)");
                }
            }
            zzt.zzp();
            WebResourceResponse zzT2 = com.google.android.gms.ads.internal.util.zzt.zzT(httpURLConnection);
            TrafficStats.clearThreadStatsTag();
            return zzT2;
        } finally {
            TrafficStats.clearThreadStatsTag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzO(Map<String, String> map, List<zzbrt<? super zzcop>> list, String str) {
        String str2;
        if (zze.zzc()) {
            if (str.length() != 0) {
                str2 = "Received GMSG: ".concat(str);
            } else {
                str2 = new String("Received GMSG: ");
            }
            zze.zza(str2);
            for (String next : map.keySet()) {
                String str3 = map.get(next);
                StringBuilder sb2 = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str3).length());
                sb2.append("  ");
                sb2.append(next);
                sb2.append(": ");
                sb2.append(str3);
                zze.zza(sb2.toString());
            }
        }
        for (zzbrt<? super zzcop> zza2 : list) {
            zza2.zza(this.zzc, map);
        }
    }

    private final void zzP() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.zzC;
        if (onAttachStateChangeListener != null) {
            ((View) this.zzc).removeOnAttachStateChangeListener(onAttachStateChangeListener);
        }
    }

    /* access modifiers changed from: private */
    public final void zzQ(View view, zzcgf zzcgf, int i11) {
        if (zzcgf.zzi() && i11 > 0) {
            zzcgf.zzg(view);
            if (zzcgf.zzi()) {
                com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new zzcor(this, view, zzcgf, i11), 100);
            }
        }
    }

    private static final boolean zzR(boolean z11, zzcop zzcop) {
        if (!z11 || zzcop.zzQ().zzi() || zzcop.zzU().equals("interstitial_mb")) {
            return false;
        }
        return true;
    }

    public final void onAdClicked() {
        zzbes zzbes = this.zzg;
        if (zzbes != null) {
            zzbes.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String str2;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Loading resource: ".concat(valueOf);
        } else {
            str2 = new String("Loading resource: ");
        }
        zze.zza(str2);
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzi(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zza();
        r0.zzj = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzg();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzx = true;
        r1 = r0.zzj;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.zzf
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzcop r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.zzaB()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zze.zza(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzcop r2 = r0.zzc     // Catch:{ all -> 0x0029 }
            r2.zzW()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzx = r1
            com.google.android.gms.internal.ads.zzcqb r1 = r0.zzj
            if (r1 == 0) goto L_0x0025
            r1.zza()
            r1 = 0
            r0.zzj = r1
        L_0x0025:
            r0.zzg()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcow.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public final void onReceivedError(WebView webView, int i11, String str, String str2) {
        this.zzo = true;
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzc.zzaA(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    @Nullable
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzc(str, Collections.emptyMap());
    }

    public final boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        String str3;
        String str4;
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "AdWebView shouldOverrideUrlLoading: ".concat(valueOf);
        } else {
            str2 = new String("AdWebView shouldOverrideUrlLoading: ");
        }
        zze.zza(str2);
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzn && webView == this.zzc.zzI()) {
                String scheme = parse.getScheme();
                if (ProxyConfig.MATCH_HTTP.equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzbes zzbes = this.zzg;
                    if (zzbes != null) {
                        zzbes.onAdClicked();
                        zzcgf zzcgf = this.zza;
                        if (zzcgf != null) {
                            zzcgf.zzh(str);
                        }
                        this.zzg = null;
                    }
                    zzdmd zzdmd = this.zzm;
                    if (zzdmd != null) {
                        zzdmd.zzq();
                        this.zzm = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzc.zzI().willNotDraw()) {
                try {
                    zzalt zzK = this.zzc.zzK();
                    if (zzK != null && zzK.zzf(parse)) {
                        Context context = this.zzc.getContext();
                        zzcop zzcop = this.zzc;
                        parse = zzK.zza(parse, context, (View) zzcop, zzcop.zzk());
                    }
                } catch (zzalu unused) {
                    String valueOf2 = String.valueOf(str);
                    if (valueOf2.length() != 0) {
                        str4 = "Unable to append parameter to URL: ".concat(valueOf2);
                    } else {
                        str4 = new String("Unable to append parameter to URL: ");
                    }
                    zzciz.zzj(str4);
                }
                zzb zzb2 = this.zzu;
                if (zzb2 == null || zzb2.zzc()) {
                    zzr(new zzc("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null, (zzu) null), true);
                } else {
                    this.zzu.zzb(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                if (valueOf3.length() != 0) {
                    str3 = "AdWebView unable to handle URL: ".concat(valueOf3);
                } else {
                    str3 = new String("AdWebView unable to handle URL: ");
                }
                zzciz.zzj(str3);
            }
        } else {
            zzi(parse);
        }
        return true;
    }

    public final void zzA(int i11, int i12) {
        zzcak zzcak = this.zzv;
        if (zzcak != null) {
            zzcak.zzd(i11, i12);
        }
    }

    public final void zzB(boolean z11) {
        this.zzn = false;
    }

    public final void zzC(boolean z11) {
        synchronized (this.zzf) {
            this.zzr = z11;
        }
    }

    public final void zzD() {
        synchronized (this.zzf) {
            this.zzn = false;
            this.zzp = true;
            zzcjm.zze.execute(new zzcoq(this));
        }
    }

    public final void zzE(boolean z11) {
        synchronized (this.zzf) {
            this.zzq = true;
        }
    }

    public final void zzF(zzcqb zzcqb) {
        this.zzj = zzcqb;
    }

    public final void zzG(String str, zzbrt<? super zzcop> zzbrt) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list != null) {
                list.remove(zzbrt);
            }
        }
    }

    public final void zzH(String str, Predicate<zzbrt<? super zzcop>> predicate) {
        synchronized (this.zzf) {
            List<zzbrt> list = this.zze.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzbrt zzbrt : list) {
                    if (predicate.apply(zzbrt)) {
                        arrayList.add(zzbrt);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final boolean zzI() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzr;
        }
        return z11;
    }

    public final boolean zzJ() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzp;
        }
        return z11;
    }

    public final boolean zzK() {
        boolean z11;
        synchronized (this.zzf) {
            z11 = this.zzq;
        }
        return z11;
    }

    public final void zzL(@Nullable zzbes zzbes, @Nullable zzbqt zzbqt, @Nullable zzo zzo2, @Nullable zzbqv zzbqv, @Nullable zzw zzw2, boolean z11, @Nullable zzbrw zzbrw, @Nullable zzb zzb2, @Nullable zzcar zzcar, @Nullable zzcgf zzcgf, @Nullable zzehh zzehh, @Nullable zzfjs zzfjs, @Nullable zzdyz zzdyz, @Nullable zzfio zzfio, @Nullable zzbru zzbru, @Nullable zzdmd zzdmd) {
        zzbqt zzbqt2 = zzbqt;
        zzbqv zzbqv2 = zzbqv;
        zzbrw zzbrw2 = zzbrw;
        zzcar zzcar2 = zzcar;
        zzcgf zzcgf2 = zzcgf;
        zzehh zzehh2 = zzehh;
        zzfjs zzfjs2 = zzfjs;
        zzbru zzbru2 = zzbru;
        zzdmd zzdmd2 = zzdmd;
        zzb zzb3 = zzb2 == null ? new zzb(this.zzc.getContext(), zzcgf2, (zzcde) null) : zzb2;
        this.zzv = new zzcak(this.zzc, zzcar2);
        this.zza = zzcgf2;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaF)).booleanValue()) {
            zzx("/adMetadata", new zzbqs(zzbqt2));
        }
        if (zzbqv2 != null) {
            zzx("/appEvent", new zzbqu(zzbqv2));
        }
        zzx("/backButton", zzbrs.zzj);
        zzx("/refresh", zzbrs.zzk);
        zzx("/canOpenApp", zzbrs.zzb);
        zzx("/canOpenURLs", zzbrs.zza);
        zzx("/canOpenIntents", zzbrs.zzc);
        zzx("/close", zzbrs.zzd);
        zzx("/customClose", zzbrs.zze);
        zzx("/instrument", zzbrs.zzn);
        zzx("/delayPageLoaded", zzbrs.zzp);
        zzx("/delayPageClosed", zzbrs.zzq);
        zzx("/getLocationInfo", zzbrs.zzr);
        zzx("/log", zzbrs.zzg);
        zzx("/mraid", new zzbsa(zzb3, this.zzv, zzcar2));
        zzcap zzcap = this.zzt;
        if (zzcap != null) {
            zzx("/mraidLoaded", zzcap);
        }
        zzbse zzbse = r4;
        zzbse zzbse2 = new zzbse(zzb3, this.zzv, zzehh, zzdyz, zzfio);
        zzx("/open", zzbse);
        zzx("/precache", new zzcng());
        zzx("/touch", zzbrs.zzi);
        zzx("/video", zzbrs.zzl);
        zzx("/videoMeta", zzbrs.zzm);
        if (zzehh2 == null || zzfjs2 == null) {
            zzx("/click", zzbrs.zza(zzdmd));
            zzx("/httpTrack", zzbrs.zzf);
        } else {
            zzx("/click", new zzfel(zzdmd2, zzfjs2, zzehh2));
            zzx("/httpTrack", new zzfem(zzfjs2, zzehh2));
        }
        if (zzt.zzn().zzu(this.zzc.getContext())) {
            zzx("/logScionEvent", new zzbrz(this.zzc.getContext()));
        }
        if (zzbrw2 != null) {
            zzx("/setInterstitialProperties", new zzbrv(zzbrw2, (byte[]) null));
        }
        if (zzbru2 != null) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgA)).booleanValue()) {
                zzx("/inspectorNetworkExtras", zzbru2);
            }
        }
        this.zzg = zzbes;
        this.zzh = zzo2;
        this.zzk = zzbqt2;
        this.zzl = zzbqv2;
        this.zzs = zzw2;
        this.zzu = zzb3;
        this.zzm = zzdmd2;
        this.zzn = z11;
        this.zzw = zzfjs2;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zza() {
        synchronized (this.zzf) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzb() {
        synchronized (this.zzf) {
        }
        return null;
    }

    @Nullable
    public final WebResourceResponse zzc(String str, Map<String, String> map) {
        zzbah zzb2;
        try {
            if (zzbmy.zza.zze().booleanValue()) {
                if (this.zzw != null && "oda".equals(Uri.parse(str).getScheme())) {
                    this.zzw.zzb(str);
                    return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
                }
            }
            String zzc2 = zzchj.zzc(str, this.zzc.getContext(), this.zzA);
            if (!zzc2.equals(str)) {
                return zzN(zzc2, map);
            }
            zzbak zza2 = zzbak.zza(Uri.parse(str));
            if (zza2 != null && (zzb2 = zzt.zzc().zzb(zza2)) != null && zzb2.zze()) {
                return new WebResourceResponse("", "", zzb2.zzc());
            }
            if (!zzciy.zzl() || !zzbmu.zzb.zze().booleanValue()) {
                return null;
            }
            return zzN(str, map);
        } catch (Exception | NoClassDefFoundError e11) {
            zzt.zzo().zzs(e11, "AdWebViewClient.interceptRequest");
            return zzM();
        }
    }

    public final zzb zzd() {
        return this.zzu;
    }

    public final void zzg() {
        if (this.zzi != null && ((this.zzx && this.zzz <= 0) || this.zzy || this.zzo)) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzbr)).booleanValue() && this.zzc.zzo() != null) {
                zzblq.zza(this.zzc.zzo().zza(), this.zzc.zzn(), "awfllc");
            }
            zzcqa zzcqa = this.zzi;
            boolean z11 = false;
            if (!this.zzy && !this.zzo) {
                z11 = true;
            }
            zzcqa.zza(z11);
            this.zzi = null;
        }
        this.zzc.zzae();
    }

    public final void zzh(boolean z11) {
        this.zzA = z11;
    }

    public final void zzi(Uri uri) {
        String str;
        String str2;
        String path = uri.getPath();
        List list = this.zze.get(path);
        if (path == null || list == null) {
            zze.zza("No GMSG handler found for GMSG: ".concat(String.valueOf(uri)));
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfh)).booleanValue() && zzt.zzo().zzf() != null) {
                if (path == null || path.length() < 2) {
                    str = "null";
                } else {
                    str = path.substring(1);
                }
                zzcjm.zza.execute(new zzcos(str));
                return;
            }
            return;
        }
        String encodedQuery = uri.getEncodedQuery();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzea)).booleanValue() && this.zzB.contains(path) && encodedQuery != null) {
            if (encodedQuery.length() >= ((Integer) zzbgq.zzc().zzb(zzblj.zzec)).intValue()) {
                if (path.length() != 0) {
                    str2 = "Parsing gmsg query params on BG thread: ".concat(path);
                } else {
                    str2 = new String("Parsing gmsg query params on BG thread: ");
                }
                zze.zza(str2);
                zzfwq.zzr(zzt.zzp().zzb(uri), new zzcou(this, list, path, uri), zzcjm.zze);
                return;
            }
        }
        zzt.zzp();
        zzO(com.google.android.gms.ads.internal.util.zzt.zzS(uri), list, path);
    }

    public final void zzj() {
        zzbay zzbay = this.zzd;
        if (zzbay != null) {
            zzbay.zzc(DownloadConstants.REQUEST_NOT_SUPPORT_DOWNLOAD);
        }
        this.zzy = true;
        zzg();
        this.zzc.destroy();
    }

    public final void zzk() {
        synchronized (this.zzf) {
        }
        this.zzz++;
        zzg();
    }

    public final void zzl() {
        this.zzz--;
        zzg();
    }

    public final /* synthetic */ void zzm() {
        this.zzc.zzac();
        zzl zzN = this.zzc.zzN();
        if (zzN != null) {
            zzN.zzx();
        }
    }

    public final /* synthetic */ void zzn(View view, zzcgf zzcgf, int i11) {
        zzQ(view, zzcgf, i11 - 1);
    }

    public final void zzo(int i11, int i12, boolean z11) {
        zzcap zzcap = this.zzt;
        if (zzcap != null) {
            zzcap.zzb(i11, i12);
        }
        zzcak zzcak = this.zzv;
        if (zzcak != null) {
            zzcak.zzc(i11, i12, false);
        }
    }

    public final void zzp() {
        zzcgf zzcgf = this.zza;
        if (zzcgf != null) {
            WebView zzI = this.zzc.zzI();
            if (ViewCompat.isAttachedToWindow(zzI)) {
                zzQ(zzI, zzcgf, 10);
                return;
            }
            zzP();
            zzcot zzcot = new zzcot(this, zzcgf);
            this.zzC = zzcot;
            ((View) this.zzc).addOnAttachStateChangeListener(zzcot);
        }
    }

    public final void zzq() {
        zzdmd zzdmd = this.zzm;
        if (zzdmd != null) {
            zzdmd.zzq();
        }
    }

    public final void zzr(zzc zzc2, boolean z11) {
        zzbes zzbes;
        zzo zzo2;
        zzdmd zzdmd;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z12 = true;
        if (!zzR && z11) {
            z12 = false;
        }
        if (zzR) {
            zzbes = null;
        } else {
            zzbes = this.zzg;
        }
        if (zzaC) {
            zzo2 = null;
        } else {
            zzo2 = this.zzh;
        }
        zzw zzw2 = this.zzs;
        zzcjf zzp2 = this.zzc.zzp();
        zzcop zzcop = this.zzc;
        if (z12) {
            zzdmd = null;
        } else {
            zzdmd = this.zzm;
        }
        zzu(new AdOverlayInfoParcel(zzc2, zzbes, zzo2, zzw2, zzp2, zzcop, zzdmd));
    }

    public final void zzs(zzbv zzbv, zzehh zzehh, zzdyz zzdyz, zzfio zzfio, String str, String str2, int i11) {
        zzcop zzcop = this.zzc;
        zzu(new AdOverlayInfoParcel(zzcop, zzcop.zzp(), zzbv, zzehh, zzdyz, zzfio, str, str2, i11));
    }

    public final void zzt(boolean z11, int i11, boolean z12) {
        zzbes zzbes;
        zzdmd zzdmd;
        boolean zzR = zzR(this.zzc.zzaC(), this.zzc);
        boolean z13 = true;
        if (!zzR && z12) {
            z13 = false;
        }
        if (zzR) {
            zzbes = null;
        } else {
            zzbes = this.zzg;
        }
        zzo zzo2 = this.zzh;
        zzw zzw2 = this.zzs;
        zzcop zzcop = this.zzc;
        zzcjf zzp2 = zzcop.zzp();
        if (z13) {
            zzdmd = null;
        } else {
            zzdmd = this.zzm;
        }
        zzu(new AdOverlayInfoParcel(zzbes, zzo2, zzw2, zzcop, z11, i11, zzp2, zzdmd));
    }

    public final void zzu(AdOverlayInfoParcel adOverlayInfoParcel) {
        boolean z11;
        zzc zzc2;
        zzcak zzcak = this.zzv;
        if (zzcak != null) {
            z11 = zzcak.zze();
        } else {
            z11 = false;
        }
        zzt.zzj();
        zzm.zza(this.zzc.getContext(), adOverlayInfoParcel, !z11);
        zzcgf zzcgf = this.zza;
        if (zzcgf != null) {
            String str = adOverlayInfoParcel.zzl;
            if (str == null && (zzc2 = adOverlayInfoParcel.zza) != null) {
                str = zzc2.zzb;
            }
            zzcgf.zzh(str);
        }
    }

    public final void zzv(boolean z11, int i11, String str, boolean z12) {
        zzbes zzbes;
        zzcov zzcov;
        zzdmd zzdmd;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z13 = true;
        if (!zzR && z12) {
            z13 = false;
        }
        if (zzR) {
            zzbes = null;
        } else {
            zzbes = this.zzg;
        }
        if (zzaC) {
            zzcov = null;
        } else {
            zzcov = new zzcov(this.zzc, this.zzh);
        }
        zzbqt zzbqt = this.zzk;
        zzbqv zzbqv = this.zzl;
        zzw zzw2 = this.zzs;
        zzcop zzcop = this.zzc;
        zzcjf zzp2 = zzcop.zzp();
        if (z13) {
            zzdmd = null;
        } else {
            zzdmd = this.zzm;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zzbes, zzcov, zzbqt, zzbqv, zzw2, zzcop, z11, i11, str, zzp2, zzdmd);
        zzu(adOverlayInfoParcel);
    }

    public final void zzw(boolean z11, int i11, String str, String str2, boolean z12) {
        zzbes zzbes;
        zzcov zzcov;
        zzdmd zzdmd;
        boolean zzaC = this.zzc.zzaC();
        boolean zzR = zzR(zzaC, this.zzc);
        boolean z13 = true;
        if (!zzR && z12) {
            z13 = false;
        }
        if (zzR) {
            zzbes = null;
        } else {
            zzbes = this.zzg;
        }
        if (zzaC) {
            zzcov = null;
        } else {
            zzcov = new zzcov(this.zzc, this.zzh);
        }
        zzbqt zzbqt = this.zzk;
        zzbqv zzbqv = this.zzl;
        zzw zzw2 = this.zzs;
        zzcop zzcop = this.zzc;
        zzcjf zzp2 = zzcop.zzp();
        if (z13) {
            zzdmd = null;
        } else {
            zzdmd = this.zzm;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = r4;
        AdOverlayInfoParcel adOverlayInfoParcel2 = new AdOverlayInfoParcel(zzbes, (zzo) zzcov, zzbqt, zzbqv, zzw2, zzcop, z11, i11, str, str2, zzp2, zzdmd);
        zzu(adOverlayInfoParcel);
    }

    public final void zzx(String str, zzbrt<? super zzcop> zzbrt) {
        synchronized (this.zzf) {
            List list = this.zze.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zze.put(str, list);
            }
            list.add(zzbrt);
        }
    }

    public final void zzy() {
        zzcgf zzcgf = this.zza;
        if (zzcgf != null) {
            zzcgf.zze();
            this.zza = null;
        }
        zzP();
        synchronized (this.zzf) {
            this.zze.clear();
            this.zzg = null;
            this.zzh = null;
            this.zzi = null;
            this.zzj = null;
            this.zzk = null;
            this.zzl = null;
            this.zzn = false;
            this.zzp = false;
            this.zzq = false;
            this.zzs = null;
            this.zzu = null;
            this.zzt = null;
            zzcak zzcak = this.zzv;
            if (zzcak != null) {
                zzcak.zza(true);
                this.zzv = null;
            }
            this.zzw = null;
        }
    }

    public final void zzz(zzcqa zzcqa) {
        this.zzi = zzcqa;
    }
}
