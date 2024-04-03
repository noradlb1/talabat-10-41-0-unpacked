package com.talabat.growth.ui.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.talabat.helpers.GlobalConstants;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\u0004*\u00020\b2\u0006\u0010\t\u001a\u00020\u0001¨\u0006\n"}, d2 = {"decimalFormat", "", "", "openLinkInBrowser", "", "context", "Landroid/content/Context;", "renderContentAsHtml", "Landroid/widget/TextView;", "htmlContent", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ExtentionsKt {
    @NotNull
    public static final String decimalFormat(int i11) {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            DecimalFormat decimalFormat = new DecimalFormat();
            String str = GlobalConstants.commaDecimalPattern;
            Intrinsics.checkNotNullExpressionValue(str, "commaDecimalPattern");
            decimalFormat.applyPattern(str);
            obj = Result.m6329constructorimpl(decimalFormat.format(Integer.valueOf(i11)));
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = "";
        }
        return (String) obj;
    }

    public static final void openLinkInBrowser(@NotNull String str, @NotNull Context context) throws NullPointerException {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        if (!StringsKt__StringsJVMKt.isBlank(str)) {
            context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
            return;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final void renderContentAsHtml(@NotNull TextView textView, @NotNull String str) {
        Spanned spanned;
        Intrinsics.checkNotNullParameter(textView, "<this>");
        Intrinsics.checkNotNullParameter(str, "htmlContent");
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(str, 63);
        } else {
            spanned = Html.fromHtml(str);
        }
        textView.setText(spanned);
    }
}
