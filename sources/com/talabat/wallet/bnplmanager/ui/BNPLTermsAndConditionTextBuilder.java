package com.talabat.wallet.bnplmanager.ui;

import android.content.Context;
import android.text.SpannableString;
import androidx.core.content.ContextCompat;
import com.talabat.localization.R;
import com.talabat.talabatnavigation.legacyTalabat.LegacyTalabatActions;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b¨\u0006\n"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLTermsAndConditionTextBuilder;", "", "()V", "createBNPLTermsAndConditionTextBuilder", "", "context", "Landroid/content/Context;", "termsAndConditionUrl", "", "pageTitle", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLTermsAndConditionTextBuilder {
    @NotNull
    public static final BNPLTermsAndConditionTextBuilder INSTANCE = new BNPLTermsAndConditionTextBuilder();

    private BNPLTermsAndConditionTextBuilder() {
    }

    @NotNull
    public final CharSequence createBNPLTermsAndConditionTextBuilder(@NotNull Context context, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "termsAndConditionUrl");
        Intrinsics.checkNotNullParameter(str2, LegacyTalabatActions.EXTRA_MAIN_FAQ_SCREEN_TITLE);
        String string = context.getString(R.string.payment_terms_and_condition);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(\n     …s_and_condition\n        )");
        String string2 = context.getString(R.string.terms_and_conditions);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.ta…ing.terms_and_conditions)");
        SpannableString spannableString = new SpannableString(string + " " + string2);
        int color = ContextCompat.getColor(context, com.designsystem.marshmallow.R.color.ds_primary_100);
        spannableString.setSpan(Integer.valueOf(color), string.length(), spannableString.length(), 0);
        spannableString.setSpan(new BNPLTermsAndConditionTextBuilder$createBNPLTermsAndConditionTextBuilder$termsClickableSpan$1(context, str2, str, color), string.length() + 1, spannableString.length(), 33);
        return spannableString;
    }
}
