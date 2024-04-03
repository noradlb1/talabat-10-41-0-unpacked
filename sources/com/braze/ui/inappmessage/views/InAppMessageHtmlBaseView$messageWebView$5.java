package com.braze.ui.inappmessage.views;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/braze/ui/inappmessage/views/InAppMessageHtmlBaseView$messageWebView$5", "Landroid/webkit/WebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "onConsoleMessage", "", "cm", "Landroid/webkit/ConsoleMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageHtmlBaseView$messageWebView$5 extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ InAppMessageHtmlBaseView f44168a;

    public InAppMessageHtmlBaseView$messageWebView$5(InAppMessageHtmlBaseView inAppMessageHtmlBaseView) {
        this.f44168a = inAppMessageHtmlBaseView;
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public boolean onConsoleMessage(@NotNull ConsoleMessage consoleMessage) {
        Intrinsics.checkNotNullParameter(consoleMessage, "cm");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f44168a, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new InAppMessageHtmlBaseView$messageWebView$5$onConsoleMessage$1(consoleMessage), 7, (Object) null);
        return true;
    }
}
