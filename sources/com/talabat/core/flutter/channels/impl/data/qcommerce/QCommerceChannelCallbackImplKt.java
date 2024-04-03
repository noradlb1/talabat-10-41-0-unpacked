package com.talabat.core.flutter.channels.impl.data.qcommerce;

import com.talabat.core.navigation.domain.screen.checkout.ExitPointCampaign;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointFeeDescription;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointProduct;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.CartResponse;
import com.talabat.feature.darkstorescart.data.model.CartResponseProduct;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import com.talabat.feature.darkstoresvendor.data.model.VendorResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002\u001a\u001e\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002\u001a\u0016\u0010\u0010\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0002\u001a\"\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0003H\u0002\u001a\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00190\fH\u0002¢\u0006\u0002\u0010\u001a\u001a\f\u0010\u001b\u001a\u00020\u001c*\u00020\u0014H\u0002\u001a\u0018\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\f*\b\u0012\u0004\u0012\u00020\u001f0\fH\u0002\u001a\u001a\u0010 \u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\f*\b\u0012\u0004\u0012\u00020\u000f0\fH\u0002\u001a\u0018\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\f*\b\u0012\u0004\u0012\u00020\u00190\fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0003XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"DESCRIPTIONS_SIZE", "", "EXTRA_VERTICALS_DARKSTORES_BRIDGE", "", "EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT", "FEE_DESCRIPTION_TYPE_DELIVERY", "FEE_DESCRIPTION_TYPE_GENERIC", "FEE_DESCRIPTION_TYPE_SERVICE", "HOW_IT_WORKS_DESCRIPTION_DELIMITER", "createDeliveryFeeDescription", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointFeeDescription;", "descriptions", "", "createHowFeesWorksDescription", "howItWorks", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "createServiceFeeDescription", "getExitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "cartResponse", "Lcom/talabat/feature/darkstorescart/data/model/CartResponse;", "vendorResponse", "Lcom/talabat/feature/darkstoresvendor/data/model/VendorResponse;", "specialRequest", "calculateAgeRestriction", "Lcom/talabat/feature/darkstorescart/data/model/CartResponseProduct;", "(Ljava/util/List;)Ljava/lang/Integer;", "calculateTotalDiscount", "", "toExitPointCampaignLabels", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointCampaign;", "Lcom/talabat/feature/darkstorescart/data/model/CampaignLabel;", "toExitPointFeeDescriptions", "toExitPointProducts", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointProduct;", "com_talabat_core_flutter-channels-impl_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class QCommerceChannelCallbackImplKt {
    private static final int DESCRIPTIONS_SIZE = 3;
    @NotNull
    private static final String EXTRA_VERTICALS_DARKSTORES_BRIDGE = "darkstores_bridge_model";
    @NotNull
    private static final String EXTRA_VERTICALS_DARKSTORES_BRIDGE_RESTAURANT = "darkstores_bridge_restaurant";
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_DELIVERY = "DeliveryFee";
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_GENERIC = "HowFeesWork";
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_SERVICE = "ServiceFee";
    @NotNull
    private static final String HOW_IT_WORKS_DESCRIPTION_DELIMITER = "\n\n";

    private static final Integer calculateAgeRestriction(List<CartResponseProduct> list) {
        boolean z11;
        ArrayList arrayList = new ArrayList();
        for (CartResponseProduct ageLimit : list) {
            Integer ageLimit2 = ageLimit.getAgeLimit();
            if (ageLimit2 != null) {
                arrayList.add(ageLimit2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next : arrayList) {
            if (((Number) next).intValue() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                arrayList2.add(next);
            }
        }
        return (Integer) CollectionsKt.maxOrNull((Iterable) arrayList2);
    }

    private static final float calculateTotalDiscount(CartResponse cartResponse) {
        float absoluteDiscount = cartResponse.getAbsoluteDiscount();
        Iterable<CartResponseProduct> items = cartResponse.getItems();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(items, 10));
        for (CartResponseProduct absoluteDiscount2 : items) {
            arrayList.add(Float.valueOf(absoluteDiscount2.getAbsoluteDiscount()));
        }
        return absoluteDiscount + CollectionsKt___CollectionsKt.sumOfFloat(arrayList);
    }

    private static final ExitPointFeeDescription createDeliveryFeeDescription(List<String> list) {
        String str = (String) CollectionsKt___CollectionsKt.getOrNull(list, 1);
        if (str == null) {
            str = "";
        }
        return new ExitPointFeeDescription("DeliveryFee", "", str, (String) null, (String) null);
    }

    private static final ExitPointFeeDescription createHowFeesWorksDescription(FeeDescription feeDescription, List<String> list) {
        String str;
        String str2;
        String name2 = feeDescription.getName();
        if (name2 == null) {
            str = "";
        } else {
            str = name2;
        }
        String str3 = (String) CollectionsKt___CollectionsKt.getOrNull(list, 0);
        if (str3 == null) {
            str3 = "";
        }
        String url = feeDescription.getUrl();
        String urlText = feeDescription.getUrlText();
        if (urlText == null) {
            str2 = "";
        } else {
            str2 = urlText;
        }
        return new ExitPointFeeDescription("HowFeesWork", str, str3, url, str2);
    }

    private static final ExitPointFeeDescription createServiceFeeDescription(List<String> list) {
        String str = (String) CollectionsKt___CollectionsKt.getOrNull(list, 2);
        if (str == null) {
            str = "";
        }
        return new ExitPointFeeDescription("ServiceFee", "", str, (String) null, (String) null);
    }

    /* access modifiers changed from: private */
    public static final ExitPointData getExitPointData(CartResponse cartResponse, VendorResponse vendorResponse, String str) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        List<ExitPointProduct> exitPointProducts = toExitPointProducts(cartResponse.getItems());
        float subtotal = cartResponse.getSubtotal();
        float deliveryFee = cartResponse.getDeliveryFee();
        Float serviceFee = cartResponse.getServiceFee();
        float calculateTotalDiscount = calculateTotalDiscount(cartResponse);
        float total = cartResponse.getTotal();
        String targetAudience = cartResponse.getTargetAudience();
        float absoluteDiscount = cartResponse.getAbsoluteDiscount();
        float deliveryAbsoluteDiscount = cartResponse.getDeliveryAbsoluteDiscount();
        Float valueOf = Float.valueOf(cartResponse.getDeliveryTotal());
        String cartId = cartResponse.getCartId();
        if (cartId == null) {
            str2 = "";
        } else {
            str2 = cartId;
        }
        List<ExitPointCampaign> exitPointCampaignLabels = toExitPointCampaignLabels(cartResponse.getAppliedCampaigns());
        String vendorId = vendorResponse.getVendorId();
        if (vendorId == null) {
            str3 = "";
        } else {
            str3 = vendorId;
        }
        if (str == null) {
            str4 = "";
        } else {
            str4 = str;
        }
        Integer calculateAgeRestriction = calculateAgeRestriction(cartResponse.getItems());
        List<ExitPointFeeDescription> list = null;
        if (calculateAgeRestriction != null) {
            str5 = calculateAgeRestriction.toString();
        } else {
            str5 = null;
        }
        if (str5 == null) {
            str6 = "";
        } else {
            str6 = str5;
        }
        List<FeeDescription> feeDescriptions = cartResponse.getFeeDescriptions();
        if (feeDescriptions != null) {
            list = toExitPointFeeDescriptions(feeDescriptions);
        }
        if (list == null) {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        return new ExitPointData(exitPointProducts, subtotal, deliveryFee, serviceFee, calculateTotalDiscount, total, targetAudience, absoluteDiscount, deliveryAbsoluteDiscount, valueOf, str2, exitPointCampaignLabels, str3, str4, (String) null, str6, list, vendorResponse.getScheduleDeliveryDiscount(), 16384, (DefaultConstructorMarker) null);
    }

    private static final List<ExitPointCampaign> toExitPointCampaignLabels(List<CampaignLabel> list) {
        Iterable<CampaignLabel> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CampaignLabel campaignLabel : iterable) {
            arrayList.add(new ExitPointCampaign(campaignLabel.getCampaignId(), campaignLabel.getCampaignName()));
        }
        return arrayList;
    }

    private static final List<ExitPointFeeDescription> toExitPointFeeDescriptions(List<FeeDescription> list) {
        Object obj;
        List list2;
        boolean z11;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((FeeDescription) obj).getType(), (Object) "HowFeesWork")) {
                break;
            }
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        if (feeDescription == null) {
            return null;
        }
        String description = feeDescription.getDescription();
        if (description != null) {
            list2 = StringsKt__StringsKt.split$default((CharSequence) description, new String[]{HOW_IT_WORKS_DESCRIPTION_DELIMITER}, false, 0, 6, (Object) null);
        } else {
            list2 = null;
        }
        if (list2 == null || list2.size() != 3) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            list2 = null;
        }
        if (list2 == null) {
            return null;
        }
        return CollectionsKt__CollectionsKt.listOf(createHowFeesWorksDescription(feeDescription, list2), createDeliveryFeeDescription(list2), createServiceFeeDescription(list2));
    }

    private static final List<ExitPointProduct> toExitPointProducts(List<CartResponseProduct> list) {
        Iterable<CartResponseProduct> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (CartResponseProduct cartResponseProduct : iterable) {
            String productId = cartResponseProduct.getProductId();
            String productSku = cartResponseProduct.getProductSku();
            List<String> productCategoryIds = cartResponseProduct.getProductCategoryIds();
            String productName = cartResponseProduct.getProductName();
            if (productName == null) {
                productName = "";
            }
            arrayList.add(new ExitPointProduct(productId, productName, "", cartResponseProduct.getImageUrl(), cartResponseProduct.getQuantity(), cartResponseProduct.getTotal(), cartResponseProduct.getSubtotal(), toExitPointCampaignLabels(cartResponseProduct.getAppliedCampaigns()), cartResponseProduct.getAbsoluteDiscount(), productSku, productCategoryIds));
        }
        return arrayList;
    }
}
