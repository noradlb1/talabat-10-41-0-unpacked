package com.talabat.feature.darkstorescart.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0003\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "Landroid/os/Parcelable;", "campaignId", "", "campaignName", "(Ljava/lang/String;Ljava/lang/String;)V", "getCampaignId", "()Ljava/lang/String;", "getCampaignName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class CampaignLabel implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<CampaignLabel> CREATOR = new Creator();
    @NotNull
    private final String campaignId;
    @NotNull
    private final String campaignName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CampaignLabel> {
        @NotNull
        public final CampaignLabel createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new CampaignLabel(parcel.readString(), parcel.readString());
        }

        @NotNull
        public final CampaignLabel[] newArray(int i11) {
            return new CampaignLabel[i11];
        }
    }

    public CampaignLabel(@NotNull @Json(name = "campaign_id") String str, @NotNull @Json(name = "campaign_name") String str2) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(str2, "campaignName");
        this.campaignId = str;
        this.campaignName = str2;
    }

    public static /* synthetic */ CampaignLabel copy$default(CampaignLabel campaignLabel, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = campaignLabel.campaignId;
        }
        if ((i11 & 2) != 0) {
            str2 = campaignLabel.campaignName;
        }
        return campaignLabel.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.campaignId;
    }

    @NotNull
    public final String component2() {
        return this.campaignName;
    }

    @NotNull
    public final CampaignLabel copy(@NotNull @Json(name = "campaign_id") String str, @NotNull @Json(name = "campaign_name") String str2) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(str2, "campaignName");
        return new CampaignLabel(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CampaignLabel)) {
            return false;
        }
        CampaignLabel campaignLabel = (CampaignLabel) obj;
        return Intrinsics.areEqual((Object) this.campaignId, (Object) campaignLabel.campaignId) && Intrinsics.areEqual((Object) this.campaignName, (Object) campaignLabel.campaignName);
    }

    @NotNull
    public final String getCampaignId() {
        return this.campaignId;
    }

    @NotNull
    public final String getCampaignName() {
        return this.campaignName;
    }

    public int hashCode() {
        return (this.campaignId.hashCode() * 31) + this.campaignName.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.campaignId;
        String str2 = this.campaignName;
        return "CampaignLabel(campaignId=" + str + ", campaignName=" + str2 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.campaignId);
        parcel.writeString(this.campaignName);
    }
}
