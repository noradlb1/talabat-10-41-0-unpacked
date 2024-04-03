package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import android.view.View;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.NativeAd;
import java.util.List;
import java.util.Map;

public abstract class UnifiedNativeAdMapper {
    private String zza;
    private List<NativeAd.Image> zzb;
    private String zzc;
    private NativeAd.Image zzd;
    private String zze;
    private String zzf;
    private Double zzg;
    private String zzh;
    private String zzi;
    private VideoController zzj;
    private boolean zzk;
    private View zzl;
    private View zzm;
    private Object zzn;
    private Bundle zzo = new Bundle();
    private boolean zzp;
    private boolean zzq;
    private float zzr;

    @RecentlyNonNull
    public View getAdChoicesContent() {
        return this.zzl;
    }

    @RecentlyNonNull
    public final String getAdvertiser() {
        return this.zzf;
    }

    @RecentlyNonNull
    public final String getBody() {
        return this.zzc;
    }

    @RecentlyNonNull
    public final String getCallToAction() {
        return this.zze;
    }

    public float getCurrentTime() {
        return 0.0f;
    }

    public float getDuration() {
        return 0.0f;
    }

    @RecentlyNonNull
    public final Bundle getExtras() {
        return this.zzo;
    }

    @RecentlyNonNull
    public final String getHeadline() {
        return this.zza;
    }

    @RecentlyNonNull
    public final NativeAd.Image getIcon() {
        return this.zzd;
    }

    @RecentlyNonNull
    public final List<NativeAd.Image> getImages() {
        return this.zzb;
    }

    public float getMediaContentAspectRatio() {
        return this.zzr;
    }

    public final boolean getOverrideClickHandling() {
        return this.zzq;
    }

    public final boolean getOverrideImpressionRecording() {
        return this.zzp;
    }

    @RecentlyNonNull
    public final String getPrice() {
        return this.zzi;
    }

    @RecentlyNonNull
    public final Double getStarRating() {
        return this.zzg;
    }

    @RecentlyNonNull
    public final String getStore() {
        return this.zzh;
    }

    public void handleClick(@RecentlyNonNull View view) {
    }

    public boolean hasVideoContent() {
        return this.zzk;
    }

    public void recordImpression() {
    }

    public void setAdChoicesContent(@RecentlyNonNull View view) {
        this.zzl = view;
    }

    public final void setAdvertiser(@RecentlyNonNull String str) {
        this.zzf = str;
    }

    public final void setBody(@RecentlyNonNull String str) {
        this.zzc = str;
    }

    public final void setCallToAction(@RecentlyNonNull String str) {
        this.zze = str;
    }

    public final void setExtras(@RecentlyNonNull Bundle bundle) {
        this.zzo = bundle;
    }

    public void setHasVideoContent(boolean z11) {
        this.zzk = z11;
    }

    public final void setHeadline(@RecentlyNonNull String str) {
        this.zza = str;
    }

    public final void setIcon(@RecentlyNonNull NativeAd.Image image) {
        this.zzd = image;
    }

    public final void setImages(@RecentlyNonNull List<NativeAd.Image> list) {
        this.zzb = list;
    }

    public void setMediaContentAspectRatio(float f11) {
        this.zzr = f11;
    }

    public void setMediaView(@RecentlyNonNull View view) {
        this.zzm = view;
    }

    public final void setOverrideClickHandling(boolean z11) {
        this.zzq = z11;
    }

    public final void setOverrideImpressionRecording(boolean z11) {
        this.zzp = z11;
    }

    public final void setPrice(@RecentlyNonNull String str) {
        this.zzi = str;
    }

    public final void setStarRating(@RecentlyNonNull Double d11) {
        this.zzg = d11;
    }

    public final void setStore(@RecentlyNonNull String str) {
        this.zzh = str;
    }

    public void trackViews(@RecentlyNonNull View view, @RecentlyNonNull Map<String, View> map, @RecentlyNonNull Map<String, View> map2) {
    }

    public void untrackView(@RecentlyNonNull View view) {
    }

    @RecentlyNonNull
    public final View zza() {
        return this.zzm;
    }

    @RecentlyNonNull
    public final VideoController zzb() {
        return this.zzj;
    }

    @RecentlyNonNull
    public final Object zzc() {
        return this.zzn;
    }

    public final void zzd(@RecentlyNonNull Object obj) {
        this.zzn = obj;
    }

    public final void zze(@RecentlyNonNull VideoController videoController) {
        this.zzj = videoController;
    }
}
