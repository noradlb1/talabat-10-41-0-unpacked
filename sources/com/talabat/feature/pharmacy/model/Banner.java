package com.talabat.feature.pharmacy.model;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020#0'J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006)"}, d2 = {"Lcom/talabat/feature/pharmacy/model/Banner;", "Ljava/io/Serializable;", "title", "", "description", "ctaText", "deliveryFee", "deliveryTime", "bannerUrl", "logUrl", "placementStatus", "Lcom/talabat/feature/pharmacy/model/PrescriptionPlacementStatus;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/talabat/feature/pharmacy/model/PrescriptionPlacementStatus;)V", "getBannerUrl", "()Ljava/lang/String;", "getCtaText", "getDeliveryFee", "getDeliveryTime", "getDescription", "getLogUrl", "getPlacementStatus", "()Lcom/talabat/feature/pharmacy/model/PrescriptionPlacementStatus;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "", "hashCode", "", "toMap", "", "toString", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Banner implements Serializable {
    @NotNull
    private final String bannerUrl;
    @NotNull
    private final String ctaText;
    @NotNull
    private final String deliveryFee;
    @NotNull
    private final String deliveryTime;
    @NotNull
    private final String description;
    @NotNull
    private final String logUrl;
    @NotNull
    private final PrescriptionPlacementStatus placementStatus;
    @NotNull
    private final String title;

    public Banner(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull PrescriptionPlacementStatus prescriptionPlacementStatus) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "ctaText");
        Intrinsics.checkNotNullParameter(str4, "deliveryFee");
        Intrinsics.checkNotNullParameter(str5, "deliveryTime");
        Intrinsics.checkNotNullParameter(str6, "bannerUrl");
        Intrinsics.checkNotNullParameter(str7, "logUrl");
        Intrinsics.checkNotNullParameter(prescriptionPlacementStatus, "placementStatus");
        this.title = str;
        this.description = str2;
        this.ctaText = str3;
        this.deliveryFee = str4;
        this.deliveryTime = str5;
        this.bannerUrl = str6;
        this.logUrl = str7;
        this.placementStatus = prescriptionPlacementStatus;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, String str3, String str4, String str5, String str6, String str7, PrescriptionPlacementStatus prescriptionPlacementStatus, int i11, Object obj) {
        Banner banner2 = banner;
        int i12 = i11;
        return banner.copy((i12 & 1) != 0 ? banner2.title : str, (i12 & 2) != 0 ? banner2.description : str2, (i12 & 4) != 0 ? banner2.ctaText : str3, (i12 & 8) != 0 ? banner2.deliveryFee : str4, (i12 & 16) != 0 ? banner2.deliveryTime : str5, (i12 & 32) != 0 ? banner2.bannerUrl : str6, (i12 & 64) != 0 ? banner2.logUrl : str7, (i12 & 128) != 0 ? banner2.placementStatus : prescriptionPlacementStatus);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @NotNull
    public final String component3() {
        return this.ctaText;
    }

    @NotNull
    public final String component4() {
        return this.deliveryFee;
    }

    @NotNull
    public final String component5() {
        return this.deliveryTime;
    }

    @NotNull
    public final String component6() {
        return this.bannerUrl;
    }

    @NotNull
    public final String component7() {
        return this.logUrl;
    }

    @NotNull
    public final PrescriptionPlacementStatus component8() {
        return this.placementStatus;
    }

    @NotNull
    public final Banner copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6, @NotNull String str7, @NotNull PrescriptionPlacementStatus prescriptionPlacementStatus) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "ctaText");
        Intrinsics.checkNotNullParameter(str4, "deliveryFee");
        Intrinsics.checkNotNullParameter(str5, "deliveryTime");
        String str8 = str6;
        Intrinsics.checkNotNullParameter(str8, "bannerUrl");
        String str9 = str7;
        Intrinsics.checkNotNullParameter(str9, "logUrl");
        PrescriptionPlacementStatus prescriptionPlacementStatus2 = prescriptionPlacementStatus;
        Intrinsics.checkNotNullParameter(prescriptionPlacementStatus2, "placementStatus");
        return new Banner(str, str2, str3, str4, str5, str8, str9, prescriptionPlacementStatus2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Banner)) {
            return false;
        }
        Banner banner = (Banner) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) banner.title) && Intrinsics.areEqual((Object) this.description, (Object) banner.description) && Intrinsics.areEqual((Object) this.ctaText, (Object) banner.ctaText) && Intrinsics.areEqual((Object) this.deliveryFee, (Object) banner.deliveryFee) && Intrinsics.areEqual((Object) this.deliveryTime, (Object) banner.deliveryTime) && Intrinsics.areEqual((Object) this.bannerUrl, (Object) banner.bannerUrl) && Intrinsics.areEqual((Object) this.logUrl, (Object) banner.logUrl) && Intrinsics.areEqual((Object) this.placementStatus, (Object) banner.placementStatus);
    }

    @NotNull
    public final String getBannerUrl() {
        return this.bannerUrl;
    }

    @NotNull
    public final String getCtaText() {
        return this.ctaText;
    }

    @NotNull
    public final String getDeliveryFee() {
        return this.deliveryFee;
    }

    @NotNull
    public final String getDeliveryTime() {
        return this.deliveryTime;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getLogUrl() {
        return this.logUrl;
    }

    @NotNull
    public final PrescriptionPlacementStatus getPlacementStatus() {
        return this.placementStatus;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((((((((((this.title.hashCode() * 31) + this.description.hashCode()) * 31) + this.ctaText.hashCode()) * 31) + this.deliveryFee.hashCode()) * 31) + this.deliveryTime.hashCode()) * 31) + this.bannerUrl.hashCode()) * 31) + this.logUrl.hashCode()) * 31) + this.placementStatus.hashCode();
    }

    @NotNull
    public final Map<String, Object> toMap() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("title", this.title), TuplesKt.to("description", this.description), TuplesKt.to("cta_text", this.ctaText), TuplesKt.to("delivery_fee", this.deliveryFee), TuplesKt.to("delivery_time", this.deliveryTime), TuplesKt.to("banner_url", this.bannerUrl), TuplesKt.to("logo_url", this.logUrl), TuplesKt.to("placementStatus", this.placementStatus.toMap()));
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.ctaText;
        String str4 = this.deliveryFee;
        String str5 = this.deliveryTime;
        String str6 = this.bannerUrl;
        String str7 = this.logUrl;
        PrescriptionPlacementStatus prescriptionPlacementStatus = this.placementStatus;
        return "Banner(title=" + str + ", description=" + str2 + ", ctaText=" + str3 + ", deliveryFee=" + str4 + ", deliveryTime=" + str5 + ", bannerUrl=" + str6 + ", logUrl=" + str7 + ", placementStatus=" + prescriptionPlacementStatus + ")";
    }
}
