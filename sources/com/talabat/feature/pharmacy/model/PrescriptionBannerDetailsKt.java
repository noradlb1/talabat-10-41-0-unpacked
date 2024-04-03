package com.talabat.feature.pharmacy.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0002\u001a\u000e\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\u0002H\u0002\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0000¨\u0006\u0007"}, d2 = {"getActiveOrder", "Lcom/talabat/feature/pharmacy/model/ActiveOrder;", "Lcom/talabat/feature/pharmacy/model/PrescriptionBannerDetails;", "getVendor", "Lcom/talabat/feature/pharmacy/model/Vendor;", "toDomain", "Lcom/talabat/feature/pharmacy/model/BannerData;", "com_talabat_feature_pharmacy_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class PrescriptionBannerDetailsKt {
    private static final ActiveOrder getActiveOrder(PrescriptionBannerDetails prescriptionBannerDetails) {
        ActiveOrderResponse activeOrder = prescriptionBannerDetails.getActiveOrder();
        if (activeOrder == null) {
            return null;
        }
        String status = activeOrder.getStatus();
        String eta = activeOrder.getEta();
        ActiveOrderAddress activeOrderAddress = r4;
        ActiveOrderAddress activeOrderAddress2 = new ActiveOrderAddress(activeOrder.getAddress().getId(), activeOrder.getAddress().getAreaId(), activeOrder.getAddress().getAreaName(), activeOrder.getAddress().getBlock(), activeOrder.getAddress().getBuildingNo(), activeOrder.getAddress().getCityId(), activeOrder.getAddress().getCountyId(), activeOrder.getAddress().getCountryName(), activeOrder.getAddress().getExtraDirections(), activeOrder.getAddress().getFloor(), activeOrder.getAddress().getGeoAddressMsg(), activeOrder.getAddress().getGeoAddressTitle(), activeOrder.getAddress().getGrl(), activeOrder.getAddress().getGrlid(), activeOrder.getAddress().isAreaSplit(), activeOrder.getAddress().isDeliverable(), activeOrder.getAddress().isOldAddreses(), activeOrder.getAddress().getJudda(), activeOrder.getAddress().getLatitude(), activeOrder.getAddress().getLongitude(), activeOrder.getAddress().getMobileNumber(), activeOrder.getAddress().getMobilNumberCountryCode(), activeOrder.getAddress().getPhoneNumber(), activeOrder.getAddress().getProfileName(), activeOrder.getAddress().getStreet(), activeOrder.getAddress().getSuite(), activeOrder.getAddress().getType());
        return new ActiveOrder(status, eta, activeOrderAddress, activeOrder.getPrescriptionOrderId());
    }

    private static final Vendor getVendor(PrescriptionBannerDetails prescriptionBannerDetails) {
        if (prescriptionBannerDetails.getVendor() == null) {
            return null;
        }
        return new Vendor(prescriptionBannerDetails.getVendor().getChainId(), prescriptionBannerDetails.getVendor().getChainName(), prescriptionBannerDetails.getVendor().getVendorAddress(), prescriptionBannerDetails.getVendor().getPhoneNumber(), prescriptionBannerDetails.getVendor().getLogUrl());
    }

    @NotNull
    public static final BannerData toDomain(@NotNull PrescriptionBannerDetails prescriptionBannerDetails) {
        Banner banner;
        Intrinsics.checkNotNullParameter(prescriptionBannerDetails, "<this>");
        BannerResponse banner2 = prescriptionBannerDetails.getBanner();
        if (banner2 != null) {
            banner = new Banner(banner2.getTitle(), banner2.getDescription(), banner2.getCtaText(), banner2.getDeliveryFee(), banner2.getDeliveryTime(), banner2.getBannerUrl(), banner2.getLogUrl(), new PrescriptionPlacementStatus(banner2.getPlacementStatus().getEnabled(), banner2.getPlacementStatus().getDisabledTitle(), banner2.getPlacementStatus().getDisabledSubtitle(), banner2.getPlacementStatus().getTimeStartAndEnd()));
        } else {
            banner = null;
        }
        return new BannerData(banner, getActiveOrder(prescriptionBannerDetails), getVendor(prescriptionBannerDetails), new PrescriptionConfig(prescriptionBannerDetails.getConfig().getAllowedAreaId()));
    }
}
