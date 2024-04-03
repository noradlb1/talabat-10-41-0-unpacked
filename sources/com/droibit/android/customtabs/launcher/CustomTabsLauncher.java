package com.droibit.android.customtabs.launcher;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.droibit.android.customtabs.launcher.internal.CustomTabsLauncherImpl;
import com.droibit.android.customtabs.launcher.internal.CustomTabsPackage;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/droibit/android/customtabs/launcher/CustomTabsLauncher;", "", "()V", "IMPL", "Lcom/droibit/android/customtabs/launcher/internal/CustomTabsLauncherImpl;", "launch", "", "context", "Landroid/content/Context;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "uri", "Landroid/net/Uri;", "fallback", "Lcom/droibit/android/customtabs/launcher/CustomTabsFallback;", "LaunchNonChromeCustomTabs", "launcher_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabsLauncher {
    /* access modifiers changed from: private */
    @NotNull
    public static final CustomTabsLauncherImpl IMPL = new CustomTabsLauncherImpl();
    @NotNull
    public static final CustomTabsLauncher INSTANCE = new CustomTabsLauncher();

    private CustomTabsLauncher() {
    }

    @JvmStatic
    @JvmOverloads
    public static final void launch(@NotNull Context context, @NotNull CustomTabsIntent customTabsIntent, @NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        Intrinsics.checkNotNullParameter(uri, "uri");
        launch$default(context, customTabsIntent, uri, (CustomTabsFallback) null, 8, (Object) null);
    }

    @JvmStatic
    @JvmOverloads
    public static final void launch(@NotNull Context context, @NotNull CustomTabsIntent customTabsIntent, @NotNull Uri uri, @Nullable CustomTabsFallback customTabsFallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        Intrinsics.checkNotNullParameter(uri, "uri");
        IMPL.launch(context, customTabsIntent, uri, CustomTabsPackage.INSTANCE.getCHROME_PACKAGES(), customTabsFallback);
    }

    public static /* synthetic */ void launch$default(Context context, CustomTabsIntent customTabsIntent, Uri uri, CustomTabsFallback customTabsFallback, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            customTabsFallback = null;
        }
        launch(context, customTabsIntent, uri, customTabsFallback);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ \u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/droibit/android/customtabs/launcher/CustomTabsLauncher$LaunchNonChromeCustomTabs;", "Lcom/droibit/android/customtabs/launcher/CustomTabsFallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "customTabsPackages", "", "", "(Ljava/util/List;)V", "openUrl", "", "uri", "Landroid/net/Uri;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "launcher_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class LaunchNonChromeCustomTabs implements CustomTabsFallback {
        @NotNull
        private final List<String> customTabsPackages;

        public LaunchNonChromeCustomTabs(@NotNull List<String> list) {
            Intrinsics.checkNotNullParameter(list, "customTabsPackages");
            this.customTabsPackages = list;
        }

        public void openUrl(@NotNull Context context, @NotNull Uri uri, @NotNull CustomTabsIntent customTabsIntent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(uri, "uri");
            Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
            if (this.customTabsPackages.isEmpty()) {
                customTabsIntent.launchUrl(context, uri);
                return;
            }
            CustomTabsLauncher.IMPL.launch(context, customTabsIntent, uri, this.customTabsPackages, (CustomTabsFallback) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public LaunchNonChromeCustomTabs(@NotNull Context context) {
            this(CustomTabsPackage.INSTANCE.getNonChromeCustomTabsPackages(context));
            Intrinsics.checkNotNullParameter(context, "context");
        }
    }
}
