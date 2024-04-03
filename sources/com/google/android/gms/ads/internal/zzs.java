package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzalt;
import com.google.android.gms.internal.ads.zzalu;
import com.google.android.gms.internal.ads.zzazw;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbfi;
import com.google.android.gms.internal.ads.zzbfo;
import com.google.android.gms.internal.ads.zzbgo;
import com.google.android.gms.internal.ads.zzbgu;
import com.google.android.gms.internal.ads.zzbgx;
import com.google.android.gms.internal.ads.zzbha;
import com.google.android.gms.internal.ads.zzbhj;
import com.google.android.gms.internal.ads.zzbho;
import com.google.android.gms.internal.ads.zzbhr;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzbhy;
import com.google.android.gms.internal.ads.zzbit;
import com.google.android.gms.internal.ads.zzbiw;
import com.google.android.gms.internal.ads.zzbiz;
import com.google.android.gms.internal.ads.zzbjd;
import com.google.android.gms.internal.ads.zzbkq;
import com.google.android.gms.internal.ads.zzbme;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzccb;
import com.google.android.gms.internal.ads.zzcce;
import com.google.android.gms.internal.ads.zzcem;
import com.google.android.gms.internal.ads.zzcis;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcjm;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@Instrumented
@ParametersAreNonnullByDefault
public final class zzs extends zzbhj {
    /* access modifiers changed from: private */
    public final zzcjf zza;
    private final zzbfi zzb;
    /* access modifiers changed from: private */
    public final Future<zzalt> zzc = zzcjm.zza.zzb(new zzo(this));
    /* access modifiers changed from: private */
    public final Context zzd;
    private final zzr zze;
    /* access modifiers changed from: private */
    @Nullable
    public WebView zzf;
    /* access modifiers changed from: private */
    @Nullable
    public zzbgx zzg;
    /* access modifiers changed from: private */
    @Nullable
    public zzalt zzh;
    private AsyncTask<Void, Void, String> zzi;

    public zzs(Context context, zzbfi zzbfi, String str, zzcjf zzcjf) {
        this.zzd = context;
        this.zza = zzcjf;
        this.zzb = zzbfi;
        this.zzf = new WebView(context);
        this.zze = new zzr(context, str);
        zzV(0);
        this.zzf.setVerticalScrollBarEnabled(false);
        this.zzf.getSettings().setJavaScriptEnabled(true);
        this.zzf.setWebViewClient(new zzm(this));
        this.zzf.setOnTouchListener(new zzn(this));
    }

    public static /* bridge */ /* synthetic */ String zzo(zzs zzs, String str) {
        if (zzs.zzh == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = zzs.zzh.zza(parse, zzs.zzd, (View) null, (Activity) null);
        } catch (zzalu e11) {
            zzciz.zzk("Unable to process ad data", e11);
        }
        return parse.toString();
    }

    public static /* bridge */ /* synthetic */ void zzw(zzs zzs, String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        zzs.zzd.startActivity(intent);
    }

    public final void zzA() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzB() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void zzC(zzbgu zzbgu) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzD(zzbgx zzbgx) throws RemoteException {
        this.zzg = zzbgx;
    }

    public final void zzE(zzbho zzbho) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzF(zzbfi zzbfi) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zzG(zzbhr zzbhr) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzH(zzazw zzazw) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzI(zzbfo zzbfo) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzJ(zzbhy zzbhy) {
    }

    public final void zzK(zzbjd zzbjd) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzL(boolean z11) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzM(zzccb zzccb) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzN(boolean z11) throws RemoteException {
    }

    public final void zzO(zzbme zzbme) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzP(zzbit zzbit) {
    }

    public final void zzQ(zzcce zzcce, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzR(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zzS(zzcem zzcem) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzT(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final void zzU(zzbkq zzbkq) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    public final void zzV(int i11) {
        if (this.zzf != null) {
            this.zzf.setLayoutParams(new ViewGroup.LayoutParams(-1, i11));
        }
    }

    public final void zzW(IObjectWrapper iObjectWrapper) {
    }

    public final void zzX() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zzY() throws RemoteException {
        return false;
    }

    public final boolean zzZ() throws RemoteException {
        return false;
    }

    public final boolean zzaa(zzbfd zzbfd) throws RemoteException {
        Preconditions.checkNotNull(this.zzf, "This Search Ad has already been torn down");
        this.zze.zzf(zzbfd, this.zza);
        this.zzi = AsyncTaskInstrumentation.execute(new zzq(this, (zzp) null), new Void[0]);
        return true;
    }

    public final void zzab(zzbhv zzbhv) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    public final int zzb(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzbgo.zzb();
            return zzcis.zzs(this.zzd, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public final Bundle zzd() {
        throw new IllegalStateException("Unused method");
    }

    public final zzbfi zzg() throws RemoteException {
        return this.zzb;
    }

    public final zzbgx zzi() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    public final zzbhr zzj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Nullable
    public final zzbiw zzk() {
        return null;
    }

    @Nullable
    public final zzbiz zzl() {
        return null;
    }

    public final IObjectWrapper zzn() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzf);
    }

    @VisibleForTesting
    public final String zzp() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzbmn.zzd.zze());
        builder.appendQueryParameter("query", this.zze.zzd());
        builder.appendQueryParameter("pubId", this.zze.zzc());
        builder.appendQueryParameter("mappver", this.zze.zza());
        Map<String, String> zze2 = this.zze.zze();
        for (String next : zze2.keySet()) {
            builder.appendQueryParameter(next, zze2.get(next));
        }
        Uri build = builder.build();
        zzalt zzalt = this.zzh;
        if (zzalt != null) {
            try {
                build = zzalt.zzb(build, this.zzd);
            } catch (zzalu e11) {
                zzciz.zzk("Unable to process ad data", e11);
            }
        }
        String zzq = zzq();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb2 = new StringBuilder(zzq.length() + 1 + String.valueOf(encodedQuery).length());
        sb2.append(zzq);
        sb2.append("#");
        sb2.append(encodedQuery);
        return sb2.toString();
    }

    @VisibleForTesting
    public final String zzq() {
        String zzb2 = this.zze.zzb();
        if (true == TextUtils.isEmpty(zzb2)) {
            zzb2 = "www.google.com";
        }
        String zze2 = zzbmn.zzd.zze();
        StringBuilder sb2 = new StringBuilder(String.valueOf(zzb2).length() + 8 + String.valueOf(zze2).length());
        sb2.append("https://");
        sb2.append(zzb2);
        sb2.append(zze2);
        return sb2.toString();
    }

    public final String zzr() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Nullable
    public final String zzs() throws RemoteException {
        return null;
    }

    @Nullable
    public final String zzt() throws RemoteException {
        return null;
    }

    public final void zzx() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzi.cancel(true);
        this.zzc.cancel(true);
        this.zzf.destroy();
        this.zzf = null;
    }

    public final void zzy(zzbfd zzbfd, zzbha zzbha) {
    }

    public final void zzz() throws RemoteException {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }
}
