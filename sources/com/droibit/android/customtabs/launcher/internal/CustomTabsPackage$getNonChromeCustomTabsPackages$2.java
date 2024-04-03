package com.droibit.android.customtabs.launcher.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CustomTabsPackage$getNonChromeCustomTabsPackages$2 extends Lambda implements Function1<String, Boolean> {
    public static final CustomTabsPackage$getNonChromeCustomTabsPackages$2 INSTANCE = new CustomTabsPackage$getNonChromeCustomTabsPackages$2();

    public CustomTabsPackage$getNonChromeCustomTabsPackages$2() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(String str) {
        return Boolean.valueOf(!CustomTabsPackage.INSTANCE.getCHROME_PACKAGES().contains(str));
    }
}
