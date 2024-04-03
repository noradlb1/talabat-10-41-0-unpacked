package com.talabat.gem.domain.usecases;

import com.talabat.gem.domain.entities.GemTier;
import com.talabat.gem.ports.presentation.GemDiscountViewPort;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import com.talabat.talabatcommon.extentions.DoubleKt;
import com.talabat.talabatcommon.extentions.FloatKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0001\u001a\f\u0010\u0005\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\b\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\f\u0010\t\u001a\u00020\u0006*\u00020\u0007H\u0007\u001a\u0019\u0010\n\u001a\u0004\u0018\u00010\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"formatDiscountText", "", "amount", "", "currency", "bindDiscountAmount", "", "Lcom/talabat/gem/ports/presentation/GemDiscountViewPort;", "bindDiscountText", "bindDiscountVisibility", "toSavedAmount", "Lcom/talabat/gem/domain/entities/GemTier;", "subTotal", "(Lcom/talabat/gem/domain/entities/GemTier;D)Ljava/lang/Double;", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemDiscountBusinessRulesKt {
    @BusinessRules
    public static final void bindDiscountAmount(@NotNull GemDiscountViewPort gemDiscountViewPort) {
        Intrinsics.checkNotNullParameter(gemDiscountViewPort, "<this>");
        gemDiscountViewPort.autoDispose(new GemDiscountBusinessRulesKt$bindDiscountAmount$1(gemDiscountViewPort));
    }

    @BusinessRules
    public static final void bindDiscountText(@NotNull GemDiscountViewPort gemDiscountViewPort) {
        Intrinsics.checkNotNullParameter(gemDiscountViewPort, "<this>");
        gemDiscountViewPort.autoDispose(new GemDiscountBusinessRulesKt$bindDiscountText$1(gemDiscountViewPort));
    }

    @BusinessRules
    public static final void bindDiscountVisibility(@NotNull GemDiscountViewPort gemDiscountViewPort) {
        Intrinsics.checkNotNullParameter(gemDiscountViewPort, "<this>");
        gemDiscountViewPort.autoDispose(new GemDiscountBusinessRulesKt$bindDiscountVisibility$1(gemDiscountViewPort));
    }

    @NotNull
    @BusinessRules
    public static final String formatDiscountText(double d11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "currency");
        String format = BusinessRulesKt.getDecimalFormat().format(d11);
        return SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE + str + " " + format;
    }

    @Nullable
    public static final Double toSavedAmount(@NotNull GemTier gemTier, double d11) {
        double d12;
        Intrinsics.checkNotNullParameter(gemTier, "<this>");
        if (BusinessRulesKt.isPercentage(BusinessRulesKt.getGemPercentageVariant())) {
            return Double.valueOf(RangesKt___RangesKt.coerceAtMost(d11 * ((double) FloatKt.orZero(gemTier.getDiscountPercentage())), DoubleKt.orZero(gemTier.getOnTotalAmount())));
        }
        Double onTotalAmount = gemTier.getOnTotalAmount();
        if (onTotalAmount == null) {
            return null;
        }
        double doubleValue = onTotalAmount.doubleValue();
        Double payOnlyAmount = gemTier.getPayOnlyAmount();
        if (payOnlyAmount != null) {
            d12 = payOnlyAmount.doubleValue();
        } else {
            d12 = 0.0d;
        }
        return Double.valueOf(doubleValue - d12);
    }
}
