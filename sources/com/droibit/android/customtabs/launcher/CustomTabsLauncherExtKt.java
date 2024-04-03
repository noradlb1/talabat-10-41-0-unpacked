package com.droibit.android.customtabs.launcher;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u001a&\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\n"}, d2 = {"launch", "", "Landroidx/browser/customtabs/CustomTabsIntent;", "context", "Landroid/content/Context;", "url", "Landroid/net/Uri;", "fallback", "Lcom/droibit/android/customtabs/launcher/CustomTabsFallback;", "", "launcher_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CustomTabsLauncherExtKt {
    public static final void launch(@NotNull CustomTabsIntent customTabsIntent, @NotNull Context context, @NotNull String str, @Nullable CustomTabsFallback customTabsFallback) {
        Intrinsics.checkNotNullParameter(customTabsIntent, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "url");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "parse(url)");
        CustomTabsLauncher.launch(context, customTabsIntent, parse, customTabsFallback);
    }

    public static /* synthetic */ void launch$default(CustomTabsIntent customTabsIntent, Context context, String str, CustomTabsFallback customTabsFallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            customTabsFallback = null;
        }
        launch(customTabsIntent, context, str, customTabsFallback);
    }

    public static final void launch(@NotNull CustomTabsIntent customTabsIntent, @NotNull Context context, @NotNull Uri uri, @Nullable CustomTabsFallback customTabsFallback) {
        Intrinsics.checkNotNullParameter(customTabsIntent, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "url");
        CustomTabsLauncher.launch(context, customTabsIntent, uri, customTabsFallback);
    }

    public static /* synthetic */ void launch$default(CustomTabsIntent customTabsIntent, Context context, Uri uri, CustomTabsFallback customTabsFallback, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            customTabsFallback = null;
        }
        launch(customTabsIntent, context, uri, customTabsFallback);
    }
}
