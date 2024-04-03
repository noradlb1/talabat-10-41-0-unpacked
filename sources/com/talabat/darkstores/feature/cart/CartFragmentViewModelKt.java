package com.talabat.darkstores.feature.cart;

import com.talabat.core.navigation.domain.screen.checkout.ExitPointCampaign;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointData;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointFeeDescription;
import com.talabat.core.navigation.domain.screen.checkout.ExitPointProduct;
import com.talabat.feature.darkstorescart.data.model.CampaignLabel;
import com.talabat.feature.darkstorescart.data.model.FeeDescription;
import com.talabat.feature.darkstorescart.data.model.Product;
import com.talabat.feature.darkstoresvendor.domain.model.Vendor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002\u001a\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002\u001a\u0016\u0010\u0013\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002\u001a$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002\u001a\u001c\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u000fH\u0002\u001a\"\u0010\u0019\u001a\u00020\u0001*\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\u0004\u0012\u00020\u001c0\u001aj\u0002`\u001dH\u0000\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020 H\u0000\u001a.\u0010\u001e\u001a\u00020\u001f*\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\u0004\u0012\u00020\u001c0\u001a2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0016\u001a\u00020\u0017H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000*.\u0010#\"\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\u0004\u0012\u00020\u001c0\u001a2\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001b0\u000f\u0012\u0004\u0012\u00020\u001c0\u001a¨\u0006$"}, d2 = {"CATEGORIES_ROW_COUNT", "", "CATEGORIES_ROW_COUNT_DEFAULT", "DESCRIPTIONS_SIZE", "FEE_DESCRIPTION_TYPE_DELIVERY", "", "FEE_DESCRIPTION_TYPE_GENERIC", "FEE_DESCRIPTION_TYPE_SERVICE", "HOW_IT_WORKS_DESCRIPTION_DELIMITER", "VARIATION_CART_PRODUCT_VIEW_TYPE_COMPACT", "VARIATION_CART_PRODUCT_VIEW_TYPE_COMPACT_WITH_ALERTS", "VARIATION_SHOW_LOW_STOCK_INDICATOR", "createDeliveryFeeDescription", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointFeeDescription;", "descriptions", "", "createHowFeesWorksDescription", "howItWorks", "Lcom/talabat/feature/darkstorescart/data/model/FeeDescription;", "createServiceFeeDescription", "getExitPointFeeDescription", "feeDescriptions", "isServiceFreeDescriptionFixEnabled", "", "mapFeeDescription", "cartCount", "Lkotlin/Pair;", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "Lcom/talabat/darkstores/feature/cart/CartSummary;", "Lcom/talabat/darkstores/feature/cart/CartProductsWithSummary;", "toExitPointData", "Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointData;", "Lcom/talabat/darkstores/feature/cart/CartFragmentData;", "vendor", "Lcom/talabat/feature/darkstoresvendor/domain/model/Vendor;", "CartProductsWithSummary", "com_talabat_NewArchi_darkstores_darkstores"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CartFragmentViewModelKt {
    private static final int CATEGORIES_ROW_COUNT = 3;
    private static final int CATEGORIES_ROW_COUNT_DEFAULT = 2;
    private static final int DESCRIPTIONS_SIZE = 3;
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_DELIVERY = "DeliveryFee";
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_GENERIC = "HowFeesWork";
    @NotNull
    private static final String FEE_DESCRIPTION_TYPE_SERVICE = "ServiceFee";
    @NotNull
    private static final String HOW_IT_WORKS_DESCRIPTION_DELIMITER = "\n\n";
    @NotNull
    private static final String VARIATION_CART_PRODUCT_VIEW_TYPE_COMPACT = "Variation1";
    @NotNull
    private static final String VARIATION_CART_PRODUCT_VIEW_TYPE_COMPACT_WITH_ALERTS = "Variation2";
    @NotNull
    private static final String VARIATION_SHOW_LOW_STOCK_INDICATOR = "Variation1";

    public static final int cartCount(@NotNull Pair<? extends List<Product>, CartSummary> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        int i11 = 0;
        for (Product totalCountWithFreeItems : (Iterable) pair.getFirst()) {
            i11 += totalCountWithFreeItems.getTotalCountWithFreeItems();
        }
        return i11;
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

    private static final List<ExitPointFeeDescription> getExitPointFeeDescription(List<FeeDescription> list, boolean z11) {
        List<ExitPointFeeDescription> list2;
        Object obj;
        List list3;
        boolean z12;
        if (!z11) {
            return mapFeeDescription(list);
        }
        Iterator it = list.iterator();
        while (true) {
            list2 = null;
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
        if (feeDescription != null) {
            String description = feeDescription.getDescription();
            if (description != null) {
                list3 = StringsKt__StringsKt.split$default((CharSequence) description, new String[]{HOW_IT_WORKS_DESCRIPTION_DELIMITER}, false, 0, 6, (Object) null);
            } else {
                list3 = null;
            }
            if (list3 == null || list3.size() != 3) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (!z12) {
                list3 = null;
            }
            if (list3 != null) {
                list2 = CollectionsKt__CollectionsKt.listOf(createHowFeesWorksDescription(feeDescription, list3), createDeliveryFeeDescription(list3), createServiceFeeDescription(list3));
            }
            if (list2 != null) {
                return list2;
            }
        }
        return mapFeeDescription(list);
    }

    private static final List<ExitPointFeeDescription> mapFeeDescription(List<FeeDescription> list) {
        String str;
        String str2;
        Iterable<FeeDescription> iterable = list;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (FeeDescription feeDescription : iterable) {
            String type = feeDescription.getType();
            String name2 = feeDescription.getName();
            if (name2 == null) {
                str = "";
            } else {
                str = name2;
            }
            String description = feeDescription.getDescription();
            if (description == null) {
                str2 = "";
            } else {
                str2 = description;
            }
            arrayList.add(new ExitPointFeeDescription(type, str, str2, feeDescription.getUrl(), feeDescription.getUrlText()));
        }
        return arrayList;
    }

    @NotNull
    public static final ExitPointData toExitPointData(@NotNull CartFragmentData cartFragmentData) {
        Intrinsics.checkNotNullParameter(cartFragmentData, "<this>");
        return toExitPointData(cartFragmentData.getCartProductsWithSummary(), cartFragmentData.getVendor(), cartFragmentData.isServiceFreeDescriptionFixEnabled());
    }

    @NotNull
    public static final ExitPointData toExitPointData(@NotNull Pair<? extends List<Product>, CartSummary> pair, @NotNull Vendor vendor, boolean z11) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(vendor, "vendor");
        Iterable iterable = (Iterable) pair.getFirst();
        int i11 = 10;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Product product = (Product) it.next();
            String id2 = product.getId();
            String sku = product.getSku();
            List<String> categoryIds = product.getCategoryIds();
            String name2 = product.getName();
            String description = product.getDescription();
            String imageUrl = product.getImageUrl();
            int cartCount = product.getCartCount();
            float price = product.getPrice();
            Float previousPrice = product.getPreviousPrice();
            float floatValue = previousPrice != null ? previousPrice.floatValue() : product.getPrice();
            Float absoluteDiscount = product.getAbsoluteDiscount();
            float floatValue2 = absoluteDiscount != null ? absoluteDiscount.floatValue() : 0.0f;
            Iterable<CampaignLabel> appliedCampaigns = product.getAppliedCampaigns();
            ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(appliedCampaigns, i11));
            for (CampaignLabel campaignLabel : appliedCampaigns) {
                arrayList2.add(new ExitPointCampaign(campaignLabel.getCampaignId(), campaignLabel.getCampaignName()));
                it = it;
            }
            arrayList.add(new ExitPointProduct(id2, name2, description, imageUrl, cartCount, price, floatValue, arrayList2, floatValue2, sku, categoryIds));
            it = it;
            i11 = 10;
        }
        List<ExitPointFeeDescription> exitPointFeeDescription = getExitPointFeeDescription(pair.getSecond().getFeeDescriptions(), z11);
        String id3 = pair.getSecond().getId();
        float subtotal = pair.getSecond().getSubtotal();
        float deliveryFee = pair.getSecond().getDeliveryFee();
        Float serviceFee = pair.getSecond().getServiceFee();
        float offerDiscount = pair.getSecond().getOfferDiscount();
        float total = pair.getSecond().getTotal();
        String targetAudience = pair.getSecond().getTargetAudience();
        float absoluteDiscount2 = pair.getSecond().getAbsoluteDiscount();
        float deliveryAbsoluteDiscount = pair.getSecond().getDeliveryAbsoluteDiscount();
        Float deliveryFeeBeforeDiscount = pair.getSecond().getDeliveryFeeBeforeDiscount();
        Iterable appliedCampaigns2 = pair.getSecond().getAppliedCampaigns();
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(appliedCampaigns2, 10));
        for (Iterator it2 = appliedCampaigns2.iterator(); it2.hasNext(); it2 = it2) {
            CampaignLabel campaignLabel2 = (CampaignLabel) it2.next();
            arrayList3.add(new ExitPointCampaign(campaignLabel2.getCampaignId(), campaignLabel2.getCampaignName()));
        }
        return new ExitPointData(arrayList, subtotal, deliveryFee, serviceFee, offerDiscount, total, targetAudience, absoluteDiscount2, deliveryAbsoluteDiscount, deliveryFeeBeforeDiscount, id3, arrayList3, vendor.getVendorId(), (String) null, (String) null, (String) null, exitPointFeeDescription, vendor.getScheduleDeliveryDiscount(), 57344, (DefaultConstructorMarker) null);
    }
}
