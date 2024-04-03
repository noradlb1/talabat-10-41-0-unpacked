package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.overlay.zzc;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.util.zzaf;
import com.google.android.gms.ads.internal.util.zzbv;
import com.google.android.gms.ads.internal.util.zzt;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.instabug.library.model.NetworkLog;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.JSONObjectInstrumentation;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

@Instrumented
public final class zzcpe extends FrameLayout implements zzcop {
    private final zzcop zza;
    private final zzckw zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzcpe(zzcop zzcop) {
        super(zzcop.getContext());
        this.zza = zzcop;
        this.zzb = new zzckw(zzcop.zzG(), this, this);
        addView((View) zzcop);
    }

    public final boolean canGoBack() {
        return this.zza.canGoBack();
    }

    public final void destroy() {
        IObjectWrapper zzS = zzS();
        if (zzS != null) {
            zzfpj zzfpj = zzt.zza;
            zzfpj.post(new zzcpd(zzS));
            zzcop zzcop = this.zza;
            zzcop.getClass();
            zzfpj.postDelayed(new zzcpc(zzcop), (long) ((Integer) zzbgq.zzc().zzb(zzblj.zzdC)).intValue());
            return;
        }
        this.zza.destroy();
    }

    public final void goBack() {
        this.zza.goBack();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zza.loadData(str, NetworkLog.HTML, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zza.loadDataWithBaseURL(str, str2, NetworkLog.HTML, "UTF-8", (String) null);
    }

    public final void loadUrl(String str) {
        this.zza.loadUrl(str);
    }

    public final void onAdClicked() {
        zzcop zzcop = this.zza;
        if (zzcop != null) {
            zzcop.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzb.zze();
        this.zza.onPause();
    }

    public final void onResume() {
        this.zza.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zza.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zza.setOnTouchListener(onTouchListener);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zza.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zza.setWebViewClient(webViewClient);
    }

    public final void zzA(int i11) {
        this.zza.zzA(i11);
    }

    public final void zzB(boolean z11) {
        this.zza.zzB(false);
    }

    public final void zzC(int i11) {
        this.zza.zzC(i11);
    }

    public final void zzD(int i11) {
        this.zzb.zzf(i11);
    }

    public final void zzE(zzcpl zzcpl) {
        this.zza.zzE(zzcpl);
    }

    public final zzfdn zzF() {
        return this.zza.zzF();
    }

    public final Context zzG() {
        return this.zza.zzG();
    }

    public final View zzH() {
        return this;
    }

    public final WebView zzI() {
        return (WebView) this.zza;
    }

    public final WebViewClient zzJ() {
        return this.zza.zzJ();
    }

    public final zzalt zzK() {
        return this.zza.zzK();
    }

    public final zzazn zzL() {
        return this.zza.zzL();
    }

    @Nullable
    public final zzbnv zzM() {
        return this.zza.zzM();
    }

    public final zzl zzN() {
        return this.zza.zzN();
    }

    public final zzl zzO() {
        return this.zza.zzO();
    }

    public final zzcqc zzP() {
        return ((zzcpi) this.zza).zzaL();
    }

    public final zzcqe zzQ() {
        return this.zza.zzQ();
    }

    public final zzfdq zzR() {
        return this.zza.zzR();
    }

    public final IObjectWrapper zzS() {
        return this.zza.zzS();
    }

    public final zzfxa<String> zzT() {
        return this.zza.zzT();
    }

    public final String zzU() {
        return this.zza.zzU();
    }

    public final void zzV(zzfdn zzfdn, zzfdq zzfdq) {
        this.zza.zzV(zzfdn, zzfdq);
    }

    public final void zzW() {
        this.zzb.zzd();
        this.zza.zzW();
    }

    public final void zzX() {
        this.zza.zzX();
    }

    public final void zzY(int i11) {
        this.zza.zzY(i11);
    }

    public final void zzZ() {
        this.zza.zzZ();
    }

    public final void zza(String str) {
        ((zzcpi) this.zza).zzaQ(str);
    }

    public final boolean zzaA(boolean z11, int i11) {
        if (!this.zzc.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzaA)).booleanValue()) {
            return false;
        }
        if (this.zza.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zza.getParent()).removeView((View) this.zza);
        }
        this.zza.zzaA(z11, i11);
        return true;
    }

    public final boolean zzaB() {
        return this.zza.zzaB();
    }

    public final boolean zzaC() {
        return this.zza.zzaC();
    }

    public final boolean zzaD() {
        return this.zzc.get();
    }

    public final boolean zzaE() {
        return this.zza.zzaE();
    }

    public final void zzaF(zzc zzc2, boolean z11) {
        this.zza.zzaF(zzc2, z11);
    }

    public final void zzaG(zzbv zzbv, zzehh zzehh, zzdyz zzdyz, zzfio zzfio, String str, String str2, int i11) {
        this.zza.zzaG(zzbv, zzehh, zzdyz, zzfio, str, str2, i11);
    }

    public final void zzaH(boolean z11, int i11, boolean z12) {
        this.zza.zzaH(z11, i11, z12);
    }

    public final void zzaI(boolean z11, int i11, String str, boolean z12) {
        this.zza.zzaI(z11, i11, str, z12);
    }

    public final void zzaJ(boolean z11, int i11, String str, String str2, boolean z12) {
        this.zza.zzaJ(z11, i11, str, str2, z12);
    }

    public final void zzaa() {
        zzcop zzcop = this.zza;
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zze()));
        hashMap.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzt.zzr().zza()));
        zzcpi zzcpi = (zzcpi) zzcop;
        hashMap.put("device_volume", String.valueOf(zzaf.zzb(zzcpi.getContext())));
        zzcpi.zzd("volume", hashMap);
    }

    public final void zzab(boolean z11) {
        this.zza.zzab(z11);
    }

    public final void zzac() {
        this.zza.zzac();
    }

    public final void zzad(String str, String str2, @Nullable String str3) {
        this.zza.zzad(str, str2, (String) null);
    }

    public final void zzae() {
        this.zza.zzae();
    }

    public final void zzaf(String str, zzbrt<? super zzcop> zzbrt) {
        this.zza.zzaf(str, zzbrt);
    }

    public final void zzag() {
        TextView textView = new TextView(getContext());
        com.google.android.gms.ads.internal.zzt.zzp();
        textView.setText(zzt.zzD());
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final void zzah(zzl zzl) {
        this.zza.zzah(zzl);
    }

    public final void zzai(zzcqe zzcqe) {
        this.zza.zzai(zzcqe);
    }

    public final void zzaj(zzazn zzazn) {
        this.zza.zzaj(zzazn);
    }

    public final void zzak(boolean z11) {
        this.zza.zzak(z11);
    }

    public final void zzal() {
        setBackgroundColor(0);
        this.zza.setBackgroundColor(0);
    }

    public final void zzam(Context context) {
        this.zza.zzam(context);
    }

    public final void zzan(boolean z11) {
        this.zza.zzan(z11);
    }

    public final void zzao(zzbnt zzbnt) {
        this.zza.zzao(zzbnt);
    }

    public final void zzap(boolean z11) {
        this.zza.zzap(z11);
    }

    public final void zzaq(@Nullable zzbnv zzbnv) {
        this.zza.zzaq(zzbnv);
    }

    public final void zzar(IObjectWrapper iObjectWrapper) {
        this.zza.zzar(iObjectWrapper);
    }

    public final void zzas(int i11) {
        this.zza.zzas(i11);
    }

    public final void zzat(zzl zzl) {
        this.zza.zzat(zzl);
    }

    public final void zzau(boolean z11) {
        this.zza.zzau(z11);
    }

    public final void zzav(boolean z11) {
        this.zza.zzav(z11);
    }

    public final void zzaw(String str, zzbrt<? super zzcop> zzbrt) {
        this.zza.zzaw(str, zzbrt);
    }

    public final void zzax(String str, Predicate<zzbrt<? super zzcop>> predicate) {
        this.zza.zzax(str, predicate);
    }

    public final boolean zzay() {
        return this.zza.zzay();
    }

    public final boolean zzaz() {
        return this.zza.zzaz();
    }

    public final void zzb(String str, String str2) {
        this.zza.zzb("window.inspectorInfo", str2);
    }

    public final void zzbv() {
        this.zza.zzbv();
    }

    public final void zzbw() {
        this.zza.zzbw();
    }

    public final zzckw zzbx() {
        return this.zzb;
    }

    public final void zzc(zzaxz zzaxz) {
        this.zza.zzc(zzaxz);
    }

    public final void zzd(String str, Map<String, ?> map) {
        this.zza.zzd(str, map);
    }

    public final void zze(String str, JSONObject jSONObject) {
        this.zza.zze(str, jSONObject);
    }

    public final int zzf() {
        return this.zza.zzf();
    }

    public final int zzg() {
        return this.zza.zzg();
    }

    public final int zzh() {
        return this.zza.zzh();
    }

    public final int zzi() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcw)).booleanValue()) {
            return this.zza.getMeasuredHeight();
        }
        return getMeasuredHeight();
    }

    public final int zzj() {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzcw)).booleanValue()) {
            return this.zza.getMeasuredWidth();
        }
        return getMeasuredWidth();
    }

    @Nullable
    public final Activity zzk() {
        return this.zza.zzk();
    }

    public final void zzl(String str, JSONObject jSONObject) {
        String str2;
        zzcop zzcop = this.zza;
        if (!(jSONObject instanceof JSONObject)) {
            str2 = jSONObject.toString();
        } else {
            str2 = JSONObjectInstrumentation.toString(jSONObject);
        }
        ((zzcpi) zzcop).zzb(str, str2);
    }

    public final zza zzm() {
        return this.zza.zzm();
    }

    public final zzblv zzn() {
        return this.zza.zzn();
    }

    public final zzblw zzo() {
        return this.zza.zzo();
    }

    public final zzcjf zzp() {
        return this.zza.zzp();
    }

    public final void zzq() {
        zzcop zzcop = this.zza;
        if (zzcop != null) {
            zzcop.zzq();
        }
    }

    public final zzcnf zzr(String str) {
        return this.zza.zzr(str);
    }

    public final zzcpl zzs() {
        return this.zza.zzs();
    }

    public final String zzt() {
        return this.zza.zzt();
    }

    public final String zzu() {
        return this.zza.zzu();
    }

    public final void zzv(String str, zzcnf zzcnf) {
        this.zza.zzv(str, zzcnf);
    }

    public final void zzw() {
        this.zza.zzw();
    }

    public final void zzx(boolean z11, long j11) {
        this.zza.zzx(z11, j11);
    }

    public final void zzy() {
        this.zza.zzy();
    }

    public final void zzz(int i11) {
        this.zza.zzz(i11);
    }
}
