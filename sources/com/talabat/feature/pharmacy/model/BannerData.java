package com.talabat.feature.pharmacy.model;

import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020\u001b0\u001fJ\t\u0010!\u001a\u00020 HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\""}, d2 = {"Lcom/talabat/feature/pharmacy/model/BannerData;", "Ljava/io/Serializable;", "banner", "Lcom/talabat/feature/pharmacy/model/Banner;", "activeOrder", "Lcom/talabat/feature/pharmacy/model/ActiveOrder;", "vendor", "Lcom/talabat/feature/pharmacy/model/Vendor;", "config", "Lcom/talabat/feature/pharmacy/model/PrescriptionConfig;", "(Lcom/talabat/feature/pharmacy/model/Banner;Lcom/talabat/feature/pharmacy/model/ActiveOrder;Lcom/talabat/feature/pharmacy/model/Vendor;Lcom/talabat/feature/pharmacy/model/PrescriptionConfig;)V", "getActiveOrder", "()Lcom/talabat/feature/pharmacy/model/ActiveOrder;", "getBanner", "()Lcom/talabat/feature/pharmacy/model/Banner;", "getConfig", "()Lcom/talabat/feature/pharmacy/model/PrescriptionConfig;", "getVendor", "()Lcom/talabat/feature/pharmacy/model/Vendor;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toMap", "", "", "toString", "com_talabat_feature_pharmacy_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BannerData implements Serializable {
    @Nullable
    private final ActiveOrder activeOrder;
    @Nullable
    private final Banner banner;
    @NotNull
    private final PrescriptionConfig config;
    @Nullable
    private final Vendor vendor;

    public BannerData(@Nullable Banner banner2, @Nullable ActiveOrder activeOrder2, @Nullable Vendor vendor2, @NotNull PrescriptionConfig prescriptionConfig) {
        Intrinsics.checkNotNullParameter(prescriptionConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.banner = banner2;
        this.activeOrder = activeOrder2;
        this.vendor = vendor2;
        this.config = prescriptionConfig;
    }

    public static /* synthetic */ BannerData copy$default(BannerData bannerData, Banner banner2, ActiveOrder activeOrder2, Vendor vendor2, PrescriptionConfig prescriptionConfig, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            banner2 = bannerData.banner;
        }
        if ((i11 & 2) != 0) {
            activeOrder2 = bannerData.activeOrder;
        }
        if ((i11 & 4) != 0) {
            vendor2 = bannerData.vendor;
        }
        if ((i11 & 8) != 0) {
            prescriptionConfig = bannerData.config;
        }
        return bannerData.copy(banner2, activeOrder2, vendor2, prescriptionConfig);
    }

    @Nullable
    public final Banner component1() {
        return this.banner;
    }

    @Nullable
    public final ActiveOrder component2() {
        return this.activeOrder;
    }

    @Nullable
    public final Vendor component3() {
        return this.vendor;
    }

    @NotNull
    public final PrescriptionConfig component4() {
        return this.config;
    }

    @NotNull
    public final BannerData copy(@Nullable Banner banner2, @Nullable ActiveOrder activeOrder2, @Nullable Vendor vendor2, @NotNull PrescriptionConfig prescriptionConfig) {
        Intrinsics.checkNotNullParameter(prescriptionConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        return new BannerData(banner2, activeOrder2, vendor2, prescriptionConfig);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BannerData)) {
            return false;
        }
        BannerData bannerData = (BannerData) obj;
        return Intrinsics.areEqual((Object) this.banner, (Object) bannerData.banner) && Intrinsics.areEqual((Object) this.activeOrder, (Object) bannerData.activeOrder) && Intrinsics.areEqual((Object) this.vendor, (Object) bannerData.vendor) && Intrinsics.areEqual((Object) this.config, (Object) bannerData.config);
    }

    @Nullable
    public final ActiveOrder getActiveOrder() {
        return this.activeOrder;
    }

    @Nullable
    public final Banner getBanner() {
        return this.banner;
    }

    @NotNull
    public final PrescriptionConfig getConfig() {
        return this.config;
    }

    @Nullable
    public final Vendor getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        Banner banner2 = this.banner;
        int i11 = 0;
        int hashCode = (banner2 == null ? 0 : banner2.hashCode()) * 31;
        ActiveOrder activeOrder2 = this.activeOrder;
        int hashCode2 = (hashCode + (activeOrder2 == null ? 0 : activeOrder2.hashCode())) * 31;
        Vendor vendor2 = this.vendor;
        if (vendor2 != null) {
            i11 = vendor2.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.config.hashCode();
    }

    @NotNull
    public final Map<String, Object> toMap() {
        Map<String, Object> map;
        Map<String, Object> map2;
        Map<String, Object> map3;
        Pair[] pairArr = new Pair[4];
        Banner banner2 = this.banner;
        if (banner2 == null || (map = banner2.toMap()) == null) {
            map = MapsKt__MapsKt.emptyMap();
        }
        pairArr[0] = TuplesKt.to("banner", map);
        ActiveOrder activeOrder2 = this.activeOrder;
        if (activeOrder2 == null || (map2 = activeOrder2.toMap()) == null) {
            map2 = MapsKt__MapsKt.emptyMap();
        }
        pairArr[1] = TuplesKt.to("activeOrder", map2);
        Vendor vendor2 = this.vendor;
        if (vendor2 == null || (map3 = vendor2.toMap()) == null) {
            map3 = MapsKt__MapsKt.emptyMap();
        }
        pairArr[2] = TuplesKt.to("vendor", map3);
        pairArr[3] = TuplesKt.to(DarkstoresMainActivity.CONFIG_EXTRA_KEY, this.config.toMap());
        return MapsKt__MapsKt.mapOf(pairArr);
    }

    @NotNull
    public String toString() {
        Banner banner2 = this.banner;
        ActiveOrder activeOrder2 = this.activeOrder;
        Vendor vendor2 = this.vendor;
        PrescriptionConfig prescriptionConfig = this.config;
        return "BannerData(banner=" + banner2 + ", activeOrder=" + activeOrder2 + ", vendor=" + vendor2 + ", config=" + prescriptionConfig + ")";
    }
}
