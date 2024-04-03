package com.droibit.android.customtabs.launcher.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\r\u001a\u00020\u000eR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/droibit/android/customtabs/launcher/internal/CustomTabsPackage;", "", "()V", "CHROME_PACKAGES", "", "", "getCHROME_PACKAGES", "()Ljava/util/List;", "PACKAGE_CHROME_BETA", "PACKAGE_CHROME_DEV", "PACKAGE_CHROME_LOCAL", "PACKAGE_CHROME_STABLE", "getNonChromeCustomTabsPackages", "context", "Landroid/content/Context;", "launcher_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CustomTabsPackage {
    @NotNull
    private static final List<String> CHROME_PACKAGES = CollectionsKt__CollectionsKt.listOf(PACKAGE_CHROME_STABLE, PACKAGE_CHROME_BETA, PACKAGE_CHROME_DEV, PACKAGE_CHROME_LOCAL);
    @NotNull
    public static final CustomTabsPackage INSTANCE = new CustomTabsPackage();
    @NotNull
    private static final String PACKAGE_CHROME_BETA = "com.chrome.beta";
    @NotNull
    private static final String PACKAGE_CHROME_DEV = "com.chrome.dev";
    @NotNull
    private static final String PACKAGE_CHROME_LOCAL = "com.google.android.apps.chrome";
    @NotNull
    private static final String PACKAGE_CHROME_STABLE = "com.android.chrome";

    private CustomTabsPackage() {
    }

    @NotNull
    public final List<String> getCHROME_PACKAGES() {
        return CHROME_PACKAGES;
    }

    @NotNull
    public final List<String> getNonChromeCustomTabsPackages(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intent addCategory = new Intent("android.intent.action.VIEW", Uri.parse("http://")).addCategory("android.intent.category.BROWSABLE");
        Intrinsics.checkNotNullExpressionValue(addCategory, "Intent(ACTION_VIEW, Uri.…ntent.CATEGORY_BROWSABLE)");
        PackageManager packageManager = context.getPackageManager();
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(addCategory, 131072);
        Intrinsics.checkNotNullExpressionValue(queryIntentActivities, "pm.queryIntentActivities(activityIntent, flag)");
        return SequencesKt___SequencesKt.toList(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.filter(SequencesKt___SequencesKt.map(CollectionsKt___CollectionsKt.asSequence(queryIntentActivities), CustomTabsPackage$getNonChromeCustomTabsPackages$1.INSTANCE), CustomTabsPackage$getNonChromeCustomTabsPackages$2.INSTANCE), new CustomTabsPackage$getNonChromeCustomTabsPackages$3(packageManager)));
    }
}
