package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemSubTotalViewPort;
import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.talabatcommon.extentions.BroadcastsKt;
import com.talabat.talabatcommon.extentions.RxKt;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u001e\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00010\u00012\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a \u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\n2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u000f\u001a\u001a\u0010\u0010\u001a\u00020\f2\u0010\u0010\r\u001a\f\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u000fH\u0002\u001a2\u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\n\u0012\u000e\u0012\f\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u000f0\u0013\u001a\u0017\u0010\u0014\u001a\u00020\u00042\b\u0010\u0015\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0002\u0010\u0016\u001a\f\u0010\u0017\u001a\u00020\u0018*\u00020\u0019H\u0007\u001a\f\u0010\u001a\u001a\u00020\u0018*\u00020\u0019H\u0007\u001a\f\u0010\u001b\u001a\u00020\u0018*\u00020\u0019H\u0007\u001a\f\u0010\u001c\u001a\u00020\u0018*\u00020\u0019H\u0007\u001a\u0014\u0010\u001d\u001a\u00020\u0018*\u00020\u00192\u0006\u0010\u001e\u001a\u00020\nH\u0007\u001a\u001c\u0010\u001f\u001a\n \u0006*\u0004\u0018\u00010\u00010\u0001*\u00020\b2\u0006\u0010 \u001a\u00020\nH\u0002\u001a\u0016\u0010!\u001a\u00020\u0001*\f\u0012\u0004\u0012\u00020\b0\u000ej\u0002`\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"ACTION_UPDATE_SUBTOTAL", "", "KEY_SUBTOTAL", "NEXT_TIER", "", "addAmount", "kotlin.jvm.PlatformType", "subTotalTier", "Lcom/talabat/gem/domain/entities/GemTier;", "subTotalAmount", "", "isMaximumTierReached", "", "tiers", "", "Lcom/talabat/gem/domain/entities/GemTiers;", "isNotValidTiers", "nextGemTier", "data", "Lkotlin/Triple;", "nextTierIndex", "selectedTierIndex", "(Ljava/lang/Integer;)I", "bindCurrency", "", "Lcom/talabat/gem/ports/presentation/GemSubTotalViewPort;", "bindSubTitleLineOne", "bindSubTitleLineTwo", "bindSubTotalVisibility", "onUpdateSubTotal", "amount", "subTotalAfterDiscount", "subTotal", "toCurrency", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemSubTotalBusinessRulesKt {
    @NotNull
    public static final String ACTION_UPDATE_SUBTOTAL = "com.talabat.gem.domain.usecases.ACTION_UPDATE_SUBTOTAL";
    @NotNull
    public static final String KEY_SUBTOTAL = "com.talabat.gem.domain.usecases.KEY_SUBTOTAL";
    private static final int NEXT_TIER = 1;

    public static final String addAmount(@NotNull GemTier gemTier, double d11) {
        double d12;
        Intrinsics.checkNotNullParameter(gemTier, "subTotalTier");
        DecimalFormat decimalFormat = BusinessRulesKt.getDecimalFormat();
        Double onTotalAmount = gemTier.getOnTotalAmount();
        if (onTotalAmount != null) {
            d12 = onTotalAmount.doubleValue();
        } else {
            d12 = 0.0d;
        }
        return decimalFormat.format(RangesKt___RangesKt.coerceAtLeast(d12 - d11, 0.0d));
    }

    @BusinessRules
    public static final void bindCurrency(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
        Intrinsics.checkNotNullParameter(gemSubTotalViewPort, "<this>");
        gemSubTotalViewPort.autoDispose(new GemSubTotalBusinessRulesKt$bindCurrency$1(gemSubTotalViewPort));
    }

    @BusinessRules
    public static final void bindSubTitleLineOne(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
        Intrinsics.checkNotNullParameter(gemSubTotalViewPort, "<this>");
        gemSubTotalViewPort.autoDispose(new GemSubTotalBusinessRulesKt$bindSubTitleLineOne$1(gemSubTotalViewPort));
    }

    @BusinessRules
    public static final void bindSubTitleLineTwo(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
        Intrinsics.checkNotNullParameter(gemSubTotalViewPort, "<this>");
        gemSubTotalViewPort.autoDispose(new GemSubTotalBusinessRulesKt$bindSubTitleLineTwo$1(gemSubTotalViewPort));
    }

    @BusinessRules
    public static final void bindSubTotalVisibility(@NotNull GemSubTotalViewPort gemSubTotalViewPort) {
        Intrinsics.checkNotNullParameter(gemSubTotalViewPort, "<this>");
        gemSubTotalViewPort.autoDispose(new GemSubTotalBusinessRulesKt$bindSubTotalVisibility$1(gemSubTotalViewPort));
    }

    public static final boolean isMaximumTierReached(double d11, @NotNull List<GemTier> list) {
        double d12;
        Double onTotalAmount;
        Boolean bool;
        Intrinsics.checkNotNullParameter(list, BasketDeliveryFeeTiersInfoKeys.KEY_BASKET_DELIVERY_FREE_TIERS);
        if (BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            GemTier gemTier = (GemTier) CollectionsKt___CollectionsKt.lastOrNull(list);
            if (gemTier != null) {
                bool = Boolean.valueOf(BusinessRulesKt.reachPercentage(gemTier, d11));
            } else {
                bool = null;
            }
            return BooleanKt.orFalse(bool);
        }
        GemTier gemTier2 = (GemTier) CollectionsKt___CollectionsKt.lastOrNull(list);
        if (gemTier2 == null || (onTotalAmount = gemTier2.getOnTotalAmount()) == null) {
            d12 = 0.0d;
        } else {
            d12 = onTotalAmount.doubleValue();
        }
        if (d11 >= d12) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public static final boolean isNotValidTiers(List<GemTier> list) {
        Collection collection = list;
        return collection == null || collection.isEmpty();
    }

    @NotNull
    public static final GemTier nextGemTier(double d11, @NotNull Triple<String, Double, ? extends List<GemTier>> triple) {
        Intrinsics.checkNotNullParameter(triple, "data");
        GemTier gemTier = (GemTier) CollectionsKt___CollectionsKt.getOrNull((List) triple.getThird(), nextTierIndex(BusinessRulesKt.selectedTierIndex(Double.valueOf(d11), new GemSubTotalBusinessRulesKt$nextGemTier$1(triple))));
        if (gemTier == null) {
            return (GemTier) CollectionsKt___CollectionsKt.last((List) triple.getThird());
        }
        return gemTier;
    }

    private static final int nextTierIndex(Integer num) {
        return (num != null ? num.intValue() : -1) + 1;
    }

    @BusinessRules
    public static final void onUpdateSubTotal(@NotNull GemSubTotalViewPort gemSubTotalViewPort, double d11) {
        Intrinsics.checkNotNullParameter(gemSubTotalViewPort, "<this>");
        RxKt.plusAssign(gemSubTotalViewPort.getSubTotal(), Double.valueOf(d11));
        BroadcastsKt.sendBroadcast(ACTION_UPDATE_SUBTOTAL, TuplesKt.to(KEY_SUBTOTAL, Double.valueOf(d11)));
    }

    /* access modifiers changed from: private */
    public static final String subTotalAfterDiscount(GemTier gemTier, double d11) {
        return BusinessRulesKt.getDecimalFormat().format(d11 - BusinessRulesKt.savedAmount(gemTier));
    }

    /* access modifiers changed from: private */
    public static final String toCurrency(List<GemTier> list) {
        ArrayList arrayList = new ArrayList();
        for (GemTier currency : list) {
            String currency2 = currency.getCurrency();
            if (currency2 != null) {
                arrayList.add(currency2);
            }
        }
        String str = (String) CollectionsKt___CollectionsKt.firstOrNull(arrayList);
        if (str == null) {
            return "";
        }
        return str;
    }
}
