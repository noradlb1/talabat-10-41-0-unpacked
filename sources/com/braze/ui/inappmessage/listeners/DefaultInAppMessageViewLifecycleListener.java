package com.braze.ui.inappmessage.listeners;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.View;
import com.appboy.enums.Channel;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.enums.inappmessage.ClickAction;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.models.inappmessage.IInAppMessageHtml;
import com.braze.models.inappmessage.IInAppMessageImmersive;
import com.braze.models.inappmessage.MessageButton;
import com.braze.support.BrazeFunctionNotImplemented;
import com.braze.support.BrazeLogger;
import com.braze.support.BundleUtils;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.inappmessage.BrazeInAppMessageManager;
import com.braze.ui.inappmessage.InAppMessageCloser;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J \u0010\u0017\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u0018\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\nH\u0016J2\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J \u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\"\u001a\u00020\bH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006#"}, d2 = {"Lcom/braze/ui/inappmessage/listeners/DefaultInAppMessageViewLifecycleListener;", "Lcom/braze/ui/inappmessage/listeners/IInAppMessageViewLifecycleListener;", "()V", "inAppMessageManager", "Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "getInAppMessageManager", "()Lcom/braze/ui/inappmessage/BrazeInAppMessageManager;", "afterClosed", "", "inAppMessage", "Lcom/braze/models/inappmessage/IInAppMessage;", "afterOpened", "inAppMessageView", "Landroid/view/View;", "beforeClosed", "beforeOpened", "onButtonClicked", "inAppMessageCloser", "Lcom/braze/ui/inappmessage/InAppMessageCloser;", "messageButton", "Lcom/braze/models/inappmessage/MessageButton;", "inAppMessageImmersive", "Lcom/braze/models/inappmessage/IInAppMessageImmersive;", "onClicked", "onDismissed", "performClickAction", "clickAction", "Lcom/braze/enums/inappmessage/ClickAction;", "clickUri", "Landroid/net/Uri;", "openUriInWebview", "", "performInAppMessageButtonClicked", "performInAppMessageClicked", "startClearHtmlInAppMessageAssetsThread", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultInAppMessageViewLifecycleListener implements IInAppMessageViewLifecycleListener {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClickAction.values().length];
            iArr[ClickAction.NEWS_FEED.ordinal()] = 1;
            iArr[ClickAction.URI.ordinal()] = 2;
            iArr[ClickAction.NONE.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final BrazeInAppMessageManager getInAppMessageManager() {
        return BrazeInAppMessageManager.Companion.getInstance();
    }

    private final void performClickAction(ClickAction clickAction, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser, Uri uri, boolean z11) {
        Activity activity = getInAppMessageManager().getActivity();
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$1.INSTANCE, 6, (Object) null);
            return;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[clickAction.ordinal()];
        if (i11 == 1) {
            inAppMessageCloser.close(false);
            BrazeDeeplinkHandler.Companion.getInstance().gotoNewsFeed(activity, new NewsfeedAction(BundleUtils.toBundle(iInAppMessage.getExtras()), Channel.INAPP_MESSAGE));
        } else if (i11 == 2) {
            inAppMessageCloser.close(false);
            if (uri == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$2.INSTANCE, 7, (Object) null);
                return;
            }
            BrazeDeeplinkHandler.Companion companion = BrazeDeeplinkHandler.Companion;
            UriAction createUriActionFromUri = companion.getInstance().createUriActionFromUri(uri, BundleUtils.toBundle(iInAppMessage.getExtras()), z11, Channel.INAPP_MESSAGE);
            Context applicationContext = getInAppMessageManager().getApplicationContext();
            if (applicationContext == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$performClickAction$3.INSTANCE, 7, (Object) null);
                return;
            }
            companion.getInstance().gotoUri(applicationContext, createUriActionFromUri);
        } else if (i11 != 3) {
            inAppMessageCloser.close(false);
        } else {
            inAppMessageCloser.close(iInAppMessage.getAnimateOut());
        }
    }

    private final void performInAppMessageButtonClicked(MessageButton messageButton, IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(messageButton.getClickAction(), iInAppMessage, inAppMessageCloser, messageButton.getUri(), messageButton.getOpenUriInWebview());
    }

    private final void performInAppMessageClicked(IInAppMessage iInAppMessage, InAppMessageCloser inAppMessageCloser) {
        performClickAction(iInAppMessage.getClickAction(), iInAppMessage, inAppMessageCloser, iInAppMessage.getUri(), iInAppMessage.getOpenUriInWebView());
    }

    private final void startClearHtmlInAppMessageAssetsThread() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1((Continuation<? super DefaultInAppMessageViewLifecycleListener$startClearHtmlInAppMessageAssetsThread$1>) null), 3, (Object) null);
    }

    public void afterClosed(@NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$afterClosed$1.INSTANCE, 7, (Object) null);
        getInAppMessageManager().resetAfterInAppMessageClose();
        if (iInAppMessage instanceof IInAppMessageHtml) {
            startClearHtmlInAppMessageAssetsThread();
        }
        iInAppMessage.onAfterClosed();
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewClosed(iInAppMessage);
    }

    public void afterOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$afterOpened$1.INSTANCE, 7, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().afterInAppMessageViewOpened(view, iInAppMessage);
    }

    public void beforeClosed(@NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewClosed(view, iInAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$beforeClosed$1.INSTANCE, 7, (Object) null);
    }

    public void beforeOpened(@NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        getInAppMessageManager().getInAppMessageManagerListener().beforeInAppMessageViewOpened(view, iInAppMessage);
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$beforeOpened$1.INSTANCE, 7, (Object) null);
        iInAppMessage.logImpression();
    }

    public void onButtonClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull MessageButton messageButton, @NotNull IInAppMessageImmersive iInAppMessageImmersive) {
        boolean z11;
        Intrinsics.checkNotNullParameter(inAppMessageCloser, "inAppMessageCloser");
        Intrinsics.checkNotNullParameter(messageButton, "messageButton");
        Intrinsics.checkNotNullParameter(iInAppMessageImmersive, "inAppMessageImmersive");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$onButtonClicked$1.INSTANCE, 7, (Object) null);
        iInAppMessageImmersive.logButtonClick(messageButton);
        try {
            z11 = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(iInAppMessageImmersive, messageButton, inAppMessageCloser);
        } catch (BrazeFunctionNotImplemented unused) {
            z11 = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageButtonClicked(iInAppMessageImmersive, messageButton);
        }
        if (!z11) {
            performInAppMessageButtonClicked(messageButton, iInAppMessageImmersive, inAppMessageCloser);
        }
    }

    public void onClicked(@NotNull InAppMessageCloser inAppMessageCloser, @NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        boolean z11;
        InAppMessageCloser inAppMessageCloser2 = inAppMessageCloser;
        IInAppMessage iInAppMessage2 = iInAppMessage;
        Intrinsics.checkNotNullParameter(inAppMessageCloser2, "inAppMessageCloser");
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage2, "inAppMessage");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$1.INSTANCE, 7, (Object) null);
        iInAppMessage.logClick();
        try {
            z11 = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(iInAppMessage2, inAppMessageCloser2);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$1.INSTANCE, 7, (Object) null);
        } catch (BrazeFunctionNotImplemented unused) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$onClicked$wasHandled$2.INSTANCE, 7, (Object) null);
            z11 = getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageClicked(iInAppMessage2);
        }
        if (!z11) {
            performInAppMessageClicked(iInAppMessage2, inAppMessageCloser2);
        }
    }

    public void onDismissed(@NotNull View view, @NotNull IInAppMessage iInAppMessage) {
        Intrinsics.checkNotNullParameter(view, "inAppMessageView");
        Intrinsics.checkNotNullParameter(iInAppMessage, "inAppMessage");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) DefaultInAppMessageViewLifecycleListener$onDismissed$1.INSTANCE, 7, (Object) null);
        getInAppMessageManager().getInAppMessageManagerListener().onInAppMessageDismissed(iInAppMessage);
    }
}
