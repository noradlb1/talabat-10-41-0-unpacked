package com.droibit.android.customtabs.launcher.internal;

import android.content.pm.ResolveInfo;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0010\u0004\u001a\n \u0001*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroid/content/pm/ResolveInfo;", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CustomTabsPackage$getNonChromeCustomTabsPackages$1 extends Lambda implements Function1<ResolveInfo, String> {
    public static final CustomTabsPackage$getNonChromeCustomTabsPackages$1 INSTANCE = new CustomTabsPackage$getNonChromeCustomTabsPackages$1();

    public CustomTabsPackage$getNonChromeCustomTabsPackages$1() {
        super(1);
    }

    public final String invoke(ResolveInfo resolveInfo) {
        return resolveInfo.activityInfo.packageName;
    }
}
