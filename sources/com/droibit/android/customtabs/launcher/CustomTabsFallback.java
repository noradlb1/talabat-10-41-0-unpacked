package com.droibit.android.customtabs.launcher;

import android.content.Context;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/droibit/android/customtabs/launcher/CustomTabsFallback;", "", "openUrl", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "customTabsIntent", "Landroidx/browser/customtabs/CustomTabsIntent;", "launcher_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface CustomTabsFallback {
    void openUrl(@NotNull Context context, @NotNull Uri uri, @NotNull CustomTabsIntent customTabsIntent);
}
