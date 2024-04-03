package com.talabat.feature.nfvinvendorsearch.presentation.mapper;

import com.talabat.core.flutter.channels.impl.data.tpro.TProChannelCallbackImpl;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFeeTiersInfo;
import com.talabat.feature.darkstoresvendor.domain.model.BasketDeliveryFreeTier;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import com.talabat.feature.nfvinvendorsearch.presentation.model.FlutterConfigurationParams;
import com.talabat.mapper.ModelMapper;
import com.visa.checkout.Profile;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002(\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00050\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\bJ*\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00052\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0016J \u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J4\u0010\u000e\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u00050\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/nfvinvendorsearch/presentation/mapper/FlutterVendorToMapMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "Lcom/talabat/feature/nfvinvendorsearch/presentation/model/FlutterConfigurationParams;", "", "", "", "()V", "apply", "source", "getBasketDeliveryFeeTiersInfoMap", "tiersInfo", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFeeTiersInfo;", "mapBasketDelivery", "", "tires", "Lcom/talabat/feature/darkstoresvendor/domain/model/BasketDeliveryFreeTier;", "com_talabat_feature_qcommerce-flutter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlutterVendorToMapMapper implements ModelMapper<Pair<? extends Vendor, ? extends FlutterConfigurationParams>, Map<String, ? extends Object>> {
    private final Map<String, Object> getBasketDeliveryFeeTiersInfoMap(BasketDeliveryFeeTiersInfo basketDeliveryFeeTiersInfo) {
        if (basketDeliveryFeeTiersInfo == null) {
            return null;
        }
        return MapsKt__MapsKt.mapOf(TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_RANGE, basketDeliveryFeeTiersInfo.getRange()), TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS, mapBasketDelivery(basketDeliveryFeeTiersInfo.getBasketDeliveryFreeTiers())), TuplesKt.to("tags", MapsKt__MapsKt.mapOf(TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_TITLE, basketDeliveryFeeTiersInfo.getTags().getBottomSheetTitle()), TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_MOV_MESSAGE, basketDeliveryFeeTiersInfo.getTags().getBottomSheetMovMessage()), TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_BOTTOM_SHEET_BUTTON_TITLE, basketDeliveryFeeTiersInfo.getTags().getBottomSheetButtonTitle()))));
    }

    private final List<Map<String, Map<String, Object>>> mapBasketDelivery(List<BasketDeliveryFreeTier> list) {
        Iterable<BasketDeliveryFreeTier> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (BasketDeliveryFreeTier basketDeliveryFreeTier : iterable) {
            arrayList.add(MapsKt__MapsJVMKt.mapOf(TuplesKt.to("tags", MapsKt__MapsKt.mapOf(TuplesKt.to("label", basketDeliveryFreeTier.getTags().getLabel()), TuplesKt.to("message", basketDeliveryFreeTier.getTags().getMessage()), TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_PROGRESS_PERCENTAGE, Float.valueOf(basketDeliveryFreeTier.getTags().getProgressPercentage())), TuplesKt.to(BasketDeliveryFeeTiersInfoKeys.KEY_IS_HIGHLIGHTED, Boolean.valueOf(basketDeliveryFreeTier.getTags().isHighlighted()))))));
        }
        return arrayList;
    }

    @NotNull
    public Map<String, Object> apply(@NotNull Pair<Vendor, FlutterConfigurationParams> pair) {
        Intrinsics.checkNotNullParameter(pair, "source");
        Vendor component1 = pair.component1();
        FlutterConfigurationParams component2 = pair.component2();
        return MapsKt__MapsKt.mapOf(TuplesKt.to("globalVendorId", component1.getVendorId()), TuplesKt.to("branchId", component2.getVendorCode()), TuplesKt.to("chainId", component2.getChainId()), TuplesKt.to("name", component2.getName()), TuplesKt.to("verticalId", Integer.valueOf(component2.getVerticalId())), TuplesKt.to("isDarkstore", Boolean.valueOf(component2.isDarkstore())), TuplesKt.to(TProChannelCallbackImpl.MINIMUM_ORDER_VALUE_KEY, Float.valueOf(component1.getMinimumOrderValue())), TuplesKt.to("isVendorPro", Boolean.valueOf(component1.isVendorPro())), TuplesKt.to(Profile.LOGO_URL, component2.getLogoUrl()), TuplesKt.to("status", Integer.valueOf(component2.getStatus())), TuplesKt.to("deliveryFee", Float.valueOf(component1.getDeliveryFee())), TuplesKt.to("basketDeliveryFeeTiersInfo", getBasketDeliveryFeeTiersInfoMap(component1.getBasketDeliveryFeeTiersInfo())));
    }
}
