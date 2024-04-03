package com.braze.ui;

import android.graphics.Bitmap;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/braze/ui/BrazeWebViewActivity$createWebChromeClient$1", "Landroid/webkit/WebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "onConsoleMessage", "", "cm", "Landroid/webkit/ConsoleMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeWebViewActivity$createWebChromeClient$1 extends WebChromeClient {
    @Nullable
    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public boolean onConsoleMessage(@NotNull ConsoleMessage consoleMessage) {
        Intrinsics.checkNotNullParameter(consoleMessage, "cm");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeWebViewActivity$createWebChromeClient$1$onConsoleMessage$1(consoleMessage), 7, (Object) null);
        return true;
    }
}
