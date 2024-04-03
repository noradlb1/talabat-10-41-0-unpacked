package com.braze.push.support;

import android.os.Build;
import android.text.Html;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"TAG", "", "getHtmlSpannedTextIfEnabled", "", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "android-sdk-ui_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
@JvmName(name = "HtmlUtils")
public final class HtmlUtils {
    @NotNull
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("HtmlUtils");

    @NotNull
    public static final CharSequence getHtmlSpannedTextIfEnabled(@NotNull String str, @NotNull BrazeConfigurationProvider brazeConfigurationProvider) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        if (StringsKt__StringsJVMKt.isBlank(str)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) HtmlUtils$getHtmlSpannedTextIfEnabled$1.INSTANCE, 14, (Object) null);
            return str;
        }
        CharSequence charSequence2 = str;
        if (brazeConfigurationProvider.isPushNotificationHtmlRenderingEnabled()) {
            if (Build.VERSION.SDK_INT >= 24) {
                charSequence = Html.fromHtml(str, 0);
            } else {
                charSequence = Html.fromHtml(str);
            }
            Intrinsics.checkNotNullExpressionValue(charSequence, "{\n        if (Build.VERS…tml(this)\n        }\n    }");
            charSequence2 = charSequence;
        }
        return charSequence2;
    }
}
