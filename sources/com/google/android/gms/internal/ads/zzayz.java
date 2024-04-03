package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

@TargetApi(14)
@ParametersAreNonnullByDefault
public final class zzayz extends Thread {
    private boolean zza = false;
    private boolean zzb = false;
    private final Object zzc;
    private final zzayq zzd;
    private final int zze;
    private final int zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final String zzm;
    private final boolean zzn;
    private final boolean zzo;
    private final boolean zzp;

    public zzayz() {
        zzayq zzayq = new zzayq();
        this.zzd = zzayq;
        this.zzc = new Object();
        this.zzf = zzbmq.zzd.zze().intValue();
        this.zzg = zzbmq.zza.zze().intValue();
        this.zzh = zzbmq.zze.zze().intValue();
        this.zzi = zzbmq.zzc.zze().intValue();
        this.zzj = ((Integer) zzbgq.zzc().zzb(zzblj.zzN)).intValue();
        this.zzk = ((Integer) zzbgq.zzc().zzb(zzblj.zzO)).intValue();
        this.zzl = ((Integer) zzbgq.zzc().zzb(zzblj.zzP)).intValue();
        this.zze = zzbmq.zzf.zze().intValue();
        this.zzm = (String) zzbgq.zzc().zzb(zzblj.zzR);
        this.zzn = ((Boolean) zzbgq.zzc().zzb(zzblj.zzS)).booleanValue();
        this.zzo = ((Boolean) zzbgq.zzc().zzb(zzblj.zzT)).booleanValue();
        this.zzp = ((Boolean) zzbgq.zzc().zzb(zzblj.zzU)).booleanValue();
        setName("ContentFetchTask");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processHandlersOutBlocks(RegionMaker.java:1008)
        	at jadx.core.dex.visitors.regions.RegionMaker.processTryCatchBlocks(RegionMaker.java:978)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:52)
        */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dc */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00dc A[LOOP:2: B:48:0x00dc->B:62:0x00dc, LOOP_START, SYNTHETIC] */
    public final void run() {
        /*
            r6 = this;
        L_0x0000:
            com.google.android.gms.internal.ads.zzayu r0 = com.google.android.gms.ads.internal.zzt.zzb()     // Catch:{ all -> 0x00a8 }
            android.content.Context r0 = r0.zzb()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x000c
            goto L_0x00b2
        L_0x000c:
            java.lang.String r1 = "activity"
            java.lang.Object r1 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager r1 = (android.app.ActivityManager) r1     // Catch:{ all -> 0x00a8 }
            java.lang.String r2 = "keyguard"
            java.lang.Object r2 = r0.getSystemService(r2)     // Catch:{ all -> 0x00a8 }
            android.app.KeyguardManager r2 = (android.app.KeyguardManager) r2     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            if (r2 == 0) goto L_0x00b2
            java.util.List r1 = r1.getRunningAppProcesses()     // Catch:{ all -> 0x00a8 }
            if (r1 == 0) goto L_0x00b2
            java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x00a8 }
        L_0x002a:
            boolean r3 = r1.hasNext()     // Catch:{ all -> 0x00a8 }
            if (r3 == 0) goto L_0x00b2
            java.lang.Object r3 = r1.next()     // Catch:{ all -> 0x00a8 }
            android.app.ActivityManager$RunningAppProcessInfo r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3     // Catch:{ all -> 0x00a8 }
            int r4 = android.os.Process.myPid()     // Catch:{ all -> 0x00a8 }
            int r5 = r3.pid     // Catch:{ all -> 0x00a8 }
            if (r4 != r5) goto L_0x002a
            int r1 = r3.importance     // Catch:{ all -> 0x00a8 }
            r3 = 100
            if (r1 != r3) goto L_0x00b2
            boolean r1 = r2.inKeyguardRestrictedInputMode()     // Catch:{ all -> 0x00a8 }
            if (r1 != 0) goto L_0x00b2
            java.lang.String r1 = "power"
            java.lang.Object r0 = r0.getSystemService(r1)     // Catch:{ all -> 0x00a8 }
            android.os.PowerManager r0 = (android.os.PowerManager) r0     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            boolean r0 = r0.isScreenOn()     // Catch:{ all -> 0x00a8 }
            if (r0 == 0) goto L_0x00b2
            com.google.android.gms.internal.ads.zzayu r0 = com.google.android.gms.ads.internal.zzt.zzb()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            android.app.Activity r0 = r0.zza()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            if (r0 != 0) goto L_0x006d
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.internal.ads.zzciz.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x006d:
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x008e }
            if (r2 == 0) goto L_0x009d
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x008e }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x008e }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r1 = r0.findViewById(r2)     // Catch:{ Exception -> 0x008e }
            goto L_0x009d
        L_0x008e:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcik r2 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zzs(r0, r3)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.internal.ads.zzciz.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x009d:
            if (r1 == 0) goto L_0x00ba
            com.google.android.gms.internal.ads.zzayv r0 = new com.google.android.gms.internal.ads.zzayv     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r0.<init>(r6, r1)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00ba
        L_0x00a8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzcik r1 = com.google.android.gms.ads.internal.zzt.zzo()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.String r2 = "ContentFetchTask.isInForeground"
            r1.zzs(r0, r2)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00b2:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.internal.ads.zzciz.zze(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            r6.zzf()     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
        L_0x00ba:
            int r0 = r6.zze     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x00d3, Exception -> 0x00c3 }
            goto L_0x00d9
        L_0x00c3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzciz.zzh(r1, r0)
            com.google.android.gms.internal.ads.zzcik r1 = com.google.android.gms.ads.internal.zzt.zzo()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zzs(r0, r2)
            goto L_0x00d9
        L_0x00d3:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.internal.ads.zzciz.zzh(r1, r0)
        L_0x00d9:
            java.lang.Object r0 = r6.zzc
            monitor-enter(r0)
        L_0x00dc:
            boolean r1 = r6.zzb     // Catch:{ all -> 0x00ee }
            if (r1 == 0) goto L_0x00eb
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.internal.ads.zzciz.zze(r1)     // Catch:{ InterruptedException -> 0x00dc }
            java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x00dc }
            r1.wait()     // Catch:{ InterruptedException -> 0x00dc }
            goto L_0x00dc
        L_0x00eb:
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            goto L_0x0000
        L_0x00ee:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00ee }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzayz.run():void");
    }

    public final zzayp zza() {
        return this.zzd.zza(this.zzp);
    }

    @VisibleForTesting
    public final zzayy zzb(@Nullable View view, zzayp zzayp) {
        if (view == null) {
            return new zzayy(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzayy(this, 0, 0);
            }
            zzayp.zzk(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzayy(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzcop)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                return new zzayy(this, 0, 0);
            }
            zzayp.zzh();
            webView.post(new zzayx(this, zzayp, webView, globalVisibleRect));
            return new zzayy(this, 0, 1);
        } else if (!(view instanceof ViewGroup)) {
            return new zzayy(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i11 = 0;
            int i12 = 0;
            for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                zzayy zzb2 = zzb(viewGroup.getChildAt(i13), zzayp);
                i11 += zzb2.zza;
                i12 += zzb2.zzb;
            }
            return new zzayy(this, i11, i12);
        }
    }

    @VisibleForTesting
    public final void zzc(View view) {
        try {
            zzayp zzayp = new zzayp(this.zzf, this.zzg, this.zzh, this.zzi, this.zzj, this.zzk, this.zzl, this.zzo);
            Context zzb2 = zzt.zzb().zzb();
            if (zzb2 != null && !TextUtils.isEmpty(this.zzm)) {
                String str = (String) view.getTag(zzb2.getResources().getIdentifier((String) zzbgq.zzc().zzb(zzblj.zzQ), "id", zzb2.getPackageName()));
                if (str != null) {
                    if (str.equals(this.zzm)) {
                        return;
                    }
                }
            }
            zzayy zzb3 = zzb(view, zzayp);
            zzayp.zzm();
            if (zzb3.zza == 0) {
                if (zzb3.zzb == 0) {
                    return;
                }
            }
            if (zzb3.zzb == 0) {
                if (zzayp.zzc() == 0) {
                    return;
                }
            }
            if (zzb3.zzb == 0) {
                if (this.zzd.zzd(zzayp)) {
                    return;
                }
            }
            this.zzd.zzb(zzayp);
        } catch (Exception e11) {
            zzciz.zzh("Exception in fetchContentOnUIThread", e11);
            zzt.zzo().zzs(e11, "ContentFetchTask.fetchContent");
        }
    }

    @VisibleForTesting
    public final void zzd(zzayp zzayp, WebView webView, String str, boolean z11) {
        zzayp.zzg();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString("text");
                if (this.zzn || TextUtils.isEmpty(webView.getTitle())) {
                    zzayp.zzl(optString, z11, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb2 = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb2.append(title);
                    sb2.append(StringUtils.LF);
                    sb2.append(optString);
                    zzayp.zzl(sb2.toString(), z11, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzayp.zzo()) {
                this.zzd.zzc(zzayp);
            }
        } catch (JSONException unused) {
            zzciz.zze("Json string may be malformed.");
        } catch (Throwable th2) {
            zzciz.zzf("Failed to get webview content.", th2);
            zzt.zzo().zzs(th2, "ContentFetchTask.processWebViewContent");
        }
    }

    public final void zze() {
        synchronized (this.zzc) {
            if (this.zza) {
                zzciz.zze("Content hash thread already started, quiting...");
                return;
            }
            this.zza = true;
            start();
        }
    }

    public final void zzf() {
        synchronized (this.zzc) {
            this.zzb = true;
            StringBuilder sb2 = new StringBuilder(42);
            sb2.append("ContentFetchThread: paused, mPause = ");
            sb2.append(true);
            zzciz.zze(sb2.toString());
        }
    }

    public final void zzg() {
        synchronized (this.zzc) {
            this.zzb = false;
            this.zzc.notifyAll();
            zzciz.zze("ContentFetchThread: wakeup");
        }
    }

    public final boolean zzh() {
        return this.zzb;
    }
}
