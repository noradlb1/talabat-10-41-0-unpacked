package com.talabat.feature.nfvinvendorsearch.presentation.navigation;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\n0\tH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\t\u0010\f\u001a\u00020\u0003HÂ\u0003J\t\u0010\r\u001a\u00020\u0003HÂ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÂ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00062\b\u0010\u0013\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u0014\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0011HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/BannerCampaignProductListingRoute;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/navigation/FlutterRoute;", "branchId", "", "campaignId", "isLegacyBanners", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "buildArguments", "", "", "buildPath", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "other", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class BannerCampaignProductListingRoute extends FlutterRoute {
    @NotNull
    public static final Parcelable.Creator<BannerCampaignProductListingRoute> CREATOR = new Creator();
    @NotNull
    private final String branchId;
    @NotNull
    private final String campaignId;
    private final boolean isLegacyBanners;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<BannerCampaignProductListingRoute> {
        @NotNull
        public final BannerCampaignProductListingRoute createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new BannerCampaignProductListingRoute(parcel.readString(), parcel.readString(), parcel.readInt() != 0);
        }

        @NotNull
        public final BannerCampaignProductListingRoute[] newArray(int i11) {
            return new BannerCampaignProductListingRoute[i11];
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BannerCampaignProductListingRoute(String str, String str2, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i11 & 4) != 0 ? true : z11);
    }

    private final String component1() {
        return this.branchId;
    }

    private final String component2() {
        return this.campaignId;
    }

    private final boolean component3() {
        return this.isLegacyBanners;
    }

    public static /* synthetic */ BannerCampaignProductListingRoute copy$default(BannerCampaignProductListingRoute bannerCampaignProductListingRoute, String str, String str2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bannerCampaignProductListingRoute.branchId;
        }
        if ((i11 & 2) != 0) {
            str2 = bannerCampaignProductListingRoute.campaignId;
        }
        if ((i11 & 4) != 0) {
            z11 = bannerCampaignProductListingRoute.isLegacyBanners;
        }
        return bannerCampaignProductListingRoute.copy(str, str2, z11);
    }

    @NotNull
    public Map<String, Object> buildArguments() {
        return MapsKt__MapsKt.mapOf(TuplesKt.to("id", this.campaignId), TuplesKt.to("isLegacyBanners", Boolean.valueOf(this.isLegacyBanners)));
    }

    @NotNull
    public String buildPath() {
        String str = this.branchId;
        return "qcommerce/branches/" + str + "/products/banner";
    }

    @NotNull
    public final BannerCampaignProductListingRoute copy(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "campaignId");
        return new BannerCampaignProductListingRoute(str, str2, z11);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerCampaignProductListingRoute)) {
            return false;
        }
        BannerCampaignProductListingRoute bannerCampaignProductListingRoute = (BannerCampaignProductListingRoute) obj;
        return Intrinsics.areEqual((Object) this.branchId, (Object) bannerCampaignProductListingRoute.branchId) && Intrinsics.areEqual((Object) this.campaignId, (Object) bannerCampaignProductListingRoute.campaignId) && this.isLegacyBanners == bannerCampaignProductListingRoute.isLegacyBanners;
    }

    public int hashCode() {
        int hashCode = ((this.branchId.hashCode() * 31) + this.campaignId.hashCode()) * 31;
        boolean z11 = this.isLegacyBanners;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    @NotNull
    public String toString() {
        String str = this.branchId;
        String str2 = this.campaignId;
        boolean z11 = this.isLegacyBanners;
        return "BannerCampaignProductListingRoute(branchId=" + str + ", campaignId=" + str2 + ", isLegacyBanners=" + z11 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.branchId);
        parcel.writeString(this.campaignId);
        parcel.writeInt(this.isLegacyBanners ? 1 : 0);
    }

    public BannerCampaignProductListingRoute(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "branchId");
        Intrinsics.checkNotNullParameter(str2, "campaignId");
        this.branchId = str;
        this.campaignId = str2;
        this.isLegacyBanners = z11;
    }
}
