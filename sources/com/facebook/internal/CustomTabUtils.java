package com.facebook.internal;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import androidx.browser.customtabs.CustomTabsService;
import com.facebook.FacebookSdk;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.util.HashSet;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0007J\b\u0010\b\u001a\u00020\u0005H\u0007J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/facebook/internal/CustomTabUtils;", "", "()V", "CHROME_PACKAGES", "", "", "[Ljava/lang/String;", "getChromePackage", "getDefaultRedirectURI", "getValidRedirectURI", "developerDefinedRedirectURI", "facebook-common_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@AutoHandleExceptions
public final class CustomTabUtils {
    @NotNull
    private static final String[] CHROME_PACKAGES = {"com.android.chrome", "com.chrome.beta", "com.chrome.dev"};
    @NotNull
    public static final CustomTabUtils INSTANCE = new CustomTabUtils();

    private CustomTabUtils() {
    }

    @JvmStatic
    @Nullable
    public static final String getChromePackage() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        List<ResolveInfo> queryIntentServices = applicationContext.getPackageManager().queryIntentServices(new Intent(CustomTabsService.ACTION_CUSTOM_TABS_CONNECTION), 0);
        Intrinsics.checkNotNullExpressionValue(queryIntentServices, "context.packageManager.queryIntentServices(serviceIntent, 0)");
        HashSet hashSet = ArraysKt___ArraysKt.toHashSet((T[]) CHROME_PACKAGES);
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            if (serviceInfo != null && hashSet.contains(serviceInfo.packageName)) {
                return serviceInfo.packageName;
            }
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getDefaultRedirectURI() {
        return Intrinsics.stringPlus(Validate.CUSTOM_TAB_REDIRECT_URI_PREFIX, FacebookSdk.getApplicationContext().getPackageName());
    }

    @JvmStatic
    @NotNull
    public static final String getValidRedirectURI(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "developerDefinedRedirectURI");
        Validate validate = Validate.INSTANCE;
        if (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), str)) {
            return str;
        }
        if (Validate.hasCustomTabRedirectActivity(FacebookSdk.getApplicationContext(), getDefaultRedirectURI())) {
            return getDefaultRedirectURI();
        }
        return "";
    }
}
