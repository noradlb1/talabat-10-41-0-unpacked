package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\u0006HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\""}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/InlineAdDisplayModel;", "", "adsLink", "", "adsImage", "adsPosition", "", "vendorLogo", "vendorName", "vendorCuisine", "baseUrl", "(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAdsImage", "()Ljava/lang/String;", "getAdsLink", "getAdsPosition", "()I", "getBaseUrl", "getVendorCuisine", "getVendorLogo", "getVendorName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InlineAdDisplayModel {
    @NotNull
    private final String adsImage;
    @NotNull
    private final String adsLink;
    private final int adsPosition;
    @NotNull
    private final String baseUrl;
    @NotNull
    private final String vendorCuisine;
    @NotNull
    private final String vendorLogo;
    @NotNull
    private final String vendorName;

    public InlineAdDisplayModel(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "adsLink");
        Intrinsics.checkNotNullParameter(str2, "adsImage");
        Intrinsics.checkNotNullParameter(str3, "vendorLogo");
        Intrinsics.checkNotNullParameter(str4, "vendorName");
        Intrinsics.checkNotNullParameter(str5, "vendorCuisine");
        Intrinsics.checkNotNullParameter(str6, "baseUrl");
        this.adsLink = str;
        this.adsImage = str2;
        this.adsPosition = i11;
        this.vendorLogo = str3;
        this.vendorName = str4;
        this.vendorCuisine = str5;
        this.baseUrl = str6;
    }

    public static /* synthetic */ InlineAdDisplayModel copy$default(InlineAdDisplayModel inlineAdDisplayModel, String str, String str2, int i11, String str3, String str4, String str5, String str6, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = inlineAdDisplayModel.adsLink;
        }
        if ((i12 & 2) != 0) {
            str2 = inlineAdDisplayModel.adsImage;
        }
        String str7 = str2;
        if ((i12 & 4) != 0) {
            i11 = inlineAdDisplayModel.adsPosition;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            str3 = inlineAdDisplayModel.vendorLogo;
        }
        String str8 = str3;
        if ((i12 & 16) != 0) {
            str4 = inlineAdDisplayModel.vendorName;
        }
        String str9 = str4;
        if ((i12 & 32) != 0) {
            str5 = inlineAdDisplayModel.vendorCuisine;
        }
        String str10 = str5;
        if ((i12 & 64) != 0) {
            str6 = inlineAdDisplayModel.baseUrl;
        }
        return inlineAdDisplayModel.copy(str, str7, i13, str8, str9, str10, str6);
    }

    @NotNull
    public final String component1() {
        return this.adsLink;
    }

    @NotNull
    public final String component2() {
        return this.adsImage;
    }

    public final int component3() {
        return this.adsPosition;
    }

    @NotNull
    public final String component4() {
        return this.vendorLogo;
    }

    @NotNull
    public final String component5() {
        return this.vendorName;
    }

    @NotNull
    public final String component6() {
        return this.vendorCuisine;
    }

    @NotNull
    public final String component7() {
        return this.baseUrl;
    }

    @NotNull
    public final InlineAdDisplayModel copy(@NotNull String str, @NotNull String str2, int i11, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6) {
        Intrinsics.checkNotNullParameter(str, "adsLink");
        Intrinsics.checkNotNullParameter(str2, "adsImage");
        Intrinsics.checkNotNullParameter(str3, "vendorLogo");
        Intrinsics.checkNotNullParameter(str4, "vendorName");
        Intrinsics.checkNotNullParameter(str5, "vendorCuisine");
        String str7 = str6;
        Intrinsics.checkNotNullParameter(str7, "baseUrl");
        return new InlineAdDisplayModel(str, str2, i11, str3, str4, str5, str7);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InlineAdDisplayModel)) {
            return false;
        }
        InlineAdDisplayModel inlineAdDisplayModel = (InlineAdDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.adsLink, (Object) inlineAdDisplayModel.adsLink) && Intrinsics.areEqual((Object) this.adsImage, (Object) inlineAdDisplayModel.adsImage) && this.adsPosition == inlineAdDisplayModel.adsPosition && Intrinsics.areEqual((Object) this.vendorLogo, (Object) inlineAdDisplayModel.vendorLogo) && Intrinsics.areEqual((Object) this.vendorName, (Object) inlineAdDisplayModel.vendorName) && Intrinsics.areEqual((Object) this.vendorCuisine, (Object) inlineAdDisplayModel.vendorCuisine) && Intrinsics.areEqual((Object) this.baseUrl, (Object) inlineAdDisplayModel.baseUrl);
    }

    @NotNull
    public final String getAdsImage() {
        return this.adsImage;
    }

    @NotNull
    public final String getAdsLink() {
        return this.adsLink;
    }

    public final int getAdsPosition() {
        return this.adsPosition;
    }

    @NotNull
    public final String getBaseUrl() {
        return this.baseUrl;
    }

    @NotNull
    public final String getVendorCuisine() {
        return this.vendorCuisine;
    }

    @NotNull
    public final String getVendorLogo() {
        return this.vendorLogo;
    }

    @NotNull
    public final String getVendorName() {
        return this.vendorName;
    }

    public int hashCode() {
        return (((((((((((this.adsLink.hashCode() * 31) + this.adsImage.hashCode()) * 31) + this.adsPosition) * 31) + this.vendorLogo.hashCode()) * 31) + this.vendorName.hashCode()) * 31) + this.vendorCuisine.hashCode()) * 31) + this.baseUrl.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.adsLink;
        String str2 = this.adsImage;
        int i11 = this.adsPosition;
        String str3 = this.vendorLogo;
        String str4 = this.vendorName;
        String str5 = this.vendorCuisine;
        String str6 = this.baseUrl;
        return "InlineAdDisplayModel(adsLink=" + str + ", adsImage=" + str2 + ", adsPosition=" + i11 + ", vendorLogo=" + str3 + ", vendorName=" + str4 + ", vendorCuisine=" + str5 + ", baseUrl=" + str6 + ")";
    }
}
