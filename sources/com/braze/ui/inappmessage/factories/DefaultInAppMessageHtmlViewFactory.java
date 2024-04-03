package com.braze.ui.inappmessage.factories;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.appboy.ui.R;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.InAppMessageHtml;
import com.braze.support.BrazeLogger;
import com.braze.ui.inappmessage.IInAppMessageViewFactory;
import com.braze.ui.inappmessage.jsinterface.InAppMessageJavascriptInterface;
import com.braze.ui.inappmessage.listeners.IInAppMessageWebViewClientListener;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import com.braze.ui.inappmessage.views.InAppMessageHtmlBaseView;
import com.braze.ui.inappmessage.views.InAppMessageHtmlView;
import com.braze.ui.support.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/inappmessage/factories/DefaultInAppMessageHtmlViewFactory;", "Lcom/braze/ui/inappmessage/IInAppMessageViewFactory;", "inAppMessageWebViewClientListener", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "(Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;)V", "createInAppMessageView", "Lcom/braze/ui/inappmessage/views/InAppMessageHtmlView;", "activity", "Landroid/app/Activity;", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultInAppMessageHtmlViewFactory implements IInAppMessageViewFactory {
    @NotNull
    private final IInAppMessageWebViewClientListener inAppMessageWebViewClientListener;

    public DefaultInAppMessageHtmlViewFactory(@NotNull IInAppMessageWebViewClientListener iInAppMessageWebViewClientListener) {
        Intrinsics.checkNotNullParameter(iInAppMessageWebViewClientListener, "inAppMessageWebViewClientListener");
        this.inAppMessageWebViewClientListener = iInAppMessageWebViewClientListener;
    }

    @Nullable
    @SuppressLint({"AddJavascriptInterface"})
    public InAppMessageHtmlView createInAppMessageView(@NotNull Activity activity, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Context applicationContext = activity.getApplicationContext();
        View inflate = activity.getLayoutInflater().inflate(R.layout.com_braze_inappmessage_html, (ViewGroup) null);
        if (inflate != null) {
            InAppMessageHtmlView inAppMessageHtmlView = (InAppMessageHtmlView) inflate;
            Intrinsics.checkNotNullExpressionValue(applicationContext, "context");
            if (!new BrazeConfigurationProvider(applicationContext).isTouchModeRequiredForHtmlInAppMessages() || !ViewUtils.isDeviceNotInTouchMode(inAppMessageHtmlView)) {
                InAppMessageHtml inAppMessageHtml = (InAppMessageHtml) iInAppMessage;
                InAppMessageJavascriptInterface inAppMessageJavascriptInterface = new InAppMessageJavascriptInterface(applicationContext, inAppMessageHtml);
                InAppMessageHtmlBaseView.setWebViewContent$default(inAppMessageHtmlView, inAppMessageHtml.getMessage(), (String) null, 2, (Object) null);
                Context applicationContext2 = activity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext2, "activity.applicationContext");
                inAppMessageHtmlView.setInAppMessageWebViewClient(new InAppMessageWebViewClient(applicationContext2, inAppMessageHtml, this.inAppMessageWebViewClientListener));
                WebView messageWebView = inAppMessageHtmlView.getMessageWebView();
                if (messageWebView != null) {
                    messageWebView.addJavascriptInterface(inAppMessageJavascriptInterface, InAppMessageHtmlBaseView.BRAZE_BRIDGE_PREFIX);
                }
                return inAppMessageHtmlView;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) DefaultInAppMessageHtmlViewFactory$createInAppMessageView$1.INSTANCE, 6, (Object) null);
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type com.braze.ui.inappmessage.views.InAppMessageHtmlView");
    }
}
