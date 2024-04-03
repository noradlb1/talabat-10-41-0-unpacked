package com.talabat.feature.nfvinvendorsearch.presentation.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\"\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\b¢\u0006\u0002\u0010\u0011J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\u0003HÆ\u0003J\t\u0010\"\u001a\u00020\bHÆ\u0003J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\bHÆ\u0003J\t\u0010'\u001a\u00020\nHÆ\u0003J\t\u0010(\u001a\u00020\fHÆ\u0003J\t\u0010)\u001a\u00020\fHÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003Jw\u0010+\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u00032\b\b\u0002\u0010\u0010\u001a\u00020\bHÆ\u0001J\t\u0010,\u001a\u00020\bHÖ\u0001J\u0013\u0010-\u001a\u00020\n2\b\u0010.\u001a\u0004\u0018\u00010/HÖ\u0003J\t\u00100\u001a\u00020\bHÖ\u0001J\t\u00101\u001a\u00020\u0003HÖ\u0001J\u0019\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\bHÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u000e\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0013R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u0010\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u00067"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "Landroid/os/Parcelable;", "vendorCode", "", "globalEntityId", "chainId", "name", "verticalId", "", "isDarkstore", "", "latitude", "", "longitude", "customerId", "logoUrl", "status", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZDDLjava/lang/String;Ljava/lang/String;I)V", "getChainId", "()Ljava/lang/String;", "getCustomerId", "getGlobalEntityId", "()Z", "getLatitude", "()D", "getLogoUrl", "getLongitude", "getName", "getStatus", "()I", "getVendorCode", "getVerticalId", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class FlutterConfigurationParams implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<FlutterConfigurationParams> CREATOR = new Creator();
    @NotNull
    private final String chainId;
    @NotNull
    private final String customerId;
    @NotNull
    private final String globalEntityId;
    private final boolean isDarkstore;
    private final double latitude;
    @NotNull
    private final String logoUrl;
    private final double longitude;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58626name;
    private final int status;
    @NotNull
    private final String vendorCode;
    private final int verticalId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FlutterConfigurationParams> {
        @NotNull
        public final FlutterConfigurationParams createFromParcel(@NotNull Parcel parcel) {
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            return new FlutterConfigurationParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readDouble(), parcel.readDouble(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        @NotNull
        public final FlutterConfigurationParams[] newArray(int i11) {
            return new FlutterConfigurationParams[i11];
        }
    }

    public FlutterConfigurationParams(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, boolean z11, double d11, double d12, @NotNull String str5, @NotNull String str6, int i12) {
        Intrinsics.checkNotNullParameter(str, ObservableAttributesNames.VENDOR_CODE);
        Intrinsics.checkNotNullParameter(str2, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str3, "chainId");
        Intrinsics.checkNotNullParameter(str4, "name");
        Intrinsics.checkNotNullParameter(str5, "customerId");
        Intrinsics.checkNotNullParameter(str6, Profile.LOGO_URL);
        this.vendorCode = str;
        this.globalEntityId = str2;
        this.chainId = str3;
        this.f58626name = str4;
        this.verticalId = i11;
        this.isDarkstore = z11;
        this.latitude = d11;
        this.longitude = d12;
        this.customerId = str5;
        this.logoUrl = str6;
        this.status = i12;
    }

    public static /* synthetic */ FlutterConfigurationParams copy$default(FlutterConfigurationParams flutterConfigurationParams, String str, String str2, String str3, String str4, int i11, boolean z11, double d11, double d12, String str5, String str6, int i12, int i13, Object obj) {
        FlutterConfigurationParams flutterConfigurationParams2 = flutterConfigurationParams;
        int i14 = i13;
        return flutterConfigurationParams.copy((i14 & 1) != 0 ? flutterConfigurationParams2.vendorCode : str, (i14 & 2) != 0 ? flutterConfigurationParams2.globalEntityId : str2, (i14 & 4) != 0 ? flutterConfigurationParams2.chainId : str3, (i14 & 8) != 0 ? flutterConfigurationParams2.f58626name : str4, (i14 & 16) != 0 ? flutterConfigurationParams2.verticalId : i11, (i14 & 32) != 0 ? flutterConfigurationParams2.isDarkstore : z11, (i14 & 64) != 0 ? flutterConfigurationParams2.latitude : d11, (i14 & 128) != 0 ? flutterConfigurationParams2.longitude : d12, (i14 & 256) != 0 ? flutterConfigurationParams2.customerId : str5, (i14 & 512) != 0 ? flutterConfigurationParams2.logoUrl : str6, (i14 & 1024) != 0 ? flutterConfigurationParams2.status : i12);
    }

    @NotNull
    public final String component1() {
        return this.vendorCode;
    }

    @NotNull
    public final String component10() {
        return this.logoUrl;
    }

    public final int component11() {
        return this.status;
    }

    @NotNull
    public final String component2() {
        return this.globalEntityId;
    }

    @NotNull
    public final String component3() {
        return this.chainId;
    }

    @NotNull
    public final String component4() {
        return this.f58626name;
    }

    public final int component5() {
        return this.verticalId;
    }

    public final boolean component6() {
        return this.isDarkstore;
    }

    public final double component7() {
        return this.latitude;
    }

    public final double component8() {
        return this.longitude;
    }

    @NotNull
    public final String component9() {
        return this.customerId;
    }

    @NotNull
    public final FlutterConfigurationParams copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, boolean z11, double d11, double d12, @NotNull String str5, @NotNull String str6, int i12) {
        String str7 = str;
        Intrinsics.checkNotNullParameter(str7, ObservableAttributesNames.VENDOR_CODE);
        String str8 = str2;
        Intrinsics.checkNotNullParameter(str8, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        String str9 = str3;
        Intrinsics.checkNotNullParameter(str9, "chainId");
        String str10 = str4;
        Intrinsics.checkNotNullParameter(str10, "name");
        String str11 = str5;
        Intrinsics.checkNotNullParameter(str11, "customerId");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, Profile.LOGO_URL);
        return new FlutterConfigurationParams(str7, str8, str9, str10, i11, z11, d11, d12, str11, str12, i12);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FlutterConfigurationParams)) {
            return false;
        }
        FlutterConfigurationParams flutterConfigurationParams = (FlutterConfigurationParams) obj;
        return Intrinsics.areEqual((Object) this.vendorCode, (Object) flutterConfigurationParams.vendorCode) && Intrinsics.areEqual((Object) this.globalEntityId, (Object) flutterConfigurationParams.globalEntityId) && Intrinsics.areEqual((Object) this.chainId, (Object) flutterConfigurationParams.chainId) && Intrinsics.areEqual((Object) this.f58626name, (Object) flutterConfigurationParams.f58626name) && this.verticalId == flutterConfigurationParams.verticalId && this.isDarkstore == flutterConfigurationParams.isDarkstore && Intrinsics.areEqual((Object) Double.valueOf(this.latitude), (Object) Double.valueOf(flutterConfigurationParams.latitude)) && Intrinsics.areEqual((Object) Double.valueOf(this.longitude), (Object) Double.valueOf(flutterConfigurationParams.longitude)) && Intrinsics.areEqual((Object) this.customerId, (Object) flutterConfigurationParams.customerId) && Intrinsics.areEqual((Object) this.logoUrl, (Object) flutterConfigurationParams.logoUrl) && this.status == flutterConfigurationParams.status;
    }

    @NotNull
    public final String getChainId() {
        return this.chainId;
    }

    @NotNull
    public final String getCustomerId() {
        return this.customerId;
    }

    @NotNull
    public final String getGlobalEntityId() {
        return this.globalEntityId;
    }

    public final double getLatitude() {
        return this.latitude;
    }

    @NotNull
    public final String getLogoUrl() {
        return this.logoUrl;
    }

    public final double getLongitude() {
        return this.longitude;
    }

    @NotNull
    public final String getName() {
        return this.f58626name;
    }

    public final int getStatus() {
        return this.status;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    public final int getVerticalId() {
        return this.verticalId;
    }

    public int hashCode() {
        int hashCode = ((((((((this.vendorCode.hashCode() * 31) + this.globalEntityId.hashCode()) * 31) + this.chainId.hashCode()) * 31) + this.f58626name.hashCode()) * 31) + this.verticalId) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((((((((hashCode + (z11 ? 1 : 0)) * 31) + Double.doubleToLongBits(this.latitude)) * 31) + Double.doubleToLongBits(this.longitude)) * 31) + this.customerId.hashCode()) * 31) + this.logoUrl.hashCode()) * 31) + this.status;
    }

    public final boolean isDarkstore() {
        return this.isDarkstore;
    }

    @NotNull
    public String toString() {
        String str = this.vendorCode;
        String str2 = this.globalEntityId;
        String str3 = this.chainId;
        String str4 = this.f58626name;
        int i11 = this.verticalId;
        boolean z11 = this.isDarkstore;
        double d11 = this.latitude;
        double d12 = this.longitude;
        String str5 = this.customerId;
        String str6 = this.logoUrl;
        int i12 = this.status;
        return "FlutterConfigurationParams(vendorCode=" + str + ", globalEntityId=" + str2 + ", chainId=" + str3 + ", name=" + str4 + ", verticalId=" + i11 + ", isDarkstore=" + z11 + ", latitude=" + d11 + ", longitude=" + d12 + ", customerId=" + str5 + ", logoUrl=" + str6 + ", status=" + i12 + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeString(this.vendorCode);
        parcel.writeString(this.globalEntityId);
        parcel.writeString(this.chainId);
        parcel.writeString(this.f58626name);
        parcel.writeInt(this.verticalId);
        parcel.writeInt(this.isDarkstore ? 1 : 0);
        parcel.writeDouble(this.latitude);
        parcel.writeDouble(this.longitude);
        parcel.writeString(this.customerId);
        parcel.writeString(this.logoUrl);
        parcel.writeInt(this.status);
    }
}
