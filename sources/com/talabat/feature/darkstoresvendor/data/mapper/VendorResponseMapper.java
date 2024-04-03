package com.talabat.feature.darkstoresvendor.data.mapper;

import com.talabat.feature.darkstoresvendor.data.model.BasketDeliveryFeeTierInfoResponse;
import com.talabat.feature.darkstoresvendor.data.model.BasketTagsResponse;
import com.talabat.feature.darkstoresvendor.data.model.DeliveryFeeTierResponse;
import com.talabat.feature.darkstoresvendor.data.model.TierTagsResponse;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFreeTier;
import com.talabat.feature.darkstoresvendor.domain.model.Tags;
import com.talabat.feature.darkstoresvendor.domain.model.TierTags;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u000e\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\tH\u0002J\u000e\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0002J\u0018\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\b\u0012\u0004\u0012\u00020\u00100\u000eH\u0002¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/darkstoresvendor/data/mapper/VendorResponseMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "()V", "apply", "source", "mapBasketTiers", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketDeliveryFeeTierInfoResponse;", "toTags", "Lcom/talabat/feature/darkstoresvendor/domain/model/Tags;", "Lcom/talabat/feature/darkstoresvendor/data/model/BasketTagsResponse;", "toTiers", "", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFreeTier;", "Lcom/talabat/feature/darkstoresvendor/data/model/DeliveryFeeTierResponse;", "com_talabat_feature_darkstores-vendor_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorResponseMapper implements ModelMapper<VendorResponse, Vendor> {
    private final BasketDeliveryFeeTiersInfo mapBasketTiers(BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTierInfoResponse) {
        List<BasketDeliveryFreeTier> list;
        Tags tags;
        boolean z11;
        List<DeliveryFeeTierResponse> tiers = basketDeliveryFeeTierInfoResponse.getTiers();
        if (tiers != null) {
            list = toTiers(tiers);
        } else {
            list = null;
        }
        BasketTagsResponse tags2 = basketDeliveryFeeTierInfoResponse.getTags();
        if (tags2 != null) {
            tags = toTags(tags2);
        } else {
            tags = null;
        }
        String range = basketDeliveryFeeTierInfoResponse.getRange();
        Collection collection = list;
        boolean z12 = false;
        if (collection == null || collection.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || tags == null) {
            return null;
        }
        if (range == null || range.length() == 0) {
            z12 = true;
        }
        if (z12) {
            return null;
        }
        return new BasketDeliveryFeeTiersInfo(range, list, tags);
    }

    private final Tags toTags(BasketTagsResponse basketTagsResponse) {
        boolean z11;
        String bottomSheetTitle = basketTagsResponse.getBottomSheetTitle();
        boolean z12 = false;
        if (bottomSheetTitle == null || bottomSheetTitle.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            String bottomSheetButtonTitle = basketTagsResponse.getBottomSheetButtonTitle();
            if (bottomSheetButtonTitle == null || bottomSheetButtonTitle.length() == 0) {
                z12 = true;
            }
            if (!z12) {
                return new Tags(basketTagsResponse.getBottomSheetTitle(), basketTagsResponse.getBottomSheetButtonTitle(), basketTagsResponse.getBottomSheetMovMessage());
            }
        }
        return null;
    }

    private final List<BasketDeliveryFreeTier> toTiers(List<DeliveryFeeTierResponse> list) {
        String str;
        String str2;
        float f11;
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (DeliveryFeeTierResponse deliveryFeeTierResponse : list) {
            TierTagsResponse tags = deliveryFeeTierResponse.getTags();
            BasketDeliveryFreeTier basketDeliveryFreeTier = null;
            if (tags != null) {
                str = tags.getLabel();
            } else {
                str = null;
            }
            if (tags != null) {
                str2 = tags.getMessage();
            } else {
                str2 = null;
            }
            if (!(tags == null || str == null || str2 == null)) {
                Float progressPercentage = tags.getProgressPercentage();
                if (progressPercentage != null) {
                    f11 = progressPercentage.floatValue();
                } else {
                    f11 = 0.0f;
                }
                Boolean isHighlighted = deliveryFeeTierResponse.getTags().isHighlighted();
                if (isHighlighted != null) {
                    z11 = isHighlighted.booleanValue();
                } else {
                    z11 = false;
                }
                basketDeliveryFreeTier = new BasketDeliveryFreeTier(new TierTags(str, str2, f11, z11));
            }
            if (basketDeliveryFreeTier != null) {
                arrayList.add(basketDeliveryFreeTier);
            }
        }
        return arrayList;
    }

    @NotNull
    public Vendor apply(@NotNull VendorResponse vendorResponse) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(vendorResponse, "source");
        String vendorId = vendorResponse.getVendorId();
        String str3 = vendorId == null ? "" : vendorId;
        String vendorCode = vendorResponse.getVendorCode();
        if (vendorCode == null) {
            str = "";
        } else {
            str = vendorCode;
        }
        Float deliveryFee = vendorResponse.getDeliveryFee();
        float floatValue = deliveryFee != null ? deliveryFee.floatValue() : 0.0f;
        String deliveryTime = vendorResponse.getDeliveryTime();
        if (deliveryTime == null) {
            str2 = "";
        } else {
            str2 = deliveryTime;
        }
        Float minimumOrderValue = vendorResponse.getMinimumOrderValue();
        float floatValue2 = minimumOrderValue != null ? minimumOrderValue.floatValue() : 0.0f;
        Boolean isTPro = vendorResponse.isTPro();
        boolean booleanValue = isTPro != null ? isTPro.booleanValue() : false;
        Boolean isVendorPro = vendorResponse.isVendorPro();
        boolean booleanValue2 = isVendorPro != null ? isVendorPro.booleanValue() : false;
        BasketDeliveryFeeTierInfoResponse basketDeliveryFeeTiers = vendorResponse.getBasketDeliveryFeeTiers();
        return new Vendor(str3, str, floatValue, str2, floatValue2, booleanValue, booleanValue2, basketDeliveryFeeTiers != null ? mapBasketTiers(basketDeliveryFeeTiers) : null, vendorResponse.getScheduleDeliveryDiscount());
    }
}
