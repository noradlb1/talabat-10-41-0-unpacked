package com.droibit.android.customtabs.launcher.internal;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsIntent;
import com.droibit.android.customtabs.launcher.CustomTabsFallback;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¨\u0006\u0010"}, d2 = {"Lcom/droibit/android/customtabs/launcher/internal/CustomTabsLauncherImpl;", "", "()V", "launch", "", "context", "Landroid/content/Context;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "uri", "Landroid/net/Uri;", "expectCustomTabsPackages", "", "", "fallback", "Lcom/droibit/android/customtabs/launcher/CustomTabsFallback;", "launcher_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabsLauncherImpl {
    public final void launch(@NotNull Context context, @NotNull CustomTabsIntent customTabsIntent, @NotNull Uri uri, @NotNull List<String> list, @Nullable CustomTabsFallback customTabsFallback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(customTabsIntent, "customTabsIntent");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(list, "expectCustomTabsPackages");
        String packageName = CustomTabsClient.getPackageName(context, list);
        if (packageName != null || customTabsFallback == null) {
            customTabsIntent.intent.setPackage(packageName);
            customTabsIntent.launchUrl(context, uri);
            return;
        }
        customTabsFallback.openUrl(context, uri, customTabsIntent);
    }
}
