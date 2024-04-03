package com.talabat.talabatcommon.utils;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import androidx.core.content.ContextCompat;
import com.talabat.configuration.tcs.TermsAndConditionsConfig;
import com.talabat.localization.R;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatnavigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/talabat/talabatcommon/utils/PrivacyPolicyConsentTextBuilder;", "", "()V", "createPrivacyPolicyConsentText", "", "context", "Landroid/content/Context;", "termsAndConditionsConfig", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "redirectToWebViewScreen", "", "url", "", "pageTitle", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyPolicyConsentTextBuilder {
    @NotNull
    public static final PrivacyPolicyConsentTextBuilder INSTANCE = new PrivacyPolicyConsentTextBuilder();

    private PrivacyPolicyConsentTextBuilder() {
    }

    /* access modifiers changed from: private */
    public final void redirectToWebViewScreen(Context context, String str, String str2) {
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(Navigator.Companion, context, str2, str);
    }

    @NotNull
    public final CharSequence createPrivacyPolicyConsentText(@NotNull Context context, @NotNull TermsAndConditionsConfig termsAndConditionsConfig) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(termsAndConditionsConfig, "termsAndConditionsConfig");
        String string = context.getString(R.string.privacy_policy_consent_message);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta…y_policy_consent_message)");
        String string2 = context.getString(R.string.terms_of_use_consent_message);
        Intrinsics.checkNotNullExpressionValue(string2, "context.getString(com.ta…s_of_use_consent_message)");
        String string3 = context.getString(R.string.social_registration_consent_message, new Object[]{string, string2});
        Intrinsics.checkNotNullExpressionValue(string3, "context.getString(com.ta…rivacyPolicy, termsOfUse)");
        SpannableString spannableString = new SpannableString(string3);
        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) string3, string, 0, false, 6, (Object) null);
        int length = string.length() + indexOf$default;
        int indexOf$default2 = StringsKt__StringsKt.indexOf$default((CharSequence) string3, string2, 0, false, 6, (Object) null);
        int length2 = string2.length() + indexOf$default2;
        int color = ContextCompat.getColor(context, com.designsystem.marshmallow.R.color.ds_primary_100);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(color);
        spannableString.setSpan(foregroundColorSpan, indexOf$default, length, 33);
        spannableString.setSpan(foregroundColorSpan, indexOf$default2, length2, 33);
        PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1 privacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1 = new PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1(context, termsAndConditionsConfig, color);
        PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$termsClickableSpan$1 privacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$termsClickableSpan$1 = new PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$termsClickableSpan$1(context, termsAndConditionsConfig, color);
        spannableString.setSpan(privacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1, indexOf$default, length, 33);
        spannableString.setSpan(privacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$termsClickableSpan$1, indexOf$default2, length2, 33);
        return spannableString;
    }
}
