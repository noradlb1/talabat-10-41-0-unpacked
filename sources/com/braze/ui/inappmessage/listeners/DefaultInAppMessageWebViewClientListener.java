package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.appboy.enums.Channel;
import com.braze.Braze;
import com.braze.enums.inappmessage.MessageType;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.outgoing.BrazeProperties;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.utils.InAppMessageWebViewClient;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0011\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageWebViewClientListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageWebViewClientListener;", "()V", "inAppMessageManager", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "getInAppMessageManager", "()Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "onCloseAction", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "url", "", "queryBundle", "Landroid/os/Bundle;", "onCustomEventAction", "onNewsfeedAction", "onOtherUrlAction", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultInAppMessageWebViewClientListener implements IInAppMessageWebViewClientListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HTML_IN_APP_MESSAGE_CUSTOM_EVENT_NAME_KEY = "name";

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageWebViewClientListener$Companion;", "", "()V", "HTML_IN_APP_MESSAGE_CUSTOM_EVENT_NAME_KEY", "", "logHtmlInAppMessageClick", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "queryBundle", "Landroid/os/Bundle;", "parseCustomEventNameFromQueryBundle", "parsePropertiesFromQueryBundle", "Lcom/braze/models/outgoing/BrazeProperties;", "parseUseWebViewFromQueryBundle", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @VisibleForTesting
        public final void logHtmlInAppMessageClick(@NotNull IInAppMessage iInAppMessage, @NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_BUTTON_ID)) {
                IInAppMessageHtml iInAppMessageHtml = (IInAppMessageHtml) iInAppMessage;
                String string = bundle.getString(InAppMessageWebViewClient.QUERY_NAME_BUTTON_ID);
                if (string != null) {
                    iInAppMessageHtml.logButtonClick(string);
                }
            } else if (iInAppMessage.getMessageType() == MessageType.HTML_FULL) {
                iInAppMessage.logClick();
            }
        }

        @JvmStatic
        @VisibleForTesting
        @Nullable
        public final String parseCustomEventNameFromQueryBundle(@NotNull Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            return bundle.getString("name");
        }

        @JvmStatic
        @NotNull
        @VisibleForTesting
        public final BrazeProperties parsePropertiesFromQueryBundle(@NotNull Bundle bundle) {
            boolean z11;
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            BrazeProperties brazeProperties = new BrazeProperties();
            for (String next : bundle.keySet()) {
                if (!Intrinsics.areEqual((Object) next, (Object) "name")) {
                    String string = bundle.getString(next, (String) null);
                    if (string == null || StringsKt__StringsJVMKt.isBlank(string)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        Intrinsics.checkNotNullExpressionValue(next, "key");
                        brazeProperties.addProperty(next, string);
                    }
                }
            }
            return brazeProperties;
        }

        @JvmStatic
        @VisibleForTesting
        public final boolean parseUseWebViewFromQueryBundle(@NotNull IInAppMessage iInAppMessage, @NotNull Bundle bundle) {
            boolean z11;
            boolean z12;
            boolean z13;
            Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
            Intrinsics.checkNotNullParameter(bundle, "queryBundle");
            boolean z14 = true;
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_DEEPLINK)) {
                z12 = Boolean.parseBoolean(bundle.getString(InAppMessageWebViewClient.QUERY_NAME_DEEPLINK));
                z11 = true;
            } else {
                z12 = false;
                z11 = false;
            }
            if (bundle.containsKey(InAppMessageWebViewClient.QUERY_NAME_EXTERNAL_OPEN)) {
                z13 = Boolean.parseBoolean(bundle.getString(InAppMessageWebViewClient.QUERY_NAME_EXTERNAL_OPEN));
                z11 = true;
            } else {
                z13 = false;
            }
            boolean openUriInWebView = iInAppMessage.getOpenUriInWebView();
            if (!z11) {
                return openUriInWebView;
            }
            if (z12 || z13) {
                z14 = false;
            }
            return z14;
        }
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    @JvmStatic
    @VisibleForTesting
    public static final void logHtmlInAppMessageClick(@NotNull IInAppMessage iInAppMessage, @NotNull Bundle bundle) {
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
    }

    @JvmStatic
    @VisibleForTesting
    @Nullable
    public static final String parseCustomEventNameFromQueryBundle(@NotNull Bundle bundle) {
        return Companion.parseCustomEventNameFromQueryBundle(bundle);
    }

    @JvmStatic
    @NotNull
    @VisibleForTesting
    public static final BrazeProperties parsePropertiesFromQueryBundle(@NotNull Bundle bundle) {
        return Companion.parsePropertiesFromQueryBundle(bundle);
    }

    @JvmStatic
    @VisibleForTesting
    public static final boolean parseUseWebViewFromQueryBundle(@NotNull IInAppMessage iInAppMessage, @NotNull Bundle bundle) {
        return Companion.parseUseWebViewFromQueryBundle(iInAppMessage, bundle);
    }

    public void onCloseAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onCloseAction$1.INSTANCE, 7, (Object) null);
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(true);
        getInAppMessageManager().getHtmlInAppMessageActionListener().onCloseClicked(iInAppMessage, str, bundle);
    }

    public void onCustomEventAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        boolean z11;
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onCustomEventAction$1.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onCustomEventAction$2.INSTANCE, 6, (Object) null);
        } else if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onCustomEventFired(iInAppMessage, str, bundle)) {
            Companion companion = Companion;
            String parseCustomEventNameFromQueryBundle = companion.parseCustomEventNameFromQueryBundle(bundle);
            if (parseCustomEventNameFromQueryBundle == null || StringsKt__StringsJVMKt.isBlank(parseCustomEventNameFromQueryBundle)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                BrazeProperties parsePropertiesFromQueryBundle = companion.parsePropertiesFromQueryBundle(bundle);
                Activity activity = getInAppMessageManager().getActivity();
                if (activity != null) {
                    Braze.Companion.getInstance(activity).logCustomEvent(parseCustomEventNameFromQueryBundle, parsePropertiesFromQueryBundle);
                }
            }
        }
    }

    public void onNewsfeedAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onNewsfeedAction$1.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onNewsfeedAction$2.INSTANCE, 6, (Object) null);
            return;
        }
        Companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        if (!getInAppMessageManager().getHtmlInAppMessageActionListener().onNewsfeedClicked(iInAppMessage, str, bundle)) {
            iInAppMessage.setAnimateOut(false);
            getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
            NewsfeedAction newsfeedAction = new NewsfeedAction(BundleUtils.toBundle(iInAppMessage.getExtras()), Channel.INAPP_MESSAGE);
            Activity activity = getInAppMessageManager().getActivity();
            if (activity != null) {
                BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, newsfeedAction);
            }
        }
    }

    public void onOtherUrlAction(@NotNull IInAppMessage iInAppMessage, @NotNull String str, @NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(bundle, "queryBundle");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageWebViewClientListener$onOtherUrlAction$1.INSTANCE, 7, (Object) null);
        if (getInAppMessageManager().getActivity() == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$2(str), 6, (Object) null);
            return;
        }
        Companion companion = Companion;
        companion.logHtmlInAppMessageClick(iInAppMessage, bundle);
        if (getInAppMessageManager().getHtmlInAppMessageActionListener().onOtherUrlAction(iInAppMessage, str, bundle)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$3(str), 6, (Object) null);
            return;
        }
        boolean parseUseWebViewFromQueryBundle = companion.parseUseWebViewFromQueryBundle(iInAppMessage, bundle);
        Bundle bundle2 = BundleUtils.toBundle(iInAppMessage.getExtras());
        bundle2.putAll(bundle);
        BrazeDeeplinkHandler.Companion companion2 = BrazeDeeplinkHandler.Companion;
        UriAction createUriActionFromUrlString = companion2.getInstance().createUriActionFromUrlString(str, bundle2, parseUseWebViewFromQueryBundle, Channel.INAPP_MESSAGE);
        if (createUriActionFromUrlString == null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$4(str), 6, (Object) null);
            return;
        }
        Uri uri = createUriActionFromUrlString.getUri();
        if (BrazeFileUtils.isLocalUri(uri)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) new DefaultInAppMessageWebViewClientListener$onOtherUrlAction$5(uri, str), 6, (Object) null);
            return;
        }
        iInAppMessage.setAnimateOut(false);
        getInAppMessageManager().hideCurrentlyDisplayingInAppMessage(false);
        Activity activity = getInAppMessageManager().getActivity();
        if (activity != null) {
            companion2.getInstance().gotoUri(activity, createUriActionFromUrlString);
        }
    }
}
