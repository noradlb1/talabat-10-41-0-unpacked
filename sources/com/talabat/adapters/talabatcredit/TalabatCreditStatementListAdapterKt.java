package com.talabat.adapters.talabatcredit;

import android.text.Spanned;
import buisnessmodels.TalabatFormatter;
import com.talabat.helpers.TalabatUtils;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0002\u001a\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007¨\u0006\t"}, d2 = {"getCurrencyFormattedText", "Landroid/text/Spanned;", "amount", "", "addOperatorSymbol", "", "getSubstringUntilFirstNumber", "", "source", "com_talabat_talabat_talabat"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class TalabatCreditStatementListAdapterKt {
    /* access modifiers changed from: private */
    public static final Spanned getCurrencyFormattedText(float f11, boolean z11) {
        String formattedCurrency = TalabatFormatter.getInstance().getFormattedCurrency(f11);
        String substringUntilFirstNumber = getSubstringUntilFirstNumber(formattedCurrency);
        String str = "";
        if (f11 <= 0.0f) {
            f11 = Math.abs(f11);
            if (!TalabatUtils.isNullOrEmpty(substringUntilFirstNumber)) {
                substringUntilFirstNumber = StringsKt__StringsJVMKt.replace$default(substringUntilFirstNumber, SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE, "", false, 4, (Object) null);
            }
            if (z11) {
                str = "<b>- </b>";
            }
        } else if (z11) {
            str = "<b>+ </b>";
        }
        String formattedCurrency2 = TalabatFormatter.getInstance().getFormattedCurrency(f11, false);
        Spanned fromHtml = TalabatUtils.fromHtml(substringUntilFirstNumber + str + "<b>" + formattedCurrency2 + "</b>");
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(currencyCode +p…sAmount, false) + \"</b>\")");
        return fromHtml;
    }

    @NotNull
    public static final String getSubstringUntilFirstNumber(@NotNull String str) {
        List list;
        boolean z11;
        Intrinsics.checkNotNullParameter(str, "source");
        List<String> split = new Regex("[0-9]").split(str, 0);
        if (!split.isEmpty()) {
            ListIterator<String> listIterator = split.listIterator(split.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    break;
                }
                if (listIterator.previous().length() == 0) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (!z11) {
                    list = CollectionsKt___CollectionsKt.take(split, listIterator.nextIndex() + 1);
                    break;
                }
            }
            Object[] array = list.toArray(new String[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return ((String[]) array)[0];
        }
        list = CollectionsKt__CollectionsKt.emptyList();
        Object[] array2 = list.toArray(new String[0]);
        Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return ((String[]) array2)[0];
    }
}
