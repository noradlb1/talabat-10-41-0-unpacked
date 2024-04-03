package com.talabat.wallet.bnplmanager.ui;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.talabat.talabatcommon.extentions.LagecyTalabatNavigatorExtKt;
import com.talabat.talabatnavigation.Navigator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/talabat/wallet/bnplmanager/ui/BNPLTermsAndConditionTextBuilder$createBNPLTermsAndConditionTextBuilder$termsClickableSpan$1", "Landroid/text/style/ClickableSpan;", "onClick", "", "widget", "Landroid/view/View;", "updateDrawState", "ds", "Landroid/text/TextPaint;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLTermsAndConditionTextBuilder$createBNPLTermsAndConditionTextBuilder$termsClickableSpan$1 extends ClickableSpan {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12513b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f12514c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f12515d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ int f12516e;

    public BNPLTermsAndConditionTextBuilder$createBNPLTermsAndConditionTextBuilder$termsClickableSpan$1(Context context, String str, String str2, int i11) {
        this.f12513b = context;
        this.f12514c = str;
        this.f12515d = str2;
        this.f12516e = i11;
    }

    public void onClick(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "widget");
        LagecyTalabatNavigatorExtKt.navigateToMainFAQ(Navigator.Companion, this.f12513b, this.f12514c, this.f12515d);
    }

    public void updateDrawState(@NotNull TextPaint textPaint) {
        Intrinsics.checkNotNullParameter(textPaint, "ds");
        super.updateDrawState(textPaint);
        textPaint.setUnderlineText(false);
        textPaint.setColor(this.f12516e);
    }
}
