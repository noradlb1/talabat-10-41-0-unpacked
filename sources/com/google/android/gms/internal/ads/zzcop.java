package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzl;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@VisibleForTesting
public interface zzcop extends zzbes, zzdmd, zzcog, zzbuk, zzcpm, zzcpq, zzbux, zzaya, zzcpu, zzl, zzcpx, zzcpy, zzclh, zzcpz {
    boolean canGoBack();

    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    int getMeasuredHeight();

    int getMeasuredWidth();

    ViewParent getParent();

    int getWidth();

    void goBack();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i11, int i12);

    void onPause();

    void onResume();

    void setBackgroundColor(int i11);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zzE(zzcpl zzcpl);

    zzfdn zzF();

    Context zzG();

    View zzH();

    WebView zzI();

    WebViewClient zzJ();

    zzalt zzK();

    zzazn zzL();

    zzbnv zzM();

    com.google.android.gms.ads.internal.overlay.zzl zzN();

    com.google.android.gms.ads.internal.overlay.zzl zzO();

    zzcqc zzP();

    zzcqe zzQ();

    zzfdq zzR();

    IObjectWrapper zzS();

    zzfxa<String> zzT();

    String zzU();

    void zzV(zzfdn zzfdn, zzfdq zzfdq);

    void zzW();

    void zzX();

    void zzY(int i11);

    void zzZ();

    boolean zzaA(boolean z11, int i11);

    boolean zzaB();

    boolean zzaC();

    boolean zzaD();

    boolean zzaE();

    void zzaa();

    void zzab(boolean z11);

    void zzac();

    void zzad(String str, String str2, String str3);

    void zzae();

    void zzaf(String str, zzbrt<? super zzcop> zzbrt);

    void zzag();

    void zzah(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzai(zzcqe zzcqe);

    void zzaj(zzazn zzazn);

    void zzak(boolean z11);

    void zzal();

    void zzam(Context context);

    void zzan(boolean z11);

    void zzao(zzbnt zzbnt);

    void zzap(boolean z11);

    void zzaq(zzbnv zzbnv);

    void zzar(IObjectWrapper iObjectWrapper);

    void zzas(int i11);

    void zzat(com.google.android.gms.ads.internal.overlay.zzl zzl);

    void zzau(boolean z11);

    void zzav(boolean z11);

    void zzaw(String str, zzbrt<? super zzcop> zzbrt);

    void zzax(String str, Predicate<zzbrt<? super zzcop>> predicate);

    boolean zzay();

    boolean zzaz();

    Activity zzk();

    zza zzm();

    zzblw zzo();

    zzcjf zzp();

    zzcpl zzs();

    void zzv(String str, zzcnf zzcnf);
}
