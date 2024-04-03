package com.talabat.wallet.helpers;

import android.widget.ImageView;
import com.talabat.R;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import com.talabat.helpers.GlobalConstants;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/helpers/CreditCardHelperInterface;", "", "hasCardExpired", "", "expiryMonth", "", "expiryYear", "setCardTypeIcon", "", "cardType", "imageView", "Landroid/widget/ImageView;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface CreditCardHelperInterface {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static boolean hasCardExpired(@NotNull CreditCardHelperInterface creditCardHelperInterface, @NotNull String str, @NotNull String str2) {
            Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_EXPIRY_MONTH_KEY);
            Intrinsics.checkNotNullParameter(str2, CardTokenizationPlugin.ARG_EXPIRY_YEAR_KEY);
            try {
                String substring = String.valueOf(Calendar.getInstance().get(1)).substring(2);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                int parseInt = Integer.parseInt(substring);
                int i11 = Calendar.getInstance().get(2) + 1;
                if (parseInt > Integer.parseInt(str2)) {
                    return true;
                }
                if (i11 < Integer.parseInt(str) || parseInt != Integer.parseInt(str2)) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
                return true;
            }
        }

        public static void setCardTypeIcon(@NotNull CreditCardHelperInterface creditCardHelperInterface, @Nullable String str, @NotNull ImageView imageView) {
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            if (str != null) {
                String lowerCase = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase()");
                String lowerCase2 = "VISA".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) lowerCase2, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.visa_icon);
                    return;
                }
                String lowerCase3 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase()");
                String lowerCase4 = "MASTERCARD".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase3, (CharSequence) lowerCase4, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.master_card_icon);
                    return;
                }
                String lowerCase5 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase()");
                String lowerCase6 = "AMEX".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase6, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase5, (CharSequence) lowerCase6, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.amex_card_icon);
                    return;
                }
                String lowerCase7 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase7, "this as java.lang.String).toLowerCase()");
                String lowerCase8 = GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_DINERSCLUB.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase8, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase7, (CharSequence) lowerCase8, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_dinersclub);
                    return;
                }
                String lowerCase9 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase9, "this as java.lang.String).toLowerCase()");
                String lowerCase10 = GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_JCB.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase10, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase9, (CharSequence) lowerCase10, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_jcb);
                    return;
                }
                String lowerCase11 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase11, "this as java.lang.String).toLowerCase()");
                String lowerCase12 = "DISCOVER".toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase12, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase11, (CharSequence) lowerCase12, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_discover);
                    return;
                }
                String lowerCase13 = str.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase13, "this as java.lang.String).toLowerCase()");
                String lowerCase14 = GlobalConstants.PAYFORT_CARD_TYPE.TOKEN_CARD_TYPE_MAESTRO.toLowerCase();
                Intrinsics.checkNotNullExpressionValue(lowerCase14, "this as java.lang.String).toLowerCase()");
                if (StringsKt__StringsKt.contains$default((CharSequence) lowerCase13, (CharSequence) lowerCase14, false, 2, (Object) null)) {
                    imageView.setImageResource(R.drawable.bt_ic_maestro);
                } else {
                    imageView.setImageResource(R.drawable.bt_ic_unknown);
                }
            }
        }
    }

    boolean hasCardExpired(@NotNull String str, @NotNull String str2);

    void setCardTypeIcon(@Nullable String str, @NotNull ImageView imageView);
}
