package com.talabat.gem.ports.presentation;

import com.talabat.gem.domain.usecases.BusinessRulesKt;
import com.talabat.localization.R;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0004"}, d2 = {"getSubTitle", "", "Lcom/talabat/gem/ports/presentation/TitleData;", "getTitle", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemOfferTitleViewPortKt {
    @NotNull
    public static final String getSubTitle(@NotNull TitleData titleData) {
        String str;
        Intrinsics.checkNotNullParameter(titleData, "<this>");
        if (BusinessRulesKt.getEnableGemWordingFromServer()) {
            String collectionSubtitle = titleData.getCollectionSubtitle();
            if (collectionSubtitle == null) {
                return "";
            }
            return collectionSubtitle;
        } else if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String format = String.format(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_collection_subtitle_percentage_variant_a, (String) null, 1, (Object) null), "{saveAmount}", titleData.getSavingsAmount(), false, 4, (Object) null), "{currency}", titleData.getCurrency(), false, 4, (Object) null), Arrays.copyOf(new Object[0], 0));
            Intrinsics.checkNotNullExpressionValue(format, "format(format, *args)");
            return format;
        } else if (!BusinessRulesKt.isPercentageWithProgressBarVariantB(BusinessRulesKt.getGemPercentageVariant())) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.gem_collection_subtitle, (String) null, 1, (Object) null);
        } else {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_collection_subtitle_percentage_variant_b, (String) null, 1, (Object) null);
            String discount = titleData.getDiscount();
            if (discount == null) {
                str = "";
            } else {
                str = discount;
            }
            return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{percentage}", str, false, 4, (Object) null);
        }
    }

    @NotNull
    public static final String getTitle(@NotNull TitleData titleData) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(titleData, "<this>");
        if (BusinessRulesKt.getEnableGemWordingFromServer()) {
            String collectionTitle = titleData.getCollectionTitle();
            if (collectionTitle == null) {
                return "";
            }
            return collectionTitle;
        } else if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_title_variant_a, (String) null, 1, (Object) null);
            String discount = titleData.getDiscount();
            if (discount == null) {
                str2 = "";
            } else {
                str2 = discount;
            }
            return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{percentage}", str2, false, 4, (Object) null);
        } else if (!BusinessRulesKt.isPercentageWithProgressBarVariantB(BusinessRulesKt.getGemPercentageVariant())) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null), "{saveAmount}", titleData.getSavingsAmount(), false, 4, (Object) null), "{currency}", titleData.getCurrency(), false, 4, (Object) null);
        } else {
            String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_title_variant_b, (String) null, 1, (Object) null);
            String discount2 = titleData.getDiscount();
            if (discount2 == null) {
                str = "";
            } else {
                str = discount2;
            }
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(localizedString$default2, "{percentage}", str, false, 4, (Object) null), "{saveAmount}", titleData.getSavingsAmount(), false, 4, (Object) null), "{currency}", titleData.getCurrency(), false, 4, (Object) null);
        }
    }
}
