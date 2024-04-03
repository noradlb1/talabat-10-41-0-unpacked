package com.google.android.gms.ads.search;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbjg;
import kotlinx.coroutines.DebugKt;

public final class DynamicHeightSearchAdRequest {
    private final SearchAdRequest zza;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final zzb zza = new zzb();
        private final Bundle zzb = new Bundle();

        @RecentlyNonNull
        public Builder addCustomEventExtrasBundle(@RecentlyNonNull Class<? extends CustomEvent> cls, @RecentlyNonNull Bundle bundle) {
            this.zza.zzb(cls, bundle);
            return this;
        }

        @RecentlyNonNull
        public Builder addNetworkExtras(@RecentlyNonNull NetworkExtras networkExtras) {
            this.zza.zzc(networkExtras);
            return this;
        }

        @RecentlyNonNull
        public Builder addNetworkExtrasBundle(@RecentlyNonNull Class<? extends MediationAdapter> cls, @RecentlyNonNull Bundle bundle) {
            this.zza.zzd(cls, bundle);
            return this;
        }

        @RecentlyNonNull
        public DynamicHeightSearchAdRequest build() {
            this.zza.zzd(AdMobAdapter.class, this.zzb);
            return new DynamicHeightSearchAdRequest(this, (zza) null);
        }

        @RecentlyNonNull
        public Builder setAdBorderSelectors(@RecentlyNonNull String str) {
            this.zzb.putString("csa_adBorderSelectors", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setAdTest(boolean z11) {
            this.zzb.putString("csa_adtest", true != z11 ? DebugKt.DEBUG_PROPERTY_VALUE_OFF : DebugKt.DEBUG_PROPERTY_VALUE_ON);
            return this;
        }

        @RecentlyNonNull
        public Builder setAdjustableLineHeight(int i11) {
            this.zzb.putString("csa_adjustableLineHeight", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setAdvancedOptionValue(@RecentlyNonNull String str, @RecentlyNonNull String str2) {
            this.zzb.putString(str, str2);
            return this;
        }

        @RecentlyNonNull
        public Builder setAttributionSpacingBelow(int i11) {
            this.zzb.putString("csa_attributionSpacingBelow", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setBorderSelections(@RecentlyNonNull String str) {
            this.zzb.putString("csa_borderSelections", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setChannel(@RecentlyNonNull String str) {
            this.zzb.putString("csa_channel", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorAdBorder(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorAdBorder", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorAdSeparator(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorAdSeparator", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorAnnotation(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorAnnotation", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorAttribution(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorAttribution", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorBackground(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorBackground", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorBorder(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorBorder", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorDomainLink(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorDomainLink", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorText(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorText", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setColorTitleLink(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorTitleLink", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setCssWidth(int i11) {
            this.zzb.putString("csa_width", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setDetailedAttribution(boolean z11) {
            this.zzb.putString("csa_detailedAttribution", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setFontFamily(@RecentlyNonNull String str) {
            this.zzb.putString("csa_fontFamily", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setFontFamilyAttribution(@RecentlyNonNull String str) {
            this.zzb.putString("csa_fontFamilyAttribution", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setFontSizeAnnotation(int i11) {
            this.zzb.putString("csa_fontSizeAnnotation", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setFontSizeAttribution(int i11) {
            this.zzb.putString("csa_fontSizeAttribution", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setFontSizeDescription(int i11) {
            this.zzb.putString("csa_fontSizeDescription", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setFontSizeDomainLink(int i11) {
            this.zzb.putString("csa_fontSizeDomainLink", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setFontSizeTitle(int i11) {
            this.zzb.putString("csa_fontSizeTitle", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setHostLanguage(@RecentlyNonNull String str) {
            this.zzb.putString("csa_hl", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setIsClickToCallEnabled(boolean z11) {
            this.zzb.putString("csa_clickToCall", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsLocationEnabled(boolean z11) {
            this.zzb.putString("csa_location", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsPlusOnesEnabled(boolean z11) {
            this.zzb.putString("csa_plusOnes", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsSellerRatingsEnabled(boolean z11) {
            this.zzb.putString("csa_sellerRatings", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsSiteLinksEnabled(boolean z11) {
            this.zzb.putString("csa_siteLinks", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsTitleBold(boolean z11) {
            this.zzb.putString("csa_titleBold", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setIsTitleUnderlined(boolean z11) {
            this.zzb.putString("csa_noTitleUnderline", Boolean.toString(!z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setLocationColor(@RecentlyNonNull String str) {
            this.zzb.putString("csa_colorLocation", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setLocationFontSize(int i11) {
            this.zzb.putString("csa_fontSizeLocation", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setLongerHeadlines(boolean z11) {
            this.zzb.putString("csa_longerHeadlines", Boolean.toString(z11));
            return this;
        }

        @RecentlyNonNull
        public Builder setNumber(int i11) {
            this.zzb.putString("csa_number", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setPage(int i11) {
            this.zzb.putString("csa_adPage", Integer.toString(i11));
            return this;
        }

        @RecentlyNonNull
        public Builder setQuery(@RecentlyNonNull String str) {
            this.zza.zze(str);
            return this;
        }

        @RecentlyNonNull
        public Builder setStyleId(@RecentlyNonNull String str) {
            this.zzb.putString("csa_styleId", str);
            return this;
        }

        @RecentlyNonNull
        public Builder setVerticalSpacing(int i11) {
            this.zzb.putString("csa_verticalSpacing", Integer.toString(i11));
            return this;
        }
    }

    public /* synthetic */ DynamicHeightSearchAdRequest(Builder builder, zza zza2) {
        this.zza = new SearchAdRequest(builder.zza, (zzc) null);
    }

    @RecentlyNullable
    public <T extends CustomEvent> Bundle getCustomEventExtrasBundle(@RecentlyNonNull Class<T> cls) {
        return this.zza.getCustomEventExtrasBundle(cls);
    }

    @RecentlyNullable
    public <T extends MediationAdapter> Bundle getNetworkExtrasBundle(@RecentlyNonNull Class<T> cls) {
        return this.zza.getNetworkExtrasBundle(cls);
    }

    @RecentlyNonNull
    public String getQuery() {
        return this.zza.getQuery();
    }

    public boolean isTestDevice(@RecentlyNonNull Context context) {
        return this.zza.isTestDevice(context);
    }

    public final zzbjg zza() {
        return this.zza.zza();
    }
}
