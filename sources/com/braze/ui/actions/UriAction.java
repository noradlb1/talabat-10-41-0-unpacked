package com.braze.ui.actions;

import android.annotation.SuppressLint;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.VisibleForTesting;
import com.appboy.enums.Channel;
import com.braze.IBrazeDeeplinkHandler;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeFileUtils;
import com.braze.support.BrazeLogger;
import com.braze.ui.BrazeDeeplinkHandler;
import com.braze.ui.BrazeWebViewActivity;
import com.braze.ui.actions.brazeactions.BrazeActionParser;
import com.braze.ui.support.UriUtils;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0016\u0018\u00002\u00020\u0001B+\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010%\u001a\u00020$\u0012\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b+\u0010,B\u0011\b\u0016\u0012\u0006\u0010-\u001a\u00020\u0000¢\u0006\u0004\b+\u0010.J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\"\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\"\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0014J\"\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\"\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\"\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0004J\"\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0005J7\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00142\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0015\u0010\u0016R\u0019\u0010\t\u001a\u0004\u0018\u00010\b8\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001b\u001a\u00020\u001a8\u0016X\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\"\u0010\u0007\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0007\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\"\u0010%\u001a\u00020$8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006/"}, d2 = {"Lcom/braze/ui/actions/UriAction;", "Lcom/braze/ui/actions/IAction;", "Landroid/content/Context;", "context", "", "execute", "Landroid/net/Uri;", "uri", "Landroid/os/Bundle;", "extras", "e", "c", "f", "d", "Landroid/content/Intent;", "b", "a", "targetIntent", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "getIntentArrayWithConfiguredBackStack", "(Landroid/content/Context;Landroid/os/Bundle;Landroid/content/Intent;Lcom/braze/configuration/BrazeConfigurationProvider;)[Landroid/content/Intent;", "Landroid/os/Bundle;", "getExtras", "()Landroid/os/Bundle;", "Lcom/appboy/enums/Channel;", "channel", "Lcom/appboy/enums/Channel;", "getChannel", "()Lcom/appboy/enums/Channel;", "Landroid/net/Uri;", "getUri", "()Landroid/net/Uri;", "setUri", "(Landroid/net/Uri;)V", "", "useWebView", "Z", "getUseWebView", "()Z", "setUseWebView", "(Z)V", "<init>", "(Landroid/net/Uri;Landroid/os/Bundle;ZLcom/appboy/enums/Channel;)V", "original", "(Lcom/braze/ui/actions/UriAction;)V", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0})
public class UriAction implements IAction {
    @NotNull
    private final Channel channel;
    @Nullable
    private final Bundle extras;
    @NotNull
    private Uri uri;
    private boolean useWebView;

    public UriAction(@NotNull Uri uri2, @Nullable Bundle bundle, boolean z11, @NotNull Channel channel2) {
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.uri = uri2;
        this.extras = bundle;
        this.useWebView = z11;
        this.channel = channel2;
    }

    @NotNull
    @SuppressLint({"QueryPermissionsNeeded"})
    public final Intent a(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        List<ResolveInfo> list;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(uri2);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        if (Build.VERSION.SDK_INT >= 33) {
            list = context.getPackageManager().queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(0));
        } else {
            list = context.getPackageManager().queryIntentActivities(intent, 0);
        }
        Intrinsics.checkNotNullExpressionValue(list, "if (Build.VERSION.SDK_IN…ties(intent, 0)\n        }");
        if (list.size() > 1) {
            Iterator<ResolveInfo> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                ResolveInfo next = it.next();
                if (Intrinsics.areEqual((Object) next.activityInfo.packageName, (Object) context.getPackageName())) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new UriAction$getActionViewIntent$1(next), 7, (Object) null);
                    intent.setPackage(next.activityInfo.packageName);
                    break;
                }
            }
        }
        return intent;
    }

    @NotNull
    public final Intent b(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        boolean z11;
        Intent intent;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        String customHtmlWebViewActivityClassName = new BrazeConfigurationProvider(context).getCustomHtmlWebViewActivityClassName();
        if (customHtmlWebViewActivityClassName == null || StringsKt__StringsJVMKt.isBlank(customHtmlWebViewActivityClassName)) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11 || !UriUtils.isActivityRegisteredInManifest(context, customHtmlWebViewActivityClassName)) {
            intent = new Intent(context, BrazeWebViewActivity.class);
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new UriAction$getWebViewActivityIntent$webViewActivityIntent$1(customHtmlWebViewActivityClassName), 7, (Object) null);
            intent = new Intent().setClassName(context, customHtmlWebViewActivityClassName);
            Intrinsics.checkNotNullExpressionValue(intent, "val customWebViewActivit…ivityClassName)\n        }");
        }
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        intent.putExtra("url", uri2.toString());
        return intent;
    }

    public void c(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent a11 = a(context, uri2, bundle);
        a11.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_ACTION_VIEW));
        try {
            context.startActivity(a11);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) new UriAction$openUriWithActionView$1(uri2, bundle), 4, (Object) null);
        }
    }

    public final void d(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, a(context, uri2, bundle), new BrazeConfigurationProvider(context)));
        } catch (ActivityNotFoundException e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) e11, false, (Function0) new UriAction$openUriWithActionViewFromPush$1(uri2), 4, (Object) null);
        }
    }

    public final void e(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        Intent b11 = b(context, uri2, bundle);
        b11.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_OPEN_WITH_WEBVIEW_ACTIVITY));
        try {
            context.startActivity(b11);
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) UriAction$openUriWithWebViewActivity$1.INSTANCE, 4, (Object) null);
        }
    }

    public void execute(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (BrazeFileUtils.isLocalUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new UriAction$execute$1(this), 7, (Object) null);
            return;
        }
        BrazeActionParser brazeActionParser = BrazeActionParser.INSTANCE;
        if (brazeActionParser.isBrazeActionUri(this.uri)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new UriAction$execute$2(this), 6, (Object) null);
            brazeActionParser.execute(context, this.uri, getChannel());
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new UriAction$execute$3(this), 7, (Object) null);
        if (!this.useWebView || !CollectionsKt___CollectionsKt.contains(BrazeFileUtils.REMOTE_SCHEMES, this.uri.getScheme())) {
            if (getChannel() == Channel.PUSH) {
                d(context, this.uri, this.extras);
            } else {
                c(context, this.uri, this.extras);
            }
        } else if (getChannel() == Channel.PUSH) {
            f(context, this.uri, this.extras);
        } else {
            e(context, this.uri, this.extras);
        }
    }

    public final void f(@NotNull Context context, @NotNull Uri uri2, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri2, "uri");
        try {
            context.startActivities(getIntentArrayWithConfiguredBackStack(context, bundle, b(context, uri2, bundle), new BrazeConfigurationProvider(context)));
        } catch (Exception e11) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) e11, false, (Function0) UriAction$openUriWithWebViewActivityFromPush$1.INSTANCE, 4, (Object) null);
        }
    }

    @NotNull
    public Channel getChannel() {
        return this.channel;
    }

    @Nullable
    public final Bundle getExtras() {
        return this.extras;
    }

    @NotNull
    @VisibleForTesting
    public final Intent[] getIntentArrayWithConfiguredBackStack(@NotNull Context context, @Nullable Bundle bundle, @NotNull Intent intent, @NotNull BrazeConfigurationProvider brazeConfigurationProvider) {
        boolean z11;
        Context context2 = context;
        Bundle bundle2 = bundle;
        Intent intent2 = intent;
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(intent2, "targetIntent");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intent intent3 = null;
        if (brazeConfigurationProvider.isPushDeepLinkBackStackActivityEnabled()) {
            String pushDeepLinkBackStackActivityClassName = brazeConfigurationProvider.getPushDeepLinkBackStackActivityClassName();
            if (pushDeepLinkBackStackActivityClassName == null || StringsKt__StringsJVMKt.isBlank(pushDeepLinkBackStackActivityClassName)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) UriAction$getIntentArrayWithConfiguredBackStack$1.INSTANCE, 6, (Object) null);
                intent3 = UriUtils.getMainActivityIntent(context, bundle);
            } else if (UriUtils.isActivityRegisteredInManifest(context2, pushDeepLinkBackStackActivityClassName)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new UriAction$getIntentArrayWithConfiguredBackStack$2(pushDeepLinkBackStackActivityClassName), 6, (Object) null);
                if (bundle2 != null) {
                    intent3 = new Intent().setClassName(context2, pushDeepLinkBackStackActivityClassName).setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_GET_ROOT_INTENT)).putExtras(bundle2);
                }
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) new UriAction$getIntentArrayWithConfiguredBackStack$4(pushDeepLinkBackStackActivityClassName), 6, (Object) null);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) UriAction$getIntentArrayWithConfiguredBackStack$5.INSTANCE, 6, (Object) null);
        }
        if (intent3 == null) {
            intent2.setFlags(BrazeDeeplinkHandler.Companion.getInstance().getIntentFlags(IBrazeDeeplinkHandler.IntentFlagPurpose.URI_ACTION_BACK_STACK_ONLY_GET_TARGET_INTENT));
            return new Intent[]{intent2};
        }
        return new Intent[]{intent3, intent2};
    }

    @NotNull
    public final Uri getUri() {
        return this.uri;
    }

    public final boolean getUseWebView() {
        return this.useWebView;
    }

    public final void setUri(@NotNull Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, "<set-?>");
        this.uri = uri2;
    }

    public final void setUseWebView(boolean z11) {
        this.useWebView = z11;
    }

    public UriAction(@NotNull UriAction uriAction) {
        Intrinsics.checkNotNullParameter(uriAction, "original");
        this.uri = uriAction.uri;
        this.extras = uriAction.extras;
        this.useWebView = uriAction.useWebView;
        this.channel = uriAction.getChannel();
    }
}
