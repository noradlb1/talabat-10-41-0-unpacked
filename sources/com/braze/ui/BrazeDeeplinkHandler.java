package com.braze.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.appboy.enums.Channel;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.NewsfeedAction;
import com.braze.ui.actions.UriAction;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J,\u0010\r\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0004H\u0016¨\u0006\u001d"}, d2 = {"Lcom/braze/ui/BrazeDeeplinkHandler;", "Lcom/braze/IBrazeDeeplinkHandler;", "()V", "createUriActionFromUri", "Lcom/braze/ui/actions/UriAction;", "uri", "Landroid/net/Uri;", "extras", "Landroid/os/Bundle;", "openInWebView", "", "channel", "Lcom/appboy/enums/Channel;", "createUriActionFromUrlString", "url", "", "getIntentFlags", "", "intentFlagPurpose", "Lcom/braze/IBrazeDeeplinkHandler$IntentFlagPurpose;", "gotoNewsFeed", "", "context", "Landroid/content/Context;", "newsfeedAction", "Lcom/braze/ui/actions/NewsfeedAction;", "gotoUri", "uriAction", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BrazeDeeplinkHandler implements IBrazeDeeplinkHandler {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @Nullable
    public static volatile IBrazeDeeplinkHandler customHandler;
    /* access modifiers changed from: private */
    @NotNull
    public static final IBrazeDeeplinkHandler defaultHandler = new BrazeDeeplinkHandler();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/braze/ui/BrazeDeeplinkHandler$Companion;", "", "()V", "customHandler", "Lcom/braze/IBrazeDeeplinkHandler;", "defaultHandler", "getInstance", "setBrazeDeeplinkHandler", "", "brazeDeeplinkHandler", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @NotNull
        public final IBrazeDeeplinkHandler getInstance() {
            IBrazeDeeplinkHandler access$getCustomHandler$cp = BrazeDeeplinkHandler.customHandler;
            return access$getCustomHandler$cp == null ? BrazeDeeplinkHandler.defaultHandler : access$getCustomHandler$cp;
        }

        @JvmStatic
        public final void setBrazeDeeplinkHandler(@Nullable IBrazeDeeplinkHandler iBrazeDeeplinkHandler) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new BrazeDeeplinkHandler$Companion$setBrazeDeeplinkHandler$1(iBrazeDeeplinkHandler), 7, (Object) null);
            BrazeDeeplinkHandler.customHandler = iBrazeDeeplinkHandler;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[IBrazeDeeplinkHandler.IntentFlagPurpose.values().length];
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_ACTION_WITH_DEEPLINK.ordinal()] = 1;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.NOTIFICATION_PUSH_STORY_PAGE_CLICK.ordinal()] = 2;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY.ordinal()] = 3;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW.ordinal()] = 4;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_UTILS_GET_MAIN_ACTIVITY_INTENT.ordinal()] = 5;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT.ordinal()] = 6;
            iArr[IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @JvmStatic
    @NotNull
    public static final IBrazeDeeplinkHandler getInstance() {
        return Companion.getInstance();
    }

    @JvmStatic
    public static final void setBrazeDeeplinkHandler(@Nullable IBrazeDeeplinkHandler iBrazeDeeplinkHandler) {
        Companion.setBrazeDeeplinkHandler(iBrazeDeeplinkHandler);
    }

    @NotNull
    public UriAction createUriActionFromUri(@NotNull Uri uri, @Nullable Bundle bundle, boolean z11, @NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(channel, "channel");
        return new UriAction(uri, bundle, z11, channel);
    }

    @Nullable
    public UriAction createUriActionFromUrlString(@NotNull String str, @Nullable Bundle bundle, boolean z11, @NotNull Channel channel) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(channel, "channel");
        try {
            if (!StringsKt__StringsJVMKt.isBlank(str)) {
                Uri parse = Uri.parse(str);
                Intrinsics.checkNotNullExpressionValue(parse, "uri");
                return createUriActionFromUri(parse, bundle, z11, channel);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, false, (Function0) BrazeDeeplinkHandler$createUriActionFromUrlString$1.INSTANCE, 6, (Object) null);
            return null;
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) BrazeDeeplinkHandler$createUriActionFromUrlString$2.INSTANCE, 4, (Object) null);
            return null;
        }
    }

    public int getIntentFlags(@NotNull IBrazeDeeplinkHandler.IntentFlagPurpose intentFlagPurpose) {
        Intrinsics.checkNotNullParameter(intentFlagPurpose, "intentFlagPurpose");
        switch (WhenMappings.$EnumSwitchMapping$0[intentFlagPurpose.ordinal()]) {
            case 1:
            case 2:
                return 1073741824;
            case 3:
            case 4:
            case 5:
                return 872415232;
            case 6:
            case 7:
                return 268435456;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public void gotoNewsFeed(@NotNull Context context, @NotNull NewsfeedAction newsfeedAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(newsfeedAction, "newsfeedAction");
        newsfeedAction.execute(context);
    }

    public void gotoUri(@NotNull Context context, @NotNull UriAction uriAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uriAction, "uriAction");
        uriAction.execute(context);
    }
}
