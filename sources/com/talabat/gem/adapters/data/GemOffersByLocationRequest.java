package com.talabat.gem.adapters.data;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0014\u001a\u00020\bHÆ\u0003J:\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001¢\u0006\u0002\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00062\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001c"}, d2 = {"Lcom/talabat/gem/adapters/data/GemOffersByLocationRequest;", "", "latitude", "", "longitude", "isSandBox", "", "countryId", "", "(Ljava/lang/Double;Ljava/lang/Double;ZI)V", "getCountryId", "()I", "()Z", "getLatitude", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getLongitude", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Double;ZI)Lcom/talabat/gem/adapters/data/GemOffersByLocationRequest;", "equals", "other", "hashCode", "toString", "", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemOffersByLocationRequest {
    @SerializedName("countryId")
    private final int countryId;
    @SerializedName("isSandBox")
    private final boolean isSandBox;
    @SerializedName("latitude")
    @Nullable
    private final Double latitude;
    @SerializedName("longitude")
    @Nullable
    private final Double longitude;

    public GemOffersByLocationRequest() {
        this((Double) null, (Double) null, false, 0, 15, (DefaultConstructorMarker) null);
    }

    public GemOffersByLocationRequest(@Nullable Double d11, @Nullable Double d12, boolean z11, int i11) {
        this.latitude = d11;
        this.longitude = d12;
        this.isSandBox = z11;
        this.countryId = i11;
    }

    public static /* synthetic */ GemOffersByLocationRequest copy$default(GemOffersByLocationRequest gemOffersByLocationRequest, Double d11, Double d12, boolean z11, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            d11 = gemOffersByLocationRequest.latitude;
        }
        if ((i12 & 2) != 0) {
            d12 = gemOffersByLocationRequest.longitude;
        }
        if ((i12 & 4) != 0) {
            z11 = gemOffersByLocationRequest.isSandBox;
        }
        if ((i12 & 8) != 0) {
            i11 = gemOffersByLocationRequest.countryId;
        }
        return gemOffersByLocationRequest.copy(d11, d12, z11, i11);
    }

    @Nullable
    public final Double component1() {
        return this.latitude;
    }

    @Nullable
    public final Double component2() {
        return this.longitude;
    }

    public final boolean component3() {
        return this.isSandBox;
    }

    public final int component4() {
        return this.countryId;
    }

    @NotNull
    public final GemOffersByLocationRequest copy(@Nullable Double d11, @Nullable Double d12, boolean z11, int i11) {
        return new GemOffersByLocationRequest(d11, d12, z11, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GemOffersByLocationRequest)) {
            return false;
        }
        GemOffersByLocationRequest gemOffersByLocationRequest = (GemOffersByLocationRequest) obj;
        return Intrinsics.areEqual((Object) this.latitude, (Object) gemOffersByLocationRequest.latitude) && Intrinsics.areEqual((Object) this.longitude, (Object) gemOffersByLocationRequest.longitude) && this.isSandBox == gemOffersByLocationRequest.isSandBox && this.countryId == gemOffersByLocationRequest.countryId;
    }

    public final int getCountryId() {
        return this.countryId;
    }

    @Nullable
    public final Double getLatitude() {
        return this.latitude;
    }

    @Nullable
    public final Double getLongitude() {
        return this.longitude;
    }

    public int hashCode() {
        Double d11 = this.latitude;
        int i11 = 0;
        int hashCode = (d11 == null ? 0 : d11.hashCode()) * 31;
        Double d12 = this.longitude;
        if (d12 != null) {
            i11 = d12.hashCode();
        }
        int i12 = (hashCode + i11) * 31;
        boolean z11 = this.isSandBox;
        if (z11) {
            z11 = true;
        }
        return ((i12 + (z11 ? 1 : 0)) * 31) + this.countryId;
    }

    public final boolean isSandBox() {
        return this.isSandBox;
    }

    @NotNull
    public String toString() {
        Double d11 = this.latitude;
        Double d12 = this.longitude;
        boolean z11 = this.isSandBox;
        int i11 = this.countryId;
        return "GemOffersByLocationRequest(latitude=" + d11 + ", longitude=" + d12 + ", isSandBox=" + z11 + ", countryId=" + i11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ GemOffersByLocationRequest(java.lang.Double r1, java.lang.Double r2, boolean r3, int r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0011
            java.lang.String r1 = com.talabat.helpers.GlobalDataModel.LATLONGFORAPI.getLatitude()
            java.lang.String r6 = "getLatitude()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
            java.lang.Double r1 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r1)
        L_0x0011:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0022
            java.lang.String r2 = com.talabat.helpers.GlobalDataModel.LATLONGFORAPI.getLongitude()
            java.lang.String r6 = "getLongitude()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r6)
            java.lang.Double r2 = kotlin.text.StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(r2)
        L_0x0022:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0032
            java.lang.Boolean r3 = com.talabat.gem.adapters.data.ServerKt.getSandboxResponse()
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.booleanValue()
            goto L_0x0032
        L_0x0031:
            r3 = 0
        L_0x0032:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x003a
            int r4 = com.talabat.gem.adapters.data.ServerKt.getSelectedCountryId()
        L_0x003a:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.gem.adapters.data.GemOffersByLocationRequest.<init>(java.lang.Double, java.lang.Double, boolean, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
