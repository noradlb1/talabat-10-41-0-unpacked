package com.talabat.darkstores.feature.home;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lcom/talabat/darkstores/feature/home/BannerObservabilityData;", "", "heroBannerSize", "", "bannerSize", "vendorId", "", "(IILjava/lang/String;)V", "getBannerSize", "()I", "getHeroBannerSize", "getVendorId", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class BannerObservabilityData {
    private final int bannerSize;
    private final int heroBannerSize;
    @NotNull
    private final String vendorId;

    public BannerObservabilityData(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        this.heroBannerSize = i11;
        this.bannerSize = i12;
        this.vendorId = str;
    }

    public static /* synthetic */ BannerObservabilityData copy$default(BannerObservabilityData bannerObservabilityData, int i11, int i12, String str, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = bannerObservabilityData.heroBannerSize;
        }
        if ((i13 & 2) != 0) {
            i12 = bannerObservabilityData.bannerSize;
        }
        if ((i13 & 4) != 0) {
            str = bannerObservabilityData.vendorId;
        }
        return bannerObservabilityData.copy(i11, i12, str);
    }

    public final int component1() {
        return this.heroBannerSize;
    }

    public final int component2() {
        return this.bannerSize;
    }

    @NotNull
    public final String component3() {
        return this.vendorId;
    }

    @NotNull
    public final BannerObservabilityData copy(int i11, int i12, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        return new BannerObservabilityData(i11, i12, str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerObservabilityData)) {
            return false;
        }
        BannerObservabilityData bannerObservabilityData = (BannerObservabilityData) obj;
        return this.heroBannerSize == bannerObservabilityData.heroBannerSize && this.bannerSize == bannerObservabilityData.bannerSize && Intrinsics.areEqual((Object) this.vendorId, (Object) bannerObservabilityData.vendorId);
    }

    public final int getBannerSize() {
        return this.bannerSize;
    }

    public final int getHeroBannerSize() {
        return this.heroBannerSize;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        return (((this.heroBannerSize * 31) + this.bannerSize) * 31) + this.vendorId.hashCode();
    }

    @NotNull
    public String toString() {
        int i11 = this.heroBannerSize;
        int i12 = this.bannerSize;
        String str = this.vendorId;
        return "BannerObservabilityData(heroBannerSize=" + i11 + ", bannerSize=" + i12 + ", vendorId=" + str + ")";
    }
}
