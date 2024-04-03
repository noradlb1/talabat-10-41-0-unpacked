package com.talabat.feature.pharmacy.model;

import com.google.gson.annotations.SerializedName;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B+\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J7\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/talabat/feature/pharmacy/model/PrescriptionBannerDetails;", "Ljava/io/Serializable;", "banner", "Lcom/talabat/feature/pharmacy/model/BannerResponse;", "activeOrder", "Lcom/talabat/feature/pharmacy/model/ActiveOrderResponse;", "vendor", "Lcom/talabat/feature/pharmacy/model/VendorResponse;", "config", "Lcom/talabat/feature/pharmacy/model/PrescriptionConfigResponse;", "(Lcom/talabat/feature/pharmacy/model/BannerResponse;Lcom/talabat/feature/pharmacy/model/ActiveOrderResponse;Lcom/talabat/feature/pharmacy/model/VendorResponse;Lcom/talabat/feature/pharmacy/model/PrescriptionConfigResponse;)V", "getActiveOrder", "()Lcom/talabat/feature/pharmacy/model/ActiveOrderResponse;", "getBanner", "()Lcom/talabat/feature/pharmacy/model/BannerResponse;", "getConfig", "()Lcom/talabat/feature/pharmacy/model/PrescriptionConfigResponse;", "getVendor", "()Lcom/talabat/feature/pharmacy/model/VendorResponse;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_feature_pharmacy_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionBannerDetails implements Serializable {
    @SerializedName("active_order")
    @Nullable
    private final ActiveOrderResponse activeOrder;
    @Nullable
    private final BannerResponse banner;
    @NotNull
    private final PrescriptionConfigResponse config;
    @Nullable
    private final VendorResponse vendor;

    public PrescriptionBannerDetails(@Nullable BannerResponse bannerResponse, @Nullable ActiveOrderResponse activeOrderResponse, @Nullable VendorResponse vendorResponse, @NotNull PrescriptionConfigResponse prescriptionConfigResponse) {
        Intrinsics.checkNotNullParameter(prescriptionConfigResponse, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        this.banner = bannerResponse;
        this.activeOrder = activeOrderResponse;
        this.vendor = vendorResponse;
        this.config = prescriptionConfigResponse;
    }

    public static /* synthetic */ PrescriptionBannerDetails copy$default(PrescriptionBannerDetails prescriptionBannerDetails, BannerResponse bannerResponse, ActiveOrderResponse activeOrderResponse, VendorResponse vendorResponse, PrescriptionConfigResponse prescriptionConfigResponse, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bannerResponse = prescriptionBannerDetails.banner;
        }
        if ((i11 & 2) != 0) {
            activeOrderResponse = prescriptionBannerDetails.activeOrder;
        }
        if ((i11 & 4) != 0) {
            vendorResponse = prescriptionBannerDetails.vendor;
        }
        if ((i11 & 8) != 0) {
            prescriptionConfigResponse = prescriptionBannerDetails.config;
        }
        return prescriptionBannerDetails.copy(bannerResponse, activeOrderResponse, vendorResponse, prescriptionConfigResponse);
    }

    @Nullable
    public final BannerResponse component1() {
        return this.banner;
    }

    @Nullable
    public final ActiveOrderResponse component2() {
        return this.activeOrder;
    }

    @Nullable
    public final VendorResponse component3() {
        return this.vendor;
    }

    @NotNull
    public final PrescriptionConfigResponse component4() {
        return this.config;
    }

    @NotNull
    public final PrescriptionBannerDetails copy(@Nullable BannerResponse bannerResponse, @Nullable ActiveOrderResponse activeOrderResponse, @Nullable VendorResponse vendorResponse, @NotNull PrescriptionConfigResponse prescriptionConfigResponse) {
        Intrinsics.checkNotNullParameter(prescriptionConfigResponse, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
        return new PrescriptionBannerDetails(bannerResponse, activeOrderResponse, vendorResponse, prescriptionConfigResponse);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PrescriptionBannerDetails)) {
            return false;
        }
        PrescriptionBannerDetails prescriptionBannerDetails = (PrescriptionBannerDetails) obj;
        return Intrinsics.areEqual((Object) this.banner, (Object) prescriptionBannerDetails.banner) && Intrinsics.areEqual((Object) this.activeOrder, (Object) prescriptionBannerDetails.activeOrder) && Intrinsics.areEqual((Object) this.vendor, (Object) prescriptionBannerDetails.vendor) && Intrinsics.areEqual((Object) this.config, (Object) prescriptionBannerDetails.config);
    }

    @Nullable
    public final ActiveOrderResponse getActiveOrder() {
        return this.activeOrder;
    }

    @Nullable
    public final BannerResponse getBanner() {
        return this.banner;
    }

    @NotNull
    public final PrescriptionConfigResponse getConfig() {
        return this.config;
    }

    @Nullable
    public final VendorResponse getVendor() {
        return this.vendor;
    }

    public int hashCode() {
        BannerResponse bannerResponse = this.banner;
        int i11 = 0;
        int hashCode = (bannerResponse == null ? 0 : bannerResponse.hashCode()) * 31;
        ActiveOrderResponse activeOrderResponse = this.activeOrder;
        int hashCode2 = (hashCode + (activeOrderResponse == null ? 0 : activeOrderResponse.hashCode())) * 31;
        VendorResponse vendorResponse = this.vendor;
        if (vendorResponse != null) {
            i11 = vendorResponse.hashCode();
        }
        return ((hashCode2 + i11) * 31) + this.config.hashCode();
    }

    @NotNull
    public String toString() {
        BannerResponse bannerResponse = this.banner;
        ActiveOrderResponse activeOrderResponse = this.activeOrder;
        VendorResponse vendorResponse = this.vendor;
        PrescriptionConfigResponse prescriptionConfigResponse = this.config;
        return "PrescriptionBannerDetails(banner=" + bannerResponse + ", activeOrder=" + activeOrderResponse + ", vendor=" + vendorResponse + ", config=" + prescriptionConfigResponse + ")";
    }
}
