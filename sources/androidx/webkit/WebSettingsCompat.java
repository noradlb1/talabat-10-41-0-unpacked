package androidx.webkit;

import android.webkit.WebSettings;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.webkit.internal.ApiFeature;
import androidx.webkit.internal.ApiHelperForM;
import androidx.webkit.internal.ApiHelperForN;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.ApiHelperForQ;
import androidx.webkit.internal.WebSettingsAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Set;

public class WebSettingsCompat {
    @Deprecated
    public static final int DARK_STRATEGY_PREFER_WEB_THEME_OVER_USER_AGENT_DARKENING = 2;
    @Deprecated
    public static final int DARK_STRATEGY_USER_AGENT_DARKENING_ONLY = 0;
    @Deprecated
    public static final int DARK_STRATEGY_WEB_THEME_DARKENING_ONLY = 1;
    @Deprecated
    public static final int FORCE_DARK_AUTO = 1;
    @Deprecated
    public static final int FORCE_DARK_OFF = 0;
    @Deprecated
    public static final int FORCE_DARK_ON = 2;

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDark {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ForceDarkStrategy {
    }

    @Target({ElementType.PARAMETER, ElementType.METHOD})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface MenuItemFlags {
    }

    private WebSettingsCompat() {
    }

    private static WebSettingsAdapter getAdapter(WebSettings webSettings) {
        return WebViewGlueCommunicator.getCompatConverter().convertSettings(webSettings);
    }

    public static int getDisabledActionModeMenuItems(@NonNull WebSettings webSettings) {
        ApiFeature.N n11 = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (n11.isSupportedByFramework()) {
            return ApiHelperForN.getDisabledActionModeMenuItems(webSettings);
        }
        if (n11.isSupportedByWebView()) {
            return getAdapter(webSettings).getDisabledActionModeMenuItems();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getEnterpriseAuthenticationAppLinkPolicyEnabled(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView()) {
            return getAdapter(webSettings).getEnterpriseAuthenticationAppLinkPolicyEnabled();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Deprecated
    public static int getForceDark(@NonNull WebSettings webSettings) {
        ApiFeature.Q q11 = WebViewFeatureInternal.FORCE_DARK;
        if (q11.isSupportedByFramework()) {
            return ApiHelperForQ.getForceDark(webSettings);
        }
        if (q11.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Deprecated
    public static int getForceDarkStrategy(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            return getAdapter(webSettings).getForceDark();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getOffscreenPreRaster(@NonNull WebSettings webSettings) {
        ApiFeature.M m11 = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (m11.isSupportedByFramework()) {
            return ApiHelperForM.getOffscreenPreRaster(webSettings);
        }
        if (m11.isSupportedByWebView()) {
            return getAdapter(webSettings).getOffscreenPreRaster();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @NonNull
    public static Set<String> getRequestedWithHeaderOriginAllowList(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            return getAdapter(webSettings).getRequestedWithHeaderOriginAllowList();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean getSafeBrowsingEnabled(@NonNull WebSettings webSettings) {
        ApiFeature.O o11 = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (o11.isSupportedByFramework()) {
            return ApiHelperForO.getSafeBrowsingEnabled(webSettings);
        }
        if (o11.isSupportedByWebView()) {
            return getAdapter(webSettings).getSafeBrowsingEnabled();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static boolean isAlgorithmicDarkeningAllowed(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView()) {
            return getAdapter(webSettings).isAlgorithmicDarkeningAllowed();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setAlgorithmicDarkeningAllowed(@NonNull WebSettings webSettings, boolean z11) {
        if (WebViewFeatureInternal.ALGORITHMIC_DARKENING.isSupportedByWebView()) {
            getAdapter(webSettings).setAlgorithmicDarkeningAllowed(z11);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setDisabledActionModeMenuItems(@NonNull WebSettings webSettings, int i11) {
        ApiFeature.N n11 = WebViewFeatureInternal.DISABLED_ACTION_MODE_MENU_ITEMS;
        if (n11.isSupportedByFramework()) {
            ApiHelperForN.setDisabledActionModeMenuItems(webSettings, i11);
        } else if (n11.isSupportedByWebView()) {
            getAdapter(webSettings).setDisabledActionModeMenuItems(i11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void setEnterpriseAuthenticationAppLinkPolicyEnabled(@NonNull WebSettings webSettings, boolean z11) {
        if (WebViewFeatureInternal.ENTERPRISE_AUTHENTICATION_APP_LINK_POLICY.isSupportedByWebView()) {
            getAdapter(webSettings).setEnterpriseAuthenticationAppLinkPolicyEnabled(z11);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @Deprecated
    public static void setForceDark(@NonNull WebSettings webSettings, int i11) {
        ApiFeature.Q q11 = WebViewFeatureInternal.FORCE_DARK;
        if (q11.isSupportedByFramework()) {
            ApiHelperForQ.setForceDark(webSettings, i11);
        } else if (q11.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDark(i11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @Deprecated
    public static void setForceDarkStrategy(@NonNull WebSettings webSettings, int i11) {
        if (WebViewFeatureInternal.FORCE_DARK_STRATEGY.isSupportedByWebView()) {
            getAdapter(webSettings).setForceDarkStrategy(i11);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setOffscreenPreRaster(@NonNull WebSettings webSettings, boolean z11) {
        ApiFeature.M m11 = WebViewFeatureInternal.OFF_SCREEN_PRERASTER;
        if (m11.isSupportedByFramework()) {
            ApiHelperForM.setOffscreenPreRaster(webSettings, z11);
        } else if (m11.isSupportedByWebView()) {
            getAdapter(webSettings).setOffscreenPreRaster(z11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public static void setRequestedWithHeaderOriginAllowList(@NonNull WebSettings webSettings, @NonNull Set<String> set) {
        if (WebViewFeatureInternal.REQUESTED_WITH_HEADER_ALLOW_LIST.isSupportedByWebView()) {
            getAdapter(webSettings).setRequestedWithHeaderOriginAllowList(set);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public static void setSafeBrowsingEnabled(@NonNull WebSettings webSettings, boolean z11) {
        ApiFeature.O o11 = WebViewFeatureInternal.SAFE_BROWSING_ENABLE;
        if (o11.isSupportedByFramework()) {
            ApiHelperForO.setSafeBrowsingEnabled(webSettings, z11);
        } else if (o11.isSupportedByWebView()) {
            getAdapter(webSettings).setSafeBrowsingEnabled(z11);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static void setWillSuppressErrorPage(@NonNull WebSettings webSettings, boolean z11) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            getAdapter(webSettings).setWillSuppressErrorPage(z11);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static boolean willSuppressErrorPage(@NonNull WebSettings webSettings) {
        if (WebViewFeatureInternal.SUPPRESS_ERROR_PAGE.isSupportedByWebView()) {
            return getAdapter(webSettings).willSuppressErrorPage();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
