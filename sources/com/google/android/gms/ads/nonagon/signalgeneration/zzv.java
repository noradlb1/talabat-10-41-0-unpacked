package com.google.android.gms.ads.nonagon.signalgeneration;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.internal.util.zzcb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzalu;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfe;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzcch;
import com.google.android.gms.internal.ads.zzcco;
import com.google.android.gms.internal.ads.zzchq;
import com.google.android.gms.internal.ads.zzchs;
import com.google.android.gms.internal.ads.zzchx;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcqm;
import com.google.android.gms.internal.ads.zzdeb;
import com.google.android.gms.internal.ads.zzdkc;
import com.google.android.gms.internal.ads.zzduy;
import com.google.android.gms.internal.ads.zzdyy;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzfed;
import com.google.android.gms.internal.ads.zzfew;
import com.google.android.gms.internal.ads.zzfin;
import com.google.android.gms.internal.ads.zzfio;
import com.google.android.gms.internal.ads.zzfjs;
import com.google.android.gms.internal.ads.zzfwh;
import com.google.android.gms.internal.ads.zzfwq;
import com.google.android.gms.internal.ads.zzfxa;
import com.google.android.gms.internal.ads.zzfxb;
import com.huawei.hms.framework.common.ContainerUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public final class zzv extends zzchs {
    protected static final List<String> zza = new ArrayList(Arrays.asList(new String[]{"/aclk", "/pcs/click"}));
    protected static final List<String> zzb = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com"}));
    protected static final List<String> zzc = new ArrayList(Arrays.asList(new String[]{"/pagead/adview", "/pcs/view", "/pagead/conversion"}));
    protected static final List<String> zzd = new ArrayList(Arrays.asList(new String[]{".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"}));
    public static final /* synthetic */ int zze = 0;
    /* access modifiers changed from: private */
    public final zzcjf zzA;
    /* access modifiers changed from: private */
    public String zzB;
    /* access modifiers changed from: private */
    public final String zzC;
    private final zzcqm zzf;
    /* access modifiers changed from: private */
    public Context zzg;
    private final zzalt zzh;
    private final zzfew<zzduy> zzi;
    private final zzfxb zzj;
    private final ScheduledExecutorService zzk;
    @Nullable
    private zzcco zzl;
    private Point zzm = new Point();
    private Point zzn = new Point();
    private final Set<WebView> zzo = Collections.newSetFromMap(new WeakHashMap());
    /* access modifiers changed from: private */
    public final zzb zzp;
    private final zzdyz zzq;
    private final zzfio zzr;
    /* access modifiers changed from: private */
    public final zzfjs zzs;
    /* access modifiers changed from: private */
    public final boolean zzt;
    /* access modifiers changed from: private */
    public final boolean zzu;
    /* access modifiers changed from: private */
    public final boolean zzv;
    /* access modifiers changed from: private */
    public final boolean zzw;
    /* access modifiers changed from: private */
    public final String zzx;
    /* access modifiers changed from: private */
    public final String zzy;
    /* access modifiers changed from: private */
    public final AtomicInteger zzz = new AtomicInteger(0);

    public zzv(zzcqm zzcqm, Context context, zzalt zzalt, zzfew<zzduy> zzfew, zzfxb zzfxb, ScheduledExecutorService scheduledExecutorService, zzdyz zzdyz, zzfio zzfio, zzfjs zzfjs, zzcjf zzcjf) {
        this.zzf = zzcqm;
        this.zzg = context;
        this.zzh = zzalt;
        this.zzi = zzfew;
        this.zzj = zzfxb;
        this.zzk = scheduledExecutorService;
        this.zzp = zzcqm.zzp();
        this.zzq = zzdyz;
        this.zzr = zzfio;
        this.zzs = zzfjs;
        this.zzA = zzcjf;
        this.zzt = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfy)).booleanValue();
        this.zzu = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfx)).booleanValue();
        this.zzv = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfz)).booleanValue();
        this.zzw = ((Boolean) zzbgq.zzc().zzb(zzblj.zzfB)).booleanValue();
        this.zzx = (String) zzbgq.zzc().zzb(zzblj.zzfA);
        this.zzy = (String) zzbgq.zzc().zzb(zzblj.zzfC);
        this.zzC = (String) zzbgq.zzc().zzb(zzblj.zzfD);
    }

    @VisibleForTesting
    public static boolean zzE(@NonNull Uri uri) {
        return zzJ(uri, zzc, zzd);
    }

    public static final /* synthetic */ Uri zzF(Uri uri, String str) {
        if (!TextUtils.isEmpty(str)) {
            return zzL(uri, "nas", str);
        }
        return uri;
    }

    public static final /* synthetic */ ArrayList zzG(List list, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Uri uri = (Uri) it.next();
            if (!zzE(uri) || TextUtils.isEmpty(str)) {
                arrayList.add(uri);
            } else {
                arrayList.add(zzL(uri, "nas", str));
            }
        }
        return arrayList;
    }

    private final zzg zzH(Context context, String str, String str2, zzbfi zzbfi, zzbfd zzbfd) {
        zzf zzq2 = this.zzf.zzq();
        zzdeb zzdeb = new zzdeb();
        zzdeb.zzc(context);
        zzfed zzfed = new zzfed();
        if (str == null) {
            str = "adUnitId";
        }
        zzfed.zzs(str);
        if (zzbfd == null) {
            zzbfd = new zzbfe().zza();
        }
        zzfed.zzD(zzbfd);
        if (zzbfi == null) {
            zzbfi = new zzbfi();
        }
        zzfed.zzr(zzbfi);
        zzdeb.zzf(zzfed.zzF());
        zzq2.zza(zzdeb.zzg());
        zzx zzx2 = new zzx();
        zzx2.zza(str2);
        zzq2.zzb(new zzz(zzx2, (zzy) null));
        new zzdkc();
        return zzq2.zzc();
    }

    private final zzfxa<String> zzI(String str) {
        zzduy[] zzduyArr = new zzduy[1];
        zzfxa<O> zzn2 = zzfwq.zzn(this.zzi.zza(), new zzn(this, zzduyArr, str), this.zzj);
        zzn2.zzc(new zzo(this, zzduyArr), this.zzj);
        return zzfwq.zzf(zzfwq.zzm((zzfwh) zzfwq.zzo(zzfwh.zzw(zzn2), (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzfF)).intValue(), TimeUnit.MILLISECONDS, this.zzk), zzk.zza, this.zzj), Exception.class, zzj.zza, this.zzj);
    }

    private static boolean zzJ(@NonNull Uri uri, List<String> list, List<String> list2) {
        String host = uri.getHost();
        String path = uri.getPath();
        if (!(host == null || path == null)) {
            for (String contains : list) {
                if (path.contains(contains)) {
                    for (String endsWith : list2) {
                        if (host.endsWith(endsWith)) {
                            return true;
                        }
                    }
                    continue;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.zzb;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzK() {
        /*
            r1 = this;
            com.google.android.gms.internal.ads.zzcco r0 = r1.zzl
            if (r0 == 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r0 = r0.zzb
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0010
            r0 = 1
            return r0
        L_0x0010:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzv.zzK():boolean");
    }

    /* access modifiers changed from: private */
    public static final Uri zzL(Uri uri, String str, String str2) {
        String uri2 = uri.toString();
        int indexOf = uri2.indexOf("&adurl=");
        if (indexOf == -1) {
            indexOf = uri2.indexOf("?adurl=");
        }
        if (indexOf == -1) {
            return uri.buildUpon().appendQueryParameter(str, str2).build();
        }
        int i11 = indexOf + 1;
        return Uri.parse(uri2.substring(0, i11) + str + "=" + str2 + ContainerUtils.FIELD_DELIMITER + uri2.substring(i11));
    }

    public static /* bridge */ /* synthetic */ void zzy(zzv zzv2, String str, String str2, String str3) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgq)).booleanValue()) {
                zzfio zzfio = zzv2.zzr;
                zzfin zzb2 = zzfin.zzb(str);
                zzb2.zza(str2, str3);
                zzfio.zzb(zzb2);
                return;
            }
            zzdyy zza2 = zzv2.zzq.zza();
            zza2.zzb(NativeProtocol.WEB_DIALOG_ACTION, str);
            zza2.zzb(str2, str3);
            zza2.zzf();
        }
    }

    public final void zze(IObjectWrapper iObjectWrapper, zzchx zzchx, zzchq zzchq) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        this.zzg = context;
        zzfwq.zzr(zzH(context, zzchx.zza, zzchx.zzb, zzchx.zzc, zzchx.zzd).zza(), new zzr(this, zzchq), this.zzf.zzC());
    }

    public final void zzf(zzcco zzcco) {
        this.zzl = zzcco;
        this.zzi.zzc(1);
    }

    @SuppressLint({"AddJavascriptInterface"})
    public final void zzg(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgS)).booleanValue()) {
            if (((Boolean) zzbgq.zzc().zzb(zzblj.zzgT)).booleanValue()) {
                zzfwq.zzr(zzH(this.zzg, (String) null, AdFormat.BANNER.name(), (zzbfi) null, (zzbfd) null).zza(), new zzu(this), this.zzf.zzC());
            }
            WebView webView = (WebView) ObjectWrapper.unwrap(iObjectWrapper);
            if (webView == null) {
                zzciz.zzg("The webView cannot be null.");
            } else if (this.zzo.contains(webView)) {
                zzciz.zzi("This webview has already been registered.");
            } else {
                this.zzo.add(webView);
                webView.addJavascriptInterface(new TaggingLibraryJsInterface(webView, this.zzh), "gmaSdk");
            }
        }
    }

    public final void zzh(IObjectWrapper iObjectWrapper) {
        View view;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfE)).booleanValue()) {
            MotionEvent motionEvent = (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper);
            zzcco zzcco = this.zzl;
            if (zzcco == null) {
                view = null;
            } else {
                view = zzcco.zza;
            }
            this.zzm = zzcb.zza(motionEvent, view);
            if (motionEvent.getAction() == 0) {
                this.zzn = this.zzm;
            }
            MotionEvent obtain = MotionEvent.obtain(motionEvent);
            Point point = this.zzm;
            obtain.setLocation((float) point.x, (float) point.y);
            this.zzh.zzd(obtain);
            obtain.recycle();
        }
    }

    public final void zzi(List<Uri> list, IObjectWrapper iObjectWrapper, zzcch zzcch) {
        try {
            if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfE)).booleanValue()) {
                zzcch.zze("The updating URL feature is not enabled.");
            } else if (list.size() != 1) {
                zzcch.zze("There should be only 1 click URL.");
            } else {
                Uri uri = list.get(0);
                if (!zzJ(uri, zza, zzb)) {
                    String valueOf = String.valueOf(uri);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 18);
                    sb2.append("Not a Google URL: ");
                    sb2.append(valueOf);
                    zzciz.zzj(sb2.toString());
                    zzcch.zzf(list);
                    return;
                }
                zzfxa zzb2 = this.zzj.zzb(new zzp(this, uri, iObjectWrapper));
                if (zzK()) {
                    zzb2 = zzfwq.zzn(zzb2, new zzl(this), this.zzj);
                } else {
                    zzciz.zzi("Asset view map is empty.");
                }
                zzfwq.zzr(zzb2, new zzt(this, zzcch), this.zzf.zzC());
            }
        } catch (RemoteException e11) {
            zzciz.zzh("", e11);
        }
    }

    public final void zzj(List<Uri> list, IObjectWrapper iObjectWrapper, zzcch zzcch) {
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfE)).booleanValue()) {
            try {
                zzcch.zze("The updating URL feature is not enabled.");
            } catch (RemoteException e11) {
                zzciz.zzh("", e11);
            }
        } else {
            zzfxa zzb2 = this.zzj.zzb(new zzq(this, list, iObjectWrapper));
            if (zzK()) {
                zzb2 = zzfwq.zzn(zzb2, new zzm(this), this.zzj);
            } else {
                zzciz.zzi("Asset view map is empty.");
            }
            zzfwq.zzr(zzb2, new zzs(this, zzcch), this.zzf.zzC());
        }
    }

    public final /* synthetic */ Uri zzk(Uri uri, IObjectWrapper iObjectWrapper) throws Exception {
        try {
            uri = this.zzh.zza(uri, this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } catch (zzalu e11) {
            zzciz.zzk("", e11);
        }
        if (uri.getQueryParameter("ms") != null) {
            return uri;
        }
        throw new Exception("Failed to append spam signals to click url.");
    }

    public final /* synthetic */ zzfxa zzo(zzduy[] zzduyArr, String str, zzduy zzduy) throws Exception {
        zzduyArr[0] = zzduy;
        Context context = this.zzg;
        zzcco zzcco = this.zzl;
        Map<String, WeakReference<View>> map = zzcco.zzb;
        JSONObject zzd2 = zzcb.zzd(context, map, map, zzcco.zza);
        JSONObject zzg2 = zzcb.zzg(this.zzg, this.zzl.zza);
        JSONObject zzf2 = zzcb.zzf(this.zzl.zza);
        JSONObject zze2 = zzcb.zze(this.zzg, this.zzl.zza);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("asset_view_signal", (Object) zzd2);
        jSONObject.put("ad_view_signal", (Object) zzg2);
        jSONObject.put("scroll_view_signal", (Object) zzf2);
        jSONObject.put("lock_screen_signal", (Object) zze2);
        if (str == "google.afma.nativeAds.getPublisherCustomRenderedClickSignals") {
            jSONObject.put("click_signal", (Object) zzcb.zzc((String) null, this.zzg, this.zzn, this.zzm));
        }
        return zzduy.zzd(str, jSONObject);
    }

    public final /* synthetic */ zzfxa zzp(Uri uri) throws Exception {
        return zzfwq.zzm(zzI("google.afma.nativeAds.getPublisherCustomRenderedClickSignals"), new zzh(this, uri), this.zzj);
    }

    public final /* synthetic */ zzfxa zzq(ArrayList arrayList) throws Exception {
        return zzfwq.zzm(zzI("google.afma.nativeAds.getPublisherCustomRenderedImpressionSignals"), new zzi(this, arrayList), this.zzj);
    }

    public final /* synthetic */ ArrayList zzv(List list, IObjectWrapper iObjectWrapper) throws Exception {
        String str;
        if (this.zzh.zzc() != null) {
            str = this.zzh.zzc().zzh(this.zzg, (View) ObjectWrapper.unwrap(iObjectWrapper), (Activity) null);
        } else {
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Uri uri = (Uri) it.next();
                if (!zzE(uri)) {
                    zzciz.zzj("Not a Google URL: ".concat(String.valueOf(uri)));
                    arrayList.add(uri);
                } else {
                    arrayList.add(zzL(uri, "ms", str));
                }
            }
            if (!arrayList.isEmpty()) {
                return arrayList;
            }
            throw new Exception("Empty impression URLs result.");
        }
        throw new Exception("Failed to get view signals.");
    }

    public final /* synthetic */ void zzz(zzduy[] zzduyArr) {
        zzduy zzduy = zzduyArr[0];
        if (zzduy != null) {
            this.zzi.zzb(zzfwq.zzi(zzduy));
        }
    }
}
