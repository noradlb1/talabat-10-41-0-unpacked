package com.talabat.gem.adapters.presentation.menu;

import android.graphics.Color;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;
import com.talabat.gem.domain.usecases.SubTotalLineOne;
import com.talabat.gem.domain.usecases.SubTotalLineTwo;
import com.talabat.localization.R;
import com.talabat.talabatcommon.helpers.DynamicLocalizationKt;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0007H\u0007\u001a\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H\u0002\u001a\u0014\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\f"}, d2 = {"subTotalAfterDiscountColor", "", "line", "Lcom/talabat/gem/domain/usecases/SubTotalLineOne;", "subTotalAfterDiscountText", "", "subTotalLineTwoText", "Lcom/talabat/gem/domain/usecases/SubTotalLineTwo;", "subTotalText", "formattedSubTotalText", "Landroid/text/SpannableString;", "Lcom/talabat/gem/adapters/presentation/menu/GemMenuFooterView;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class GemMenuFooterViewKt {
    /* access modifiers changed from: private */
    public static final SpannableString formattedSubTotalText(GemMenuFooterView gemMenuFooterView, SubTotalLineOne subTotalLineOne) {
        String subTotalText = subTotalText(subTotalLineOne);
        SpannableString spannableString = new SpannableString(subTotalText);
        if (subTotalLineOne.getStrikeThrough()) {
            spannableString.setSpan(new StrikethroughSpan(), 0, subTotalText.length(), 33);
            spannableString.setSpan(new ForegroundColorSpan(-7829368), 0, subTotalText.length(), 33);
        }
        return spannableString;
    }

    /* access modifiers changed from: private */
    public static final int subTotalAfterDiscountColor(SubTotalLineOne subTotalLineOne) {
        if (subTotalLineOne.getSubTotalAfterDiscountColor() == null) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        return Color.parseColor(subTotalLineOne.getSubTotalAfterDiscountColor());
    }

    /* access modifiers changed from: private */
    public static final String subTotalAfterDiscountText(SubTotalLineOne subTotalLineOne) {
        if (subTotalLineOne.getSubTotalAfterDiscount() == null) {
            return null;
        }
        String localizedString$default = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_footer_sub_total, (String) null, 1, (Object) null);
        String subTotalAfterDiscount = subTotalLineOne.getSubTotalAfterDiscount();
        if (subTotalAfterDiscount == null) {
            subTotalAfterDiscount = "";
        }
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(localizedString$default, "{subTotal}", subTotalAfterDiscount, false, 4, (Object) null), "{currency}", subTotalLineOne.getCurrency(), false, 4, (Object) null);
    }

    @NotNull
    @VisibleForTesting
    public static final String subTotalLineTwoText(@NotNull SubTotalLineTwo subTotalLineTwo) {
        String str;
        Intrinsics.checkNotNullParameter(subTotalLineTwo, Constants.LINE);
        if (subTotalLineTwo.getMaximumTierReached()) {
            str = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_footer_max_tier_hint, (String) null, 1, (Object) null);
        } else {
            str = DynamicLocalizationKt.toLocalizedString$default(R.string.gem_footer_subtotal_hint, (String) null, 1, (Object) null);
        }
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(str, "{addAmount}", subTotalLineTwo.getAddAmount(), false, 4, (Object) null), "{currency}", subTotalLineTwo.getCurrency(), false, 4, (Object) null), "{saveAmount}", subTotalLineTwo.getSaveAmount(), false, 4, (Object) null);
    }

    private static final String subTotalText(SubTotalLineOne subTotalLineOne) {
        return StringsKt__StringsJVMKt.replace$default(StringsKt__StringsJVMKt.replace$default(DynamicLocalizationKt.toLocalizedString$default(R.string.gem_footer_sub_total, (String) null, 1, (Object) null), "{subTotal}", subTotalLineOne.getSubTotal(), false, 4, (Object) null), "{currency}", subTotalLineOne.getCurrency(), false, 4, (Object) null);
    }
}
