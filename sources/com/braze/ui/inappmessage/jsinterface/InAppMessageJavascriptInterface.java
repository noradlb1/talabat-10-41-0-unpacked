package com.braze.ui.inappmessage.jsinterface;

import android.content.Context;
import android.webkit.JavascriptInterface;
import androidx.annotation.VisibleForTesting;
import com.braze.Braze;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeLogger;
import com.braze.support.PermissionUtils;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.google.android.gms.ads.AdError;
import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001a\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u0012\u001a\u00020\fH\u0007J\u001c\u0010\u0013\u001a\u00020\f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0007J6\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0007J\u0014\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000eH\u0007J\b\u0010\u001f\u001a\u00020\fH\u0007J\b\u0010 \u001a\u00020\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0007\u001a\u00020\b8G¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006!"}, d2 = {"Lcom/braze/ui/inappmessage/jsinterface/InAppMessageJavascriptInterface;", "", "context", "Landroid/content/Context;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessageHtml;", "(Landroid/content/Context;Lcom/braze/models/inappmessage/IInAppMessageHtml;)V", "user", "Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "getUser", "()Lcom/braze/ui/inappmessage/jsinterface/InAppMessageUserJavascriptInterface;", "changeUser", "", "userId", "", "sdkAuthSignature", "logButtonClick", "buttonId", "logClick", "logCustomEventWithJSON", "eventName", "propertiesJSON", "logPurchaseWithJSON", "productId", "price", "", "currencyCode", "quantity", "", "parseProperties", "Lcom/braze/models/outgoing/BrazeProperties;", "requestImmediateDataFlush", "requestPushPermission", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class InAppMessageJavascriptInterface {
    @NotNull
    private final Context context;
    @NotNull
    private final IInAppMessageHtml inAppMessage;
    @NotNull
    private final InAppMessageUserJavascriptInterface user;

    public InAppMessageJavascriptInterface(@NotNull Context context2, @NotNull IInAppMessageHtml iInAppMessageHtml) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(iInAppMessageHtml, "inAppMessage");
        this.context = context2;
        this.inAppMessage = iInAppMessageHtml;
        this.user = new InAppMessageUserJavascriptInterface(context2);
    }

    @JavascriptInterface
    public final void changeUser(@NotNull String str, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Braze.Companion.getInstance(this.context).changeUser(str, str2);
    }

    @JavascriptInterface
    @NotNull
    public final InAppMessageUserJavascriptInterface getUser() {
        return this.user;
    }

    @JavascriptInterface
    public final void logButtonClick(@Nullable String str) {
        if (str != null) {
            this.inAppMessage.logButtonClick(str);
        }
    }

    @JavascriptInterface
    public final void logClick() {
        this.inAppMessage.logClick();
    }

    @JavascriptInterface
    public final void logCustomEventWithJSON(@Nullable String str, @Nullable String str2) {
        Braze.Companion.getInstance(this.context).logCustomEvent(str, parseProperties(str2));
    }

    @JavascriptInterface
    public final void logPurchaseWithJSON(@Nullable String str, double d11, @Nullable String str2, int i11, @Nullable String str3) {
        String str4 = str;
        String str5 = str2;
        Braze.Companion.getInstance(this.context).logPurchase(str4, str5, new BigDecimal(String.valueOf(d11)), i11, parseProperties(str3));
    }

    @VisibleForTesting
    @Nullable
    public final BrazeProperties parseProperties(@Nullable String str) {
        if (str == null) {
            return null;
        }
        try {
            if (Intrinsics.areEqual((Object) str, (Object) AdError.UNDEFINED_DOMAIN) || Intrinsics.areEqual((Object) str, (Object) "null")) {
                return null;
            }
            return new BrazeProperties(new JSONObject(str));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new InAppMessageJavascriptInterface$parseProperties$1(str), 4, (Object) null);
            return null;
        }
    }

    @JavascriptInterface
    public final void requestImmediateDataFlush() {
        Braze.Companion.getInstance(this.context).requestImmediateDataFlush();
    }

    @JavascriptInterface
    public final void requestPushPermission() {
        BrazeInAppMessageManager.Companion companion = BrazeInAppMessageManager.Companion;
        companion.getInstance().setShouldNextUnregisterBeSkipped(true);
        PermissionUtils.requestPushPermissionPrompt(companion.getInstance().getActivity());
    }
}
