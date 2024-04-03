package com.droibit.android.customtabs.launcher.internal;

import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.browser.customtabs.CustomTabsService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u00032\u000e\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"", "kotlin.jvm.PlatformType", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
public final class CustomTabsPackage$getNonChromeCustomTabsPackages$3 extends Lambda implements Function1<String, Boolean> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PackageManager f33555g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CustomTabsPackage$getNonChromeCustomTabsPackages$3(PackageManager packageManager) {
        super(1);
        this.f33555g = packageManager;
    }

    @NotNull
    public final Boolean invoke(String str) {
        Intent intent = new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION).setPackage(str);
        Intrinsics.checkNotNullExpressionValue(intent, "Intent(CustomTabsService…          .setPackage(it)");
        boolean z11 = false;
        if (this.f33555g.resolveService(intent, 0) != null) {
            z11 = true;
        }
        return Boolean.valueOf(z11);
    }
}
