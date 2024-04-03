package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import JsonModels.Response.LoyaltyVoucherResponse.LoyaltyVoucherBounds;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003\u001a\n\u0010\u0004\u001a\u00020\u0005*\u00020\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0003¨\u0006\b"}, d2 = {"boundsToMap", "", "", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/Bounds;", "hasBounds", "", "toLoyaltyVoucherBounds", "LJsonModels/Response/LoyaltyVoucherResponse/LoyaltyVoucherBounds;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class BoundsKt {
    @NotNull
    public static final Map<String, String> boundsToMap(@NotNull Bounds bounds) {
        Intrinsics.checkNotNullParameter(bounds, "<this>");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("productIds", CollectionsKt___CollectionsKt.joinToString$default(bounds.getProductIds(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), TuplesKt.to("categoryIds", CollectionsKt___CollectionsKt.joinToString$default(bounds.getCategoryIds(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), TuplesKt.to("skuIds", CollectionsKt___CollectionsKt.joinToString$default(bounds.getSkuIds(), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null)), TuplesKt.to("excludeCategories", String.valueOf(bounds.getExcludeCategories())));
    }

    public static final boolean hasBounds(@NotNull Bounds bounds) {
        boolean z11;
        boolean z12;
        boolean z13;
        Intrinsics.checkNotNullParameter(bounds, "<this>");
        Collection productIds = bounds.getProductIds();
        if (productIds == null || productIds.isEmpty()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            Collection skuIds = bounds.getSkuIds();
            if (skuIds == null || skuIds.isEmpty()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                Collection categoryIds = bounds.getCategoryIds();
                if (categoryIds == null || categoryIds.isEmpty()) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                if (z13) {
                    return false;
                }
            }
        }
        return true;
    }

    @NotNull
    public static final LoyaltyVoucherBounds toLoyaltyVoucherBounds(@NotNull Bounds bounds) {
        Intrinsics.checkNotNullParameter(bounds, "<this>");
        return new LoyaltyVoucherBounds(bounds.getCategoryIds(), bounds.getProductIds(), bounds.getSkuIds(), Boolean.valueOf(bounds.getExcludeCategories()));
    }
}
