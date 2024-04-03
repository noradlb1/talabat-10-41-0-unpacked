package com.talabat.gem.domain.usecases;

import com.talabat.gem.ports.presentation.GemEntryViewPort;
import com.talabat.localization.R;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\f\u0010\u0002\u001a\u00020\u0003*\u00020\u0004H\u0007\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\b\u001a\u00020\u0006*\u00020\u0007\u001a\n\u0010\t\u001a\u00020\u0006*\u00020\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"PERCENTAGE", "", "bindSaveUpToAmountText", "", "Lcom/talabat/gem/ports/presentation/GemEntryViewPort;", "getBrandingMessage", "", "Lcom/talabat/gem/domain/usecases/SaveUpToAmountText;", "getOrganicListingMessage", "getTitle", "com_talabat_Components_gem-core_gem-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemEntryBusinessRulesKt {
    public static final int PERCENTAGE = 100;

    @BusinessRules
    public static final void bindSaveUpToAmountText(@NotNull GemEntryViewPort gemEntryViewPort) {
        Intrinsics.checkNotNullParameter(gemEntryViewPort, "<this>");
        gemEntryViewPort.autoDispose(new GemEntryBusinessRulesKt$bindSaveUpToAmountText$1(gemEntryViewPort));
    }

    @NotNull
    public static final String getBrandingMessage(@NotNull SaveUpToAmountText saveUpToAmountText) {
        Intrinsics.checkNotNullParameter(saveUpToAmountText, "<this>");
        if (!BusinessRulesKt.getEnableGemWordingFromServer()) {
            return DynamicLocalizationKt.toLocalizedString$default(R.string.gem_active_sub_title, (String) null, 1, (Object) null);
        }
        String brandingMessage = saveUpToAmountText.getBrandingMessage();
        if (brandingMessage == null) {
            return "";
        }
        return brandingMessage;
    }

    @NotNull
    public static final String getOrganicListingMessage(@NotNull SaveUpToAmountText saveUpToAmountText) {
        Intrinsics.checkNotNullParameter(saveUpToAmountText, "<this>");
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_organic_listing_message, (String) null, 1, (Object) null), "{saveAmount}", saveUpToAmountText.getSaveAmount(), false, 4, (Object) null), "{currency}", saveUpToAmountText.getCurrency(), false, 4, (Object) null);
    }

    @NotNull
    public static final String getTitle(@NotNull SaveUpToAmountText saveUpToAmountText) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(saveUpToAmountText, "<this>");
        if (BusinessRulesKt.getEnableGemWordingFromServer()) {
            String collectionTitle = saveUpToAmountText.getCollectionTitle();
            if (collectionTitle == null) {
                return "";
            }
            return collectionTitle;
        } else if (BusinessRulesKt.isPercentageWithoutProgressBarVariantA(BusinessRulesKt.getGemPercentageVariant())) {
            String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_title_variant_a, (String) null, 1, (Object) null);
            String discount = saveUpToAmountText.getDiscount();
            if (discount == null) {
                str2 = "";
            } else {
                str2 = discount;
            }
            return StringsKt__StringsJVMKt.replace$default(localizedString$default, "{percentage}", str2, false, 4, (Object) null);
        } else if (!BusinessRulesKt.isPercentageWithProgressBarVariantB(BusinessRulesKt.getGemPercentageVariant())) {
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_swimlane_title, (String) null, 1, (Object) null), "{saveAmount}", saveUpToAmountText.getSaveAmount(), false, 4, (Object) null), "{currency}", saveUpToAmountText.getCurrency(), false, 4, (Object) null);
        } else {
            String localizedString$default2 = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_title_variant_b, (String) null, 1, (Object) null);
            String discount2 = saveUpToAmountText.getDiscount();
            if (discount2 == null) {
                str = "";
            } else {
                str = discount2;
            }
            return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(localizedString$default2, "{percentage}", str, false, 4, (Object) null), "{saveAmount}", saveUpToAmountText.getSaveAmount(), false, 4, (Object) null), "{currency}", saveUpToAmountText.getCurrency(), false, 4, (Object) null);
        }
    }
}
