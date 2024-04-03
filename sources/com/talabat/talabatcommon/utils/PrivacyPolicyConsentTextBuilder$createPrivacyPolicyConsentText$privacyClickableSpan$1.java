package com.talabat.talabatcommon.utils;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.talabat.configuration.tcs.TermsAndConditionsConfig;
import com.talabat.localization.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/talabatcommon/utils/PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1 extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f61785b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TermsAndConditionsConfig f61786c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f61787d;

    public PrivacyPolicyConsentTextBuilder$createPrivacyPolicyConsentText$privacyClickableSpan$1(Context context, TermsAndConditionsConfig termsAndConditionsConfig, int i11) {
        this.f61785b = context;
        this.f61786c = termsAndConditionsConfig;
        this.f61787d = i11;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        PrivacyPolicyConsentTextBuilder privacyPolicyConsentTextBuilder = PrivacyPolicyConsentTextBuilder.INSTANCE;
        Context context = this.f61785b;
        String privacyPolicyUrl = this.f61786c.privacyPolicyUrl();
        String string = this.f61785b.getString(R.string.privacy_policy);
        Intrinsics.checkNotNullExpressionValue(string, "context.getString(com.ta….R.string.privacy_policy)");
        privacyPolicyConsentTextBuilder.redirectToWebViewScreen(context, privacyPolicyUrl, string);
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setColor(this.f61787d);
        textPaint.setUnderlineText(false);
    }
}
